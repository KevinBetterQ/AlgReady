package algCommon;

// �������������Ѱ��� top-k ����

/*
 * �㷨˼·��
1.�������Ƚ�������г�ʼ�������ɴ���ѡ�
2.Ȼ���������ÿ������ʱ�������һ�����n�ڵ��ֵ����ڵ�0��ֵ�����滻��Ȼ�󽫽ڵ��ֵ����ɶѡ�
3.Ȼ�󽫸��ڵ���n-1���н����ظ�����2��ֱ������Ϊ����

�ο���https://www.jianshu.com/p/48ebffa146db
 */

public class ����_�� {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4, 9, 8 };
		int k = 4;
		// ��һ�����ݽڵ㴴����
		for (int i = (k - 1) / 2; i >= 0; i--) {
			HeapAdjust(nums, i, 4);
		}
		// �ڶ�������
		HeapSort(nums, k);
		for (int n : nums) {
			System.out.println(n);
		}

	}

	/**
	 * �ѽ�����ʼ������
	 * 
	 * @param nums
	 *            ��������
	 * @param l
	 *            ������
	 */
	public static void HeapInit(int[] nums, int l) {
		for (int i = (l - 1) / 2; i >= 0; i--) {
			HeapAdjust(nums, i, l);
		}
	}

	public static void HeapSort(int[] nums, int l) {
		for (int i = l; i > 0; i--) {
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			// ��Ϊÿ�ε������ǶԸ��ڵ���е����������з���s��ԶΪ0
			HeapAdjust(nums, 0, i - 1);
		}
	}

	/**
	 * �ѵ����㷨
	 * 
	 * @param num
	 *            ����
	 * @param s
	 *            ���������
	 * @param l
	 *            ���������������
	 */
	public static void HeapAdjust(int[] num, int s, int l) {
		int i, j;
		int temp = num[s];
		i = s;
		// ���ݶ����������ʿ�֪��ÿһ����Ŷ�Ӧ���ӽڵ��Լ�˫�׽ڵ�
		for (j = 2 * i + 1; j <= l; j = 2 * j + 1) {
			// �ж����jָ����ֵ�ϴ�Ľڵ�
			if (j < l && num[j] < num[j + 1]) {
				j = j + 1;
			}
			// ��������ڵ�������ӽڵ�����ֵ���������
			if (temp > num[j]) {
				break;
			}
			// ���С�����ӽڵ��ƶ������ڵ�λ�ã�����������ӽڵ�������жϵ���λ�õ��ӽڵ�
			// ׼���������� �����ڵ�
			num[i] = num[j];
			i = j;
		}
		// ����������
		num[i] = temp;
	}

}
