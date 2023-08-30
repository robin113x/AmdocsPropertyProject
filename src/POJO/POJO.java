package POJO;

public class POJO {
	
	private int id;	
	private String propName;
	private String area;
	private float price;
	private String ownerName;
	private String buyerName;
	
	public int getPropID() {
		return id;
	}
	
	public void setPropID(int id) {
		this.id = id;
	}
	
	public String getPropName() {
		return propName;
	}
	
	public void setPropName(String propName) {
		this.propName = propName;
	}
	
	public String getPropArea() {
		return area;
	}
	
	public void setPropArea(String area) {
		this.area = area;
	}
	
	public float getPropPrice() {
		return price;
	}
	
	public void setPropPrice(float price) {
		this.price = price;
	}
	
	public String getPropOwner() {
		return ownerName;
	}
	
	public void setPropOwner(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getPropBuyer() {
		return buyerName;
	}
	
	public void setPropBuyer(String buyerName) {
		this.buyerName = buyerName;
	}
}