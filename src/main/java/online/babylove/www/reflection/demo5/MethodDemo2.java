package online.babylove.www.reflection.demo5;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo2 {
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("hello world");
//		list2.add(20);//错误的
		
		Class c1 = list.getClass();
		Class c2 = list2.getClass();
		System.out.println(c1 == c2);
		
		//反射的操作都是编译之后的操作
		
		/*
		 * c1 == c2结果返回true，说明编译之后的集合的泛型是去泛型化的
		 * Java中集合的泛型，是防止错误输入的，只在编译阶段有效
		 * 绕过编译就无效了
		 * 验证：我们可以通过方法的反射来操作，绕过编译
		 */
		try {
			//通过反射操作把int类型的值，加入到ArrayList<String>集合当中
			Method m = c2.getMethod("add", Object.class);
			m.invoke(list2, 20);
			//绕过了编译操作，就绕过了泛型
			System.out.println(list2.size());
			System.out.println(list2);
			/*
			 * 现在就不能这样遍历了
			 * for (String string : list2) {
			 * 	   System.out.println(string);
			 * }
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
