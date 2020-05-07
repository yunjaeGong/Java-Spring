package biz.user.impl;

import biz.JDBCUtil;
import biz.user.UserDTO;
import biz.user.UserService;

import java.sql.*;

public class UserDAO implements UserService {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private final String USER_GET = "select * from users where ID=? and PASSWORD=?";

    @Override
    public UserDTO getUser(UserDTO dto) {
        UserDTO user = null;
        try {
            System.out.println("===> JDBC로 getUser() 기능 처리");
            conn = JDBCUtil.getConnedtion();
            pstmt = conn.prepareStatement(USER_GET);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPassword());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                user = new UserDTO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
        return user;
    }
}
