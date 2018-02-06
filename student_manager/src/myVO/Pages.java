package myVO;
//翻页模型如下所示
public class Pages {
   private int curPage=1;
   private String sqlString;
   private int totalPage=1;
   
   public int getCurPage() {
	return curPage;
}
public void setCurPage(int curPage) {
	this.curPage = curPage;
}
public String getSqlString() {
	return sqlString;
}
public void setSqlString(String sqlString) {
	this.sqlString = sqlString;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

   
}
