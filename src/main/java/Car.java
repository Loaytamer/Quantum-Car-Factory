public class Car {

    private IEngine engine;
    private int speed = 0;
    private boolean started = false;

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public IEngine getEngine() {
        return engine;
    }

    public void start() {
        if (started) {
            System.out.println("Car Already started.");
            return;
        }
        speed = 0;
        engine.start();
        started = true;
        System.out.println("Car Started at 0 km/h.");
    }

    public void stop() {
        if (!started) {
            System.out.println("Car Already stopped.");
            return;
        }
        if (speed != 0) {
            System.out.println("Car Cannot stop while moving (" + speed + " km/h). Brake to 0 first.");
            return;
        }
        engine.stop();
        started = false;
        System.out.println("Car Stopped.");
    }

    public void accelerate() {
        if (!started) {
            System.out.println("Car is not started so it cannot accelerate.");
            return;
        }
        if (speed < 200) {
            speed += 20;
            engine.setSpeed(speed);
            System.out.println("Car Accelerated to: " + speed + " km/h");
        } else {
            System.out.println("Car Already at max speed (200 km/h).");
        }
    }

    public void brake() {
        if (!started) {
            System.out.println("Car is not started so it cannot brake.");
            return;
        }
        if (speed > 0) {
            speed -= 20;
            engine.setSpeed(speed);
            System.out.println("Car Braked to: " + speed + " km/h");
        } else {
            System.out.println("Car Already at 0 km/h.");
        }
    }

    public int getSpeed() {
        return speed;
    }
}