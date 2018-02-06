package myVO;

public class Student {
   private String stuIdString;//学生学号
   private String stuNameString;//学生姓名
   private String stuPassWordString;//登录密码
   public Student(){
	   super();
   }
   public Student(String sid,String sname,String spwd){
	   super();
	   this.stuIdString=sid;
	   this.stuNameString=sname;
	   this.stuPassWordString=spwd;
   }
   public String getSid(){
	   return stuIdString;
   }
   public void setSid(String sid){
	   this.stuIdString=sid;
   }
   public String getSname(){
	   return stuNameString;
   }
   public void setSname(String sname){
	   this.stuNameString=sname;
   }
   public String getSpassWord(){
	   return stuPassWordString;
   }
   public void setSpassWord(String spwd){
	   this.stuPassWordString=spwd;
   }
}
