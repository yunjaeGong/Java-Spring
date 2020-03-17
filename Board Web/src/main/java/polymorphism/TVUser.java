package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        /*// 1. polymorphism
        //TV tv = new SamsungTV();
        // 클라이언트 프로그램이 여려 개 있더라도, 최소한의 수정으로 TV를 교체할수 있다.
        // 2. Pattern 이용
        BeanFactory factory = new BeanFactory();
        TV tv = (TV)factory.getBean(args[0]);
        tv.powerOn();
        tv.powerOff();
        tv.volumeUp();
        tv.volumeDown();*/

        // spring container에 의한 객체생성
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("applicationContext.xml");
        // applicationContext를 참조해 GenericXmlApplicationContext 컨테이너 구동

        // 2. container로부터 필요한 객체를 요청한다.
        // -> applicationContext에 bean 객체 등록하면 명시적 생성 필요 x
        TV tv = (TV)factory.getBean("tv");
        // applicationContext의 id tv 호출
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();

        // Scope
        // 2. 스프링 컨테이너로부터 필요한 객체 요청
        TV tv1 = (TV)factory.getBean("tv");
        TV tv2 = (TV)factory.getBean("tv");
        TV tv3 = (TV)factory.getBean("tv");
        // scope="singleton" -> 하나의 객체만 생성돼 유지된다
        // scope="prototype" -> 매 번 새로운 객체를 생성해 반환한다
        // 3. Spring container를 종료한다.
        factory.close();
    }
}
