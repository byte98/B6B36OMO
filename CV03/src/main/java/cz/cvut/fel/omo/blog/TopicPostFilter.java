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
 * Class representing filter filtering posts by topic
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class TopicPostFilter implements PostFilter
{
    private Topic topic;
    
    /**
     * Creates new filter allowing filter posts by its topic
     * @param t Topic of the posts
     */
    public TopicPostFilter(Topic t)
    {
        this.topic = t;
    }
    
    /**
     * Checks, whether is post associated with topic
     * @param p Post to be checked
     * @return {@code TRUE} if post is associated with this topic, {@code FALSE} otherwise
     */
    @Override
    public boolean matches(Post p)
    {
        boolean reti = false;
        for (Topic t : p.getTopics())
        {
            if (t.getName().equals(this.topic.getName()))
            {
                reti = true;
                break;
            }
        }
        return reti;
    }
    
    
}
