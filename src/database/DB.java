package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import models.Confirmation;
import models.Member;
import models.Payment;
import models.Price;
import models.Receipt;
import models.Sale;
import models.Seat;

public class DB {
	private Connection conn; // 2. Connection 객체를 생성
	public boolean flag = false;
	public boolean flag1 = false;
	public boolean flag2=false;
	public boolean confirm = false;
	public String confirm_number;
	public Vector ing = new Vector();

	public DB() {
		String url = "jdbc:mysql://localhost:3306/studycafe?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "studycafe";
		String password = "tntjr123emd";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. Class.forNmae으로 Driver 연결
			conn = DriverManager.getConnection(url, user, password); // 3. DriverManager으로 Connection멤버변수를 받아 연동
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert 영역

	public void member_Insert(Member member) {
		String sql = "insert into members values(?,?,?,?,?,?,?)";
	      try {
	         PreparedStatement pmt = conn.prepareStatement(sql);
	         pmt.setString(1, member.getName());
	         pmt.setString(2, member.getId());
	         pmt.setString(3, member.getPassword());
	         pmt.setString(4, member.getBirthday());
	         pmt.setString(5,member.getSex());
	         pmt.setString(6, member.getEmail());    
	         pmt.setString(7, member.getPhone());
	         pmt.executeUpdate();
	         pmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void payment_Insert(Payment payment) {

		String sql = "insert into payment(m_id,time)values(?,?)"; // (생략) 결제번호 (자동생성), id, pay_day,time
		try {
			PreparedStatement pmt = conn.prepareStatement(sql);
			pmt.setString(1, payment.getM_id());
			pmt.setInt(2, payment.getTime());// 외래키..?db.Id처럼..

			pmt.executeUpdate();
			pmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void confirmation_Insert(Confirmation confirmation) {
		String sql = "insert into confirmation values(?, ? ,?)";
		try {
			PreparedStatement pmt = conn.prepareStatement(sql);
			pmt.setString(1, confirmation.getConfirm_number()); // 인증번호 변경해야함
			pmt.setString(2, confirmation.getM_id());
			pmt.setInt(3, confirmation.getUser_time());
			pmt.executeUpdate();
			pmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Select 영역

	public void select_Member() { // 매출
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from members";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				System.out.println("이름 :" + rs.getString(1) + "  ID :" + rs.getString(2) + "  비밀번호 : " + rs.getString(3)
						+ "  이메일  : " + rs.getString(4) + "  생년월일 : " + rs.getString(5)); // 추후에 추가
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Member check(String id, String passwd) { // 아이디랑 비밀번호가 일치하는가 - 로그인할때
		Member member = new Member();
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from members";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				if (rs.getString(2).equals(id) && rs.getString(3).equals(passwd)) {
					member.setId(rs.getString(2));
					flag1 = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public Member select_Name(String id) { // 아이디 검색해서 이름 가져오기
		Member member = new Member();
		try {
			Statement stm = conn.createStatement();

			String sql = "select * from members";

			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				if (rs.getString(2).equals(id)) {
					member.setName(rs.getString(1));
					member.setSex(rs.getString(5));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public Confirmation select_Usertime(String id) { // 아이디 검색해서 이름 가져오기 - confirmation에 있는 튜플 사용할때
		Confirmation confirmation = new Confirmation();
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from confirmation";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(2).equals(id)) {
					confirmation.setM_id(id);
					confirmation.setUser_time(rs.getInt(3));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmation;
	}

	public void joincheck(String id) { // 중복체크 (회원가입)
		try {
			String sql = "select * from members";
			PreparedStatement pmt = conn.prepareStatement(sql);
			ResultSet rs = pmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(2).equals(id)) {
					flag1 = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void c_joincheck(String id) { // 중복체크 confirmation에 해당 id가 존재하는가
		try {
			String sql = "select * from confirmation";
			PreparedStatement pmt = conn.prepareStatement(sql);
			ResultSet rs = pmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(2).equals(id)) {
					flag1 = true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void confirmation_Update(Confirmation confirmation) {
		String sql = "update confirmation set user_time = ? where m_id= ?";
		try {
			PreparedStatement pmt = conn.prepareStatement(sql);
			pmt.setInt(1, confirmation.getUser_time());
			pmt.setString(2, confirmation.getM_id());
			pmt.executeUpdate();
			pmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void price_Update(int a, int b) {
		String sql = "update price set price = ? where time= ?";
		try {
			PreparedStatement pmt = conn.prepareStatement(sql);
			pmt.setInt(1, a);
			pmt.setInt(2, b);
			pmt.executeUpdate();
			pmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public Price select_price(int num) {
		Price s_price = new Price();
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from price";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				if (Integer.parseInt(rs.getString(1)) == num) {
					s_price.setTime(rs.getInt(1));
					s_price.setPrice(rs.getInt(2));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s_price;

	}

	public Confirmation select_Confirm_n(String id) { // 아이디 검색해서 confirm_number확인시켜주기
		Confirmation confirmation = new Confirmation();
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from confirmation";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(2).equals(id)) {
					confirmation.setConfirm_number(rs.getString(1));
					confirm_number = confirmation.getConfirm_number();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmation;
	}

	public boolean confirm_check(String confirm_number) { // 입장하기 체크
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from confirmation";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals(confirm_number)) {
					confirm = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirm;
	}
	
	public boolean seat_check(String a) { 
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from seat";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals(a)) {
					flag2=rs.getBoolean(3);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag2;
	}
	public Vector seat_ing() {
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from seat";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				if (rs.getBoolean(3)) {
					ing.add(rs.getInt(1));
					System.out.println(ing);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ing;
	}
	
	public Vector print_sale_byDate(String Date) {
		@SuppressWarnings("rawtypes")
		Vector saledata = new Vector();

		try {
			String sql = "select distinct DATE_FORMAT(payment.pay_day, '%Y-%m-%d') day, confirmation.confirm_number, payment.m_id as 회원 , price.price as 결제금액 \r\n"
					+ "from payment,price,members,confirmation\r\n"
					+ "where payment.time=price.time and members.id =payment.m_id and confirmation.m_id=members.id and payment.pay_day like '"
					+ Date + "%'  order by payment.pay_day";
			PreparedStatement pmt = conn.prepareStatement(sql);
//			pmt.setString(1, Date);
			System.out.println(Date);
//	         System.out.println(keyword);
			Statement stm = conn.createStatement();
			ResultSet rs = pmt.executeQuery(sql);

			while (rs.next()) {
				String pay_day = rs.getString(1);
				String m_id = rs.getString(2);
				String pay_time = rs.getString(3);
				String price = rs.getString(4);

				Vector row = new Vector();
				row.add(pay_day);
				row.add(m_id);
				row.add(pay_time);
				row.add(price);

				saledata.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saledata;

	}

	public Vector print_sale() {
		Vector saledata = new Vector();

		try {
			String sql = "select  DATE_FORMAT(payment.pay_day, '%Y-%m-%d') as 결제일, payment.m_id as 회원 ,payment.time, price.price as 결제금액 \r\n"
					+ "from payment,price,members\r\n"
					+ "where payment.time=price.time and members.id =payment.m_id \r\n" + "order by payment.pay_day";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				String pay_day = rs.getString(1);
				String m_id = rs.getString(2);
				String pay_time = rs.getString(3);
				String price = rs.getString(4);

				Vector row = new Vector();
				row.add(pay_day);
				row.add(m_id);
				row.add(pay_time);
				row.add(price);

				saledata.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saledata;

	}

	public Vector print_receipt() {

		Vector data = new Vector();

		try {
			String sql = "select distinct members.name as 회원이름 , DATE_FORMAT(payment.pay_day, '%Y-%m-%d') as 결제일, payment.time as 충전시간 , confirmation.user_time as 남은시간, confirmation.confirm_number as 인증번호, price.price as '결제 금액'\r\n"
					+ "from payment,price,members,confirmation\r\n"
					+ "where payment.time=price.time and members.id = payment.m_id and members.id = confirmation.m_id  \r\n"
					+ "order by 결제일  desc limit 1";
			PreparedStatement pmt = conn.prepareStatement(sql);
//			pmt.setString(1, m_id);
			ResultSet rs = pmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);
				String pay_day = rs.getString(2);
				String buy_time = rs.getString(3);
				String rest_time = rs.getString(4);
				String confirm_number = rs.getString(5);
				String price = rs.getString(6);

				Vector row = new Vector();
				row.add(name);
				row.add(pay_day);
				row.add(buy_time);
				row.add(rest_time);
				row.add(confirm_number);
				row.add(price);

				data.add(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public Vector print_sale_sum() {
		Vector saledata = new Vector();

		try {
			String sql = "select DATE_FORMAT(payment.pay_day, '%Y-%m-%d') as 결제일 ,sum(price.price) as 총결제금액\r\n"
					+ "from payment,price\r\n" + "where payment.time=price.time\r\n" + "group by 결제일\r\n"
					+ "order by payment.pay_day";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				String pay_day = rs.getString(1);
				String price = rs.getString(2);

				Vector row = new Vector();
				row.add(pay_day);
				row.add(price);

				saledata.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saledata;

	}

	public void confirm_timeout(String id) {
		try {
			String sql = "delete from confirmation where m_id=?";
			PreparedStatement pmt = conn.prepareStatement(sql);
			pmt.setString(1, id);
			pmt.executeUpdate();
			pmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void confirm_remainTime(String id) {

	}

	public boolean check_userseat(String m_id) { // 회원이 이미 이용중인 좌석이 있는지 확인
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from seat";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {	
				if (m_id.equals(rs.getString(2))) {
					System.out.println("회원님은 이미 좌석을 사용중입니다.");
					flag1 = true;
					break;
				} else {
					System.out.println("회원님은 좌석을 미사용중입니다.");
					flag1 = false;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag1;
	}

	public boolean check_usertime(String m_id) {// 회원의 시간이 남아 있는지 확인
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from confirmation";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				if (rs.getString(2).equals(m_id)) {
					if (rs.getString(3).equals(0)) {
						System.out.println("남은 시간이 없습니다.");
						break;
					} else {
						System.out.println("남은 시간이 있습니다.");
						flag1 = true;
						break;

					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag1;

	}

	public void use_seat(Seat seat) { // 선택한 좌석을 회원이름과 true값으로 바꾼다.
		String sql = "update seat set status =1, m_id=?  where seatnumber=?";
		try {
			PreparedStatement pmt = conn.prepareStatement(sql);
			pmt.setString(1, seat.getM_id());
			pmt.setInt(2, seat.getSeatnumber());
			pmt.execute();
			pmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update_seat(String seat) { // 선택한 좌석을 회원이름과 true값으로 바꾼다.
		String sql = "update seat set m_id=null,status=0  where m_id=?";
		try {
			PreparedStatement pmt = conn.prepareStatement(sql);
			pmt.setString(1, seat);
			pmt.execute();
			pmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String dbmail(String user_Id) {
	      String confirmation;
	      String email = null;
	      try {
	         Statement stm = conn.createStatement();
	         String sql = "select members.id, members.email, confirmation.confirm_number from members, confirmation where members.id=confirmation.m_id;";
	         ResultSet rs = stm.executeQuery(sql);
	         while (rs.next()) {
	            if (rs.getString(1).equals(user_Id)) {
	               email = rs.getString(2);
	               confirmation = rs.getString(3);
	            }
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return email;

	   }


}
