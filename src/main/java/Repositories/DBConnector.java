package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnector
{
    private static Connection connection;
    private static String driver;
    private static String url;
    private static String password;
    private static String user;
    private static Properties properties;
    private static boolean props=false;

    private static void initProperties() throws Exception
    {
        //properties= new Properties();
       // properties.load(new FileInputStream("bd.config"));
        driver="com.mysql.jdbc.Driver";//properties.getProperty("jdbc.driver");
        url="jdbc:mysql://localhost:3306/web";//properties.getProperty("jdbc.url");
        user="root";//properties.getProperty("jdbc.user");
        password="";//properties.getProperty("jdbc.password");
        props=true;
        
        Class.forName(driver);
    }
    private static Connection createConnection() throws Exception
    {
        if(props==false)
            initProperties();
        connection= DriverManager.getConnection(url,user,password);
        return connection;
    }

    public static Connection getConnection() throws Exception
    {
        if(connection==null)
        {
            return createConnection();
        }
        else
        {
            if(connection.isClosed())
                return createConnection();
        }
        return null;
    }
}
