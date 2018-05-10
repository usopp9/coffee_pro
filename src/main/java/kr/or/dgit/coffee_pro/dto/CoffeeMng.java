package kr.or.dgit.coffee_pro.dto;

public class CoffeeMng {
	private Coffee cCode;
	private int cPrice;
	private int cCount;
	private int cMargin;
	private int total;
	private int tax;
	private int supplyPrice;
	private int profit;
	private int rank;
	public CoffeeMng() {
		// TODO Auto-generated constructor stub
	}
	public CoffeeMng(Coffee cCode, int cPrice, int cCount, int cMargin) {
		this.cCode = cCode;
		this.cPrice = cPrice;
		this.cCount = cCount;
		this.cMargin = cMargin;
	}
	
	public int getTotal() {
		return total;
	}
	public int getTax() {
		return tax;
	}
	public int getSupplyPrice() {
		return supplyPrice;
	}
	public int getProfit() {
		return profit;
	}
	public CoffeeMng(Coffee cCode, int cPrice, int cCount, int cMargin, int total, int tax, int supplyPrice, int profit,
			int rank) {
		super();
		this.cCode = cCode;
		this.cPrice = cPrice;
		this.cCount = cCount;
		this.cMargin = cMargin;
		this.total = total;
		this.tax = tax;
		this.supplyPrice = supplyPrice;
		this.profit = profit;
		this.rank = rank;
	}
	public Coffee getcCode() {
		return cCode;
	}
	public void setcCode(Coffee cCode) {
		this.cCode = cCode;
	}
	public int getcPrice() {
		return cPrice;
	}
	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}
	public int getcCount() {
		return cCount;
	}
	public void setcCount(int cCount) {
		this.cCount = cCount;
	}
	public int getcMargin() {
		return cMargin;
	}
	public void setcMargin(int cMargin) {
		this.cMargin = cMargin;
	}
	public Object[] toArray() {
		return new Object[] {rank, cCode,cCode.getcName(),toString().format("%,3d",cPrice),cCount,toString().format("%,3d",supplyPrice),toString().format("%,3d",tax),toString().format("%,3d",total),cMargin,toString().format("%,3d",profit)};
	}
	
	
}
