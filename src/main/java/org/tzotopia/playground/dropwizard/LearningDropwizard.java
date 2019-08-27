package org.tzotopia.playground.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.tzotopia.playground.dropwizard.endpoint.HelloWorldResource;

public class LearningDropwizard extends Application<Config> {
    public static void main(String[] args) throws Exception {
        new LearningDropwizard().run(args);
    }

    public void run(Config config, Environment environment) throws Exception {
        final HelloWorldResource resource = new HelloWorldResource (
            config.getTemplate(),
            config.getDefaultName()
        );
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();
        environment.healthChecks().register("template", healthCheck);
    }

    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public String getName() {
        return "application";
    }
}
