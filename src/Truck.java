import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;


/**
 * <h1>Truck</h1> Represents a Truck
 */
public class Truck extends Vehicle {

    private final double GAS_RATE = 1.66;

    /**
     * Default Constructor
     */
    //============================================================================
    public Truck() {
        super();
    }
    
    //============================================================================

    /**
     * Constructor
     * 
     * @param licensePlate license plate of vehicle
     * @param maxWeight    maximum weight that the vehicle can hold
     */
    //============================================================================
    public Truck(String licensePlate, double maxWeight) {
        super(licensePlate, maxWeight);
    }
    
    //============================================================================

    /*
     * =============================================================================
     * | Methods from Profitable Interface
     * =============================================================================
     */
    /**
     * Returns the profits generated by the packages currently in the Vehicle.
     * <p>
     * &sum;p<sub>price</sub> - (range<sub>max</sub> &times; 1.66)
     * </p>
     */
    @Override
    public double getProfit() {
        return getTotalPrice() - maxRange * GAS_RATE;
    }

    /**
     * Generates a String of the truck report. Truck report includes:
     * <ul>
     * <li>License Plate No.</li>
     * <li>Destination</li>
     * <li>Current Weight/Maximum Weight</li>
     * <li>Net Profit</li>
     * <li>Shipping labels of all packages in truck</li>
     * </ul>
     * 
     * @return Truck Report
     */
    @Override
    public String report() {
        return "==========Truck Report==========\n" + getLabels();
    }

    @Override
    public String getType() {
        return "Truck";
    }
}