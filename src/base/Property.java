package base;

public class Property {

	private int Prop_id;
	private String Prop_name;
	private String prop_location;
	private float prop_price;
	private String prop_type;


	public String getProp_type() {
		return prop_type;
	}

	public void setProp_type(String prop_type) {
		this.prop_type = prop_type;
	}

	public int getProp_id() {
		return Prop_id;
	}

	public void setProp_id(int prop_id) {
		this.Prop_id = prop_id;
	}
	public String getProp_name() {
		return Prop_name;
	}
	public void setProp_name(String prop_name) {
		this.Prop_name = prop_name;
	}
	public String getProp_location() {
		return prop_location;
	}
	public void setProp_location(String prop_location) {
		this.prop_location = prop_location;
	}
	public float getProp_price() {
		return prop_price;
	}
	public void setProp_price(float prop_price) {
		this.prop_price = prop_price;
	}

	public Property() {}
	public Property(int prop_id, String prop_name, String prop_location, float prop_price, String prop_type) {
		
		Prop_id = prop_id;
		Prop_name = prop_name;
		this.prop_location = prop_location;
		this.prop_price = prop_price;
		this.prop_type = prop_type;
	}

	@Override
	public String toString() {
		return "Property [Prop_id=" +  Prop_id + " , Prop_name=" + Prop_name + ", prop_location=" + prop_location
				+ ", prop_price=" + prop_price + ", prop_type=" + prop_type + "]";
	}
}
