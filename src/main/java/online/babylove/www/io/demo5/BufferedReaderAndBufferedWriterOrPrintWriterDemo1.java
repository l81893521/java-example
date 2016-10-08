package online.babylove.www.io.demo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BufferedReaderAndBufferedWriterOrPrintWriterDemo1 {
	public static void main(String[] args) throws IOException{
		/*
		 * 不指定编码的话，默认以项目编码
		 */
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("demo/srcCopyDemo.dat"),"utf-8"));
		
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("demo/srcCopyDemo3.dat"),"utf-8"));
		
		/*
		 * PrintWriter会比BufferedWriter构造起来方便
		 * 可以查看构造方法的源码，是通过上面BufferedWriter的构造方式来构造
		 */
		PrintWriter pw = new PrintWriter("demo/srcCopyDemo4.dat");
		String line;
		/*
		 * BufferedReader可以一次读一行
		 * 但是不能识别换行
		 */
		while((line=br.readLine())!=null){
			System.out.print(line);
			//可以追加
//			bw.append();
			bw.write(line);
			//单独写出换行操作
			bw.newLine();
			//刷新缓冲区
			bw.flush();
			
			//写入并且换行
			pw.println(line);
			pw.flush();
		}
		br.close();
		bw.close();
		pw.close();
	}
}
