package models;

public class Receipt {
	private String m_id;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getPay_day() {
		return pay_day;
	}
	public void setPay_day(String pay_day) {
		this.pay_day = pay_day;
	}
	public String getBuy_time() {
		return buy_time;
	}
	public void setBuy_time(String buy_time) {
		this.buy_time = buy_time;
	}
	public String getRest_time() {
		return rest_time;
	}
	public void setRest_time(String rest_time) {
		this.rest_time = rest_time;
	}
	public String getConfirm_number() {
		return confirm_number;
	}
	public void setConfirm_number(String confirm_number) {
		this.confirm_number = confirm_number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private String pay_day;
	private String buy_time;
	private String rest_time;
 	private String confirm_number;
	private String price;
	
	@Override
	public String toString() {
		return " Receipt[name="+name+",pay_day ="+pay_day+",buy_time="+buy_time+",rest_time="+rest_time+",confirm_number="+confirm_number+",price="+price+"]";
		
	}
	

}
