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
package cz.cvut.k36.omo.hw.hw03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class representing postorder iterator of tree
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class PostorderIterator implements CustomIterator
{

    /**
     * Root of iterated tree
     */
    private Node root;
    
    /**
     * Nodes which will be returned by iterator
     */
    private Queue<Node> nodes;
    
    
    
    /**
     * Creates new postorder iterator
     * @param node Root of tree which will be iterated over
     */
    public PostorderIterator(Node node)
    {
        this.root = node;
        this.nodes = new LinkedList<>();
        this.discoverNode(this.root);
    }
    
    /**
     * Discovers nodes childs postorder way
     * @param node 
     */
    private void discoverNode(Node node)
    {
        if (node == null)
        {
            return;
        }
        this.discoverNode(node.getLeftChild());
        this.discoverNode(node.getRightChild());
        this.nodes.add(node);
    }
    
   /**
    * Checks, whether there is any element left
    * @return {@code TRUE} if there is at least one element remaining {@code FALSE} otherwise
    */
    @Override
    public boolean hasNext()
    {
        return (!this.nodes.isEmpty());
        
    }

    /**
     * Gets next value from tree
     * @return Value from tree
     */
    @Override
    public int next()
    {
        return this.nodes.poll().getContents();
    }
    
}
