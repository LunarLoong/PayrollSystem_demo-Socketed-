package sqlManagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * SQL执行类
 * 使用本项目配置的cfg目录下jdbc.properties进行数据库访问，
 * 但是大家注意到，这个方式只是建立了一个数据库连接进行数据库访问
 */
public class JDBCExecutor {
    //获得驱动
    private static String DRIVER = PropertiesUtil.JDBC_DRIVER;
//    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    //获得url
    private static String URL = PropertiesUtil.JDBC_URL;
//    private static String URL = "jdbc:mysql://localhost:3306?serverTimezone=UTC";

    //获得连接数据库的用户名
    private static String USER = PropertiesUtil.JDBC_USER;
//    private static String USER = "root";

    //获得连接数据库的密码
    private static String PASS = PropertiesUtil.JDBC_PASS;
//    private static String PASS = "123456";

    //连接对象
    private Connection connection;
    //维护一个本类型的对象
    private static JDBCExecutor jdbcExecutor;
    //Statement对象,可以执行SQL语句并返回结果
    private Statement stmt;

    //私有构造器
    private JDBCExecutor() {
        try {
            //初始化JDBC驱动并让驱动加载到jvm中
            Class.forName(DRIVER);
            //创建数据库连接
            connection = DriverManager.getConnection(URL, USER, PASS);
            //创建Statement对象
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //提供一个静态方法返回本类的实例
    public static JDBCExecutor getJDBCExecutor() {
        //如果本类所维护jdbcExecutor属性为空,则调用私有的构造器获得实例
        if (jdbcExecutor == null) {
            jdbcExecutor = new JDBCExecutor();
        }
        return jdbcExecutor;
    }

    /*
     * 执行一句查询的sql
     */
    public ResultSet executeQuery(String sql) {
        ResultSet result = null;
        try {
            //利用Statement对象执行参数的sql
            result = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }

    }

    //执行单句INSERT、UPDATE 或 DELETE 语句, 如果执行INSERT时, 返回主键
    public int executeUpdate(String sql) {
        int result = -1;
        try {
            //执行SQL语句
            stmt.executeUpdate(sql);
            //获得主键
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                //返回最后一个主键
                result = rs.getInt(1);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

}
