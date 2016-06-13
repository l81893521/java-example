package online.babylove.www.io.demo5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderAndOutputStreamWriterDemo1 {
	
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("demo/srcCopyDemo.dat");
		//默认以项目编码
//			InputStreamReader isr = new InputStreamReader(in);
		InputStreamReader isr = new InputStreamReader(in,"utf-8");
		
		FileOutputStream out = new FileOutputStream("demo/srcCopyDemo1.dat");
		//默认以项目编码
//			OutputStreamWriter osw = new OutputStreamWriter(out);
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		
		//单字符读取
		/*int c;
		while((c=isr.read())!=-1){
			System.out.print((char)c);
		}*/
		
		char[] buffer = new char[8 * 1024];
		int c;
		/*
		 * 批量读取，放入到buffer这个字符数组，从0开始放，最多放buffer.length个
		 * 返回的是读到的字符的个数c
		 */
		while((c=isr.read(buffer, 0, buffer.length))!=-1){
			String s = new String(buffer, 0, c);
			System.out.print(s);
			//批量写入，从0开始写，最多写c个
			osw.write(buffer, 0, c);
			//刷新缓冲区
			osw.flush();
		}
		isr.close();
		osw.close();
		
	}
}
