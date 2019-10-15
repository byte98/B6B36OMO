/*
 * Copyright 2019 Jiri Skoda <skodaji4@fel.cvut.cz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.cvut.fel.omo.blog;

/**
 * Class definining user role in blog
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class UserRole
{
    private String name;
    
    /**
     * Creates new user role
     * @param name Name of new user role
     */
    public UserRole(String name)
    {
        this.name = name;
    }
    
    /**
     * Gets name of user role
     * @return Name of user role
     */
    public String getName()
    {
        return this.name;
    }
    
}
