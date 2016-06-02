package online.babylove.www.reflection.demo2;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ClassDemo2 {
	
	public static void main(String[] args) {
		
		Class class1 = int.class;//int的类类型
		Class class2 = String.class;//String的类类型
		//double.class和Double.class完全不是同一个类类型
		Class class3 = double.class;
		Class class4 = Double.class;
		Class class5 = void.class;
		
		//getName()获取全名，getSimpleName()获取不带包名
		System.out.println(class1.getName());
		System.out.println(class2.getName());
		System.out.println(class2.getSimpleName());
		System.out.println(class5.getName());
	}
}
