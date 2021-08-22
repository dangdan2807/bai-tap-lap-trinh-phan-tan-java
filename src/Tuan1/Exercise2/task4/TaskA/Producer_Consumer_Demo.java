package Tuan1.Exercise2.task4.TaskA;

public class Producer_Consumer_Demo {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        new Producer(q);
        new Consumer(q);
    }
}
