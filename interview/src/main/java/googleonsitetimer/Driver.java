package googleonsitetimer;

public class Driver extends AbstractMySystem {

    @Override
    public void setTimer(long durationMillis, Runnable callback) {

    }

    @Override
    public long getCurrentTimeMillis() {
        return 0;
    }

    public static void main(String[] args) throws InterruptedException {

        Driver sys = new Driver();
        sys.addTimer(100, new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("runnable 1");
            }
        }));
        Thread.sleep(50);
        sys.addTimer(100, new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.printf("runnable 2");
            }
        }));

    }
}
