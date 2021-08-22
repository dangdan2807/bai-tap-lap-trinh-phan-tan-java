package Tuan1.Exercise2.task1;

public class TestJoinThread {
    public static void main(String[] args) throws Exception{
        new Thread(new YourTask()).start();
    }
}
