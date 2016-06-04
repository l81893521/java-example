package online.babylove.www.io.demo2;

import java.io.File;
import java.io.IOException;

public class FileUtilTest {
	public static void main(String[] args) throws IOException {
		FileUtils.listDirectory(new File("/usr/local/apache-tomcat-7.0.67"));
	}
}
