package online.babylove.www.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import online.babylove.www.jdbc.model.Person;
import online.babylove.www.jdbc.util.DBUtil;

public class PersonDao {
	
	/**
	 * 保存
	 * @param person
	 * @throws SQLException
	 */
	public void save(Person person) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		String sql = "insert into tb_person(user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel)"
				+ "values"
				+ "(?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		//预编译sql
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//为占位符设置参数
		preparedStatement.setString(1, person.getUserName());
		preparedStatement.setInt(2, person.getSex());
		preparedStatement.setInt(3, person.getAge());
		preparedStatement.setDate(4, new Date(person.getBirthday().getTime()));
		preparedStatement.setString(5, person.getEmail());
		preparedStatement.setString(6, person.getMobile());
		preparedStatement.setString(7, person.getCreateUser());
		preparedStatement.setString(8, person.getUpdateUser());
		preparedStatement.setInt(9, 0);
		//调用execute才会真正执行
		preparedStatement.execute();
	}
	
	/**
	 * 更新
	 * @param person
	 * @throws SQLException
	 */
	public void update(Person person) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		String sql = " update tb_person set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,update_user=?,update_date=current_date(),isdel=?"
				+ " where id =?";
		//预编译sql
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//为占位符设置参数
		preparedStatement.setString(1, person.getUserName());
		preparedStatement.setInt(2, person.getSex());
		preparedStatement.setInt(3, person.getAge());
		preparedStatement.setDate(4, new Date(person.getBirthday().getTime()));
		preparedStatement.setString(5, person.getEmail());
		preparedStatement.setString(6, person.getMobile());
		preparedStatement.setString(7, person.getUpdateUser());
		preparedStatement.setInt(8, person.getIsdel());
		preparedStatement.setInt(9, person.getId());
		//调用execute才会真正执行
		preparedStatement.execute();
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws SQLException
	 */
	public void del(int id) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		String sql = "delete from tb_person where id =?";
		//预编译sql
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//为占位符设置参数
		preparedStatement.setInt(1, id);
		//调用execute才会真正执行
		preparedStatement.execute();
	}
	
	/**
	 * 查询所有Person
	 * @return
	 * @throws SQLException
	 */
	public List<Person> all() throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select id, user_name, age, sex, birthday, email, mobile, create_date, create_user, update_date, update_user, isdel from tb_person");
		//通过数据库连接操作数据库，实现增删改查
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		//executeQuery通常是执行查询的操作,并且返回一个ResultSet对象;
		ResultSet resultSet = preparedStatement.executeQuery();
		
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
	 * 根据查询条件查询Person,如果查询条件不断追加，这种参数形式会不会有点不方便呢?
	 * @param name 根据名称模糊查询
	 * @return
	 * @throws SQLException
	 */
	public List<Person> all(String name) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select id, user_name, age, sex, birthday, email, mobile, create_date, create_user, update_date, update_user, isdel from tb_person");
		sql.append(" where user_name like ?");
		//通过数据库连接操作数据库，实现增删改查
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		//为占位符设置参数
		preparedStatement.setString(1, "%" + name + "%");
		//executeQuery通常是执行查询的操作,并且返回一个ResultSet对象;
		ResultSet resultSet = preparedStatement.executeQuery();
		
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
	 * 根据查询条件查询Person,如果查询条件不断追加，这种参数形式会不会有点不方便呢?
	 * @param name 根据名称模糊查询
	 * @param mobile 手机
	 * @return
	 * @throws SQLException
	 */
	public List<Person> all(String name, String mobile) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select id, user_name, age, sex, birthday, email, mobile, create_date, create_user, update_date, update_user, isdel from tb_person");
		sql.append(" where user_name like ? and mobile like ?");
		//通过数据库连接操作数据库，实现增删改查
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		//为占位符设置参数
		preparedStatement.setString(1, "%" + name + "%");
		preparedStatement.setString(2, "%" + mobile + "%");
		//executeQuery通常是执行查询的操作,并且返回一个ResultSet对象;
		ResultSet resultSet = preparedStatement.executeQuery();
		
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
	 * 根据查询条件查询Person,如果查询条件不断追加，这种参数形式会不会有点不方便呢?
	 * @param name 根据名称模糊查询
	 * @param mobile 根据手机模糊查询
	 * @param email 根据邮箱模糊查询
	 * @return
	 * @throws SQLException
	 */
	public List<Person> all(String name, String mobile, String email) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select id, user_name, age, sex, birthday, email, mobile, create_date, create_user, update_date, update_user, isdel from tb_person");
		sql.append(" where user_name like ? and mobile like ? and email like ?");
		//通过数据库连接操作数据库，实现增删改查
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		//为占位符设置参数
		preparedStatement.setString(1, "%" + name + "%");
		preparedStatement.setString(2, "%" + mobile + "%");
		preparedStatement.setString(3, "%" + email + "%");
		//executeQuery通常是执行查询的操作,并且返回一个ResultSet对象;
		ResultSet resultSet = preparedStatement.executeQuery();
		
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
	 * 根据查询条件查询Person列表
	 * @param params 参数
	 * @return
	 * @throws SQLException
	 */
	public List<Person> all(List<Map<String, Object>> params) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select id, user_name, age, sex, birthday, email, mobile, create_date, create_user, update_date, update_user, isdel from tb_person where 1=1");
		//追加参数
		if(params != null && params.size() != 0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> param = params.get(i);
				sql.append(" and " + param.get("name") + " " + param.get("rela") + " " + param.get("value"));
			}
		}
		//通过数据库连接操作数据库，实现增删改查
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		//executeQuery通常是执行查询的操作,并且返回一个ResultSet对象;
		ResultSet resultSet = preparedStatement.executeQuery();
		
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
	 * 查询单个Person
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Person get(int id) throws SQLException{
		//获取数据库连接
		Connection connection = DBUtil.getConnection();
		String sql = "select id, user_name, age, sex, birthday, email, mobile, "
				+ "create_date, create_user, update_date, update_user from tb_person where id =?";
		//预编译sql
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//为占位符设置参数
		preparedStatement.setInt(1, id);
		//调用execute才会真正执行
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Person person = new Person();
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
		}
		return person;
	}
}
