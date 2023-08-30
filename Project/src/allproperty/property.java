package allproperty;

public class property {

	int propertyid;
	String property_name;
	int price;
	String area;
	String valid;


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
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}



	public property(int propertyid, String property_name, int price, String area,String valid) {
		super();
		this.propertyid = propertyid;
		this.property_name = property_name;
		this.price = price;
		this.area = area;
		this.valid = valid;
	}

	public property() {
		super();
	}

	public property(int propertyid) {
		super();
		this.propertyid = propertyid;
	}
	public property(String area) {
		super();
		this.area = area;
	}


}



