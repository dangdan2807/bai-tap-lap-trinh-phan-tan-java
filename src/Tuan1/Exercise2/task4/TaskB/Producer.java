package Tuan1.Exercise2.task4.TaskB;

public class Producer implements Runnable {
    MyQueue q;

    Producer(MyQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}
