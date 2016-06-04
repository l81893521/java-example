package online.babylove.www.io.demo2;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] args) {
		/*
		 * 了解构造函数的基本情况
		 * 使用双斜杠，或者反斜杠
		 * File file = new File("E:\\usr\\local\\io-test");
		 * File file = new File("E:/usr/local/io-test");
		 * 或者使用File.separator,这样无论什么系统，都能正确获取分隔符
		 * File file = new File(File.separator + "usr" + File.separator + "local" + File.separator + "io-test");
		 */
		
		File file = new File("/usr/local/io-test");
		//查看文件(目录)是否存在
//		System.out.println(file.exists());
		if(!file.exists()){
			//如果多级目录
			//file.mkdirs();
			//创建文件(目录)
			file.mkdir();
		}else{
			//删除文件(目录)
			file.delete();
		}
		
		//是否是一个目录 如果是目录返回true,如果不是目录or目录不存在返回的是false
		System.out.println(file.isDirectory());
		//是否是一个文件
		System.out.println(file.isFile());
		
//		File file2 = new File("/usr/local/1.txt");
		File file2 = new File("/usr/local", "1.txt");
		if(!file2.exists()){
			try {
				//创建文件
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			file2.delete();
		}
		
		//常用的file对象api
		System.out.println(file);//file.toString()的内容
		System.out.println(file.getAbsolutePath());//绝对路径
		System.out.println(file.getName());//最后一个目录名
		System.out.println(file2.getName());//文件名
		System.out.println(file.getParent());//父目录的路径
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());//获取父目录对象(再打印绝对路径)
		System.out.println(file2.getParentFile().getAbsolutePath());
	}
}
