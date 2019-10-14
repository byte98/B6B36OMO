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
 * Class for intersection of two sets
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class OMOSetIntersection implements OMOSetView
{
    private OMOSetView setA;
    private OMOSetView setB;
    
    /**
     * Constructor of intersection of two sets
     * @param setA First set, which will be in intersection
     * @param setB Second set, which will be in intersection
     */
    public OMOSetIntersection(OMOSetView setA, OMOSetView setB)
    {
        this.setA = setA;
        this.setB = setB;
    }
    
    /**
     * Checks, whether element is in intersection of sets or not
     * @param element Element to be checked
     * @return {@code TRUE} if is in intersection, {@code FALSE}  otherwise
     */
    @Override
    public boolean contains(int element)
    {
        return this.setA.contains(element) && this.setB.contains(element);
    }
    
    /**
     * Gets elements of intersection of sets as array
     * @return Array with elements from intersection
     */
    @Override
    public int[] toArray()
    {
        List<Integer> intersectionElements = new ArrayList<>();
        for (int element: this.setA.toArray())
        {
            if (this.contains(element))
            {
                intersectionElements.add(element);
            }
        }
        for (int element: this.setB.toArray())
        {
            if (this.contains(element) && intersectionElements.contains(element) == false)
            {
                intersectionElements.add(element);
            }
        }
        
        int[] reti = new int[intersectionElements.size()];
        Iterator<Integer> it = intersectionElements.iterator();
        for (int i = 0; i < intersectionElements.size(); i++)
        {
            reti[i] = it.next().intValue();
        }
        return reti;
    }
    
    /**
     * Creates copy of intersection of sets
     * @return Copy of intersection of sets
     */
    @Override
    public OMOSetView copy()
    {
        OMOSet setA = new OMOSet();
        for (int element: this.setA.toArray())
        {
            setA.add(element);
        }
        
        OMOSet setB = new OMOSet();
        for (int element: this.setB.toArray())
        {
            setB.add(element);
        }
        
        OMOSetIntersection reti = new OMOSetIntersection(setA, setB);
        return reti;
    }
}
