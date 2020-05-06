package biz;

import biz.user.UserDTO;
import biz.user.UserService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class UserServiceClient {
    public static void main(String[] args) {
        // Spring 컨테이너 구동
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        // Spring 컨테이너로부터 impl.BoardServiceImpl 객체 Lookup
        UserService boardService = (UserService) container.getBean("userService");

        // 글 등록 가능 테스트
        UserDTO dto = new UserService();
        dto.setId("test");
        dto.setPassword("test123");

        // 글 목록 검색 기능 테스트
        List<BoardDTO> boardDTOList = boardService.getBoardList(dto);
        for(BoardDTO board : boardDTOList) {
            System.out.println("---> " + board.toString());
        }

        // Spring 컨테이너 종료
        container.close();
    }
}
