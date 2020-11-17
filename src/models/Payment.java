package models;

public class Payment {
   private String m_id;
   private int time;
   
   public String getM_id() {
      return m_id;
   }
   public void setM_id(String m_id) {
      this.m_id = m_id;
   }
   public int getTime() {
      return time;
   }
   public void setTime(int time) {
      this.time = time;
   }

   public Payment(){
      
   }
   public Payment( String m_id,int time) {
      super();
      this.m_id = m_id;
      this.time = time;
   }
}