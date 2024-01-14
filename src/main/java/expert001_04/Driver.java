package expert001_04;

public class Driver {
    public static void main(String[] args) {
        CarFacade car = new CarFacade();

        System.out.println(car.getTireBrand());
        System.out.println(car.getEndgineBrand());
    }
}