package online.babylove.www.io.demo4;

import java.io.FileOutputStream;
import java.io.IOException;

import online.babylove.www.io.demo4.IOUtil;

public class FileOutputStreamDemo1 {
	public static void main(String[] args) throws IOException{
		//如果该文件不存在，则直接创建，如果存在，则删除后创建
		FileOutputStream out = new FileOutputStream("demo/fileOutputStreamDemo.dat");
		//如果该文件不存在，则直接创建，如果存在，则追加
//		FileOutputStream out = new FileOutputStream("demo/out.dat",true);
		//每次只能写一个字节
		out.write('A');//写出了'A'的底八位
		out.write('B');//写出了'B'的底八位
		int a = 10;//write只能写八位，那么写一个int需要写4次，每次8位
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		//写入字节数组
		byte[] utf8 = "中国".getBytes("utf-8");
		out.write(utf8);
		
		out.close();
		
		IOUtil.printHexByByteArray("demo/fileOutputStreamDemo.dat");
	}
}
