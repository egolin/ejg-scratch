/*
 * Copyright (c) 2014 Eric J Golin.
 */

package com.golins.dropwiztest;

import com.golins.dropwiztest.models.Saying;
import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by egolin on 9/30/14.
 */
public class SayingUnitTest {
    private final Logger logger = LoggerFactory.getLogger(SayingUnitTest.class);

    @Test
    public void simpleTest() {
        Saying saying = new Saying(42, "myName");
        assertThat(saying).isNotNull();
        assertThat(saying.getId()).isEqualTo(42L);
        assertThat(saying.getContent()).isEqualTo("myName");
        logger.debug("simpleTest passed");
    }

    @Test
    public void shortTest() {
        Saying saying = new Saying(43, "my");
        assertThat(saying).isNotNull();
        assertThat(saying.getId()).isEqualTo(43L);
        assertThat(saying.getContent()).isEqualTo("my");
        logger.debug("shortTest passed");
    }
    @Test
    public void longTest() {
        Saying saying = new Saying(44, "myNameIsTooLong");
        assertThat(saying).isNotNull();
        assertThat(saying.getId()).isEqualTo(44L);
        assertThat(saying.getContent()).isEqualTo("myNameIsTooLong");
        logger.debug("longTest passed");
    }
}
