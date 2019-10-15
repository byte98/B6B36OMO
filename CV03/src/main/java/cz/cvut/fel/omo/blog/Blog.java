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
 *
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class Blog
{
    private List<User> users;
    private List<Post> posts;
    private List<Topic> topics;
    
    public Blog()
    {
        this.users = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.topics = new ArrayList<>();
    }
    
    /**
     * Creates new user in blog
     * @param username Username of new user
     * @param password Password of new user
     * @param admin Is new user admin? ({@code TRUE} if yes, {@code FALSE} otherwise)
     * @return {@code TRUE} if account was sucessfully created, {@code FALSE} otherwise
     */
    public boolean createNewAccount(String username, String password, boolean admin)
    {
        boolean reti = true;
        for (User u : this.users)
        {
            if (u.getUserName().equals(username))
            {
                reti = false;
            }
        }
        if (reti = true)
        {
            this.users.add(new User(username, password, admin, this));
        }
        return reti;
        
    }
    
    /**
     * Function to try to log in user
     * @param username Username of user
     * @param password Password of that user
     * @return {@code User} which is logged in or {@code null} if there is no
     *          user with that login data
     */
    public User login(String username, String password)
    {
        User reti = null;
        for (User u : this.users)
        {
            if (u.getUserName().equals(username))
            {
                if (u.checkPassword(password) && u.getState() == States.UserState.ACTIVE)
                {
                    reti = u;
                }
                break;
            }
        }
        return reti;
    }
    
    /**
     * Adds new post to blog
     * @param content Content of post
     * @param label Label of post
     * @param author Author of post
     * @return {@code Post} which was added to blog or {@code null}, if adding post failed
     */
    public Post addPost(String content, String label, User author)
    {
        Post reti = null;
        if (author.isAdmin())
        {
            reti =  new Post(content, label, author);
            this.posts.add(reti);
        }        
        return reti;
    }
    
    /**
     * Adds topic to blog if it isn't yet in blog
     * @param name Name of topic
     * @param description Description of topic
     * @param author Author of the topic
     * @return {@code Topic} with entered name or {@code null}, if adding topic failed
     */
    public Topic addTopic(String name, String description, User author)
    {
        Topic reti = null;
        if (author.isAdmin())
        {
            for (Topic t : this.topics)
            {
                if (t.getName().equals(name))
                {
                    reti = t;
                    break;
                }
            }

            if (reti == null)
            {
                reti = new Topic(name, description, this);
                this.topics.add(reti);
            }
        }
        return reti;
        
    }
    
    /**
     * Gets post filtered by filter
     * @param filter Filter which filters posts
     * @return List of filtered posts
     */
    public List<Post> getPosts(PostFilter filter)
    {
        List<Post> reti = new ArrayList<>();
        for (Post p: this.posts)
        {
            if (filter.matches(p))
            {
                reti.add(p);
            }
        }
        return reti;
    }
    
    /**
     * Gets user from blog
     * @param username Username of blog which will be searched
     * @param finder User who search for user from blog
     * @return {@code User} if searching finished successfully or {@code null} if not
     */
    public User getUser(String username, User finder)
    {
        User reti = null;
        if (finder.isAdmin())
        {
            for (User u : this.users)
            {
                if (u.getUserName().equals(username))
                {
                    reti = u;
                    break;
                }
            }
        }
        return reti;
    }
    
    /**
     * Allows admins to ban user
     * @param username User to be banned
     * @param admin Admin which can ban users
     */
    public void banUser(String username, User admin)
    {
        if (admin.isAdmin())
        {
            User u = this.getUser(username, admin);
            u.banUser(admin, States.UserState.BANNED);
        }
    }
    
    /**
     * Allows admins to unban user
     * @param username Username to be unbanned
     * @param admin ADmin which can unban users
     */
    public void unbanUser(String username, User admin)
    {
        if (admin.isAdmin())
        {
            User u = this.getUser(username, admin);
            u.banUser(admin, States.UserState.ACTIVE);
        }
    }
}
