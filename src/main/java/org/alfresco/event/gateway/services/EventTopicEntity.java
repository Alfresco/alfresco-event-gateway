/*
 * Copyright 2018 Alfresco Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *    http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.alfresco.event.gateway.services;


/**
 * Event Topic Entity.
 *
 * @author Jared Ottley
 */
public class EventTopicEntity
{
    private String eventTopic;
    private String brokerUri;

    public EventTopicEntity()
    {
        //NOOP
    }

    public EventTopicEntity(String eventTopic, String brokerUri)
    {
        this.eventTopic = eventTopic;
        this.brokerUri = brokerUri;
    }
    
    public void setEventTopic(String eventTopic)
    {
        this.eventTopic = eventTopic;
    }

    public void setBrokerUri(String brokerUri)
    {
        this.brokerUri = brokerUri;
    }

    public String getEventTopic()
    {
        return eventTopic;
    }

    public String getBrokerUri()
    {
        return brokerUri;
    }
}