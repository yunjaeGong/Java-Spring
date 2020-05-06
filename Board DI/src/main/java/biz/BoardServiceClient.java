package biz;

import biz.board.BoardDTO;
import biz.board.BoardService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        // Spring 컨테이너 구동
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        // Spring 컨테이너로부터 impl.BoardServiceImpl 객체 Lookup
        BoardService boardService = (BoardService) container.getBean("boardService");

        // 글 등록 가능 테스트
        BoardDTO dto = new BoardDTO();
        dto.setTitle("임시 제목");
        dto.setWriter("공윤재");
        dto.setContent("---------임시 내용---------");
        boardService.insertBoard(dto);

        // 글 목록 검색 기능 테스트
        List<BoardDTO> boardDTOList = boardService.getBoardList(dto);
        for(BoardDTO board : boardDTOList) {
            System.out.println("---> " + board.toString());
        }

        // Spring 컨테이너 종료
        container.close();
    }
}
