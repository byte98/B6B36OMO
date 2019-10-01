package cz.cvut.fel.omo.trackingSystem;

/**
 * Class Vehicle represents a single car in company car park.
 */
public class Vehicle
{
    private final String manufacturer;
    private int mileage;
    private final String VINCode;
    // IMPLEMENT ME, PLEASE!
    
    
    public Vehicle(String manufacturer, String VINCode)
    {
        this.manufacturer = manufacturer;
        this.VINCode = VINCode;
        this.mileage = 0;
    }
    
    public Vehicle (String manufacturer, String VINCode, int mileage)
    {
        this.manufacturer = manufacturer;
        this.VINCode = VINCode;
        this.mileage = mileage;
    }
    
    public void drive(int distance)
    {
        this.mileage += distance;
    }

    public String getManufacturer()
    {
        return this.manufacturer;
    }

    public int getMileage()
    {
        return this.mileage;
    }

    public String getVINCode()
    {
        return this.VINCode;
    }
    
    @Override
    public String toString()
    {
        return this.manufacturer + ", " + this.VINCode;
    }
    
    
    
}
