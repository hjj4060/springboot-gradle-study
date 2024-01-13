package expert001_04;

public class Car {
    Tire tire;
    Engine engine;

    public Car(Tire tire, Engine engine) {
        this.tire = tire;
        this.engine = engine;
    }

    public String getTireBrand() {
        return "장착된 타이어: " + tire.getBrand();
    }

    public String getEndgineBrand() {
        return "장착된 엔진: " + engine.getBrand();
    }
}
