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

/**
 * Class representing one node in binary tree
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class Node
{
    private final int contents;
    private final Node left, right;
    private Node parent;
 
    /**
     * Constructor of node class
     * @param contents Data stored in node
     * @param left Left child of node
     * @param right Right child of node
     */
    public Node(int contents, Node left, Node right)
    {
        this.contents = contents;
        this.left = left;
        this.right = right;
        this.setParentToChilds();
       
    }
    
    /**
     * Sets this node as parent node of its childrens
     */
    private void setParentToChilds()
    {
        if (this.left != null)
        {
            this.left.setParent(this);
        }
        if (this.right != null)
        {
            this.right.setParent(this);
        }
    }
    
    /**
     * Gets data stored in node
     * @return Data stored in node
     */
    public int getContents()
    {
        return this.contents;
    }
    
    /**
     * Gets left child of node
     * @return Left child of node
     */
    public Node getLeftChild()
    {
        return this.left;
    }
    
    /**
     * Gets right child of node
     * @return Right child of node 
     */
    public Node getRightChild()
    {
        return this.right;
    }
    
    /**
     * Sets parent node of this node
     * @param node Parent node of this node
     */
    public void setParent(Node node)
    {
        this.parent = node;
    }
    
    /**
     * Gets parent node of this node
     * @return Parent node of this node
     */
    public Node getParent()
    {
        return this.parent;
    }
    
    /**
     * Gets iterator which goes through tree in preorder way
     * @return Preorder iterator
     */
    public CustomIterator preorderIterator()
    {
        return new PreorderIterator(this);
    }
    
    /**
     * Gets iterator which goes through tree in inorder way
     * @return inorder iterator
     */
    public CustomIterator inorderIterator()
    {
        return new InorderIterator(this);
        
    }
    
    /**
     * Gets iterator which goes through tree in postorder way
     * @return postorder iterator
     */
    public CustomIterator postorderIterator()
    {
        return new PostorderIterator(this);
    }
}
