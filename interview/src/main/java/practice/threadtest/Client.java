package practice.threadtest;

/**
 * @author badrikant.soni
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {

        PC pc = new PC(2);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int value = 0;
                while(true){
                    try {
                        pc.produce(value);
                        System.out.println("[Produced] : " + value);
                        value++;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        int value = pc.consume();
                        System.out.println("[Consumed] : " + value);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();

    }
}
