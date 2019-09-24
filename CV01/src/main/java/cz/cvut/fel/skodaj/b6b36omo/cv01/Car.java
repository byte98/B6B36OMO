/*
 * Copyright 2019 Jiří Škoda <skodaji4@fel.cvut.cz>.
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
package cz.cvut.fel.skodaj.b6b36omo.cv01;

import java.util.ArrayList;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class Car
{
    private Wheel[] wheels;
    private int year_manufacture;
    private String colour;
    static int cars_created = 0;
    
    private Car(int wheels_count, int wheels_diameter, String colour, int year_manufacture)
    {
        this.year_manufacture = year_manufacture;
        this.colour = colour;
        this.wheels = new Wheel[wheels_count];
        for (int i = 0; i < wheels_count; i++)
        {
            this.wheels[i] = new Wheel(wheels_diameter);
        }
        Car.cars_created++;
    }
    
    @Override
    public String toString()
    {
        return "Car: " + this.wheels.length + " wheels (D" + this.wheels[0].getDiameter() + "); year: " + this.year_manufacture + "; colour: " + this.colour;
    }
    
    static Car createLorry()
    {
        return new Car(6, 50, "orange", 2018);
    }
    
    static Car createPersonal()
    {
        return new Car(4, 17, "red", 2019);
    }
}
