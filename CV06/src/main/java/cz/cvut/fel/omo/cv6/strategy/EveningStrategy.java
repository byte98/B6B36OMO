package cz.cvut.fel.omo.cv6.strategy;

import cz.cvut.fel.omo.cv6.Street;
import cz.cvut.fel.omo.cv6.TrafficLight;

// TODO - TO BE IMPLEMENTED

public class EveningStrategy extends Strategy
{
    private int time = 0;

    public EveningStrategy(Street street)
    {
        super(street);
    }

    @Override
    public void controlTraffic()
    {
        int counter = 0;
        for (int i = this.street.getLights().size() - 1; i >= 0; i--)
        {
            TrafficLight tl = this.street.getLights().get(i);
            if (time - counter * lightDistance == 0)
            {
                tl.startGoSequence();
            }
            else
            {
                tl.timeLapseTick();
            }
            counter++;
        }
        time++;
        
    }
    
}