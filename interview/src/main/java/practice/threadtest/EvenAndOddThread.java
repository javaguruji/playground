package practice.threadtest;

/**
 * @author badrikant.soni
 */
public class EvenAndOddThread {

    private static Object object = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 21; i+= 2) {
                    synchronized (object) {  // thread will take object lock and enter
                        System.out.println("[Odd] : " + i);
                        try {
                            object.wait();
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        object.notify();
                    } // same thread will release object lock
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i < 21; i+= 2) {
                    synchronized (object) {  // thread will take object lock and enter
                        System.out.println("[Even] : " + i);
                        object.notify();
                        try {
                            object.wait();
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } // same thread will release object lock
                }
            }
        }).start();
    }

}
