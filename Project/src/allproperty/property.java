package allproperty;

public class property {

	int propertyid;
	String property_name;
	int price;
	String area;


	public int getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	public String getProperty_name() {
		return property_name;
	}
	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}


	public property(int propertyid, String property_name, int price, String area) {
		super();
		this.propertyid = propertyid;
		this.property_name = property_name;
		this.price = price;
		this.area = area;
	}

	public property() {
		super();
	}

	public property(int propertyid) {
		super();
		this.propertyid = propertyid;
	}

}



