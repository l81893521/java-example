package online.babylove.www.io.demo4;

import java.io.IOException;

public class IOUtilTest2 {
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			IOUtil.printHexByByteArray("src/main/java/online/babylove/www/io/demo4/IOUtilTest1.java");
			long end = System.currentTimeMillis();
			System.out.println("消耗时间(毫秒):" + (end - start));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
