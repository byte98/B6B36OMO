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
 * testing program for third homework
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class program
{
    public static void main(String[] args)
    {
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(8, null, null);
        Node n12 = new Node(2, n2, n1);
        
        Node n3 = new Node(5, null, null);
        Node n4 = new Node(4, null, null);
        Node n34 = new Node(6, n3, n4);
        
        Node n5 = new Node(9, null, null);
        Node n345 = new Node(7, n34, n5);
        
        Node root = new Node(3, n345, n12);
        
        CustomIterator inorder = root.inorderIterator();
        while (inorder.hasNext())
        {
            System.out.print(inorder.next() + " ");
        }
        System.out.println("");
        System.out.println("---");
        
        CustomIterator preorder = root.preorderIterator();
        while (preorder.hasNext())
        {
            System.out.print(preorder.next() + " ");
        }
        System.out.println("");
        System.out.println("---");
        
        CustomIterator postorder = root.postorderIterator();
        while (postorder.hasNext())
        {
            System.out.print(postorder.next() + " ");
        }
        System.out.println("");
        System.out.println("---");        
        
    }
}
