import java.util.ArrayList;

/**
 * <h1>Vehicle</h1> Represents a vehicle
 */

public abstract class Vehicle implements Profitable {
    private String licensePlate;
    private double maxWeight;
    private double currentWeight;
    private int zipDest;
    private ArrayList<Package> packages;
    public int maxRange;


    /**
     * Default Constructor
     */
    //============================================================================
    Vehicle() {
        licensePlate = "";
        maxWeight = 0;
        currentWeight = 0;
        zipDest = 0;
        packages = new ArrayList<>();
        maxRange = 0;
    }
    
    //============================================================================


    /**
     * Constructor
     * 
     * @param licensePlate license plate of vehicle
     * @param maxWeight    maximum weight of vehicle
     */
    //============================================================================
    public Vehicle(String licensePlate, double maxWeight) {
        this.licensePlate = licensePlate;
        this.maxWeight = maxWeight;
        currentWeight = 0.0;
        zipDest = 0;
        packages = new ArrayList<>();
        maxRange = 0;
    }
    
    //============================================================================

    
    /**
     * Returns the license plate of this vehicle
     * 
     * @return license plate of this vehicle
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    
    
    
    
    /**
     * Updates the license plate of vehicle
     * 
     * @param licensePlate license plate to be updated to
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    
    
    
    
    

    /**
     * Returns the maximum weight this vehicle can carry
     * 
     * @return the maximum weight that this vehicle can carry
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    
    
    
    
    /**
     * Updates the maximum weight of this vehicle
     * 
     * @param maxWeight max weight to be updated to
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    
    
    
    
    
    /**
     * Returns the current weight of all packages inside vehicle
     * 
     * @return current weight of all packages inside vehicle
     */
    public double getCurrentWeight() {
        return currentWeight;
    }
    
    
    
    
    

    /**
     * Returns the current ZIP code desitnation of the vehicle
     * 
     * @return current ZIP code destination of vehicle
     */
    public int getZipDest() {
        return zipDest;
    }
    
    
    
    
    

    /**
     * Updates the ZIP code destination of vehicle
     * 
     * @param zipDest ZIP code destination to be updated to
     */
    public void setZipDest(int zipDest) {
        this.zipDest = zipDest;
    }

    
    
    
    
    
    /**
     * Returns ArrayList of packages currently in Vehicle
     * 
     * @return ArrayList of packages in vehicle
     */
    public ArrayList<Package> getPackages() {
        return packages;
    }

    
    
    
    
    
    /**
     * Adds Package to the vehicle only if has room to carry it (adding it would not
     * cause it to go over its maximum carry weight).
     * 
     * @param pkg Package to add
     * @return whether or not it was successful in adding the package
     */
    public boolean addPackage(Package pkg) {
        if (pkg.getWeight() + currentWeight <= maxWeight) {
            packages.add(pkg);
            return true;
        } else
            return false;
    }

    
    
    
    
    
    /**
     * Clears vehicle of packages and resets its weight to zero
     */
    public void empty() {
        packages.clear();
        currentWeight = 0;
    }
    
    
    
    
    

    /**
     * Returns true if the Vehicle has reached its maximum weight load, false
     * otherwise.
     * 
     * @return whether or not Vehicle is full
     */
    public boolean isFull() {
        return currentWeight == maxWeight;
    }

    
    
    
    
    
    /**
     * Fills vehicle with packages with preference of date added and range of its
     * destination zip code. It will iterate over the packages intially at a range
     * of zero and fill it with as many as it can within its range without going
     * over its maximum weight. The amount the range increases is dependent on the
     * vehicle that is using this. This range it increases by after each iteration
     * is by default one.
     * 
     * @param warehousePackages List of packages to add from
     */
    public void fill(ArrayList<Package> warehousePackages) {
        int distance = 0;
        int itemsChecked = 0;
        loop:
        while (true) {
            for (Package i : warehousePackages) {
                if (isFull() || itemsChecked == warehousePackages.size())
                    break loop;
                else {
                    if (Math.abs(i.getDestination().getZipCode() - zipDest) == distance) {
                        itemsChecked++;
                        if(addPackage(i)) {
                            maxRange = distance;
                        }
                    }
                }
            }
            distance++;
        }
    }

    public double getTotalPrice() {
        double profit = 0.0;
        for (Package i : packages) {
            profit += i.getPrice();
        }
        return profit;
    }

    public String getLabels() {
        String labels = "License Plate No.: " + licensePlate + "\n" +
                "Destination: " + zipDest + "\n" +
                "Weight Load: " + String.format("%.2f", currentWeight) +
                "/" + String.format("%.2f", maxWeight) + "\n" +
                "Net Profit: $" + String.format("%.2f", getProfit()) + "\n" +
                "=====Shipping Labels=====\n";
        for (Package i : packages) {
            labels += i.shippingLabel();
        }
        return labels;
    }

    public abstract String report();

    public abstract double getProfit();

    public abstract String getType();



}