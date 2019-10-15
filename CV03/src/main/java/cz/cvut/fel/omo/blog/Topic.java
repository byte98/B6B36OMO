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
 * Class representing topic on {@code Blog}
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class Topic implements DisplayableComponent
{
    private String name;
    private String description;
    private Blog blog;
    
    /**
     * Creates new topic
     * @param name Name of topic
     * @param description Description of topic
     * @param blog Blog to which this topic belongs to
     */
    public Topic(String name, String description, Blog blog)
    {
        this.name = name;
        this.description = description;
        this.blog = blog;
    }

    @Override
    public void displayComponent()
    {
        System.out.println("[" + this.name + "] " + this.description);
    }
    
    /**
     * Gets name of topic
     * @return Name of topic
     */
    public String getName()
    {
        return this.name;
    }
}
