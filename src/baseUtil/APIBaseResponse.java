package baseUtil;

public class APIBaseResponse {
	
	private String totalCost;

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "APIBaseResponse [totalCost=" + totalCost + "]";
	}
	

}
