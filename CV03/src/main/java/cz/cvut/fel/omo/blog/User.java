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

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing user in blog
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class User
{
    private UserRole role;
    private String username;
    private String password;
    private Blog blog;
    private States.UserState state;
    
    /**
     * Creates new user
     * @param username Username of new user
     * @param password Password of new user
     * @param isAdmin Is new user admin? ({@code TRUE} if yes, {@code FALSE} if not)
     */
    public User(String username, String password, boolean isAdmin, Blog blog)
    {
        this.username = username;
        this.password = password;
        this.role = isAdmin ? new UserRole("admin") : new UserRole("user");
        this.blog = blog;
        this.state = States.UserState.ACTIVE;
    }
    
    /**
     * Checks, whether user is admin
     * @return {@code TRUE} if is admin, {@code FALSE} otherwise
     */
    public boolean isAdmin()
    {
        return "admin".equals(this.role.getName());
    }
    
    /**
     * Gets username of user
     * @return Username of user
     */
    public String getUserName()
    {
        return this.username;
    }
    
    /**
     * Checks, if entered password matches with users password
     * @param password Password to be checked
     * @return {@code TRUE} if passwords matches, {@code FALSE} otherwise
     */
    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }
    
    /**
     * Gets list of posts, where is the user author
     * @return List of posts
     */
    public List<Post> getUsersPosts()
    {
        UserPostFilter filter = new UserPostFilter(this);
        List<Post> reti = this.blog.getPosts(filter);
        return reti;
    }
    
    @Override
    public String toString()
    {
        return this.getUserName() + " [" + (this.isAdmin() ? "admin" : "basic") + "]";
    }
    
    
    /**
     * Allows to change users state
     * @param admin Admin who can change users state
     * @param newState New state of user
     */
    public void banUser(User admin, States.UserState newState)
    {
        if (admin.isAdmin())
        {
            this.state = newState;
        }
    }
    
    /**
     * Gets state of user
     * @return State of user
     */
    public States.UserState getState()
    {
        return this.state;
    }
}
