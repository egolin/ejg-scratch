/*
 * Copyright (c) 2014 Eric J Golin.
 */

package com.golins.dropwiztest.resources;

import com.codahale.metrics.annotation.Timed;
import com.golins.dropwiztest.models.Saying;
import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by egolin on 9/14/14.
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private final Logger logger = LoggerFactory.getLogger("Hello");

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        logger.debug(String.format("Saying HELLO to '%s'", name.or("<null>")));
        return new Saying(counter.incrementAndGet(), value);
    }
}
