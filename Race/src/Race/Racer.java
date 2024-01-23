//Naim Moshe 315852269 & Ofir Biton 208582494
package Race;
public class Racer implements Runnable {
    private static int globalId = 1;
    private final int ID;
    private int speed;
    private final Track track;
    private static final Object lock = new Object();
    private static int globalPosition = 0;


    public Racer(int speed, Track track) {
        this.ID = globalId++;
        setSpeed(speed);
        this.track = track;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        try {
            if (speed >= 1 && speed <= 10) {
                this.speed = speed;
            } else
                throw new IllegalArgumentException("Invalid speed value, racer's " + ID + " speed value change to 1");
        } catch (IllegalArgumentException e) {
            this.speed = 1;
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        go();
    }

    private void go() {
        Thread.currentThread().setPriority(getSpeed());
        for (int i = 1; i <= 100; i++) {
            System.out.println("Runner " + ID + " ran " + i + " meters");
            if (i == 100) {
                printFinish();
            }
        }
    }

    private synchronized void printFinish() {
        int position = ++globalPosition;
        System.out.printf("Runner %d finished %d%s\n", ID, position, position == 1 ? "st" : position == 2 ? "nd" : position == 3 ? "rd" : "th");

    }
}
