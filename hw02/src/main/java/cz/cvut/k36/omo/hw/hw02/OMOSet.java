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
 * Class representing basic class
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class OMOSet extends OMOSetBase implements OMOSetView
{
    private List<Integer> elements;
    
    /**
     * Constructor of class
     * Prepares space for set elements
     */
    public OMOSet()
    {
        this.elements = new ArrayList<>();
    }
    
    /**
     * Adds element to the set
     * @param element Element to be added to set
     */
    @Override
    public void add(int element)
    {
        if (this.elements.contains(element) == false)
        {
            this.elements.add(element);
        }
    }
    
    /**
     * Removes element from the set
     * @param element Element to be removed from set
     */
    @Override
    public void remove(int element)
    {
        if (this.elements.contains(element))
        {
            this.elements.remove((Object) element);
        }
    }
    
    /**
     * Function to check, whether element is in set or not
     * @param element Element which should be checked
     * @return {@code TRUE} if element is in the set, {@code FALSE} otherwise
     */
    @Override
    public boolean contains(int element)
    {
        boolean reti = this.elements.contains(element);
        return reti;
    }
    
    /**
     * Gets elements from the set in array
     * @return Array with elements of the set
     */
    @Override
    public int[] toArray()
    {
        int[] reti = new int[this.elements.size()];
        Iterator<Integer> it = this.elements.iterator();
        for (int i = 0; i < this.elements.size(); i++)
        {
            reti[i] = it.next().intValue();
        }
        return reti;
    }
    
    /**
     * Gets copy of the set
     * @return Copy of the set
     */
    @Override
    public OMOSetView copy()
    {
        OMOSet reti = new OMOSet();
        
        for (int element: this.toArray())
        {
            reti.add(element);
        }
        
        return reti;
    }
}
