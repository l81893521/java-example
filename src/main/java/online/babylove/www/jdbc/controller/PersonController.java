package online.babylove.www.jdbc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import online.babylove.www.jdbc.dao.PersonDao;
import online.babylove.www.jdbc.model.Person;

/**
 * Person控制层
 * @author zhangjiawei
 *
 */
public class PersonController {
	
	/**
	 * 添加
	 * @param person
	 * @throws SQLException
	 */
	public void save(Person person) throws SQLException{
		PersonDao personDao = new PersonDao();
		personDao.save(person);
	}
	
	/**
	 * 更新
	 * @param person
	 * @throws SQLException
	 */
	public void update(Person person) throws SQLException{
		PersonDao personDao = new PersonDao();
		personDao.update(person);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws SQLException
	 */
	public void del(int id) throws SQLException{
		PersonDao personDao = new PersonDao();
		personDao.del(id);
	}
	
	/**
	 * 查询所有Person
	 * @return
	 * @throws SQLException
	 */
	public List<Person> all() throws SQLException{
		PersonDao personDao = new PersonDao();
		return personDao.all();
	}
	
	/**
	 * 根据条件查询所有Person
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Person> all(List<Map<String, Object>> params) throws SQLException{
		PersonDao personDao = new PersonDao();
		return personDao.all(params);
	}
	
	/**
	 * 查询单个Person
	 * @param id
	 * @throws SQLException
	 */
	public Person get(int id) throws SQLException{
		PersonDao personDao = new PersonDao();
		return personDao.get(id);
	}
	
	public static void main(String[] args) throws SQLException {
//		Person person = new Person();
//		person.setId(10);
//		person.setUserName("张海");
//		person.setAge(21);
//		person.setBirthday(new Date());
//		person.setEmail("zhanghai@163.com");
//		person.setMobile("13333333678");
//		person.setSex(0);
//		person.setUpdateUser("admin");
//		person.setUpdateDate(new Date());
//		person.setIsdel(0);
		
		PersonDao personDao = new PersonDao();
		
		List<Map<String, Object>> params = new ArrayList<Map<String,Object>>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "user_name");
		param.put("rela", "like");
		param.put("value", "'%小%'");
		params.add(param);
		param = new HashMap<String, Object>();
		param.put("name", "mobile");
		param.put("rela", "like");
		param.put("value", "'%1%'");
		params.add(param);
		
		List<Person> persons = personDao.all(params);
		for(Person p : persons){
			System.out.println(ReflectionToStringBuilder.toString(p));
		}
//		personDao.save(person);
//		personDao.update(person);
//		personDao.del(11);
//		Person person = personDao.get(10);
//		System.out.println(ReflectionToStringBuilder.toString(person));
	}
}
