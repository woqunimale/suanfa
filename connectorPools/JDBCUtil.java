package connectorPools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
   public static myDataSource my = new myDataSource();

    public static Connection getConnection(){
        try {
            return my.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void release(Connection conn, Statement state, ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn  = null;
            }
        }
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                state  = null;
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                rs  = null;
            }
        }
    }
}
