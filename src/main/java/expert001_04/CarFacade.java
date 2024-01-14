package expert001_04;

public class CarFacade {
    Tire tire;
    Engine engine;

    public CarFacade() {
        this.tire = new AmericaTire();
        this.engine = new KoreaEngine();
    }

    public String getTireBrand() {
        return "장착된 타이어: " + tire.getBrand();
    }

    public String getEndgineBrand() {
        return "장착된 엔진: " + engine.getBrand();
    }
}
