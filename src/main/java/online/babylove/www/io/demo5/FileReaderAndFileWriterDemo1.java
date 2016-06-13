package online.babylove.www.io.demo5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndFileWriterDemo1 {
	public static void main(String[] args) throws IOException{
		/*
		 * 注意:构造时候无法制定编码
		 */
		FileReader fr = new FileReader("demo/srcCopyDemo.dat");
		FileWriter fw = new FileWriter("demo/srcCopyDemo2.dat");
		//继续往目标追加内容
//		FileWriter fw = new FileWriter("demo/srcCopyDemo2.dat",true);
		char[] buffer = new char[8 * 1024];
		int c;
		//开辟内存，批量读取和写入
		while((c=fr.read(buffer, 0, buffer.length))!=-1){
			fw.write(buffer, 0, c);
			fw.flush();
		}
		fr.close();
		fw.close();
	}
}
