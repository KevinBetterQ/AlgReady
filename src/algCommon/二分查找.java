package algCommon;

public class ���ֲ��� {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 7 };
		System.out.println("���ֲ��ң�		:" + bsearch(arr, 5));
		System.out.printf("First Equal           : %2d \n", searchFirstEqual(arr, 5));
		System.out.printf("Last Equal            : %2d \n", searchLastEqual(arr, 5));
		System.out.printf("First Equal or Larger : %2d \n", searchFirstEqualOrLarger(arr, 5));
		System.out.printf("First Larger : %2d \n", searchFirstLarger(arr,5));
		System.out.printf("Last Equal or Smaller : %2d \n",searchLastEqualOrSmaller(arr, 5));
		System.out.printf("Last Smaller : %2d \n", searchLastSmaller(arr,5));
	}

	// ��ͨ���ֲ��� ==========
	static int bsearch(int[] arr, int key) {
		int left = 0, right = arr.length - 1;
		while (left <= right) { // ע����ںţ�
			int mid = (left + right) / 2;
			if (arr[mid] == key)
				return mid;
			else if (key < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1; // �������˷��� -1
	}

	// 1. �ҳ���һ����key��ȵ�Ԫ��
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

	// 2. �ҳ����һ����key��ȵ�Ԫ��
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

	// 3. ���ҵ�һ�����ڻ��ߴ���Key��Ԫ��
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

	// 4. ���ҵ�һ������key��Ԫ��
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

	// 5. �������һ�����ڻ���С��key��Ԫ��
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

	// 6. �������һ��С��key��Ԫ��
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
	
	// �ܽ᣺�������� �ж��߼� �� ����ֵ �ϵ�ѡ��
	/* ���䣺
	 * ���ֲ�����ֵ�ļ���
		��μ�����ֲ����е���ֵ�����һ����������ּ��㷽����
		�㷨һ�� mid = (low + high) / 2
		�㷨���� mid = low + (high �C low)/2
		է���������㷨һ��࣬�㷨����ȡ֮�󣬸��㷨һû��ʲô����
		����ʵ���ϣ������Ǵ��ڵġ��㷨һ���������ڼ�������£�(low + high)����������ķ��գ������õ������mid��������³������
		���㷨���ܹ���֤���������mid��һ������low��С��high����������������⡣
	 */
	
	// �������ֲο���https://www.acwing.com/blog/content/31/
	
	// ���ֲ��� ========== 
		/*static int bsearch_1(int[] arr, int key) {
			while(l < r) {
				int mid = (l+r) >> 1;
				// ������������䲢��mid�����Ǵ�
				if(val <= arr[mid]) r = mid;
				else l = mid+1;
			}
			return l;
		}
		static int bsearch_2(int[] arr, int key) {
			while(l < r) {
				int mid = (l+r+1)>>1; //����l=r-1ʱ����ѭ��
				// ������������䲢��mid���Ǵ�
				if(check(mid) r = mid - 1;
				else l = mid;
			}
			return l;
		}*/
		
		// �������ֲο���https://www.acwing.com/blog/content/31/
}
