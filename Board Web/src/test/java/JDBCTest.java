import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.fail;

@Log4j
public class JDBCTest {
    public static void main(String[] args) {
        Connection con = null;

        String server = "localhost"; // MySQL 서버 주소
        String database = "Spring"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo990881."; // MySQL 서버 비밀번호

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?serverTimezone=UTC&useSSL=FALSE&useUnicode=FALSE&characterEncoding=UTF-8", user_name, password);
            System.out.println("정상적으로 연결되었습니다.");
        } catch(SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
            e.printStackTrace();
        }

        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }
}
