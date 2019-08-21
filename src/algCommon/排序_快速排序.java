package algCommon;

public class ÅÅÐò_¿ìËÙÅÅÐò {
    public static void quickSort(int[] arr, int left, int right) {
    	if(left>=right) return;
    	int tmp = arr[left];
    	int i=left,j=right;
    	while(i<j) {
    		while(arr[j]>=tmp&&i<j) j--;
    		while(arr[i]<=tmp&&i<j) i++;
    		if(i<j){
    			int t = arr[i];
    			arr[i] = arr[j];
    			arr[j] = t;
    		}
    	}
    	arr[left] = arr[i];
    	arr[i] = tmp;
    	quickSort(arr,left,i-1);
    	quickSort(arr,i+1,right);
    }
 
 
    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
