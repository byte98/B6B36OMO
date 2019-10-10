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
package cz.cvut.k36.omo.hw.hw02;

/**
 * Main class for program
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class Main
{
    /**
     * Entry point of program
     * @param args Argument of program
     */
    public static void main(String[] args)
    {
        OMOSet setA = new OMOSet();
        setA.add(0);
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);
        setA.add(6);
        setA.add(7);
        setA.add(8);
        setA.add(9);
        setA.add(10);
        
        OMOSet setB = new OMOSet();
        setB.add(5);
        setB.add(6);
        setB.add(7);
        setB.add(8);
        setB.add(9);
        setB.add(10);
        setB.add(11);
        setB.add(12);
        setB.add(13);
        setB.add(14);
        setB.add(15);
        
        System.out.print("     A:=");
        Main.printSet(setA);
        System.out.println("");
        
        System.out.print("     B:=");
        Main.printSet(setB);
        System.out.println("");
        
        OMOSetUnion union = new OMOSetUnion(setA, setB);
        System.out.print("  A\\/B:=");
        Main.printSet(union);
        System.out.println("");
        
        OMOSetIntersection intersection = new OMOSetIntersection(setA, setB);
        System.out.print("  A/\\B:=");
        Main.printSet(intersection);
        System.out.println("");
        
        OMOSetComplement complement = new OMOSetComplement(setA, setB);
        System.out.print("   A\\B:=");
        Main.printSet(complement);
        System.out.println("");
        
        OMOSetEven even = new OMOSetEven(setA);
        System.out.print("A_even:=");
        Main.printSet(even);
        System.out.println("");
        
        
    }
    
    /**
     * Prints elements from set
     * @param set Set of elements, which will be printed
     */
    public static void printSet(OMOSetView set)
    {
        int[] elements = set.toArray();
        for (int i = 0; i < elements.length; i++)
        {
            if (i == 0)
            {
                System.out.print("{ ");
            }
            System.out.print(elements[i]);
            if (i < elements.length - 1)
            {
                System.out.print(", ");
            }
            else
            {
                System.out.print(" }");
            }
        }
    }
}
