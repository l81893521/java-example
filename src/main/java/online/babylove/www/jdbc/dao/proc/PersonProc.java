package online.babylove.www.jdbc.dao.proc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import online.babylove.www.jdbc.util.DBUtil;

public class PersonProc {
	public void procSelectPerson() throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		//执行存储过程
		CallableStatement callableStatement = connection.prepareCall("call proc_select_person()");
		callableStatement.execute();
		//获取数据集
		ResultSet resultSet = callableStatement.getResultSet();
		
		//rs.next()方法返回一个boolean类型,如果返回是true，证明有数据
		while(resultSet.next()){
			System.out.println("ID:" + resultSet.getInt("id") + "姓名:" + resultSet.getString("user_name") + ",年龄" + resultSet.getInt("age") + ",电话" + resultSet.getString("mobile") + ",邮箱" + resultSet.getString("email"));
		}
	}
	
	public static void main(String[] args) throws SQLException {
		PersonProc personProc = new PersonProc();
		personProc.procSelectPerson();
	}
}
