package cz.cvut.fel.omo.trackingSystem;

/**
 * Tracker is device installed into company vehicles, connected to car computer in order to obtain necessary data.
 */
public class Tracker
{
    // IMPLEMENT ME, PLEASE!
    private Vehicle currentVehicle;
    private final int trackerId;
    private int innerMemory;
    
    public Tracker(int id)
    {
        this.trackerId = id;
    }
    
    public Vehicle getCurrentVehicle()
    {
        return this.currentVehicle;
    }
    
    public void attachTracker(Vehicle vehicle)
    {
        this.currentVehicle = vehicle;
        this.innerMemory = this.currentVehicle.getMileage();
    }
    
    public int getTrackerMileage()
    {
        return (this.currentVehicle.getMileage() - this.innerMemory);
    }
    
    public void resetTrackerMileage()
    {
        this.innerMemory = this.currentVehicle.getMileage();
    }
    
    @Override
    public String toString()    
    {
        return "Tracker_" + this.trackerId + ", attached to " + this.currentVehicle;
    }
    
    
}
