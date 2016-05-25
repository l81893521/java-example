#简介
JDBC全称为Java Database Connectivity(java数据库连接)
可以为多种数据库提供统一访问(oracle,mysql,sql server等等)

##结构讲解

* [online.babylove.www.jdbc.model](https://github.com/l81893521/java-example/tree/master/src/main/java/online/babylove/www/jdbc/model)模型层
* [online.babylove.www.jdbc.view](https://github.com/l81893521/java-example/tree/master/src/main/java/online/babylove/www/jdbc/view)视图层
* [online.babylove.www.jdbc.controller](https://github.com/l81893521/java-example/tree/master/src/main/java/online/babylove/www/jdbc/controller)控制层
* [online.babylove.www.jdbc.dao](https://github.com/l81893521/java-example/tree/master/src/main/java/online/babylove/www/jdbc/dao)数据持久层
* [online.babylove.www.jdbc.dao.proc](https://github.com/l81893521/java-example/tree/master/src/main/java/online/babylove/www/jdbc/dao/proc)持久层存放调用存储过程代码
* [online.babylove.www.jdbc.util](https://github.com/l81893521/java-example/tree/master/src/main/java/online/babylove/www/jdbc/util)工具包

##资源文件

* [建表sql](https://github.com/l81893521/java-example/tree/master/src/main/resources/jdbc/table)
* [建存储过程sql](https://github.com/l81893521/java-example/tree/master/src/main/resources/jdbc/table)



##操作数据库基础
* JDBC编程步骤
	* 加载驱动程序:Class.forName(driveClass)
	* 加载Mysql驱动:Class.forName("com.mysql.jdbc.Driver")
	* 加载Oracle驱动:Class.forName("oracle.jdbc.driver.OracleDriver")
* 获取数据库连接
	* DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","root")
* 创建Statement对象
	* conn.createStatement()
	
##主要操作对象
###`java.sql.Connection`
* java.sql.Connection是表示当前连接的数据库的对象。
* Connection默认是自动提交的

###'java.sql.Statement'
* 这个对象主要用于执行sql语句和获取返回结果

###'java.sql.PreparedStatement'
* 这个对象它会对sql进行预编译，并且保存在java.sql.PreparedStatement(自身)中,这个对象可以使你的sql执行效率大大提高
* 建议使用PreparedStatement来代替Statement

###'java.sql.ResultSet'
* 数据库结果集的数据表，通过执行查询语句后而生成
* 通过调用next方法来移动它的指针，如果返回false，则代表指针已经到达最后一行数据的后面。