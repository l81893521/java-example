package online.babylove.www.io.demo1;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "联通";
		//转换成字节序列用的是项目默认的编码
		//也可以手动指定gbk
		byte bytes[] = s.getBytes("gbk");
		//gbk编码中文占用2个字节，英文占用1个字节
		for (byte b : bytes) {
			//把字节(转换成了int)以16进制的方式显示
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		
		System.out.println();
		
		byte bytes2[] = s.getBytes("utf-8");
		//utf-8编码中文占用3个字节，英文占用1个字节
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		
		System.out.println();
		
		//java是双字节编码 utf-16be
		byte byte3[] = s.getBytes("utf-16be");
		//utf-16be编码中文占用2个字节，英文占用2个字节
		for (byte b : byte3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		
		System.out.println();
		
		/*
		 * 当你的字节序列是某种编码时，这个时候想把字节序列变成字符串
		 * 也需要用这种编码方式，否则会出现乱码
		 */
		String str1 = new String(byte3);//用项目默认的编码，把byte3变成字符串(utf-16be),会出现乱码
		System.out.println(str1);
		String str2 = new String(byte3,"utf-16be");//用相同的编码方式，乱码解决了
		System.out.println(str2);
		
		/*
		 * 文本文件 放的就是字节序列
		 * 可以是任意编码的字节序列
		 * eclipse里面，什么样编码的项目就只认识这样编码的文字，你要换一种，它就不认识
		 */
	}
}
