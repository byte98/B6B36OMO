/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package cz.cvut.fel.skodaj.b6b36omo.foodchain.config;

/**
 * Class storing all necessary configuration for food chain
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class Configuration
{
    
    /**
     * Instance of configuration (only one in whole system)
     */
    private Configuration instance = null;
    
    private Configuration()
    {
        //pass (singleton)
    };
    
    /**
     * Gets configuration of whole system
     * @return Configuration of whole system
     */
    public Configuration getConfig()
    {
        if (this.instance == null)
        {
            this.instance = new Configuration();
        }
        return this;
    }
}
