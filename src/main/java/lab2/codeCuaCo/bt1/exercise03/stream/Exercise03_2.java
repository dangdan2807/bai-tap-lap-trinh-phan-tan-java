package lab2.codeCuaCo.bt1.exercise03.stream;

public class Exercise03_2 {
	public static void main(String[] args) {
		
		StateUtil_2 util = new StateUtil_2();
		
		util.findByYear(1890)
		.forEach(st -> System.out.println(st));
		
		util.close();
	}
}
