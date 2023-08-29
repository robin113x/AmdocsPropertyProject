package base;

public class PropertyNotFoundException extends Exception {
	public PropertyNotFoundException() {
		super();
		System.out.println("Property not found, invalid");
	}

}
