package online.babylove.www.io.demo6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerializableDemo2{
	public static void main(String[] args) throws IOException, ClassNotFoundException{
//		String file = "demo/obj1.dat";
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
		/*
		 * 控制台输出的是构造递归调用父类构造函数所输出的，跟序列化没关系
		 */
//		Foo2 foo2 = new Foo2();
//		oos.writeObject(foo2);
//		oos.flush();
//		oos.close();
		
		/*
		 * 反序列化，是否递归调用父类的构造函数?
		 * 控制台没有任何输出，是否代表反序列化时，父类构造函数不会被调用？
		 * 并不能证明
		 * 请继续往下看Bar类
		 */
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//		System.out.println("反序列化中....");
//		Foo2 foo22 = (Foo2)ois.readObject();
//		System.out.println(foo22);
//		ois.close();
		
		/*
		 * 第二个例子
		 * 序列化和反序列化Bar2类
		 */
		System.out.println("----------第二个例子----------");
		
		String file2 = "demo/obj2.dat";
		ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file2));
		
		/*
		 * 控制台输出的是构造递归调用父类构造函数所输出的，跟序列化没关系
		 */
		Bar2 bar2 = new Bar2();
		oos2.writeObject(bar2);
		oos2.flush();
		oos2.close();
		
		/*
		 * 反序列化Bar2类
		 * 这次我们看到，反序列化的时候，父类的构造函数被调用了
		 */
		ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file2));
		System.out.println("反序列化中....");
		Bar2 bar22 = (Bar2)ois2.readObject();
		System.out.println(bar22);
		ois2.close();
//		
		/*
		 * 我们得出一个结论
		 * 对子类对象进行反序列化操作时
		 * 如果其父类没有实现序列化接口
		 * 那么其父类的构造函数，会被显式调用
		 */
	}
}
/**
 * 一个类实现了序列化接口
 * 那么，其子类都可以进行序列化
 * @author zhangjiawei
 *
 */
class Foo implements Serializable{
	public Foo() {
		System.out.println("foo...");
	}
}

class Foo1 extends Foo{
	public Foo1() {
		System.out.println("foo1...");
	}
}

class Foo2 extends Foo1{
	public Foo2(){
		System.out.println("foo2...");
	}
}
/**
 * 子类实现了序列化接口
 * 父类没有实现
 * @author zhangjiawei
 *
 */
class Bar{
	public Bar() {
		System.out.println("bar...");
	}
}

class Bar1 extends Bar{
	public Bar1() {
		System.out.println("bar1...");
	}
}

class Bar2 extends Bar1 implements Serializable{
	public Bar2() {
		System.out.println("bar2...");
	}
}