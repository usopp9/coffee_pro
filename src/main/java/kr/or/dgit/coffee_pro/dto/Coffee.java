package kr.or.dgit.coffee_pro.dto;

public class Coffee {
	private String cCode;
	private String cName;
	public Coffee() {
		
	}
	
	public Coffee(String cCode) {
		this.cCode = cCode;
	}

	public Coffee(String cCode, String cName) {
		this.cCode = cCode;
		this.cName = cName;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return String.format("%s", cCode);
	}
	
	
}
