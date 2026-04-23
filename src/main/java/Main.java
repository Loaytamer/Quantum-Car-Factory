public class Main {

    public static void main(String[] args) {

        
        System.out.println("=== 1. GAS CAR ===");
        Car gasCar = CarFactory.createCar(EngineType.GAS);
        gasCar.start();
        gasCar.accelerate();   // 0 -> 20
        gasCar.accelerate();   // 20 -> 40
        gasCar.accelerate();   // 40 -> 60
        gasCar.brake();        // 60 -> 40
        gasCar.brake();        // 40 -> 20
        gasCar.brake();        // 20 -> 0
        gasCar.stop();

        System.out.println("=== 2. ELECTRIC CAR ===");
        Car electricCar = CarFactory.createCar(EngineType.ELECTRIC);
        electricCar.start();
        electricCar.accelerate();  // 0 -> 20
        electricCar.accelerate();  // 20 -> 40
        electricCar.brake();       // 40 -> 20
        electricCar.brake();       // 20 -> 0
        electricCar.stop();

        System.out.println("=== 3. HYBRID CAR ===");
        Car hybridCar = CarFactory.createCar(EngineType.HYBRID);
        hybridCar.start();
        hybridCar.accelerate();  // 0  -> 20  (Electric)
        hybridCar.accelerate();  // 20 -> 40  (Electric)
        hybridCar.accelerate();  // 40 -> 60  (Switch to Gas)
        hybridCar.accelerate();  // 60 -> 80  (Gas)
        hybridCar.brake();       // 80 -> 60  (Gas)
        hybridCar.brake();       // 60 -> 40  (Switch to Electric)
        hybridCar.brake();       // 40 -> 20  (Electric)
        hybridCar.brake();       // 20 -> 0   (Electric)
        hybridCar.stop();

        
        System.out.println("=== 4. SAFETY CHECKS ===");
        Car safetyCar = CarFactory.createCar(EngineType.GAS);
        safetyCar.start();
        safetyCar.accelerate();     // 0 -> 20
        safetyCar.stop();           // Refused — speed is 20
        safetyCar.brake();          // 20 -> 0
        safetyCar.stop();           // Allowed

        System.out.println("=== 5. MAX SPEED TEST ===");
        Car fastCar = CarFactory.createCar(EngineType.GAS);
        fastCar.start();
        for (int i = 0; i < 12; i++) fastCar.accelerate();
        System.out.println("Car Final speed: " + fastCar.getSpeed() + " km/h");

        System.out.println("=== 6. ENGINE REPLACEMENT ===");
        Car swapCar = CarFactory.createCar(EngineType.GAS);
        swapCar.start();
        swapCar.accelerate();
        swapCar.brake();
        swapCar.stop();
        CarFactory.installEngine(swapCar, EngineType.HYBRID);
        swapCar.start();
        swapCar.accelerate();  // 0  -> 20 (Electric)
        swapCar.accelerate();  // 20 -> 40 (Electric)
        swapCar.accelerate();  // 40 -> 60 (Switch -> Gas)
        swapCar.brake();       // 60 -> 40 (Switch -> Electric)
        swapCar.brake();       // 40 -> 20
        swapCar.brake();       // 20 -> 0
        swapCar.stop();
    }

}