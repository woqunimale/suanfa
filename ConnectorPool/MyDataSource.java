package ConnectorPool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/bloghwt";
    private static String user = "root";
    private static String password = "123456";

    private static LinkedList<Connection> list = new LinkedList<Connection>();
    static{
        try {
            Class.forName(driver);
            for(int i = 0;i<10;i++ ){
                Connection conn = DriverManager.getConnection(url,user,password);
                list.add(conn);
            }
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(list.size() > 0){
          return  list.removeFirst();
        } else{
            throw new RuntimeException("系统忙");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }


    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
