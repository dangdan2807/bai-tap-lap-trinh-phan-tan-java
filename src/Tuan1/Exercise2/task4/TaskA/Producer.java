package Tuan1.Exercise2.task4.TaskA;

public class Producer implements Runnable {
    MyQueue q;

    Producer(MyQueue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}
