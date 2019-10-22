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
public class ReverseArrayIterator extends StandardArrayIterator implements Iterator
{   
    public ReverseArrayIterator(int[] data)
    {
        super(data);
        this.index = this.data.length - 1;
    }
    
    @Override
    public int next()
    {
        this.index--;
        this.dataLeft--;
        if (this.isDone())
        {
            throw new NoSuchElementException();
        }
        return this.currentItem();
    }
    
    @Override
    public boolean isDone()
    {
        return this.dataLeft == 0;
    }
    
    @Override
    public int first()
    {
        this.index = this.data.length - 1;
        return this.currentItem();
    }
}
