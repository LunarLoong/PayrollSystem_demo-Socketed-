package sqlManagement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性工具类
 *
 */
public class PropertiesUtil {
    //属性列表
    private static Properties properties = new Properties();
    //配置文件的路径
    private static String CONFIG = "jdbc.properties";
    //读取资源文件, 设置输入流
    private static InputStream is = PropertiesUtil.class.getResourceAsStream(CONFIG);
    //数据库驱动
    public static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //jdbc连接url
    public static String JDBC_URL = "jdbc:mysql://localhost:3306/payroll?serverTimezone=GMT%2B8";
    //数据库用户名
    public static String JDBC_USER = "root";
    //数据库密码
    public static String JDBC_PASS = "123456";
    static {
        try {
            //加载输入流
            properties.load(is);
            //获得配置的各个属性
            JDBC_DRIVER = properties.getProperty("jdbc.driver");
            JDBC_URL = properties.getProperty("jdbc.url");
            JDBC_USER = properties.getProperty("jdbc.user");
            JDBC_PASS = properties.getProperty("jdbc.pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

