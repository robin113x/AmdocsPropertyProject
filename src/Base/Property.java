package Base;

public class Property {
	public int floor,id;

	public String building,tower,PropertiesCol;

	public String getPropertiesCol() {
		return PropertiesCol;
	}

	public void setPropertiesCol(String propertiesCol) {
		PropertiesCol = propertiesCol;
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

	@Override
	public String toString() {
		return "Property [floor=" + floor + ", id=" + id + ", building=" + building + ", tower=" + tower + "]";
	}

	public Property(int id, int floor, String propertiesCol, String building, String tower) {
		super();
		this.floor = floor;
		this.id = id;
		this.building = building;
		this.tower = tower;
		PropertiesCol = propertiesCol;
	}

	
}
