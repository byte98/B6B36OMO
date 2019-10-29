package cz.cvut.fel.omo.cv6;

import cz.cvut.fel.omo.cv6.strategy.EveningStrategy;
import cz.cvut.fel.omo.cv6.strategy.MorningStrategy;
import cz.cvut.fel.omo.cv6.strategy.Strategy;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/** Kurz A7B36OMO - Objektove modelovani - Cviceni 6 Design Patterns State, strategy
 *
 *  @author mayerto1
 *
 * The class simulates a street with sequence of traffic lights. The lights are controlled by selected strategy - MorningStrategy before 12 p.m. and EvenningStrategy after
 */
public class Street {

    /** number of traffic lights for the street */
    int numberOfTrafficLights;

    /** control speed of the simulation reasonable values between 0 - for unit tests to 10 - for near real world simulation */
    int timeSpeed;

    /** time of simulation. Important for appropriate strategy. */
    LocalDateTime currentTime;

    /** List of sequence of traffic lights */
    List<TrafficLight> lights = new ArrayList<TrafficLight>();

    /** Current strategy to control traffic
     *
     */
    Strategy strategy;


    /** Creates and switches on the sequence of traffic lights
     *
     */
    public Street(int numberOfTrafficLights, int timeSpeed, LocalDateTime currentTime) {

        // prepare traffic lights
        for (int i = 0; i < numberOfTrafficLights ; i++) {
            lights.add(new TrafficLight());
        }

        this.timeSpeed = timeSpeed;
        this.currentTime = currentTime;

    }


    /** Select an approppriate strategy to control traffic lights and simulates clock impulses that run the traffic light logic
     *
     */
    public void runTrafficLights() {

        // choose the appropriate strategy
        // before 12pm use morning strategy, evening strategy use in the afternoon and evening
        //  TODO - TO BE IMPLEMENTED
        Strategy strategy = null;
        LocalTime now = this.currentTime.toLocalTime();
        if (now.isBefore(LocalTime.NOON))
        {
            strategy = new MorningStrategy(this);
        }
        else
        {
            strategy = new EveningStrategy(this);
        }
        

        // simulates operating of traffic lights for 1000 time units using the strategy
        for (int time = 0; time < 1000; time++) {
            strategy.controlTraffic();

            // print the traffic lights colors
            System.out.print(time);
            System.out.print(" ");
            System.out.println(this.toString());

            // wait for a while
            try {
                Thread.sleep(timeSpeed*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /** Getter
     *
     * @return List of traffic lights
     */
    public List<TrafficLight> getLights() {
        return lights;
    }

    /** Setter
     *
     * @param lights List of traffic lights
     */
    public void setLights(List<TrafficLight> lights) {
        this.lights = lights;
    }

    /** Getter
     *
     * @return Current strategy
     */
    public Strategy getStrategy() {
        return strategy;
    }

    /** Setter
     *
     * @param strategy new strategy
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /** String representation of sequence of traffic lights
     *
     * @return String represantation of current lights color
     */
    public String toString(){

        StringBuffer output = new StringBuffer();
        for(TrafficLight light : lights){
            output.append(light.getLightColor());
            output.append(" ");
        }
        return output.toString();
    }

}
