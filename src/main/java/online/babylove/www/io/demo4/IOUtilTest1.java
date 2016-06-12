package online.babylove.www.io.demo4;

import java.io.IOException;

public class IOUtilTest1 {
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			IOUtil.printHex("src/main/java/online/babylove/www/io/demo4/IOUtil.java");
			long end = System.currentTimeMillis();
			System.out.println("消耗时间(毫秒):" + (end - start));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
