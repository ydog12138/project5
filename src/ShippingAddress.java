/**
 * <h1>Shipping Address</h1> Represents a shipping address
 */
public class ShippingAddress {
	private String name;
	private String address;
	private String city;
	private String state;
	private int zipCode;

	public ShippingAddress() {
	    name = "";
	    address = "";
	    city = "";
	    state = "";
	    zipCode = 0;
    }

    public ShippingAddress(String name, String address, String city, String state, int zipCode) {
	    this.name = name;
	    this.address = address;
	    this.city = city;
	    this.state = state;
	    this.zipCode = zipCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}