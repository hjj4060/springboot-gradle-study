package expert002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("expert002/expert002.xml");

        Tire tire = (Tire)context.getBean("tire");
        Car car = (Car)context.getBean("car");

        car.setTire(tire);

        System.out.println(car.getTireBrand());
    }
}