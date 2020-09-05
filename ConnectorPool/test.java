package ConnectorPool;

import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        Connection conn = null;
        for(int i = 0 ; i < 10 ;i++) {
            conn = jdbcUtil.getConnection();
            System.out.println("第"+i+"个连接："+conn);
            jdbcUtil.release(conn,null,null);
        }
    }
}
