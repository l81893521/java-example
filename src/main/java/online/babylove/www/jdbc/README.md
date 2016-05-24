#简介
JDBC全称为Java Database Connectivity(java数据库连接)
可以为多种数据库提供统一访问(oracle,mysql,sql server等等)
##操作数据库基础
* JDBC编程步骤
	* 加载驱动程序:Class.forName(driveClass)
	* 加载Mysql驱动:Class.forName("com.mysql.jdbc.Driver")
	* 加载Oracle驱动:Class.forName("oracle.jdbc.driver.OracleDriver")
* 获取数据库连接
	* DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","root")
* 创建Statement对象
	* conn.createStatement()
##结构讲解

*[online.babylove.www.jdbc.model](https://github.com/l81893521/java-example/tree/master/src/main/java/online/babylove/www/jdbc/model)模型层

*`online.babylove.www.jdbc.util`工具包

*`online.babylove.www.jdbc.dao`数据持久层

*`online.babylove.www.jdbc.controller`控制层