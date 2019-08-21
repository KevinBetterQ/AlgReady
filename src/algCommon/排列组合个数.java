package algCommon;

//�������������
public class ������ϸ��� {
	// �������� A(n,m) n>m
	public static int A(int n, int m) {
		int result = 1;
		// ѭ��m��,��A(6,2)��Ҫѭ��2�Σ�6*5
		for (int i = 0; i < m; i++) {
			result *= n;
			n--;// ��һ�μ�һ
		}
		return result;
	}

	// ������������Ҳ����Ҫ�ˡ�����ʽ����ʹ�û�����
	public static int C2(int n, int m) {
		// int denominator=factorial(up);//��ĸup�Ľ׳�
		// ��ĸ
		int denominator = A(m, m);// A(6,6)������6*5*4*3*2*1,Ҳ������6�Ľ׳�
		// ����
		int numerator = A(n, m);// ���ӵ�������
		return numerator / denominator;
	}

	// ֱ�ӽ��������
	// �� n ������ȡ�� m ������
	public static int uniquePaths(int n, int m) {
		long res = 1;
		for (int i = 1; i <= m; i++)
			res = res * (n - m + i) / i;
		return (int) res;
	}

	public static int C(int n, int m)// Ӧ��������Ļ����ʼ򻯼�����
	{
		int helf = n / 2;
		if (m > helf) {
			System.out.print(m + "---->");
			m = n - m;
			System.out.print(m + "\n");
		}
		// ���ӵ�������
		int numerator = A(n, m);
		// ��ĸ��������
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