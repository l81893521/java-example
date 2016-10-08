package online.babylove.www.io.demo3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class RafDemo {
	
	public static void main(String[] args) throws IOException{
		File demo = new File("demo");
		if(!demo.exists()){
			demo.mkdirs();
		}
		
		File file = new File(demo,"raf.dat");
		if(!file.exists()){
			file.createNewFile();
		}
		//有两种模式"rw"(读写), "r"只读
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		//指针的位置（文件指针），打开文件时指针在开头 pointer = 0;
		System.out.println(raf.getFilePointer());
		
		raf.write('A');//只写了一个字节(char是2个字节),部分字符后八位也能直接表示
		System.out.println(raf.getFilePointer());
		
		raf.write('B');
		System.out.println(raf.getFilePointer());
		int i = 0x7fffffff;
		//用write方法每次只能写一个字节，如果要把i写进去就得写4次
		raf.write(i >>> 24);//高八位
		raf.write(i >>> 16);//
		raf.write(i >>> 8);//
		raf.write(i >>> 0);//
		System.out.println(raf.getFilePointer());
		
		//也可以直接写int
		raf.writeInt(i);
		System.out.println(raf.getFilePointer());
		String s = "中";
		byte utf8[] = s.getBytes("utf-8");
		raf.write(utf8);
		System.out.println(raf.length());
		
		//读文件，必须把指针移到头部
		raf.seek(0);
//		raf.read();//只读一个字节
		//一次性读取,把文件中的内容都读到字节数组中
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		
		String s1 = new String(buf,"utf-8");
		System.out.println(s1);
		
		for (byte b : buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		//文件读写完成以后一定要关闭（官方说明）
		raf.close();
	}
}
