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
package cz.cvut.fel.skodaj.b6b36omo.foodchain.parties;

import cz.cvut.fel.skodaj.b6b36omo.foodchain.exceptions.*;

/**
 * Class which creates parties in food chain
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class PartyFactory
{
    
    public static Party createParty(String type, String name) throws NotSuchAPartyCanBeCreatedException
    {
        Party reti = null;
        switch (type.toUpperCase())
        {
            case "FARMER":                                              //Create farmer
                reti = PartyFactory.createFarmer(name);
                break;
            default:
                throw new NotSuchAPartyCanBeCreatedException(type);
        }
        return reti;
    }
    
    /**
     * Creates farmer
     * @param name Name of farmer
     * @return New farmer with set name
     */
    public static Farmer createFarmer(String name)
    {
        return new Farmer(name);
    }
}
