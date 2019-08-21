import java.util.*;
public class Main3 {
	
	static List<String> list = new ArrayList<String>();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < q; i++) {
        	int x = sc.nextInt();
        	int index = find(arr, x) +1;
        	if(index < 0) {
        		System.out.println(0);
        	}else{
        		System.out.println(n-index);
        		for(int j = index; j < n; j++){
            		//System.out.println("arr[j]" + arr[j]);
            		arr[j] --;
            	}
            	Arrays.sort(arr);
        	}
        }
        
        //System.out.println(res.substring(1));
        
    }
    
    static int find(int[] arr, int v) {
    	for(int i = arr.length-1; i >= 0; i--) {
    		if(arr[i] < v) return i;
    	}
    	return -1;
    }
    
    
}