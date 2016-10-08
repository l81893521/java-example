package online.babylove.www.io.demo4;

import java.io.File;
import java.io.IOException;

import online.babylove.www.io.demo4.IOUtil;

public class IOUtilTest3 {
	public static void main(String[] args) {
		try {
			IOUtil.copyFile(new File("demo/srcCopyDemo.dat"), new File("demo/srcCopyDemo1.dat"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
