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
package cz.cvut.fel.skodaj.b6b36omo.cv07;



interface Movable
{
    int getX();
    
    int getY();

    void move (int dx, int dy);
}

interface MobileObject
{
    void moveTo(int x, int y);
}

class MovableAdapter implements Movable
{
    private MobileObject mobileObj;
    private int X = 0;
    private int Y = 0;
    
    public MovableAdapter(int x, int y, MobileObject obj)
    {
        this.X = x;
        this.Y = y;
        this.mobileObj = obj;
    }

    @Override
    public int getX()
    {
        return this.X;
    }

    @Override
    public int getY()
    {
        return this.Y;
    }

    @Override
    public void move(int dx, int dy)
    {
        this.X += dx;
        this.Y += dy;
        
        this.mobileObj.moveTo(this.X, this.Y);
    }
    
}
