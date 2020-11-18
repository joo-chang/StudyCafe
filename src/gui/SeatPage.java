package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.DB;
import models.Confirmation;
import models.Member;
import models.Seat;

public class SeatPage extends DB {

	public JFrame seatFrame;
	public JButton btnCheckout = new JButton("퇴실하기");
	public JButton btnBack = new JButton("로그아웃");
	public JButton btnCharge = new JButton("시간충전");
	public JButton btnSales_m = new JButton("매출관리");
	public JButton btnFee_m = new JButton("요금관리");
	JButton[] jbtn = new JButton[31];

	SeatPage() {
	}
	Confirmation confirmation = new Confirmation();
	Member member = new Member();
	Seat seat = new Seat();
	
	public SeatPage(String user_Id) {
		member = select_Name(user_Id);
		System.out.println(member.getName());
		System.out.println(user_Id);
		initialize(user_Id);
		
	}

	public void initialize(String user_Id) {
		
		seatFrame = new JFrame();
		seatFrame.setVisible(true);
		seatFrame.setBounds(100, 100, 800, 600);
		seatFrame.setLocationRelativeTo(null);
		seatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		seatFrame.getContentPane().setLayout(null);

		JPanel seatPanel = new JPanel(); // seatPanel
		seatPanel.setBounds(0, 0, 784, 561);
		seatFrame.getContentPane().add(seatPanel);
		seatPanel.setVisible(true);
		seatPanel.setLayout(null);

		btnCheckout.setBounds(44, 463, 105, 60);
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmation=select_Usertime(user_Id);
				confirmation_Update(confirmation);
				System.out.println("최종 남은 시간 :"+confirmation.getUser_time()+"분");
				seat.setM_id(user_Id);
				update_seat(seat.getM_id());
				seatFrame.setVisible(false);
				new SeatPage(user_Id);
				
			}
		});
		seatPanel.add(btnCheckout);

		JButton btnChat = new JButton("채팅하기");
		btnChat.setBounds(342, 463, 105, 60);
		seatPanel.add(btnChat);

		btnSales_m.setBounds(44, 463, 105, 60);
		btnSales_m.setVisible(false);
		btnSales_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalePage();
			}
		});
		seatPanel.add(btnSales_m);

		btnFee_m.setBounds(631, 463, 105, 60);
		btnFee_m.setVisible(false);
		btnFee_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChargeManage();
			}
		});
		seatPanel.add(btnFee_m);

		btnCharge.setBounds(631, 463, 105, 60);
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChargePage(user_Id);
			}
		});
		seatPanel.add(btnCharge);

		btnBack.setBounds(663, 12, 105, 30);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatFrame.setVisible(false);
			}
		});
		seatPanel.add(btnBack);

		JLabel labelText = new JLabel("좌석을 선택해주세요.");
		labelText.setBounds(475, 16, 204, 23);
		seatPanel.add(labelText);

		JLabel labelUsername = new JLabel(member.getName() + "님");
		labelUsername.setBounds(57, 18, 62, 18);
		seatPanel.add(labelUsername);

		// btnseat
		jbtn[0] = new JButton("1");
		jbtn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[0], user_Id);
			}
		});
		jbtn[0].setBounds(106, 100, 50, 40);
		seatPanel.add(jbtn[0]);

		jbtn[1] = new JButton("2");
		jbtn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[1], user_Id);
			}
		});
		jbtn[1].setBounds(106, 160, 50, 40);
		seatPanel.add(jbtn[1]);

		jbtn[2] = new JButton("3");
		jbtn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[2], user_Id);
			}
		});
		jbtn[2].setBounds(106, 215, 50, 40);
		seatPanel.add(jbtn[2]);

		jbtn[3] = new JButton("4");
		jbtn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[3], user_Id);
			}
		});
		jbtn[3].setBounds(106, 270, 50, 40);
		seatPanel.add(jbtn[3]);

		jbtn[4] = new JButton("5");
		jbtn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[4], user_Id);
			}
		});
		jbtn[4].setBounds(106, 325, 50, 40);
		seatPanel.add(jbtn[4]);

		jbtn[5] = new JButton("6");
		jbtn[5].setBounds(272, 100, 50, 40);
		jbtn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[5], user_Id);
			}
		});
		seatPanel.add(jbtn[5]);

		jbtn[6] = new JButton("7");
		jbtn[6].setBounds(272, 160, 50, 40);
		jbtn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[6], user_Id);
			}
		});
		seatPanel.add(jbtn[6]);

		jbtn[7] = new JButton("8");
		jbtn[7].setBounds(272, 215, 50, 40);
		jbtn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[7], user_Id);
			}
		});
		seatPanel.add(jbtn[7]);

		jbtn[8] = new JButton("9");
		jbtn[8].setBounds(272, 270, 50, 40);
		jbtn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[8], user_Id);
			}
		});
		seatPanel.add(jbtn[8]);

		jbtn[9] = new JButton("10");
		jbtn[9].setBounds(272, 325, 50, 40);
		jbtn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[9], user_Id);
			}
		});
		seatPanel.add(jbtn[9]);

		jbtn[10] = new JButton("11");
		jbtn[10].setBounds(330, 100, 50, 40);
		jbtn[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[10], user_Id);
			}
		});
		seatPanel.add(jbtn[10]);

		jbtn[11] = new JButton("12");
		jbtn[11].setBounds(330, 160, 50, 40);
		jbtn[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[11], user_Id);
			}
		});
		seatPanel.add(jbtn[11]);

		jbtn[12] = new JButton("13");
		jbtn[12].setBounds(330, 215, 50, 40);
		jbtn[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[12], user_Id);
			}
		});
		seatPanel.add(jbtn[12]);

		jbtn[13] = new JButton("14");
		jbtn[13].setBounds(330, 270, 50, 40);
		jbtn[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[13], user_Id);
			}
		});
		seatPanel.add(jbtn[13]);

		jbtn[14] = new JButton("15");
		jbtn[14].setBounds(330, 325, 50, 40);
		jbtn[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[14], user_Id);
			}
		});
		seatPanel.add(jbtn[14]);

		jbtn[15] = new JButton("16");
		jbtn[15].setBounds(446, 100, 50, 40);
		jbtn[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[15], user_Id);
			}
		});
		seatPanel.add(jbtn[15]);

		jbtn[16] = new JButton("17");
		jbtn[16].setBounds(496, 100, 50, 40);
		jbtn[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[16], user_Id);
			}
		});
		seatPanel.add(jbtn[16]);

		jbtn[17] = new JButton("18");
		jbtn[17].setBounds(546, 100, 50, 40);
		jbtn[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[17], user_Id);
			}
		});
		seatPanel.add(jbtn[17]);

		jbtn[18] = new JButton("19");
		jbtn[18].setBounds(596, 100, 50, 40);
		jbtn[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[18], user_Id);
			}
		});
		seatPanel.add(jbtn[18]);

		jbtn[19] = new JButton("20");
		jbtn[19].setBounds(446, 160, 50, 40);
		jbtn[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[19], user_Id);
			}
		});
		seatPanel.add(jbtn[19]);

		jbtn[20] = new JButton("21");
		jbtn[20].setBounds(496, 160, 50, 40);
		jbtn[20].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[20], user_Id);
			}
		});
		seatPanel.add(jbtn[20]);

		jbtn[21] = new JButton("22");
		jbtn[21].setBounds(546, 160, 50, 40);
		jbtn[21].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[21], user_Id);
			}
		});
		seatPanel.add(jbtn[21]);

		jbtn[22] = new JButton("23");
		jbtn[22].setBounds(596, 160, 50, 40);
		jbtn[22].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[22], user_Id);
			}
		});
		seatPanel.add(jbtn[22]);

		jbtn[23] = new JButton("24");
		jbtn[23].setBounds(446, 270, 50, 40);
		jbtn[23].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[23], user_Id);
			}
		});
		seatPanel.add(jbtn[23]);

		jbtn[24] = new JButton("25");
		jbtn[24].setBounds(496, 270, 50, 40);
		jbtn[24].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[24], user_Id);
			}
		});
		seatPanel.add(jbtn[24]);

		jbtn[25] = new JButton("26");
		jbtn[25].setBounds(546, 270, 50, 40);
		jbtn[25].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[25], user_Id);
			}
		});
		seatPanel.add(jbtn[25]);

		jbtn[26] = new JButton("27");
		jbtn[26].setBounds(596, 270, 50, 40);
		jbtn[26].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[26], user_Id);
			}
		});
		seatPanel.add(jbtn[26]);

		jbtn[27] = new JButton("28");
		jbtn[27].setBounds(446, 325, 50, 40);
		jbtn[27].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[27], user_Id);
			}
		});
		seatPanel.add(jbtn[27]);

		jbtn[28] = new JButton("29");
		jbtn[28].setBounds(496, 325, 50, 40);
		jbtn[28].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[28], user_Id);
			}
		});
		seatPanel.add(jbtn[28]);

		jbtn[29] = new JButton("30");
		jbtn[29].setBounds(546, 325, 50, 40);
		jbtn[29].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[29], user_Id);
			}
		});
		seatPanel.add(jbtn[29]);

		jbtn[30] = new JButton("31");
		jbtn[30].setBounds(596, 325, 50, 40);
		jbtn[30].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total_method(jbtn[30], user_Id);
			}
		});
		seatPanel.add(jbtn[30]);		
		
		ing();
	}

	public void ing(){
	      seat_ing();
	      for (int i = 0; i < 31; i++) {
	         for (int j = 0; j < ing.size(); j++) {
	            if (jbtn[i].getText().equals(ing.get(j)+"")) {
	               select_Id(jbtn[i].getText());
	               seat_name(id);
	               if(sex.equals("남자")) {//번호로 검색해서 아이디를 가져오고 그 아이디를 db에 검색해서 성별을 가져와야됨
	                  jbtn[i].setBackground(Color.blue);
	               }else {
	                  jbtn[i].setBackground(Color.red);
	               }
	               jbtn[i].setEnabled(false);
	            }
	         }
	      }
	   }

	public void total_method(JButton btn, String user_Id) {
		check_userseat(user_Id);
		if (!flag1) {
			seat_check(btn.getText());
			if (!flag2) {
				check_usertime(user_Id);
				if (flag1) {
					Seat seat = new Seat(Integer.parseInt(btn.getText()), user_Id);
					use_seat(seat);
					if(member.getSex().equals("남자")) {
						btn.setBackground(Color.blue);
					}else {
						btn.setBackground(Color.red);
					}
					btn.setEnabled(false);
					JOptionPane.showMessageDialog(null, "이용을 시작합니다.");
				} else {
					JOptionPane.showMessageDialog(null, "시간을 충전해주세요");
					new ChargePage(user_Id);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "이미 사용중인 좌석이 있습니다.");

		}

	}

}