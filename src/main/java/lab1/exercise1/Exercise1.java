package lab1.exercise1;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Collection Framework
//List, Set, Queue, Map ...
//List : ArrayList, Vector, LinkedList...


public class Exercise1 {
	
//	private static List<Integer> list = new ArrayList<>();
	private static List<Integer> list = new Vector<Integer>();
//	private static List<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) {
		int n = 10;
		int m = 1000;
		Runnable task = new AddNumberTask(list, m);
		ExecutorService service = Executors.newFixedThreadPool(n);
		for (int i = 0; i < n; i++) {
			service.submit(task);
		}
		
		service.shutdown();
		while(!service.isTerminated()) {}
		System.out.println("Size: " + list.size()); //size: 10000
	}
}
