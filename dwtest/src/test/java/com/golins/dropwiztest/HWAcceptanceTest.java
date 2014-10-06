/*
 * Copyright (c) 2014 Eric J Golin.
 */

package com.golins.dropwiztest;

import org.junit.Test;
import org.junit.ClassRule;
import static org.fest.assertions.api.Assertions.assertThat;
import com.golins.dropwiztest.resources.HelloWorldResource;
import io.dropwizard.testing.junit.DropwizardAppRule;

import com.golins.dropwiztest.models.Saying;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.net.URL;


/**
 * Created by egolin on 9/30/14.
 */
public class HWAcceptanceTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(HWAcceptanceTest.class);

    private String hwPath() {
        return String.format("http://localhost:%d/hello-world", RULE.getLocalPort());
    }

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE =
            new DropwizardAppRule<HelloWorldConfiguration>(HelloWorldApplication.class, resourceFilePath("hello-world.yml"));

    @Test
    public void hellowWorldAccecptianceTest() {
        Client client = new Client();
        ClientResponse response = client.resource(hwPath()+"?name=acceptTest")
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        assertThat(response.getStatus()).isEqualTo(200);
        Saying saying = response.getEntity(Saying.class);
    }

    private static String resourceFilePath(String name) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        URL resource = loader.getResource(name);
        if (resource == null) {
            throw new IllegalStateException("Couldn't find resource " + name);
        }
        return resource.getFile();

    }
}
