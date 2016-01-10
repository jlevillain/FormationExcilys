=======
FormationExcilys
================

1 - Create a new eclipse dynamic web project named "computer-database" and paste the files in it

2 - Setup a SQL server and execute SQL scripts 1 and 2

3 - Start coding

4 - Software needed

	- Apache Tomcat 8.0
	- Apache Maven 3.3
	- Mysql Server 5.7
	- Mysql Connnector Java 5.1
	- Java JDK 1.7
	
5 - JNDI Tomcat configuration

	Add in tomcat conf/context.xml
	
	```
	<Resource name="jdbc/BoneCpPool"
          type="com.jolbox.bonecp.BoneCPDataSource"
          auth="Container"
          factory="org.apache.naming.factory.BeanFactory"
          username="root"
          password="root"
          driverClass="com.mysql.jdbc.Driver"
          jdbcUrl="jdbc:mysql://localhost:3306/computer-database-db"
          partitionCount="1"
           />
	```