package online.babylove.www.io.demo4;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo1 {
	public static void main(String[] args) throws IOException{
		String file = "demo/dataOutputStreamDemo.dat";
		//需用通过FileOutputStream来构造DataOutputStream
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		/*
		 * 这组类，是对"流"功能的扩展，可以更加方便的读取int,long,字符等类型数据
		 * DataOutputStream会有一些更加方便的方法，如writeInt()/writeDouble()/writeUTF()等
		 */
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		//采用UTF-8编码写出
		dos.writeUTF("中国");
		//采用UTF-16be写出
		dos.writeChars("中国");
		
		dos.close();
		IOUtil.printHexByByteArray(file);
	}
}
