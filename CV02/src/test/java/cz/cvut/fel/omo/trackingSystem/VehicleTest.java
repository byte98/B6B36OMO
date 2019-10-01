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
public class VehicleTest {
    
    public VehicleTest() {
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
     * Test of drive method, of class Vehicle.
     */
    @Test
    public void testDrive() {
        System.out.println("drive");
        int initMileage = 100;
        int distance = 100;
        Vehicle instance = new Vehicle("Some", "VIN", initMileage);
        instance.drive(distance);
        assertEquals((initMileage + distance), instance.getMileage());
    }

    /**
     * Test of getManufacturer method, of class Vehicle.
     */
    @Test
    public void testGetManufacturer() {
        System.out.println("getManufacturer");
        Vehicle instance = new Vehicle("Some", "VIN");
        String expResult = "Some";
        String result = instance.getManufacturer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMileage method, of class Vehicle.
     */
    @Test
    public void testGetMileage() {
        System.out.println("getMileage");
        Vehicle instance = new Vehicle("Some", "VIN", 1000);
        int expResult = 1000;
        int result = instance.getMileage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVINCode method, of class Vehicle.
     */
    @Test
    public void testGetVINCode() {
        System.out.println("getVINCode");
        Vehicle instance = new Vehicle("Some", "VIN");
        String expResult = "VIN";
        String result = instance.getVINCode();
        assertEquals(expResult, result);
    }
}
