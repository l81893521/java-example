package online.babylove.www.io.demo4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IO流是Java做输入输出的基础(分为输入流和输出流)
 * 在这里面也分为字节流和字符流，在写入文件的时候，可以以字节为单位，也可以以字符为单位
 * 1.字节流(对应输入和输出，就是读和写),它有两个抽象的父类InputStream和OutputStream
 *  InputStream抽象了应用程序读取数据的方式
 *  OutputStream抽象了应用程序写出数据的方式
 *  
 * 2.EOF(end of file 达到文件结尾)或者说读到-1了一般也是结束
 * 
 * 3.输入流基本方法主要是读
 * 	int b = in.read();读取一个字节无符号填充到int的底八位,前面补0,-1是EOF
 *  in.read(byte[] buf)读取的数据填充到字节数据
 *  in.read(byte[] buf,int start, int size);从start开始读取size个到buf字节数组当中
 *  
 * 4.输出流基本方法主要是写
 *  out.write(int b) 只写一个字节到流，写得是b的底八位(int类型是32位)
 *  out.write(byte[] buf) 将buf字节数组，都写入到流
 *  out.write(byte[] buf, int start, int size)把buf从start开始写size个字节到流
 * @author zhangjiawei
 * 
 * 5.InputStream和OutputStream有一组子类，一般都是以搭配形式来使用
 * FileInputStream继承了InputStream,具体实现了在文件上读取数据
 * 
 * 6.byte类型8位,int类型32位
 * 当byte转换成int的时候(java的做法是补码),如果byte是一个小于0的数，转换成int之后数值会出现误差(因为高位补了数)
 * 所以我们要 & 0xff将高24位清0,这个时候结果就对了
 */
public class IOUtil {
	
	/**
	 * 单字节读取
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且每输出10个byte换行
	 * @param fileName
	 * 单字节读取，并不适合读取较大的文件(可以进入IOUtilTest1.java,读取一个较大的文件(10m左右)看看时间)
	 */
	public static void printHex(String fileName) throws IOException{
		//把文件作为字节流进行读操作
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
//		List<Byte> c = new ArrayList<Byte>();
		while((b=in.read()) != -1){
			//单位数前面补0
			if((b & 0xff) <= 0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b & 0xff) + " ");
			if(i++%10==0){
				System.out.println();
			}
		}
		in.close();
	}
	
	/**
	 * 批量字节读取，对大文件而言，效率高，也是最常用的
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且每输出10个byte换行
	 * @param fileName
	 */
	public static void printHexByByteArray(String filename) throws IOException{
		FileInputStream in = new FileInputStream(filename);
		byte[] buf = new byte[1024];
		/*
		 * 从in中批量读取字节,放到buf这个字节数组中，
		 * 从第0个位置开始放，最多放buf.length个,
		 * 返回的是读到的字节的个数
		 */
//		int bytes = in.read(buf,0,buf.length);//一次性读完，说明字节数组足够大
//		
//		int j = 1;
		/*
		 * i<buf.length吗，不是,i<bytes,因为你只读到了bytes个
		 */
//		for(int i = 0;i<bytes;i++){
//			if((buf[i] & 0xff) <= 0xf){
//				System.out.print("0");
//			}
//			System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
//			if(j++%10==0){
//				System.out.println();
//			}
//		}
//		in.close();
		
		/*
		 * 上面的写法，如果bytes数组不够大，有可能出现读不完的结果
		 * 可以对比一下下面的这个方法
		 */
		int bytes = 0;
		int j = 1;
		while((bytes = in.read(buf, 0, buf.length))!=-1){
			for(int i =0;i<bytes;i++){
				if((buf[i] & 0xff) <= 0xf){
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
				if (j++%10==0) {
					System.out.println();
				}
			}
		}
		in.close();
	}
}
