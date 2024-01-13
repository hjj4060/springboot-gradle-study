package expert001_04;

public class Driver {
    public static void main(String[] args) {
        Tire tire = new KoreaTire();
        //Tire tire = new AmericaTire();

        Engine engine = new AmericaEngine();
        //Engine engine = new KoreaEngine();

        Car car = new Car(tire, engine);

        System.out.println(car.getTireBrand());
        System.out.println(car.getEndgineBrand());
    }
}