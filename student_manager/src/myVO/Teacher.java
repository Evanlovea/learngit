package myVO;

public class Teacher {
	   private String teacherIdString;//教工号
	   private String teacherNameString;//教师姓名
	   private String teacherNum;//所交课程号
	   private String teacherPassWordString;//登录密码
	   public Teacher(){
		   super();
	   }
	   public Teacher(String tid,String  tname,String tnum,String tpwd){
		   super();
		   this.teacherIdString=tid;
		   this.teacherNameString=tname;
		   this.teacherNum=tnum;
		   this.teacherPassWordString=tpwd;
	   }
	   public String getTid(){
		   return teacherIdString;
	   }
	   public void setTid(String tid){
		   this.teacherIdString=tid;
	   }
	   public String getTname(){
		   return teacherNameString;
	   }
	   public void setTname(String tname){
		   this.teacherNameString=tname;
	   }
	   public String getTpassWord(){
		   return teacherPassWordString;
	   }
	   public void setTpassWord(String tpwd){
		   this.teacherPassWordString=tpwd;
	   }
	   public void setTnum(String tnum){
		   this.teacherNum=tnum;
	   }
	   public String getTnum(){
		   return teacherNum;
	   }
}
