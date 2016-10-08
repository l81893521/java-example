package online.babylove.www.io.demo6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ObjectSerializableDemo1{
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		String file = "demo/obj.dat";
		//1.对象序列化
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
		Student student = new Student("1001","张三",20);
		
		oos.writeObject(student);
		oos.flush();
		oos.close();
		
		//2.反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		/*
		 * 如果不等于20，反之age=0
		 * 因为transient关键字代表，该元素不会进行jvm默认的序列化
		 * 所以取int的默认值0
		 * 
		 * 但是就算又transient关键字
		 * 也可以自己完成这个元素的序列化
		 * 可以查看Student类的writeObject和readObject
		 */
		Student student2 = (Student)ois.readObject();
		System.out.println(student2);
		ois.close();
		
	}
}
