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
public class StandardArrayIterator implements Iterator
{
    protected int[] data;
    protected int index = 0;
    protected int dataLeft;
    
    public StandardArrayIterator(int[] data)
    {
        this.data = data;
        this.dataLeft = this.data.length;
    }

    @Override
    public int currentItem()
    {
        if (this.isDone())
        {
            throw new NoSuchElementException();
        }
        return this.data[this.index];
    }

    @Override
    public int next()
    {
        this.index++;
        this.dataLeft --;
        return this.currentItem();
    }

    @Override
    public boolean isDone()
    {
        return this.index >= this.data.length;
    }

    @Override
    public int first()
    {
        this.index = 0;
        return this.currentItem();
    }
    
}
