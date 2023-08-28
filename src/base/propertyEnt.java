package base;

public class propertyEnt {
	
		private int propId;
		private String propName;
		private String area;
		private int cost;
		private String ownerName;
		private String buyerName;
		
		public propertyEnt(int propId, String propName, String area, int cost, String ownerName, String buyerName) {
			super();
			this.propId = propId;
			this.propName = propName;
			this.area = area;
			this.cost = cost;
			this.ownerName = ownerName;
			this.buyerName = buyerName;
		}
				
		public int getPropId() {
			return propId;
		}

		public void setPropId(int propId) {
			this.propId = propId;
		}
 
		public String getPropName() {
			return propName;
		}


		public void setPropName(String propName) {
			this.propName = propName;
		}


		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public int getCost() {
			return cost;
		}


		public void setCost(int cost) {
			this.cost = cost;
		}


		public String getOwnerName() {
			return ownerName;
		}

		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}


		public String getBuyerName() {
			return buyerName;
		}


		public void setBuyerName(String buyerName) {
			this.buyerName = buyerName;
		}

		@Override
		public String toString() {
			return "propertyEnt [propId=" + propId + ", propName=" + propName + ", area=" + area + ", cost=" + cost
					+ ", ownerName=" + ownerName + ", buyerName=" + buyerName + "]";
		}



}
