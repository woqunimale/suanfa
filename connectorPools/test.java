package connectorPools;

import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getConnection();
        for(int i = 0;i<10;i++){
            System.out.println("这是第："+i+"个连接："+conn);
            JDBCUtil.release(conn,null,null);
        }
    }
}
