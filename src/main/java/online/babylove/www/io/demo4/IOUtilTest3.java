package online.babylove.www.io.demo4;

import java.io.File;
import java.io.IOException;

import online.babylove.www.io.demo4.IOUtil;

public class IOUtilTest3 {
	public static void main(String[] args) {
		try {
			IOUtil.copyFile(new File("demo/out.dat"), new File("demo/out1.dat"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
