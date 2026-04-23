public class GasEngine implements IEngine{
    private int speed = 0;

    @Override
    public void start() {
        speed = 0;
        System.out.println("Gas Engine Started.");
    }

    @Override
    public void stop() {
        speed = 0;
        System.out.println("Gas Engine Stopped.");
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println("Gas Engine Speed set to: " + speed + " km/h");
    }

    @Override
    public void increase() {
        speed += 1;
        System.out.println("Gas Engine Speed increased to: " + speed + " km/h");
    }

    @Override
    public void decrease() {
        speed -= 1;
        System.out.println("Gas Engine Speed decreased to: " + speed + " km/h");
    }
}
