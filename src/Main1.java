import java.util.*;
public class Main1 {
	
	static List<String> list = new ArrayList<String>();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        String str = "";
		for(int k = 0; k < arr.length; k++) {
			str = str + " " + arr[k];
		}
        //str = str.substring(1);
        per(arr, 0);
        
        Collections.sort(list);
        
        /*for(String s : list) {
        	System.out.println(s);
        }
        
        System.out.println("==========");*/
        int count = 0;
        for(String s : list) {
        	count++;
        	if(s.equals(str)) {
        		//System.out.println("count:" + count);
        		break; 
        	}
        }
        int c = list.size() - count;
        System.out.println(list.get(c).substring(1)); 
        
    }
    
    static void per(int[] arr, int i) {
    	if(i == arr.length) {
    		String ss = "";
    		for(int k = 0; k < arr.length; k++) {
    			ss = ss + " " + arr[k];
    		}
    		list.add(ss);
    		return;
    	}
    	
    	for(int j = i; j < arr.length; j++) {
    		int t = arr[i];
    		arr[i] = arr[j];
    		arr[j] = t;
    		per(arr, i+1);
    		t = arr[i];
    		arr[i] = arr[j];
    		arr[j] = t;
    	}
    	
    }
}