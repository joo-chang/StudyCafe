package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.DB;
import models.Confirmation;

public class testGUI extends DB{

	private JFrame frame;
	private JTextField textField;
	JLabel test_lb = new JLabel("time");
	JLabel test2_lb = new JLabel("time2");
	JButton btnNewButton = new JButton("New button");
	TimeThread th ;
	TimeThread th1;
	Confirmation confirm = new Confirmation();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testGUI window = new testGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testGUI() {
		initialize();
		th = new TimeThread(test_lb, "dudqls1441");
		th1 = new TimeThread(test2_lb, "a");

		th.start();
		th1.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(34, 100, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		test_lb.setBounds(34, 61, 130, 26);
		frame.getContentPane().add(test_lb);

		btnNewButton.setBounds(187, 100, 137, 29);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				th.timeStop();
			}
		});
		frame.getContentPane().add(btnNewButton);

		test2_lb.setBounds(194, 61, 130, 26);
		frame.getContentPane().add(test2_lb);
	}

	// Runnable runn = new Runnable() {
	//
	// @Override
	// public void run() {
	// Confirmation conf = new Confirmation();
	// conf = select_Usertime("joo777");
	// while (conf.getUser_time()==0) {
	// for (int i = conf.getUser_time(); i >= 0; i--) {
	//
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// Platform.runLater(() -> {
	// lbSeatInfo01.setText(name);
	// lbRemainTime01.setText(String.valueOf(
	// i / 3600 + ":" + i % 3600 / 60 + ":" + i % 3600 % 60));
	// });
	// if(startTime == false) {
	// break;
	// }
	// //System.out.println("i="+i+" "+startTime);
	// ///////db 불러서 시간 저장 하는 자리 /////////////
	//
	// } // for
	//
	// } // while
	//
	//
	//
	// }
	// };

	class TimeThread extends Thread {
		JLabel timeLabel;
		int total = 0;
		int hour = 1;
		int minute = 0;
		int sec = 10;
		String id = null;
		private boolean stopT = false; 
		
		DB db = new DB();
		Confirmation conf = new Confirmation();

		public TimeThread(JLabel label, String user_Id) {
			timeLabel = label;
			conf = db.select_Usertime(user_Id);
			id = user_Id;
			hour = conf.getUser_time() / 60;
			minute = conf.getUser_time() % 60;
		}

		//시간을 분단위로, 분을 초단위로 사용 테스트용 
		public void run() {
			// Confirmation conf = new Confirmation();
			// conf = select_Usertime("joo777");
			while (!stopT) {
				timeLabel.setText((Integer.toString(hour)) + "시" + (Integer.toString(minute)) + "분");
				if(hour==0 && minute==0){
					stopT= true;
					break;
				}
				
				try {
					Thread.sleep(1000);
				} // 10초에 1분씩 차감 
				catch (InterruptedException e) {
					return;
				} // 안 깨어나는 경우가 있을까봐 try-catch문을 사용함.

//				if (hour != 0 && minute == 0) {// 60분이 차면 시간으로 넘겨줌
//					minute = 59;
//					hour--;
//				}
				if (minute == 0) { 
					minute = 60;
					hour--;
				}
				minute-=60;
			}
			total = hour*60 + minute;
			if(total == 0 ){
				db.confirm_timeout(id);// 시간이 0이면 confirmation 에서 아예 지워야 함
			}else{
				conf.setUser_time(total);
				db.confirmation_Update(conf);
			}
			System.out.println("시간 종료");
			
		}

		public void timeStop() {
			stopT = true;
		}
	}


}