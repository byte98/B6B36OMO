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
 * Class for creating complement set to another set
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class OMOSetComplement implements OMOSetView
{
    private OMOSetView setA;
    private OMOSetView setB;
    private OMOSetIntersection intersection;
    
    /**
     * Constructor of complement set to set
     * @param setA The main set
     * @param setB The set which part is out of setA
     */
    public OMOSetComplement (OMOSetView setA, OMOSetView setB)
    {
        this.setA = setA;
        this.setB = setB;
    }

    /**
     * Checks, whether element is member of complement
     * @param element Element to be checked
     * @return {@code TRUE} if is element in complement, {@code FALSE} otherwise
     */
    @Override
    public boolean contains(int element)
    {
        return (this.setA.contains(element) && this.setB.contains(element) == false);
    }

    /**
     * Gets elements of complement as array
     * @return Array with elements from complements
     */
    @Override
    public int[] toArray()
    {
        List<Integer> complementElements = new ArrayList<>();
        for (int element: this.setA.toArray())
        {
            if (this.contains(element))
            {
                complementElements.add(element);
            }
        }
        
        int[] reti = new int[complementElements.size()];
        Iterator<Integer> it = complementElements.iterator();
        for (int i = 0; i < complementElements.size(); i++)
        {
            reti[i] = it.next().intValue();
        }
        return reti;
    }

    /**
     * Gets copy of set complement
     * @return Copy of set complement
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
            Logger.getLogger(OMOSetComplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reti;
    }
    
}
