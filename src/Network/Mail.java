package Network;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JApplet;

public class Mail {
   public static void mail(String email,int temporarily_number) {
      String host="smtp.naver.com";
      final String user = "dudqls1441@naver.com"; //발신자의 메일계정과 비밀번호 설정
      final String password = "choco8421!";
      System.out.println(email+temporarily_number);
      Properties prop = new Properties(); //property에 smtp 서버 정보를 설정
      prop.put("mail.smtp.host", host);
      prop.put("mail.smtp.port", 587);
      prop.put("mail.smtp.auth","true");
      prop.put("mal.smtp.ssl.enable","true");
      prop.put("mail.smtp.ssl.trust",host);
      
      Session session=Session.getDefaultInstance(prop, new javax.mail.Authenticator(){ //SMTP 서버 정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스를 생성한다.
         protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            return new javax.mail.PasswordAuthentication(user, password);
         }
      });
      MimeMessage message=new MimeMessage(session);
      try {
         message.setFrom(new InternetAddress(user));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
         message.setSubject("인증번호 발송");
         message.setText("Studycafe 인증번호는 "+temporarily_number+" 입니다");
         Transport.send(message);
         System.out.println("메세지 전송 완료");
         
      } catch (AddressException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (MessagingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}