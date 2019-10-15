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
 * Interface which allows post filtering
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public interface PostFilter
{
    /**
     * Check, whether post matches filter
     * @param p Post to be checked by this filter
     * @return {@code TRUE} if filter matches this post, {@code FALSE} otherwise
     */
    public boolean matches(Post p);
}
