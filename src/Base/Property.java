package Base;

public class Property {
	public int floor,id,price;

	public String building,tower;
	public boolean status;
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getTower() {
		return tower;
	}

	public void setTower(String tower) {
		this.tower = tower;
	}
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Property(int id, int floor, int price, String building, String tower, boolean status) {
		super();
		this.floor = floor;
		this.id = id;
		this.building = building;
		this.tower = tower;
		this.price = price;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Property [floor=" + floor + ", id=" + id + ", building=" + building + ", tower=" + tower
				+ ", PropertiesCol=" + price + ", status=" + status + "]";
	}

	

	
}
