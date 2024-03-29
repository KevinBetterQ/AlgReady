package algCommon;

// 堆排序可以用来寻解决 top-k 问题

/*
 * 算法思路：
1.我们首先将数组进行初始化调整成大根堆。
2.然后进行排序，每次排序时，将最后一个序号n节点的值与根节点0的值进行替换，然后将节点又调整成堆。
3.然后将根节点与n-1进行交换重复步骤2。直到序列为有序

参考：https://www.jianshu.com/p/48ebffa146db
 */

public class 排序_堆 {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4, 9, 8 };
		int k = 4;
		// 第一步根据节点创建堆
		for (int i = (k - 1) / 2; i >= 0; i--) {
			HeapAdjust(nums, i, 4);
		}
		// 第二步排序
		HeapSort(nums, k);
		for (int n : nums) {
			System.out.println(n);
		}

	}

	/**
	 * 堆建立初始化函数
	 * 
	 * @param nums
	 *            数组序列
	 * @param l
	 *            最大序号
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
			// 因为每次调整都是对根节点进行调整所以下列方法s永远为0
			HeapAdjust(nums, 0, i - 1);
		}
	}

	/**
	 * 堆调整算法
	 * 
	 * @param num
	 *            数组
	 * @param s
	 *            调整节序号
	 * @param l
	 *            数组排序最大的序号
	 */
	public static void HeapAdjust(int[] num, int s, int l) {
		int i, j;
		int temp = num[s];
		i = s;
		// 根据二叉树的性质可知道每一个序号对应的子节点以及双亲节点
		for (j = 2 * i + 1; j <= l; j = 2 * j + 1) {
			// 判断如果j指向数值较大的节点
			if (j < l && num[j] < num[j + 1]) {
				j = j + 1;
			}
			// 如果调整节点大于其子节点最大的值则无需调整
			if (temp > num[j]) {
				break;
			}
			// 如果小于则将子节点移动到根节点位置，如果还存在子节点则继续判断调整位置的子节点
			// 准备继续向下 调整节点
			num[i] = num[j];
			i = j;
		}
		// 最后插入数据
		num[i] = temp;
	}

}
