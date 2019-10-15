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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing one post in {@code Blog}
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class Post implements DisplayableComponent, EditableComponent
{
    private String content;
    private LocalDateTime last_changed;
    private String label;
    private States.PostState state;
    private User author;
    private List<Comment> comments;
    private List<Topic> topics;
    
    /**
     * Constructor of new post
     * @param content Content of post
     * @param label Label of post
     * @param author Author of post
     */
    public Post(String content, String label, User author)
    {
        this.content = content;
        this.label = label;
        this.author = author;
        this.last_changed = LocalDateTime.now();
        this.state = States.PostState.UNFINISHED;
        this.comments = new ArrayList<>();
        this.topics = new ArrayList<>();
    }
    
    /**
     * Adds comment to post
     * @param text Text of comment
     * @param author Author of comment
     * @return {@code Comment} which was added to this post or {@code null},
     *          if adding of comment failed
     */
    public Comment addComment(String text, User author)
    {
        Comment reti = null;
        if (author != null)
        {
            if (this.state == States.PostState.PUBLISHED)
            {
                reti = new Comment(this, author, text);
                this.comments.add(reti);
            }
        }       
        
        return reti;
    }
    
    /**
     * Adds topic to post
     * @param t Topic to be associated with this post
     */
    public void addTopic(Topic t)
    {
        this.topics.add(t);
    }

    /**
     * Allows to display this post by {@code Dashboard}
     */
    @Override
    public void displayComponent()
    {
        System.out.println(this.label + " by " + this.author + "(" + this.last_changed + ")");
        System.out.println(this.content);
    }
    
    /**
     * Changes posts label to new label
     * @param newLabel New label of the post
     */
    @Override
    public void changeLabel(String newLabel)
    {
        this.label = newLabel;
        this.last_changed = LocalDateTime.now();
    }
    
    /**
     * Changes content of the post to new content
     * @param newContent New content of the post
     */
    @Override
    public void changeContent(String newContent)
    {
        this.content = newContent;
        this.last_changed = LocalDateTime.now();
    }
    
    /**
     * Gets author of the post
     * @return Author of the post
     */
    public User getAuthor()
    {
        return this.author;
    }
    
    /**
     * Gets list of topics associated with this post
     * @return List of topics associated with this post
     */
    public List<Topic> getTopics()
    {
        return this.topics;
    }
    
    /**
     * Gets label of post
     * @return Label of post
     */
    public String getLabel()
    {
        return this.label;
    }
    
    
    
    
}
