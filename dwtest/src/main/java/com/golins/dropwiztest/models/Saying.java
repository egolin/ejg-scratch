package com.golins.dropwiztest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by egolin on 9/11/14.
 */
public class Saying {
    final private long id;

    @Length(max = 3)
    final private String content;

    private Saying() {
        // Jackson deserialization
        this.id = 0;
        this.content = null;
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
