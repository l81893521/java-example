#IO
* 在硬盘上的文件是byte byte byte存储的，是数据的集合

##编码的问题
* 编码是什么？
* 乱码是怎么样形成的？
* [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo1/EncodeDemo.java)

##File类常用API介绍
* java.io.File类用于表示文件(目录)
* File类只能用于文件(目录)的信息(名称，大小等)，不用用于文件内容的访问
* [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo2/FileDemo.java)

##遍历目录
* [运行入口](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo2/FileUtilTest.java)
* [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo2/FileUtils.java)

##RandomAccessFile
* Java提供的对文件内容的访问，既可以读文件，也可以写文件
* 支持随机访问文件，可以访问文件的任意位置
* [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo3/RafDemo.java)

#FileInputStream(字节流)
* FileInputStream继承了InputStream并实现了在文件上按字节读取数据,
* [读取指定文件内容，按照16进制输出到控制台,运行入口(单字节读取)](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/IOUtilTest1.java)
* [读取指定文件内容，按照16进制输出到控制台,运行入口(批量字节读取)](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/IOUtilTest2.java)

#FileOutputStream(字节流)
* FileOutputStream继承了OutputStream并实现了向文件写出byte数据的方法
* [FileOutputStream demo](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/FileOutputStreamDemo1.java)
* [文件复制demo运行入口](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/IOUtilTest3.java)

#DataInputStream/DataOutputStream
* 这组类，是对"流"功能的扩展，可以更加方便的读取int,long,字符等类型数据
* DataOutputStream会有一些更加方便的方法，如writeInt()/writeDouble()/writeUTF()等
* DataInputStream同理
* [DataOutputStream demo](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/DataOutputStreamDemo1.java)
* [DataInputStream demo](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/DataInputStreamDemo1.java)

#BufferedInputStream/BufferedOutputStream
* 这两个"流"类为IO提供了带缓冲区的操作，一般打开文件进行写入或读取操作时，都会加上缓冲，这种流模式提高了IO的性能
* 从应用程序中把输入放入文件，相当于将一缸水倒入到另一个缸中
	* FileOutputStream--->write()方法相当于一滴一滴地把水"转移"过去
	* DataOutputStream--->writeXxx()方法会方便一些，相当于一勺一勺把水"转义"过去(其实效率没变)
	* BufferedOutputStream--->writeXxx()方法更方便，相当于一勺一勺先把水放入到桶中(缓冲区),再从桶倒入到另一个缸中(性能提高了)
* [利用缓冲区文件复制demo运行入口](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/IOUtilTest4.java)

#效率测试
* [IOUtil.java](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/IOUtilTest4.java)内有3个复制文件方法，分别是copyFile(),copyFileByBuffer(),copyFileByByte()
* copyFile()的实现方式是使用开辟内存，批量字节读写
* copyFileByBuffer()的实现方式是使用缓冲区读写
* copyFileByByte的实现方式是单字节读写
* [测试入口](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/io/demo4/IOUtilTest5.java)