package online.babylove.www.jdbc.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import online.babylove.www.jdbc.controller.PersonController;
import online.babylove.www.jdbc.model.Person;

/**
 * 模拟person视图层
 * @author zhangjiawei
 *
 */
public class PersonView {
	
	/**
	 * 初始化提示
	 */
	private static final String CONTEXT="欢迎：\n" +
			"下面的是功能列表：\n" +
			"[MAIN/M]:主菜单\n" +
			"[QUERY/Q]:查看全部人员的信息\n" +
			"[GET/G]:查看某位人员的详细信息\n" +
			"[ADD/A]:添加人员信息\n" +
			"[UPDATE/U]:更新人员信息\n" +
			"[DELETE/D]:删除人员信息\n" +
			"[SEARCH/S]:查询人员信息(根据姓名、手机号来查询)\n" +
			"[EXIT/E]:退出\n" +
			"[BREAK/B]:退出当前功能，返回主菜单";

	
	/**
	 * 操作命令
	 */
	private static final String OPERATION_MAIN = "MAIN";
	private static final String OPERATION_QUERY = "QUERY";
	private static final String OPERATION_GET = "GET";
	private static final String OPERATION_ADD = "ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE = "DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT = "EXIT";
	private static final String OPERATION_BREAK = "BREAK";
	
	/**
	 * 记录上一次的什么操作
	 */
	private static String previous = null;
	/**
	 * 记录执行的步骤
	 */
	private static int step = 1;
	
	private PersonController personController = new PersonController();

	public static void main(String[] args) {
		System.out.println(CONTEXT);
		//接受控制台输入
		Scanner scanner = new Scanner(System.in);
		
		Person person = new Person();
		
		PersonView personView = new PersonView();
		
		//保持程序的一直运行
		while(scanner.hasNext()){
			//控制台输入的内容
			String in = scanner.next().toString();
			//输入exit或者e的时候，退出系统
			if (OPERATION_EXIT.equals(in) || OPERATION_EXIT.substring(0, 1).toLowerCase().equals(in)) {
				System.out.println("欢迎下次使用，再见！");
				break;
			}else if(OPERATION_GET.toLowerCase().equals(in) 
					|| OPERATION_GET.substring(0, 1).toLowerCase().equals(in)
					|| OPERATION_GET.equals(previous)){
				personView.doGet(in);
			//如果输入DELETE/delete/D/d 或者上一次操作等于DELETE,则进入	
			}else if(OPERATION_DELETE.toLowerCase().equals(in) 
					|| OPERATION_DELETE.substring(0, 1).toLowerCase().equals(in)
					|| OPERATION_DELETE.equals(previous)){
				personView.doDel(in);
			//如果输入Break/break/B/b 则返回控制台
			}else if(OPERATION_MAIN.toLowerCase().equals(in) 
					|| OPERATION_MAIN.substring(0, 1).toLowerCase().equals(in)){
				personView.doMain();
			//如果输入QUERY/query/Q/q则进入查询模块
			}else if(OPERATION_QUERY.toLowerCase().equals(in) 
					|| OPERATION_QUERY.substring(0, 1).toLowerCase().equals(in)){
				personView.doAll();
			//如果输入add/ADD/a/A，或者上一次操作等于ADD,则进入	
			}else if(OPERATION_ADD.toLowerCase().equals(in) 
					|| OPERATION_ADD.substring(0, 1).toLowerCase().equals(in)
					|| OPERATION_ADD.equals(previous)){
				personView.doSave(person, in);
			}
		}
	}
	
	/**
	 * 查询
	 * @param id
	 */
	public void doGet(String id){
		previous = OPERATION_GET;
		if(step == 1){//第一步
			System.out.println("请输入需要查询的人员的ID");
		}else if(step == 2){
			try {
				Person p = personController.get(Integer.parseInt(id));
				System.out.println("ID:" + p.getId() + "姓名:" + p.getUserName() + ",年龄" + p.getAge() + ",电话" + p.getMobile() + ",邮箱" + p.getEmail());
				System.out.println("输入[MAIN/M]:返回主菜单");
				//操作完成初始化
				doInit();
			} catch (SQLException e) {
				System.out.println("删除失败");
				e.printStackTrace();
			}
		}
		//下一步
		if(OPERATION_GET.equals(previous)){
			step++;
		}
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void doDel(String id){
		previous = OPERATION_DELETE;
		if(step == 1){//第一步
			System.out.println("请输入需要删除的人员的ID");
		}else if(step == 2){
			try {
				personController.del(Integer.parseInt(id));
				System.out.println("删除成功!输入[MAIN/M]:返回主菜单");
				//操作完成初始化
				doInit();
			} catch (SQLException e) {
				System.out.println("删除失败");
				e.printStackTrace();
			}
		}
		//下一步
		if(OPERATION_DELETE.equals(previous)){
			step++;
		}
	}
	
	/**
	 * 保存
	 * @param person 对象
	 * @param in 输入的内容
	 */
	public void doSave(Person person, String in){
		previous = OPERATION_ADD;
		if(step == 1){//第一步
			person = new Person();
			System.out.println("请输入人员的[姓名]");
		}else if(step == 2){//第二步
			person.setUserName(in);
			System.out.println("请输入人员的[年龄]");
		}else if(step == 3){//第三步
			person.setAge(Integer.parseInt(in));
			System.out.println("请输入人员的[生日],格式为:yyyy-MM-dd");
		}else if(step == 4){//第四步
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = null;
			try {
				birthday = simpleDateFormat.parse(in);
				person.setBirthday(birthday);
				System.out.println("请输入人员的[邮箱]");
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("你输入的日期格式有误,请重新输入.");
				step = 3;//返回上一步
			}
		}else if(step == 5){//第五步
			person.setEmail(in);
			System.out.println("请输入人员的[手机号]");
		}else if(step ==6){//第六步
			person.setMobile(in);
			System.out.println("请输入人员的[性别],0=男,1=女");
		}else if(step == 7){//第七步
			person.setSex(Integer.parseInt(in));
			try {
				//保存
				personController.save(person);
				System.out.println("保存成功!输入[MAIN/M]:返回主菜单");
				//操作完成初始化
				doInit();
				System.out.println("");
			} catch (SQLException e) {
				System.out.println("保存失败");
				e.printStackTrace();
			}
		}
		//下一步
		if(OPERATION_ADD.equals(previous)){
			step++;
		}
	}
	
	/**
	 * 返回主菜单
	 */
	public void doMain(){
		doInit();
		System.out.println(CONTEXT);
	}
	
	/**
	 * 查询所有Person
	 */
	public void doAll(){
		doInit();
		try {
			//查询所有Person
			List<Person> persons = personController.all();
			for(Person p : persons){
				System.out.println("ID:" + p.getId() + "姓名:" + p.getUserName() + ",年龄" + p.getAge() + ",电话" + p.getMobile() + ",邮箱" + p.getEmail());
			}
			System.out.println("输入[MAIN/M]:返回主菜单");
		} catch (SQLException e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
	}
	
	public void doInit(){
		previous = null;
		step = 1;
	}
}
