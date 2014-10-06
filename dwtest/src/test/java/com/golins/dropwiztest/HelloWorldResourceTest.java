/*
 * Copyright (c) 2014 Eric J Golin.
 */

package com.golins.dropwiztest;

import org.junit.Test;
import org.junit.ClassRule;
import static org.fest.assertions.api.Assertions.assertThat;
import com.golins.dropwiztest.resources.HelloWorldResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import com.golins.dropwiztest.models.Saying;

/**
 * Created by egolin on 9/30/14.
 */
public class HelloWorldResourceTest {
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource("Testing %s", "1, 2, 3"))
            .build();

    @Test
    public void testHello() {
        Saying say = resources.client().resource("/hello-world?name=foo").get(Saying.class);
        assertThat(say.getContent()).endsWith("foo");
    }
}


