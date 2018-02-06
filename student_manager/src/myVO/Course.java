package myVO;

public class Course {

    private String courseId;
    private String courseName;
    
    
    public Course() {
        super();
    }
    public Course(String cid, String cname) {
        super();
        this.courseId = cid;
        this.courseName = cname;
    }
    
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String cname) {
        this.courseName = cname;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String cid) {
        this.courseId = cid;
    }
}
