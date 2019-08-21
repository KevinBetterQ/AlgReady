package algCommon;

public class 数字操作 {

	public static void main(String[] args) {
		
		// 取整，但是还是尽量使用 % 和 / 就可以了
		double a = 30;
		double b = 20;
		double c = a / b;
		System.out.println("c===>" + c); // 1.5
		System.out.println("c===>" + Math.ceil(c)); // 2.0
		System.out.println(Math.floor(c)); // 1.0
		

	}

}
