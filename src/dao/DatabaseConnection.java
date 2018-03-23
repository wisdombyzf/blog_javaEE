package dao;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 由于开发之中业务层要调用数据层，所以数据库的打开与关闭交由业务层处理
 * 所以返回 Connection
 */
public class DatabaseConnection
{
    //声明Connection对象
    private static Connection con;
    //驱动程序名
    private static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    private static String url = "jdbc:mysql://localhost:3306/zf";
    //MySQL配置时的用户名
    private static String user = "root";
    //MySQL配置时的密码
    private static String password = "123456";
    private static Statement statement = null;

    public DatabaseConnection()
    {
        //加载驱动程序
        try
        {
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e1)
        {
            e1.printStackTrace();
        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        return con;
    }
}
