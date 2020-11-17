package models;

public class Price {
	private int time;
	private int price;
	
	public Price() {
		
	}
	public Price(int time, int price) {
		super();
		this.time = time;
		this.price = price;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	

}
