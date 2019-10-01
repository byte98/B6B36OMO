/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.omo.trackingSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class TrackerTest {
    
    public TrackerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCurrentVehicle method, of class Tracker.
     */
    @Test
    public void testGetCurrentVehicle() {
        System.out.println("getCurrentVehicle");
        Tracker instance = new Tracker(1);
        Vehicle vehicle = new Vehicle("Some", "VIN");
        instance.attachTracker(vehicle);
        Vehicle expResult = vehicle;
        Vehicle result = instance.getCurrentVehicle();
        assertEquals(expResult, result);
    }

    /**
     * Test of attachTracker method, of class Tracker.
     */
    @Test
    public void testAttachTracker() {
        System.out.println("getCurrentVehicle");
        Tracker instance = new Tracker(1);
        Vehicle vehicle = new Vehicle("Some", "VIN");
        instance.attachTracker(vehicle);
        Vehicle expResult = vehicle;
        Vehicle result = instance.getCurrentVehicle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTrackerMileage method, of class Tracker.
     */
    @Test
    public void testGetTrackerMileage() {
        System.out.println("getTrackerMileage");
        Tracker instance = new Tracker(1);
        Vehicle v = new Vehicle("Some", "VIN");
        instance.attachTracker(v);
        v.drive(100);
        int expResult = 100;
        int result = instance.getTrackerMileage();
        assertEquals(expResult, result);
    }

    /**
     * Test of resetTrackerMileage method, of class Tracker.
     */
    @Test
    public void testResetTrackerMileage() {
        System.out.println("resetTrackerMileage");
        Tracker instance = new Tracker(1);
        Vehicle v = new Vehicle("Some", "VIN");
        instance.attachTracker(v);
        v.drive(100);
        instance.resetTrackerMileage();
        int result = instance.getTrackerMileage();
        int expResult = 0;
        assertEquals(expResult, result);
    }
    
}
