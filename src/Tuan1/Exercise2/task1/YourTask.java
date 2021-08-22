package Tuan1.Exercise2.task1;

public class YourTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread t = new Thread(new AnotherTask("AnotherTask", 10));
            t.start();
            for (int i = 0; i < 8; i++) {
                System.out.println("Your Task #" + i);
                if (i == 5) {
                    t.join();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
