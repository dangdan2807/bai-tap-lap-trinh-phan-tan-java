package lab1.exercise1;

import java.util.List;
import java.util.Random;

public class AddNumberTask implements Runnable{
	
	private List<Integer> list;
	private int m;
	

	/**
	 * @param list
	 * @param m
	 */
	public AddNumberTask(List<Integer> list, int m) {
		this.list = list;
		this.m = m;
	}


	public void run() {
		Random random = new Random();
		for (int i = 0; i < m; i++) {
			int x = random.nextInt(10000);
			list.add(x);
		}
	}

}
