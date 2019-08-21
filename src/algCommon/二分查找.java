package algCommon;

public class 二分查找 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 7 };
		System.out.println("二分查找：		:" + bsearch(arr, 5));
		System.out.printf("First Equal           : %2d \n", searchFirstEqual(arr, 5));
		System.out.printf("Last Equal            : %2d \n", searchLastEqual(arr, 5));
		System.out.printf("First Equal or Larger : %2d \n", searchFirstEqualOrLarger(arr, 5));
		System.out.printf("First Larger : %2d \n", searchFirstLarger(arr,5));
		System.out.printf("Last Equal or Smaller : %2d \n",searchLastEqualOrSmaller(arr, 5));
		System.out.printf("Last Smaller : %2d \n", searchLastSmaller(arr,5));
	}

	// 普通二分查找 ==========
	static int bsearch(int[] arr, int key) {
		int left = 0, right = arr.length - 1;
		while (left <= right) { // 注意等于号！
			int mid = (left + right) / 2;
			if (arr[mid] == key)
				return mid;
			else if (key < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1; // 最后别忘了返回 -1
	}

	// 1. 找出第一个与key相等的元素
	static int searchFirstEqual(int[] arr, int key) {
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (key <= arr[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}
		if (l < arr.length && arr[l] == key)
			return l;
		return -1;
	}

	// 2. 找出最后一个与key相等的元素
	static int searchLastEqual(int[] arr, int key) {
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (key >= arr[mid])
				l = mid + 1;
			else
				r = mid - 1;
		}
		if (r >= 0 && arr[r] == key)
			return r;
		return -1;
	}

	// 3. 查找第一个等于或者大于Key的元素
	static int searchFirstEqualOrLarger(int[] arr, int key) {
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (key <= arr[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}
		if (l < arr.length)
			return l;
		return -1;
	}

	// 4. 查找第一个大于key的元素
	static int searchFirstLarger(int[] arr, int key) {
		int left = 0, right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(key >= arr[mid]) left = mid + 1;
			else right = mid - 1;
		}
		if(left < arr.length) return left;
		return -1;
	}

	// 5. 查找最后一个等于或者小于key的元素
	static int searchLastEqualOrSmaller(int[] arr, int key) {
		int left = 0, right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(key >= arr[mid]) left = mid + 1;
			else right = mid - 1;
		}
		if(right >= 0) return right;
		return -1;
	}

	// 6. 查找最后一个小于key的元素
	static int searchLastSmaller(int[] arr, int key){
		int left = 0, right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(key <= arr[mid]) right = mid - 1;
			else left = mid + 1;
		}
		if(right >= 0) return right;
		return -1;
	}
	
	// 总结：核心在于 判断逻辑 与 返回值 上的选择
	/* 补充：
	 * 二分查找中值的计算
		如何计算二分查找中的中值？大家一般给出了两种计算方法：
		算法一： mid = (low + high) / 2
		算法二： mid = low + (high – low)/2
		乍看起来，算法一简洁，算法二提取之后，跟算法一没有什么区别。
		但是实际上，区别是存在的。算法一的做法，在极端情况下，(low + high)存在着溢出的风险，进而得到错误的mid结果，导致程序错误。
		而算法二能够保证计算出来的mid，一定大于low，小于high，不存在溢出的问题。
	 */
	
	// 其他二分参考：https://www.acwing.com/blog/content/31/
	
	// 二分查找 ========== 
		/*static int bsearch_1(int[] arr, int key) {
			while(l < r) {
				int mid = (l+r) >> 1;
				// 如果答案在左区间并且mid可能是答案
				if(val <= arr[mid]) r = mid;
				else l = mid+1;
			}
			return l;
		}
		static int bsearch_2(int[] arr, int key) {
			while(l < r) {
				int mid = (l+r+1)>>1; //避免l=r-1时的死循环
				// 如果答案在左区间并且mid不是答案
				if(check(mid) r = mid - 1;
				else l = mid;
			}
			return l;
		}*/
		
		// 其他二分参考：https://www.acwing.com/blog/content/31/
}
