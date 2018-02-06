package myVO;

public class Admin {

   
    private String adminUserName;
    private String adminpwd;
    
    
    public Admin() {
        super();
    }
    public Admin(String username, String password) {
        super();
        this.adminUserName = username;
        this.adminpwd = password;
    }
    
    public String getAdminname() {
        return adminUserName;
    }
    public void setAdminname(String username) {
        this.adminUserName = username;
    }
    public String getAdminPassword() {
        return adminpwd;
    }
    public void setAdminPassword(String password) {
        this.adminpwd = password;
    }
    
    
}