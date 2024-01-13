package expert002;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("expert002/expert002.xml");

    @Test
    public void 자동차_코리아타이어_장착_타이어브랜드_테스트() {
        Tire tire1 = (Tire)context.getBean("tire");
        Car car1 = (Car)context.getBean("car");

        car1.setTire(tire1);

        Assertions.assertEquals("장착된 타이어: 코리아 타이어", car1.getTireBrand());
    }

    @Test
    public void 자동차_미국타이어_장착_타이어브랜드_테스트() {
        Tire tire1 = (Tire)context.getBean("americaTire");
        Car car1 = (Car)context.getBean("car");

        car1.setTire(tire1);

        Assertions.assertEquals("장착된 타이어: 미국 타이어", car1.getTireBrand());
    }
}
