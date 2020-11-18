package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import Network.Mail;
import Network.Send_SMS;
import database.DB;
import models.Confirmation;
import models.Member;
import models.Payment;
import models.Price;

public class ChargePage extends DB {
	Send_SMS ss = new Send_SMS();
	private int fee;
	private JFrame chargeFrame;
	JLabel fee_lb = new JLabel("총     계 : " + fee + " 원");
	Price price = new Price();
	Confirmation confirmation = new Confirmation();
	Member member = new Member();
	Vector v;

	ChargePage() {

	}

	public ChargePage(String user_Id) {
		member = select_Name(user_Id);
		confirmation = select_Usertime(user_Id);
		initialize(user_Id);
	}

	private void initialize(String user_Id) {
		chargeFrame = new JFrame();
		chargeFrame.setBounds(100, 100, 800, 600);
		chargeFrame.setVisible(true);
		chargeFrame.setLocationRelativeTo(null);
		chargeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chargeFrame.getContentPane().setLayout(null);

		JPanel chargePanel = new JPanel();
		chargePanel.setBounds(0, 0, 784, 561);
		chargeFrame.getContentPane().add(chargePanel);
		chargePanel.setLayout(null);

		JLabel charge_lb = new JLabel("시간 충전");
		charge_lb.setBounds(0, 60, 784, 60);
		charge_lb.setFont(new Font("휴먼엑스포", Font.PLAIN, 40));
		charge_lb.setHorizontalAlignment(SwingConstants.CENTER);
		chargePanel.add(charge_lb);

		JLabel time2H_lb = new JLabel("2 시간");
		time2H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time2H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time2H_lb.setBounds(130, 150, 75, 30);
		chargePanel.add(time2H_lb);

		JLabel time4H_lb = new JLabel("4 시간");
		time4H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time4H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time4H_lb.setBounds(130, 210, 75, 30);
		chargePanel.add(time4H_lb);

		JLabel time6H_lb = new JLabel("6 시간");
		time6H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time6H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time6H_lb.setBounds(130, 270, 75, 30);
		chargePanel.add(time6H_lb);

		JLabel time24H_lb = new JLabel("24 시간");
		time24H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time24H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time24H_lb.setBounds(130, 330, 75, 30);
		chargePanel.add(time24H_lb);

		JLabel time120H_lb = new JLabel("120 시간");
		time120H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time120H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time120H_lb.setBounds(120, 390, 100, 30);
		chargePanel.add(time120H_lb);

		price = select_price(120);
		JLabel cost1_lb = new JLabel(price.getPrice() + " 원");
		cost1_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost1_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost1_lb.setBounds(274, 150, 100, 30);
		chargePanel.add(cost1_lb);

		price = select_price(240);
		JLabel cost2_lb = new JLabel(price.getPrice() + " 원");
		cost2_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost2_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost2_lb.setBounds(274, 210, 100, 30);
		chargePanel.add(cost2_lb);

		price = select_price(360);
		JLabel cost3_lb = new JLabel(price.getPrice() + " 원");
		cost3_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost3_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost3_lb.setBounds(274, 270, 100, 30);
		chargePanel.add(cost3_lb);

		price = select_price(1440);
		JLabel cost4_lb = new JLabel(price.getPrice() + " 원");
		cost4_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost4_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost4_lb.setBounds(274, 330, 100, 30);
		chargePanel.add(cost4_lb);

		price = select_price(7200);
		JLabel cost5_lb = new JLabel(price.getPrice() + " 원");
		cost5_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost5_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost5_lb.setBounds(274, 390, 100, 30);
		chargePanel.add(cost5_lb);

		JLabel userName_lb = new JLabel(member.getName() + " 님");
		userName_lb.setHorizontalAlignment(SwingConstants.LEFT);
		userName_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		userName_lb.setBounds(484, 229, 100, 30);
		chargePanel.add(userName_lb);

		JLabel remain_lb = new JLabel("남은 시간 :");
		remain_lb.setHorizontalAlignment(SwingConstants.LEFT);
		remain_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		remain_lb.setBounds(484, 299, 120, 30);
		chargePanel.add(remain_lb);

		JLabel userTime_lb = new JLabel(changeTime(confirmation.getUser_time()));
		userTime_lb.setHorizontalAlignment(SwingConstants.CENTER);
		userTime_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		userTime_lb.setBounds(567, 299, 150, 30);
		chargePanel.add(userTime_lb);

		price = select_price(120);
		JRadioButton cost1_rdbtn = new JRadioButton(price.getPrice() + "");
		cost1_rdbtn.setBounds(382, 156, 21, 23);
		cost1_rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cost1_rdbtn.isSelected()) {
					fee = Integer.parseInt(cost1_rdbtn.getText());
					fee_lb.setText("총     계 : " + fee + " 원");
					price = select_price(120);

				}
			}
		});
		chargePanel.add(cost1_rdbtn);

		price = select_price(240);
		JRadioButton cost2_rdbtn = new JRadioButton(price.getPrice() + "");
		cost2_rdbtn.setBounds(382, 210, 21, 23);
		cost2_rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cost2_rdbtn.isSelected()) {
					fee = Integer.parseInt(cost2_rdbtn.getText());
					fee_lb.setText("총     계 : " + fee + " 원");
					price = select_price(240);
				}
			}
		});
		chargePanel.add(cost2_rdbtn);

		price = select_price(360);
		JRadioButton cost3_rdbtn = new JRadioButton(price.getPrice() + "");
		cost3_rdbtn.setBounds(382, 270, 21, 23);
		cost3_rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cost3_rdbtn.isSelected()) {
					fee = Integer.parseInt(cost3_rdbtn.getText());
					fee_lb.setText("총     계 : " + fee + " 원");
					price = select_price(360);
				}
			}
		});
		chargePanel.add(cost3_rdbtn);

		price = select_price(1440);
		JRadioButton cost4_rdbtn = new JRadioButton(price.getPrice() + "");
		cost4_rdbtn.setBounds(382, 330, 21, 23);
		cost4_rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cost4_rdbtn.isSelected()) {
					fee = Integer.parseInt(cost4_rdbtn.getText());
					fee_lb.setText("총     계 : " + fee + " 원");
					price = select_price(1440);
				}
			}
		});
		chargePanel.add(cost4_rdbtn);

		price = select_price(7200);
		JRadioButton cost5_rdbtn = new JRadioButton(price.getPrice() + "");
		cost5_rdbtn.setBounds(382, 390, 21, 23);
		cost5_rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cost5_rdbtn.isSelected()) {
					fee = Integer.parseInt(cost5_rdbtn.getText());
					fee_lb.setText("총     계 : " + fee + " 원");
					price = select_price(7200);
				}
			}
		});
		chargePanel.add(cost5_rdbtn);

		ButtonGroup bg = new ButtonGroup();
		bg.add(cost1_rdbtn);
		bg.add(cost2_rdbtn);
		bg.add(cost3_rdbtn);
		bg.add(cost4_rdbtn);
		bg.add(cost5_rdbtn);

		fee_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		fee_lb.setBounds(484, 369, 220, 30);
		chargePanel.add(fee_lb);

		JButton cancel_btn = new JButton("취소");
		cancel_btn.setBounds(130, 454, 105, 27);
		cancel_btn.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeFrame.setVisible(false);
			}
		});
		chargePanel.add(cancel_btn);

		JButton pay_btn = new JButton("결제하기");
		pay_btn.setBounds(505, 454, 170, 27);
		pay_btn.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		pay_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"총 금액 : " + fee + "        결제 후 보유 시간 : "
								+ (changeTime(confirmation.getUser_time() + price.getTime())) + "        결제 하시겠습니까?",
						"Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				if (result == JOptionPane.YES_OPTION) {// 예를 누른 경우
					price.getPrice();
					Payment payment = new Payment(user_Id, price.getTime());
					payment_Insert(payment);
					c_joincheck(user_Id);
					confirmation.setConfirm_number(confirmation.excuteNumber());
					confirm_number = confirmation.getConfirm_number();
					confirmation.setM_id(user_Id);
					confirmation.setUser_time(confirmation.getUser_time() + price.getTime());

					if (flag1) {
						confirmation_Update(confirmation);
					} else {
						confirmation_Insert(confirmation);
					}
					System.out.println(confirm_number);
					select_Confirm_n(user_Id);
					v = print_receipt();
					String name = (String) v.get(0);
					String date = (String) v.get(1);
					String buytime = (String) v.get(2);
					String remaintime = (String) v.get(3);
					String confirmnumber = (String) v.get(4);
					String price = (String) v.get(5);
					ss.sendsms(phone(user_Id),name,date,buytime,remaintime,confirmnumber,price);
					System.out.println("V=" + v);
					chargeFrame.setVisible(false);
				}
			}
		});
		chargePanel.add(pay_btn);
	}

	// 분단위 시간단위로 바꾸기
	public String changeTime(int time) {
		int hour = 0;
		int minute = 0;

		hour = time / 60;
		minute = time % 60;

		return hour + " 시간  " + minute + " 분";
	}
}