package practice;

public class �������������λ�� {
	// �ϲ����飬Ȼ������ (double)(nums[(index+1)/2-1] + nums[(index+2)/2-1])/2 
	// �����λ����������ż��������һ����ʽ��
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

// ���Ž�
// �ο���https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;
		// ��ż��������������ϲ����������������������ͬ���� k ��
		return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
	}

	// getKth���� ����num1��num2������֮��ĵ�kС��ֵ
	private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		// �� len1 �ĳ���С�� len2���������ܱ�֤�����������ˣ�һ���� len1
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