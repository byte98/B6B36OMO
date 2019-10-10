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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for union of two sets
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class OMOSetUnion implements OMOSetView
{
    private OMOSetView setA;
    private OMOSetView setB;
    
    /**
     * Constructor of union
     * @param setA First set in union
     * @param setB Second set in union
     */
    public OMOSetUnion(OMOSetView setA, OMOSetView setB)
    {
        this.setA = setA;
        this.setB = setB;
    }
    
    /**
     * Checks, whether element is in union of sets
     * @param element Element to be checked
     * @return {@code TRUE} if is in union, {@code FALSE}  otherwise
     */
    @Override
    public boolean contains(int element)
    {
        return (this.setA.contains(element)) || (this.setB.contains(element));
    }
    
    /**
     * Gets elements in union as array
     * @return Array of elements from union
     */
    @Override
    public int[] toArray()
    {
        List<Integer> unionElements = new ArrayList<>();
        
        int[] elementsA = this.setA.toArray();
        for (int element : elementsA)
        {
            unionElements.add(element);
        }
        
        int[] elementsB = this.setB.toArray();
        for (int element: elementsB)
        {
            if (unionElements.contains(element) == false)
            {
                unionElements.add(element);
            }
        }
        
        int[] reti = new int[unionElements.size()];
        Iterator<Integer> it = unionElements.iterator();
        for (int i = 0; i < unionElements.size(); i++)
        {
            reti[i] = it.next().intValue();
        }
        return reti;
    }
    
    
    /**
     * Gets copy of union of sets
     * @return Copy of union of sets
     */
    @Override
    public OMOSetView copy()
    {
        OMOSetView reti = null;
        try
        {
            reti = (OMOSetView) this.clone();
        } catch (CloneNotSupportedException ex)
        {
            Logger.getLogger(OMOSetUnion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reti;
    }
    
    
    
}
