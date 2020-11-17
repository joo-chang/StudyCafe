package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import database.DB;
import models.Member;

public class LoginPage extends DB{

   private JFrame loginFrame;
   JTextField id_tf = new JTextField();
   JPasswordField password_tf = new JPasswordField();

   public LoginPage() {
      initialize();
   }


   private void initialize() {

      loginFrame = new JFrame();
      loginFrame.setBounds(100, 100, 800, 600);
      loginFrame.setVisible(true);
      loginFrame.setLocationRelativeTo(null);
      loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      loginFrame.getContentPane().setLayout(null);

      JPanel loginPanel = new JPanel();
      loginPanel.setBounds(0, 0, 784, 561);
      loginFrame.getContentPane().add(loginPanel);
      loginPanel.setVisible(true);
      loginPanel.setLayout(null);

      JLabel title_lb = new JLabel("열공 스터디 카페");
      title_lb.setFont(new Font("휴먼엑스포", Font.PLAIN, 40));
      title_lb.setHorizontalAlignment(SwingConstants.CENTER);
      title_lb.setBounds(200, 80, 400, 60);
      loginPanel.add(title_lb);

      JLabel id_lb = new JLabel("I D");
      id_lb.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      id_lb.setHorizontalAlignment(SwingConstants.CENTER);
      id_lb.setBounds(159, 208, 97, 29);
      loginPanel.add(id_lb);

      id_tf.setBounds(295, 208, 178, 30);
      loginPanel.add(id_tf);
      id_tf.setColumns(10);

      password_tf.setColumns(10);
      password_tf.setBounds(295, 268, 178, 30);
      loginPanel.add(password_tf);

      JLabel password_lb = new JLabel("Password");
      password_lb.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      password_lb.setHorizontalAlignment(SwingConstants.CENTER);
      password_lb.setBounds(159, 269, 97, 27);
      loginPanel.add(password_lb);

      JButton btnCancel = new JButton("취소");
      btnCancel.setBounds(300, 342, 105, 27);
      btnCancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            loginFrame.setVisible(false);
         }
      });
      
      JLabel fault_lb = new JLabel("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
      fault_lb.setFont(new Font("휴먼엑스포", Font.PLAIN, 15));
      fault_lb.setHorizontalAlignment(SwingConstants.CENTER);
      fault_lb.setBounds(245, 305, 400, 30);
      fault_lb.setVisible(false);
      loginPanel.add(fault_lb);
      
      loginPanel.add(btnCancel);
      JButton btnLogin = new JButton("로그인");
      btnLogin.setFont(new Font("휴먼엑스포", Font.PLAIN, 17));
      btnLogin.setBounds(512, 208, 117, 90);
      btnLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Member member = new Member();
            member = check(id_tf.getText(),password_tf.getText());
            
            if(flag1) {
               System.out.println("로그인 성공");
               System.out.println(member.getId());
               SeatPage seatpage = new SeatPage(member.getId());
               if(id_tf.getText().equals("admin")&&password_tf.getText().equals("tntjr123emd")) {
                  seatpage.btnCheckout.setVisible(false);
                  seatpage.btnCharge.setVisible(false);
                  seatpage.btnFee_m.setVisible(true);
                  seatpage.btnSales_m.setVisible(true);
               }
               loginFrame.setVisible(false);
            }else {
               fault_lb.setVisible(true);
               
               System.out.println("로그인 실패");
            }
            
            
         }
      });
      loginPanel.add(btnLogin);
   }
}