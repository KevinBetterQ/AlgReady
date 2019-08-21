package practice;

// ����һ�� ������չ
// ˼·��������չ�㷨�� ����һ�Σ����ÿһ���ַ���������չ
// �ؼ��㣺��Ϊ��ż�����������ĵ���������� expend(s, i, i) ��  expend(s, i, i + 1)

public class ������Ӵ� {
	public String longestPalindrome(String s) {
		String res = "";
		int maxDiff = 0;
		for (int i = 0; i < s.length(); i++) {
			int diff = expend(s, i, i);
			if (diff > maxDiff) {
				maxDiff = diff;
				res = s.substring(i - diff + 1, i + diff + 1 - 1);
			}
			diff = expend(s, i, i + 1);
			if (diff >= maxDiff) {
				maxDiff = diff;
				res = s.substring(i - diff + 1, i + 1 + diff + 1 - 1);
			}
		}
		return res;
	}

	public static int expend(String str, int i1, int i2) {
		int diff = 0;
		while (i1 >= 0 && i2 < str.length() && str.charAt(i1) == str.charAt(i2)) {
			i1--;
			i2++;
			diff++;
		}
		return diff;
	}
}
