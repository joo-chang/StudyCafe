package models;

public class Sale {
   private String payday;
   private String confirm_number;
   private String m_id;
   private String price;
   
   public String getPayday() {
      return payday;
   }
   public void setPayday(String payday) {
      this.payday = payday;
   }
   public String getConfirm_number() {
      return confirm_number;
   }
   public void setConfirm_number(String confirm_number) {
      this.confirm_number = confirm_number;
   }
   public String getM_id() {
      return m_id;
   }
   public void setM_id(String m_id) {
      this.m_id = m_id;
   }
   public String getPrice() {
      return price;
   }
   public void setPrice(String price) {
      this.price = price;
   }
}