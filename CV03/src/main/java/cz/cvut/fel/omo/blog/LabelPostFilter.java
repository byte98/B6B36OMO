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
 * Class representing filter which can filter posts by its label
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class LabelPostFilter implements PostFilter
{
    
    private String label;
    
    /**
     * Creates new post filter which allows filter posts by its label
     * @param label Label of posts
     */
    public LabelPostFilter(String label)
    {
        this.label = label;
    }
    
    /**
     * Checks if posts label equals filters label
     * @param p Post to be checked
     * @return {@code TRUE} if post has filters label, {@code FALSE} otherwise
     */
    @Override
    public boolean matches(Post p)
    {
        return (p.getLabel().equals(this.label));
    }
}
