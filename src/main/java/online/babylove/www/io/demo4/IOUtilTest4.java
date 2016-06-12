package online.babylove.www.io.demo4;

import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {
	public static void main(String[] args) {
		try {
			IOUtil.copyFileByBuffer(new File("demo/srcCopyDemo.dat"), new File("demo/out2.dat"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
