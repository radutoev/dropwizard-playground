package org.tzotopia.playground.dropwizard.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Saying {
    private Long id;

    @Length(max = 3)
    private String content;

    public Saying(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
