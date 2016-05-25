package online.babylove.www.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	
	private static final String URL = "jdbc:mysql://192.168.1.54:3306/java_example_jdbc?characterEncoding=UTF-8";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "zhongniu123";
	
	//数据库连接
	private static Connection connection;
	
	//静态块
	static {
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库连接
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return connection;
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得数据库连接
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		//3.通过数据库连接操作数据库，实现增删改查
		Statement statement = connection.createStatement();
		//executeQuery通常是执行查询的操作,并且返回一个ResultSet对象;
		ResultSet resultSet = statement.executeQuery("select user_name, sex, age from tb_person");
		//rs.next()方法返回一个boolean类型,如果返回是true，证明有数据
		while(resultSet.next()){
			System.out.println("名字:" + resultSet.getString("user_name") + ",性别:" + resultSet.getInt("sex") + ",年龄:"+ resultSet.getInt("age"));
		}
	}
}
