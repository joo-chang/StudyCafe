package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import database.DB;

public class StartPage extends DB {

	private JFrame startFrame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.startFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StartPage() {
		initialize();
	}

	private void initialize() {
		startFrame = new JFrame();
		startFrame.setBounds(100, 100, 800, 600);
		startFrame.setVisible(false);
		startFrame.setLocationRelativeTo(null);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.getContentPane().setLayout(null);
		

		JPanel startPanel = new JPanel(); // startPanel
		startPanel.setBounds(0, 0, 784, 561);
		startFrame.getContentPane().add(startPanel);
		startPanel.setLayout(null);

		JLabel title_lb = new JLabel("���� ���͵� ī��");
		title_lb.setBounds(200, 80, 400, 60);
		title_lb.setFont(new Font("�޸տ�����", Font.PLAIN, 40));
		title_lb.setHorizontalAlignment(SwingConstants.CENTER);
		startPanel.add(title_lb);

		JButton btnLogin = new JButton("�α���");
		btnLogin.setBounds(250, 200, 300, 50);
		btnLogin.setFont(new Font("�޸տ�����", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
			}
		});
		startPanel.add(btnLogin);

		JButton btnAccount = new JButton("ȸ������");
		btnAccount.setBounds(250, 270, 300, 50);
		btnAccount.setFont(new Font("�޸տ�����", Font.PLAIN, 16));
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAccountPage();
			}
		});
		startPanel.add(btnAccount);

		JButton btnEnter = new JButton("�����ϱ�");
		btnEnter.setBounds(250, 340, 300, 50);
		btnEnter.setFont(new Font("�޸տ�����", Font.PLAIN, 16));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = JOptionPane.showInputDialog(null,"���� ��ȣ�� �Է��ϼ���.");
				if (confirm_check(num)) {
					JOptionPane.showMessageDialog(null, "���� �����ϴ�.");
					confirm = false;
				} else  
					JOptionPane.showMessageDialog(null, "������ȣ�� Ʋ���ų� ��ȿ���� �ʽ��ϴ�.");
				
			}
		}
		);
		startPanel.add(btnEnter);

	}}

//