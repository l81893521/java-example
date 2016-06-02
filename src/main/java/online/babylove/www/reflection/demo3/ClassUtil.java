package online.babylove.www.reflection.demo3;

import java.lang.reflect.Method;

public class ClassUtil {
	
	/**
	 * 打印类的信息，包括类的成员函数，成员比变量
	 * @param object 改对象所属类的信息
	 */
	public static void printClassMessage(Object object){
		//要获取类的信息，首先要获取类的类类型
		Class c = object.getClass();//传递的是哪个子类的对象 c就是该子类的类类型
		//获取类的名称
		System.out.println("类的名称是:" + c.getName());
		//获取类的名称（不包含包名）
		System.out.println("类的名称是(不包含包名):" + c.getSimpleName());
		
		/*
		 * Method类，方法对象
		 * 一个成员方法就是一个Method对象
		 * getMethods()方法获取的是所有public的函数，包括父类继承而来的
		 * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
		 */
		Method[] ms = c.getMethods();//c.getDeclaredMethods();
		for(int i = 0;i < ms.length; i++){
			//得到方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			//得到方法的名称
			System.out.print(ms[i].getName() + "(");
			//获取参数类型--->得到的是参数列表的类型的类类型
			Class paramTypes[] = ms[i].getParameterTypes();
			for(Class param : paramTypes){
				System.out.print(param.getName() + ",");
			}
			System.out.println(")");
		}
	}
}
