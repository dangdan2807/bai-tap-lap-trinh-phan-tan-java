package lab2.codeCuaCo.bt1.exercise03;

import lab2.codeCuaCo.bt1.entity.State;

public class Exercise03 {
	public static void main(String[] args) {

		StateUtil util = new StateUtil();
		State state = util.findByAb("ar");
		if (state == null)
			System.out.println("Không tìm thấy");
		else
			System.out.println(state);

		util.close();
	}
}
