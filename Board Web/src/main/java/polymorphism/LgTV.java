package polymorphism;

public class LgTV implements TV{
    // 인터페이스 이용으로 결합성을 낮출 수 있다
    // - 유지보수 용이
    public void powerOn() {
        System.out.println("LgTV--전원 켠다.");
    }
    public void powerOff() {
        System.out.println("LgTV--전원 끈다.");
    }
    public void volumeUp() {
        System.out.println("LgTV--소리 올린다.");
    }
    public void volumeDown() {
        System.out.println("LgTV--소리 내린다.");
    }
}
