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
 * Class for representation of set with even numbers only
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class OMOSetEven implements OMOSetView
{
    private OMOSetView set;
    
    /**
     * Constructor of set with even numbers from another set
     * @param set Set from which will be selected even numbers
     */
    public OMOSetEven(OMOSetView set)
    {
        this.set = set;
    }

    /**
     * Checks, whether even numbers set contains element
     * @param element Element to be checked
     * @return {@code TRUE} if element is in set of even numbers
     *         {@code FALSE} otherwise
     */
    @Override
    public boolean contains(int element)
    {
        return (this.set.contains(element) && element % 2 == 0);
    }

    /**
     * Gets elements of set of even numbers as array
     * @return Array with elements of even numbers set
     */
    @Override
    public int[] toArray()
    {
        List<Integer> evenElements = new ArrayList<>();
        for (int element: this.set.toArray())
        {
            if (this.contains(element))
            {
                evenElements.add(element);
            }
        }
        
        int[] reti = new int[evenElements.size()];
        Iterator<Integer> it = evenElements.iterator();
        for (int i = 0; i < evenElements.size(); i++)
        {
            reti[i] = it.next().intValue();
        }
        return reti;
    }

    /**
     * Gets copy of set of even numbers
     * @return Copy of set of even numbers
     */
    @Override
    public OMOSetView copy()
    {
        OMOSetView reti = null;
        try
        {
            reti = (OMOSetView) this.clone();
        }
        catch (CloneNotSupportedException ex)
        {
            Logger.getLogger(OMOSetEven.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reti;
    }
    
}
