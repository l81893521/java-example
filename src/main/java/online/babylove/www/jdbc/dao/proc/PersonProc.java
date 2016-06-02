package online.babylove.www.jdbc.dao.proc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


import online.babylove.www.jdbc.model.Person;
import online.babylove.www.jdbc.util.DBUtil;

public class PersonProc {
	
	/**
	 * 无参
	 * 调用存储过程proc_select_person
	 * 查询所有用户
	 * @throws SQLException
	 */
	public List<Person> procSelectPerson() throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		//执行存储过程
		CallableStatement callableStatement = connection.prepareCall("call proc_select_person()");
		callableStatement.execute();
		//获取数据集
		ResultSet resultSet = callableStatement.getResultSet();
		
		List<Person> persons = new ArrayList<Person>();
		Person person = null;
		//rs.next()方法返回一个boolean类型,如果返回是true，证明有数据
		while(resultSet.next()){
			person = new Person();
			person.setId(resultSet.getInt("id"));
			person.setUserName(resultSet.getString("user_name"));
			person.setAge(resultSet.getInt("age"));
			person.setSex(resultSet.getInt("sex"));
			person.setBirthday(resultSet.getDate("birthday"));
			person.setEmail(resultSet.getString("email"));
			person.setMobile(resultSet.getString("mobile"));
			person.setCreateDate(resultSet.getDate("create_date"));
			person.setCreateUser(resultSet.getString("create_user"));
			person.setUpdateDate(resultSet.getDate("update_date"));
			person.setUpdateUser(resultSet.getString("update_user"));
			person.setIsdel(resultSet.getInt("isdel"));
			persons.add(person);
		}
		return persons;
		
		
	}
	
	/**
	 * 入参
	 * 调用存储过程proc_select_person_by_name
	 * 根据名称查询用户
	 * 但是存储过程有条件需要注意一下，当sp_name为null或者"",则查询全部
	 * 如果sp_name为手机号码并且等于11位，则按手机查询
	 * 否则按照模糊匹配user_name
	 * @param sp_name
	 * @return
	 * @throws SQLException
	 */
	public List<Person> procSelectPersonByName(String sp_name) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		//获得callableStatement
		CallableStatement callableStatement = connection.prepareCall("call proc_select_person_by_name(?)");
		//为占位符设置参数
		callableStatement.setString(1, sp_name);
		//执行存储过程
		callableStatement.execute();
		//获取结果集
		ResultSet resultSet = callableStatement.getResultSet();
		
		
		List<Person> persons = new ArrayList<Person>();
		Person person = null;
		//rs.next()方法返回一个boolean类型,如果返回是true，证明有数据
		while(resultSet.next()){
			person = new Person();
			person.setId(resultSet.getInt("id"));
			person.setUserName(resultSet.getString("user_name"));
			person.setAge(resultSet.getInt("age"));
			person.setSex(resultSet.getInt("sex"));
			person.setBirthday(resultSet.getDate("birthday"));
			person.setEmail(resultSet.getString("email"));
			person.setMobile(resultSet.getString("mobile"));
			person.setCreateDate(resultSet.getDate("create_date"));
			person.setCreateUser(resultSet.getString("create_user"));
			person.setUpdateDate(resultSet.getDate("update_date"));
			person.setUpdateUser(resultSet.getString("update_user"));
			person.setIsdel(resultSet.getInt("isdel"));
			persons.add(person);
		}
		return persons;
	}
	
	/**
	 * 出参
	 * 调用存储过程proc_select_count_pereson
	 * 统计person表条数
	 * @return
	 * @throws SQLException
	 */
	public int selectCountPerson() throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		//获得callableStatement
		CallableStatement callableStatement = connection.prepareCall("call proc_select_count_person(?)");
		//注册输出参数
		callableStatement.registerOutParameter(1, Types.INTEGER);
		//执行存储过程
		callableStatement.execute();
		
		//获取结果集
		int count = callableStatement.getInt(1);
		return count;
		
	}
	
}
