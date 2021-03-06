/*
 * Copyright 2018 Alfresco Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.alfresco.event.gateway.metrics;

import org.apache.camel.CamelContext;
import org.apache.camel.component.metrics.routepolicy.MetricsRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jamal Kaabi-Mofrad
 */
@RestController
@RequestMapping("/camel")
public class MetricsController
{
    private final CamelContext camelContext;

    @Autowired
    public MetricsController(CamelContext camelContext)
    {
        this.camelContext = camelContext;
    }

    @RequestMapping(path = "/metrics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMetrics()
    {
        MetricsRegistryService registryService = camelContext.hasService(MetricsRegistryService.class);
        if (registryService != null)
        {
            registryService.setPrettyPrint(true);
            return new ResponseEntity<>(registryService.dumpStatisticsAsJson(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
