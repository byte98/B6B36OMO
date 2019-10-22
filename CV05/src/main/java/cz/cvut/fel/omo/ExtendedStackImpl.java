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
package cz.cvut.fel.omo;

import java.util.NoSuchElementException;

/**
 *
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class ExtendedStackImpl extends StackImpl implements ExtendedStack
{
    
    @Override
    public void push(int[] toInsert)
    {
        for (int element : toInsert)
        {
            this.push(element);
        }
    }

    @Override
    public int top() 
    {
        int reti = this.pop();
        this.push(reti);
        return reti;
    }


    @Override
    public int popFirstNegativeElement() 
    {
        int reti = 0;
        Stack tmpStack = new StackImpl();
        for (int i = 0; i < this.getSize(); i++)
        {
            int val = this.pop();
            if (val < 0)
            {
                reti = val;
                break;
            }
            else
            {
                tmpStack.push(val);
            }
        }
        for (int i = 0; i < tmpStack.getSize(); i++)
        {
            this.push(tmpStack.pop());
        }
        if (reti == 0)
        {
            throw new NoSuchElementException();
        }
        return reti;
    }
    
}
