package algCommon;

//求排列数组合数
public class 排列组合个数 {
	// 求排列数 A(n,m) n>m
	public static int A(int n, int m) {
		int result = 1;
		// 循环m次,如A(6,2)需要循环2次，6*5
		for (int i = 0; i < m; i++) {
			result *= n;
			n--;// 下一次减一
		}
		return result;
	}

	// 求组合数，这个也不需要了。定义式，不使用互补率
	public static int C2(int n, int m) {
		// int denominator=factorial(up);//分母up的阶乘
		// 分母
		int denominator = A(m, m);// A(6,6)就是求6*5*4*3*2*1,也就是求6的阶乘
		// 分子
		int numerator = A(n, m);// 分子的排列数
		return numerator / denominator;
	}

	// 直接结算组合数
	// 从 n 个数中取出 m 个数。
	public static int uniquePaths(int n, int m) {
		long res = 1;
		for (int i = 1; i <= m; i++)
			res = res * (n - m + i) / i;
		return (int) res;
	}

	public static int C(int n, int m)// 应用组合数的互补率简化计算量
	{
		int helf = n / 2;
		if (m > helf) {
			System.out.print(m + "---->");
			m = n - m;
			System.out.print(m + "\n");
		}
		// 分子的排列数
		int numerator = A(n, m);
		// 分母的排列数
		int denominator = A(m, m);
		return numerator / denominator;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 6; i++) {
			System.out.println("A(6," + i + ")=" + A(6, i));
		}
		for (int i = 1; i <= 6; i++) {
			System.out.println("C(6," + i + ")=" + C(6, i));
			System.out.println("C(6," + i + ")=" + uniquePaths(6, i));
		}
		System.out.println("C(6,5)=" + C(6, 5));// 6
	}

}