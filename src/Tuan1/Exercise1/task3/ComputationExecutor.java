package Tuan1.Exercise1.task3;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ComputationExecutor {
    public static void main(String[] args) throws Exception {
        Callable<Long> call = new ComputationTask("long-last-computation");
        FutureTask<Long> task = new FutureTask<>(call);
        new Thread(task).start();
        Long result = task.get();
        System.out.println("Result: " + result);
    }
}
