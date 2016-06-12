package online.babylove.www.io.demo4;

import java.io.File;
import java.io.IOException;

public class IOUtilTest5 {
	
	public static void main(String[] args) {
		/*
		 * 文件大小，约7.7MB
		 */
		String file = "demo/QQMusic3.1.1Build02.dmg";
		/*
		 * 测试机器
		 * 15寸 MacBook pro
		 * 2.2GHz 四核 Intel Core i7 处理器
		 * 16GB 1600MHz 内存
		 * 256GB 闪存
		 */
		
		try {
			long start = System.currentTimeMillis();
			/*
			 * 单字节拷贝
			 * 耗时：16517毫秒
			 */
//			IOUtil.copyFileByByte(new File(file), new File("demo/QQMusic3.1.1Build02-1.dmg"));
			/*
			 * 使用缓冲区拷贝
			 * 耗时:11444毫秒
			 */
//			IOUtil.copyFileByBuffer(new File(file), new File("demo/QQMusic3.1.1Build02-2.dmg"));
			/*
			 * 开辟内存，批量字节拷贝
			 * 耗时:7毫秒
			 */
			IOUtil.copyFile(new File(file), new File("demo/QQMusic3.1.1Build02-3.dmg"));
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
