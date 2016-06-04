#反射

##Class类的使用
* 在java的世界里，万事万物皆对象， 在java语言中，静态的成员，普通数据类型是不是对象呢？
* 类是谁的对象呢？类是java.lang.Class类的实例对象 [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/reflection/demo1/ClassDemo1.java)
* Class.forName("类的全称")
	* 不仅仅代表了类的类类型，还代表了动态加载类
	* 请大家区分编译，运行
	* 编译时刻加载类是静态加载类，运行时刻加载类是动态加载类
* 基本的数据类型
	* int,double,float等，甚至void关键字 都存在类类型 [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/reflection/demo2/ClassDemo2.java)
* Class类的基本API操作
	* 查看类的方法
	* 查看类的成员变量 
	* 查看类的构造方法
	* [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/reflection/demo3/ClassUtil.java)
	* [运行入口](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/reflection/demo3/ClassDemo3.java)

* 方法的反射
	* 如何获取某个方法，方法的名称和方法的参数列表才能唯一决定某个方法
	* 方法的反射操作method.invoke(对象，参数列表)
	* [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/reflection/demo4/MethodDemo1.java)
	
* 通过反射了解集合泛型的本质
	* 通过Class, Method来认识泛型的本质
	* int类型的值，加入到ArrayList<String>集合当中,是否可行?
	* [查看代码](https://github.com/l81893521/java-example/blob/master/src/main/java/online/babylove/www/reflection/demo5/MethodDemo2.java)
	