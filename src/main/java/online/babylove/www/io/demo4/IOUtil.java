package online.babylove.www.io.demo4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
	
	/**
	 * 文件拷贝
	 * 开辟内存，批量字节读取
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		
		byte[] buf = new byte[1024];
		int b;
		//把内容读到buf字节数组
		in.read(buf, 0, buf.length);
		while((b=in.read(buf,0,buf.length))!=-1){
			//把字节数组写入到destFile
			out.write(buf, 0, b);
			out.flush();
		}
		in.close();
		out.close();
	}
	
	/**
	 * 文件拷贝
	 * 利用带缓冲的字节流
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException{
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		
		int c;
		while((c=bis.read())!=-1){
			bos.write(c);
			//刷新缓冲区,否则它写入不到文件里面去
			bos.flush();
		}
		bis.close();
		bos.close();
		
	}
	
	/**
	 * 文件拷贝
	 * 单字节不带缓冲进行文件拷贝
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByByte(File srcFile, File destFile) throws IOException{
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件:"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		
		int c;
		while((c=in.read())!=-1){
			out.write(c);
			//不flush()也没问题，但是最好写上，如果带缓冲的必须flush
			out.flush();
		}
		
		in.close();
		out.close();
	}
}
