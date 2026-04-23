public class CarFactory {

    public static Car createCar(EngineType type) {
        Car car = new Car();
        installEngine(car, type);
        return car;
    }

    private static IEngine createEngine(EngineType type) {
        return switch (type) {
            case GAS      -> new GasEngine();
            case ELECTRIC -> new ElectricEngine();
            case HYBRID   -> new HybridEngine();
        };
    }

    public static void installEngine(Car car, EngineType type) {
        car.setEngine(createEngine(type));
        System.out.println("CarFactory Installed: " + type + " engine.");
    }
}