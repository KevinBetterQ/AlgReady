package algCommon;

public class ������ {

	public static void main(String[] args) {
		int[] arr = new int[]{1,4,6,7,9,23,45,88};
	}

	// �������㷨 ��m^k %p
	int powerMod(int m,int k,int p) {
		int res = 1,t = m;
		while(k > 0) {
			if ((k&1) == 1) {
				res = res * t % p;
			}
			t = t * t % p;
			k = k>>1;
		}
		return res;
	}

}
