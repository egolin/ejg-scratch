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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by egolin on 10/3/14.
 */
public class Wine {
    @JsonProperty
    private final String winery;

    @JsonProperty
    private final Integer vintageYear;

    @JsonProperty
    private final String variety;

    @JsonProperty
    private final String wineName;

    @JsonProperty
    private Integer countBottles;

    public Wine() { winery = null;  variety = null;  wineName = null; vintageYear = 0; countBottles = 0;}

    public Wine(String winery, Integer vintageYear, String variety, String wineName, Integer countBottles) {
        this.winery = winery;
        this.vintageYear = vintageYear;
        this.variety = variety;
        this.wineName = wineName;
        this.countBottles = countBottles;
    }

    /**
     * @return  Name of the winery or Chateu
     */
    public String getWinery() { return winery; }

    /**
     * @return Year of the vintage
     */
    public Integer getVintageYear() { return vintageYear; }

    /**
     * @return Primary wine variatel
     */
    public String variety() { return variety; }

    /**
     * @return Name of wine
     */
    public String wineName() { return wineName; }

    /**
     * @return Number of bottles in cellar.
     */
    public int countBottles() { return countBottles; }


}
