package exam;

public class ÖÖÊ÷ {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		pailie(arr,0);
	}
	
    
	static void pailie(int[] arr, int x) {
		if(x > arr.length) return;
		if(x == arr.length-1) {
			printarr(arr);
		}else {
			for(int i = x; i < arr.length; i++) {
				int t = arr[i];
				arr[i] = arr[x];
				arr[x] = t;
				pailie(arr, x+1);
				t = arr[i];
				arr[i] = arr[x];
				arr[x] = t;
			}
		}
		
	}
	
	static void printarr(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
