package Tuan1.Exercise2.task4.TaskA;

public class Consumer implements Runnable {
    MyQueue q;

    Consumer(MyQueue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }

}
