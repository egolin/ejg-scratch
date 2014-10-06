/*
 * Copyright (c) 2014 Eric J Golin.
 */

package com.golins.dropwiztest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by egolin on 9/11/14.
 */
public class Saying {
    private final static Logger logger = LoggerFactory.getLogger("Saying");
    final private long id;

    @Length(min=3, max=8)
    final private String content;

    private Saying() {
        // Jackson deserialization
        this.id = 0;
        this.content = null;
    }
    @Valid
    public Saying(long id, String content) {
        logger.debug("Saying hello to '{}' ({})", content, id);
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
