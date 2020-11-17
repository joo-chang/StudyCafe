package models;

public class Member {

   private String name;
   private String id;
   private String password;
   private String email;
   private String birthday;
   private String phone;
   private String sex;

   public String getSex() {
      return sex;
   }

   public void setSex(String sex) {
      this.sex = sex;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public Member() {
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getBirthday() {
      return birthday;
   }

   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }

   public Member(String name, String id, String password, String birthday, String sex, String email, String phone) {
      super();
      this.name = name;
      this.id = id;
      this.password = password;
      this.birthday = birthday;
      this.sex = sex;
      this.email = email;
      this.phone = phone;
   }
}