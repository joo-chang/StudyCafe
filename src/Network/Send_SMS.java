package Network;

import java.util.HashMap;
import java.util.Vector;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class Send_SMS {
   public void sendsms(String phone_n,String name,String date,String buytime,String remaintime,String confirmnumber,String price) {
      String api_key="NCSBCHLJCAZ6WI7M";
      String api_secret="2805BCOFVMQI35MQGYFG1PPUDUYY6GB8";
      Message coolsms=new Message(api_key, api_secret);
      
      HashMap<String, String> p=new HashMap<String, String>();
      p.put("to", phone_n);
      p.put("from", "01084219777");
      p.put("type", "SMS");
      p.put("text","Studycafe ���������� \r\n "+"�̸�  : "+name+"\r\n"+"��������  :"+date+"\r\n"+"���Žð� : "+buytime+"\r\n"+"�����ð�   :"+remaintime+"\r\n"+"������ȣ  :"+confirmnumber+"\r\n"+"��   ��     :"+price);
      p.put("app_version", "test app 1.2");
      
      try {
         JSONObject obj=(JSONObject) coolsms.send(p);
         System.out.println(obj.toString());
      } catch (CoolsmsException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         System.out.println(e.getMessage());
         System.out.println(e.getCode());
      }
      
   }

}