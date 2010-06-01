package model;

public class PhoneNumber {
	
	private String digits;
	
	public String getDigits() {
		return digits;
	}

	public void setDigits(String digits) {
		this.digits = digits;
	}

	public PhoneNumber(String digits) {
		//vanlig komentar
		//TODO add digit validation logic
		this.digits = digits;
	}
	
	@Override
	public String toString(){
		return "tel: " + this.digits.toString();
	}
}
