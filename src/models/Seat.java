package models;

public class Seat {
	private int seatnumber;
	private String m_id;
	private boolean status;

	public Seat() {

	}

	public int getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}

	public int IntSeatnumber() {
		return seatnumber;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Seat(int seatnumber, String m_id) {
		this.seatnumber = seatnumber;
		this.m_id = m_id;

	}

	public Seat(int seatnumber, String m_id, boolean status) {
		this.m_id = m_id;
		this.seatnumber = seatnumber;
		this.status = status;
	}

}
