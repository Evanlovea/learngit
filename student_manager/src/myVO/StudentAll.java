package myVO;

public class StudentAll extends Student {
    String courseName;
    String gradeString;
    public StudentAll() {
		super();
	}
    public StudentAll(String sid,String sname,String spwd,String cName,String grade ){
    	super(sid,sname,spwd);
    	this.courseName=cName;
    	this.gradeString=grade;
    }
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String cName) {
		this.courseName = cName;
	}
	public String getGradeString() {
		return gradeString;
	}
	public void setGradeString(String grade) {
		this.gradeString = grade;
	}
   
}
