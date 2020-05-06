package biz.board;

import java.util.List;

public interface BoardService {

    // CRUD
    // 글 등록
    void insertBoard(BoardDTO dto);
    // 글 수정
    void updateBoard(BoardDTO dto);

    // 글 삭제
    void deleteBoard(BoardDTO dto);

    // 글 상세 조회
    BoardDTO getBoard(BoardDTO dto);

    // 글 목록 조회
    List<BoardDTO> getBoardList(BoardDTO dto);
}
