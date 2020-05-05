import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO implements BoardService {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs;

    private final String BOARD_INSERT = "insert into board(seq, title, writer, content)" +
            " values((select nvl(max(seq), 0)+1 from board),?,?,?";
    private final String BOARD_UPDATE = "update board set title=?, content=?, where seq=?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_DELETE = "delete board where seq=?";
    private final String BOARD_LIST = "select * from board order by seq desc";

    // CRUD
    @Override
    public void insertBoard(BoardDTO dto) {
        System.out.println("==> JDBC로 insertBoard()기능 처리");
        try {
            conn = JDBCUtil.getConnedtion();
            pstmt = conn.prepareStatement(BOARD_INSERT);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getWriter());
            pstmt.setString(3, dto.getContent());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    @Override
    public void updateBoard(BoardDTO dto) {
        System.out.println("==> JDBC로 updateBoard()기능 처리");
        try {
            conn = JDBCUtil.getConnedtion();
            pstmt = conn.prepareStatement(BOARD_UPDATE);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getWriter());
            pstmt.setInt(3, dto.getSeq());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    @Override
    public void deleteBoard(BoardDTO dto) {
        System.out.println("==> JDBC로 deleteBoard()기능 처리");
        try {
            conn = JDBCUtil.getConnedtion();
            pstmt = conn.prepareStatement(BOARD_DELETE);
            pstmt.setInt(1, dto.getSeq());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    @Override
    public BoardDTO getBoard(BoardDTO dto) {
        System.out.println("==> JDBC로 getBoard()기능 처리");
        BoardDTO board = null;
        try {
            conn = JDBCUtil.getConnedtion();
            pstmt = conn.prepareStatement(BOARD_GET);
            pstmt.setInt(1, dto.getSeq());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                board = new BoardDTO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("Writer"));
                board.setContent(rs.getString("Content"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return board;
    }

    @Override
    public List<BoardDTO> getBoardList(BoardDTO dto) {
        System.out.println("==> JDBC로 getBoardList()기능 처리");
        List<BoardDTO> boardList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnedtion();
            pstmt = conn.prepareStatement(BOARD_LIST);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("Writer"));
                board.setContent(rs.getString("Content"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return boardList;
    }
}
