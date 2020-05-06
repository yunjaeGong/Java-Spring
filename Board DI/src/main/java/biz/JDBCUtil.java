package biz;

import java.sql.*;


public class JDBCUtil {
    static String server = "localhost"; // MySQL 서버 주소
    static String database = "Spring"; // MySQL DATABASE 이름
    static String user_name = "root"; //  MySQL 서버 아이디
    static String password = "dbswo990881."; // MySQL 서버 비밀번호

    public static Connection getConnedtion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?serverTimezone=UTC&useSSL=FALSE&useUnicode=FALSE&characterEncoding=UTF-8", user_name, password);
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
