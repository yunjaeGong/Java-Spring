import java.sql.*;


public class JDBCUtil {
    public static Connection getConnedtion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/?useSSL=false", "root", "dbswo990881");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(PreparedStatement pstmt, Connection conn) {
        if(pstmt != null) {
            try {
                if(!pstmt.isClosed()) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pstmt = null;
            }
        }

        if(conn != null) {
            try {
                if(!conn.isClosed()) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if(rs != null) {
            try {
                if (!rs.isClosed()) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }
        close(pstmt, conn);
    }
}
