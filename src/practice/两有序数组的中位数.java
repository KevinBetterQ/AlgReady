package practice;

public class 两有序数组的中位数 {
	// 合并数组，然后利用 (double)(nums[(index+1)/2-1] + nums[(index+2)/2-1])/2 
	// 获得中位数（不管奇偶都可以用一个公式）
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length + 1];
        int p1 = 0, p2 = 0;
        int index = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                nums[index] = nums1[p1];
                p1++;
                index++;
            } else {
                nums[index] = nums2[p2];
                p2++;
                index++;                
            }
        }
        while(p1 < nums1.length) {
            nums[index] = nums1[p1];
            p1++;
            index++;
        }
        while(p2 < nums2.length) {
            nums[index] = nums2[p2];
            p2++;
            index++;
        }
        return (double)(nums[(index+1)/2-1] + nums[(index+2)/2-1]) / 2;
    }
}

// 最优解
// 参考：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;
		// 将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
		return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
	}

	// getKth代表 返回num1和num2合起来之后的第k小的值
	private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		// 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
		if (len1 > len2)
			return getKth(nums2, start2, end2, nums1, start1, end1, k);
		if (len1 == 0)
			return nums2[start2 + k - 1];

		if (k == 1)
			return Math.min(nums1[start1], nums2[start2]);

		int i = start1 + Math.min(len1, k / 2) - 1;
		int j = start2 + Math.min(len2, k / 2) - 1;

		if (nums1[i] > nums2[j]) {
			return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
		} else {
			return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
		}
	}
}