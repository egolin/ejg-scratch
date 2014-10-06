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

package com.golins.cellar.application;


import com.golins.cellar.api.Cellar;
import com.golins.cellar.api.Wine;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by egolin on 10/3/14.
 */
@Singleton
@Path("winecellar/{owner}")
public class CellarResource {
    private Map<String, Cellar> cellarDB = new ConcurrentHashMap<String, Cellar>();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCellar(@PathParam("owner") String owner) {
        if (!cellarDB.containsKey(owner))
            throw new NotFoundException(String.format("No wine cellar found for '%s'.", owner));
        return Response.ok(cellarDB.get(owner)).build();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response createCellar(@PathParam("owner") String owner, String description) {
        Cellar newCellar = new Cellar(owner, description);
        cellarDB.put(owner, newCellar);
        return Response.ok().build();
    }

    @POST
    @Path("/wine")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createWine(@PathParam("owner") String owner, Wine wine) {
        if (!cellarDB.containsKey(owner))
            throw new NotFoundException(String.format("No wine cellar found for '%s'.", owner));
        Cellar cellar = cellarDB.get(owner);
        cellar.addWine(wine);
        return Response.ok().build();
    }
}
