package models;

import java.util.Random;

public class Confirmation {
	private String confirm_number;
	private String m_id;
	private int user_time;

	public String getConfirm_number() {
		return confirm_number;
	}
	public void setConfirm_number(String confirm_number) {
		this.confirm_number = confirm_number;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getUser_time() {
		return user_time;
	}

	public void setUser_time(int user_time) {
		this.user_time = user_time;
	}

	public Confirmation() {

	}

	public Confirmation(String confirm_number, String m_id, int user_time) {
		super();
		this.confirm_number = confirm_number;
		this.m_id = m_id;
		this.user_time = user_time;
	}

	private int numLength = 8;
	private final char[] charTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	public String excuteNumber() {
		Random random = new Random(System.currentTimeMillis());
		int tablelength = charTable.length;
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < numLength; i++) {
			buf.append(charTable[random.nextInt(tablelength)]);
		}
		return buf.toString();

	}

	public int getNumerLength() {
		return numLength;
	}

	public void setNumLength(int numberLength) {
		this.numLength = numberLength;
	}
}
