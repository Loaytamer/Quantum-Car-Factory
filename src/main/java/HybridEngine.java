public class HybridEngine implements IEngine {
    private final GasEngine gasEngine = new GasEngine();
    private final ElectricEngine electricEngine = new ElectricEngine();
    private IEngine operatingEngine;
    private int speed = 0;

    @Override
    public void start() {
        operatingEngine = electricEngine;
        electricEngine.start();
        speed = 0;
        System.out.println("Hybrid Engine Started in Electric mode.");
    }

    private void switchToGas(int newSpeed) {
        electricEngine.stop();
        gasEngine.start();
        operatingEngine = gasEngine;
        System.out.println("Hybrid Engine Switched to Gas engine at " + newSpeed + " km/h");
    }

    private void switchToElectric(int newSpeed) {
        gasEngine.stop();
        electricEngine.start();
        operatingEngine = electricEngine;
        System.out.println("Hybrid Engine Switched to Electric engine at " + newSpeed + " km/h");
    }

    @Override
    public void setSpeed(int newSpeed) {
        if (newSpeed >= 50 && speed < 50) {
            switchToGas(newSpeed);
        } else if (newSpeed < 50 && speed >= 50) {
            switchToElectric(newSpeed);
        }
        speed = newSpeed;
        operatingEngine.setSpeed(speed);
    }

    @Override
    public void stop() {
        if (operatingEngine != null) {
            operatingEngine.stop();
        }
        speed = 0;
        System.out.println("Hybrid Engine Stopped.");
    }

    @Override
    public void increase() {
        int newSpeed = speed + 1;
        if (newSpeed >= 50 && speed < 50) {
            switchToGas(newSpeed);
        }
        speed = newSpeed;
        operatingEngine.increase();
    }

    @Override
    public void decrease() {
        int newSpeed = speed - 1;
        if (newSpeed < 50 && speed >= 50) {
            switchToElectric(newSpeed);
        }
        speed = newSpeed;
        operatingEngine.decrease();
    }
}
