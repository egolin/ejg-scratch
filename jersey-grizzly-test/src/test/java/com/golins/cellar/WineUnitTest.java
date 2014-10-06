/*
 * Copyright (c) 2014 Eric J Golin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.golins.cellar;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.fest.assertions.api.Assertions.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.golins.cellar.api.Wine;

/**
 * Created by egolin on 10/5/14.
 */
public class WineUnitTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger("com.golins.cellar");
    private final String test_json = "{\"winery\":\"testWinery\",\"vintageYear\":2000,\"variety\":\"testVariety\",\"wineName\":\"testWineName\",\"countBottles\":2}";


    @Test
    public void serializesToJSON() throws Exception {
        final Wine wine = new Wine("testWinery", 2000, "testVariety", "testWineName", 2);
        final String wine_json = MAPPER.writeValueAsString(wine);
        assertThat(wine_json).isNotNull();
        assertThat(wine_json).isEqualTo(test_json);
    }

    @Test
    public void desearializesFromJSON() throws Exception {
        final Wine test_wine = new Wine("testWinery", 2000, "testVariety", "testWineName", 2);
        final Wine json_wine = MAPPER.readValue(test_json, Wine.class);
        assertThat(json_wine).isNotNull();
        assertThat(json_wine).isEqualsToByComparingFields(test_wine);
    }
}
