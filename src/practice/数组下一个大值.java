package practice;

import java.util.*;

public class 数组下一个大值 {

	public static void main(String[] args) {
		int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		int[] res = nextGreater(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(res[i] + " ");
		}
		
		int[] arr2 = new int[]{1,2,1};
		int[] res2 = nextGreater2(arr2);
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(res2[i] + " ");
		}
	}
	
	/*
	Input: [73, 74, 75, 71, 69, 72, 76, 73]
	Output: [1, 1, 4, 2, 1, 1, 0, 0]
	 */
	public static int[] nextGreater(int[] arr) {
		int len = arr.length;
		int[] res = new int[len];
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < len; i++) {
			while(!list.isEmpty() && arr[i] > arr[list.getLast()]) {
				int index = list.removeLast();
				res[index] = i - index;
			}
			list.addLast(i);
		}
		
		return res;
	}

	/*
	Input: [1,2,1]
	Output: [2,-1,2]
	 */
	public static int[] nextGreater2(int[] arr) {
		int len = arr.length;
		int[] res = new int[len];
		Arrays.fill(res, -1);
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < len * 2; i++) {
			while(!list.isEmpty() && arr[i%len] > arr[list.getLast()]) {
				int index = list.removeLast();
				res[index] = arr[i%len];
			}
			if(i < len) {
				list.addLast(i);
			}
		}
		return res;
	}
}
