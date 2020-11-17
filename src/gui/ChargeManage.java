package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import database.DB;
import models.Price;

public class ChargeManage extends DB {

	private static final Object[] JTextField = null;
	Price price = new Price();
	int value;
	private JFrame chargeFrame;
	private JTextField fee1_tf;
	private JTextField fee2_tf;
	private JTextField fee3_tf;
	private JTextField fee4_tf;
	private JTextField fee5_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChargeManage window = new ChargeManage();
					window.chargeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChargeManage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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

		JLabel charge_lb = new JLabel("\uC694\uAE08 \uBCC0\uACBD");
		charge_lb.setBounds(0, 60, 784, 60);
		charge_lb.setFont(new Font("휴먼엑스포", Font.PLAIN, 40));
		charge_lb.setHorizontalAlignment(SwingConstants.CENTER);
		chargePanel.add(charge_lb);

		JLabel time2H_lb = new JLabel("2 시간");
		time2H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time2H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time2H_lb.setBounds(210, 148, 75, 30);
		chargePanel.add(time2H_lb);

		JLabel time4H_lb = new JLabel("4 시간");
		time4H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time4H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time4H_lb.setBounds(210, 208, 75, 30);
		chargePanel.add(time4H_lb);

		JLabel time6H_lb = new JLabel("6 시간");
		time6H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time6H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time6H_lb.setBounds(210, 268, 75, 30);
		chargePanel.add(time6H_lb);

		JLabel time24H_lb = new JLabel("24 시간");
		time24H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time24H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time24H_lb.setBounds(210, 328, 75, 30);
		chargePanel.add(time24H_lb);

		JLabel time120H_lb = new JLabel("120 시간");
		time120H_lb.setHorizontalAlignment(SwingConstants.CENTER);
		time120H_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		time120H_lb.setBounds(200, 388, 100, 30);
		chargePanel.add(time120H_lb);

		price = select_price(120);
		fee1_tf = new JTextField("" + price.getPrice());
		fee1_tf.setBounds(409, 157, 116, 21);
		chargePanel.add(fee1_tf);
		fee1_tf.setColumns(10);

		JLabel cost1_lb = new JLabel("원");
		cost1_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost1_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost1_lb.setBounds(460, 148, 100, 30);
		chargePanel.add(cost1_lb);

		price = select_price(240);
		fee2_tf = new JTextField("" + price.getPrice());
		fee2_tf.setBounds(409, 217, 116, 21);
		chargePanel.add(fee2_tf);
		fee2_tf.setColumns(10);

		JLabel cost2_lb = new JLabel("원");
		cost2_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost2_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost2_lb.setBounds(460, 208, 100, 30);
		chargePanel.add(cost2_lb);

		price = select_price(360);
		fee3_tf = new JTextField("" + price.getPrice());
		fee3_tf.setBounds(409, 277, 116, 21);
		chargePanel.add(fee3_tf);
		fee3_tf.setColumns(10);

		JLabel cost3_lb = new JLabel("원");
		cost3_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost3_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost3_lb.setBounds(460, 268, 100, 30);
		chargePanel.add(cost3_lb);

		price = select_price(1440);
		fee4_tf = new JTextField("" + price.getPrice());
		fee4_tf.setBounds(409, 337, 116, 21);
		chargePanel.add(fee4_tf);
		fee4_tf.setColumns(10);

		JLabel cost4_lb = new JLabel("원");
		cost4_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost4_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost4_lb.setBounds(460, 328, 100, 30);
		chargePanel.add(cost4_lb);

		price = select_price(7200);
		fee5_tf = new JTextField("" + price.getPrice());
		fee5_tf.setBounds(409, 397, 116, 21);
		chargePanel.add(fee5_tf);
		fee5_tf.setColumns(10);

		JLabel cost5_lb = new JLabel("원");
		cost5_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		cost5_lb.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cost5_lb.setBounds(460, 388, 100, 30);
		chargePanel.add(cost5_lb);

		JButton cancel_btn = new JButton("취소");
		cancel_btn.setBounds(130, 454, 170, 27);
		cancel_btn.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeFrame.setVisible(false);
			}
		});
		chargePanel.add(cancel_btn);

		JButton update_btn = new JButton("변경하기");
		update_btn.setBounds(505, 454, 170, 27);
		update_btn.setFont(new Font("한컴 백제 M", Font.PLAIN, 20));
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price_Update(Integer.parseInt(fee1_tf.getText()), 120);
				price_Update(Integer.parseInt(fee2_tf.getText()), 240);
				price_Update(Integer.parseInt(fee3_tf.getText()), 360);
				price_Update(Integer.parseInt(fee4_tf.getText()), 1440);
				price_Update(Integer.parseInt(fee5_tf.getText()), 7200);
				chargeFrame.setVisible(false);
			}
		});
		chargePanel.add(update_btn);
	}
}