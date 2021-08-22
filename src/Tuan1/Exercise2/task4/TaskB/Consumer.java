package Tuan1.Exercise2.task4.TaskB;

public class Consumer implements Runnable {
    MyQueue q;

    Consumer(MyQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }

}
