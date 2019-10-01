package cz.cvut.fel.omo.trackingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuki on 22/09/2017.
 * GpsTrackingSystem class represents the newly introduced tool for gaining control over company car park.
 */
public class GpsTrackingSystem {
    // IMPLEMENT ME, PLEASE!
    
    private List<Tracker> activeTrackers;
    public static int counter = 0;
    
    public GpsTrackingSystem()
    {
        this.activeTrackers = new ArrayList<>();
    }
    
    public void attachTrackingDevices(List<Vehicle> vehicles)
    {
        for (Vehicle v: vehicles)
        {
            GpsTrackingSystem.counter++;
            Tracker t = new Tracker(GpsTrackingSystem.counter);
            t.attachTracker(v);
            this.activeTrackers.add(t);
        }
    }
    
    public void generateMonthlyReport()
    {
        System.out.println("=== GPS Tracking system: Monthly report ===");
        System.out.println("Currently active devices:");
        
        int distance = 0;
        for(Tracker t : this.activeTrackers)
        {
            System.out.println(t);
            distance += t.getTrackerMileage();
            t.resetTrackerMileage();
        }
        System.out.println("-------------------------------------------");
        System.out.println("This month travelled distance: " + distance + " km");
        System.out.println("");
        
    }
}
