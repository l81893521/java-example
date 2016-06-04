package online.babylove.www.reflection.demo4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {
	public static void main(String[] args){
		/*
		 * 获取print(int a, int b)方法
		 * 要获取一个方法，就是获取类信息
		 * 获取类的信息首先要获取类的类类型
		 */
		A a1 = new A();
		Class c = a1.getClass();
		
		
		try {
			/*
			 * 2.获取方法 名称和参数列表来决定
			 * getMethod获取的是public的方法
			 * getDeclaredMethod获取的是自己生命的方法
			 */
			//Method m = c.getMethod("print", new Class[]{int.class, int.class});
			Method m = c.getMethod("print", int.class, int.class);
			
			
			/*
			 * 方法的反射操作
			 * 以前我们是这样调用的a1.print(10,20)
			 * 方法的反射操作是用m对象来进行方法调用
			 * 和a1.print调用的效果完全相同
			 * 方法如果没有返回值返回null,有返回值返回具体的返回值
			 */
			//Object o = m.invoke(a1, new Object[]{10,20});
			Object o = m.invoke(a1, 10, 20);
			
			System.out.println("======================");
			
			//获取print(String a, String b)
			Method m1 = c.getMethod("print", String.class, String.class);
			//用方法进行反射操作
			//a1.print("hello", "world");
			Object o1 = m1.invoke(a1, "hello", "world");
			
			System.out.println("======================");
			
			//Method m2 = c.getMethod("print", new Class[]{});
			Method m2 = c.getMethod("print");
			
			//Object o2 = m2.invoke(a1, new Object[]{});
			Object o2 = m2.invoke(a1);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}

class A{
	public void print(){
		System.out.println("hello world");
	}
	
	public void print(int a, int b){
		System.out.println(a + b);
	}
	
	public void print(String a, String b){
		System.out.println(a.toUpperCase() + "," + b.toUpperCase());
	}
}
