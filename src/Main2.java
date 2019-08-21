import java.util.*;
public class Main2 {
	
	static List<String> list = new ArrayList<String>();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        
        String res = "";
        for(int index = 1; index <= n; index++) {
        	int c = find(arr, index);
        	res = res + " " + c;
        }
        System.out.println(res.substring(1));
        
    }
    
    static int find(int[] arr, int c) {
    	c = c - 1;
    	int min = Integer.MAX_VALUE;
    	int n = arr.length;
    	int max = 0;
    	for(int i = 0; i < n-c; i++) {
    		max = 0;
    		for(int j = i; j <= i+c;j++) {
    			if(arr[j] > max) max = arr[j];
    		}
    		//System.out.println("max:" + max);
    		if(max < min) min = max;
    	}
    	return min;
    }
}