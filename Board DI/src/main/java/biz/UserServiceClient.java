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
        UserService userService = (UserService) container.getBean("userService");

        // 글 등록 가능 테스트
        UserDTO dto = new UserDTO();
        /*dto.setId("test");
        dto.setPassword("test123");*/
        dto.setId("user1");
        dto.setPassword("user1");

        UserDTO user = userService.getUser(dto);
        if(user != null)
            System.out.println(user.getName() + "님 환영합니다.");
        else
            System.out.println("로그인 실패");

        // Spring 컨테이너 종료
        container.close();
    }
}
