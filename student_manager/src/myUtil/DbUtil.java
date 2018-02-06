package myUtil;



import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class DbUtil {
    
    private final String url="jdbc:mysql://localhost:3306/test";
    private final String user="root";
    private final String password="123456";
    private final static String driver="com.mysql.jdbc.Driver";
    private Connection connection;
   
    
    static{
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public Connection getCon() {
    	try{
    	
        connection=DriverManager.getConnection(url, user, password);
    	}
        catch(SQLException e){
        	e.printStackTrace();
        }
        return connection;
    }
    
    public void closeAll(Connection con,Statement statement,ResultSet rSet) throws SQLException{
    	
        try {
			if(con!=null){
			    con.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(rSet!=null){
				rSet.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /*
     * 定义每页显示的数量
     */
    private static int span=2;
    
	public static int getSpan() {
		return span;
	}

	public static void setSpan(int i) {
		span = i;
	}

	//获取当前页面上的数据
	public static List<String[]> getPageContent(int curPage, String sqlString) {
		// TODO Auto-generated method stub
		List<String[]>listsList=new ArrayList<String[]>();
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		ResultSet resultSet=null;try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlString);
			//获取结果集的元数据
			ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
			//得到结果集中的总列数
			int count=resultSetMetaData.getColumnCount();
			int start=(curPage-1)*span;
			if(start!=0){
				resultSet.absolute(start);
			}
			int temp=0;
			while(resultSet.next()&&temp<span){
				temp++;
				String[] strings=new String[count];
				for(int i=0;i<strings.length;i++){
					strings[i]=resultSet.getString(i+1);
				}
				listsList.add(strings);
			}
			dbUtil.closeAll(connection, statement, resultSet);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listsList;
	}
	//获取数据的页数
	public static int getTotalPages(String sql) throws SQLException{
		int totalPage=1;
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		ResultSet resultSet=null;
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			resultSet.next();
			int rows=resultSet.getInt(1);
			totalPage=rows/span;
			if(rows%span!=0){
				totalPage++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbUtil.closeAll(connection, statement, resultSet);
		return totalPage;
	}
	public boolean isLegal(String sqlString) {
		boolean legal=false;
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement;
		ResultSet resultSet;
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlString);
			if(resultSet.next()){
				legal=true;
			}
			dbUtil.closeAll(connection, statement, resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return legal;
	}

    /*public static void main(String[] args) {
        DbUtil db=new DbUtil();
        try {
            db.getCon();
            System.out.println("测试连接数据库，连接成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("测试连接数据库，连接失败");
        }
        
    }*/
}