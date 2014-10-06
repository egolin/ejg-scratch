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

package com.golins.cellar.api;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by egolin on 10/3/14.
 */
public class Cellar {
    private List<Wine> wines;
    private String owner;
    private String description;
    private Date created;

    @JsonProperty
    public List<Wine> getWines() { return wines; }
    public void addWine(Wine wine) {
        wines.add(wine);
    }

    @JsonProperty
    public String getOwner() { return owner; }

    @JsonProperty
    public String getDescription() { return description; }

    public Cellar(String owner, String description) {
        this.owner = owner;
        this.description = description;
        this.created = new Date();
        this.wines = new ArrayList<Wine>();
    }
}
