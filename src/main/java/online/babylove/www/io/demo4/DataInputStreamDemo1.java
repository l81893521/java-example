package online.babylove.www.io.demo4;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class DataInputStreamDemo1 {
	public static void main(String[] args) throws IOException{
		String file = "demo/dataOutputStreamDemo.dat";
		IOUtil.printHex(file);
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		/*
		 * 这组类，是对"流"功能的扩展，可以更加方便的读取int,long,字符等类型数据
		 * DataInputStream会有一些更加方便的方法，如readInt()/readDouble()/readUTF()等
		 */
		int i = dis.readInt();
		System.out.println(i);
		i = dis.readInt();
		System.out.println(i);
		
		long l = dis.readLong();
		System.out.println(l);
		
		double d = dis.readDouble();
		System.out.println(d);
		
		String s = dis.readUTF();
		System.out.println(s);
		
		dis.close();
	}
}
