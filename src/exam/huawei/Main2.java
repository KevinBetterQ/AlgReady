package exam.huawei;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        int res = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = low; i < high; i++) {
        	if(isSuShu(i)){
        		list.add(i);
        	}
        }
        if(list.isEmpty()) {
        	System.out.println("0");
        }else {
        	int sum1 = 0;
        	int sum2 = 0;
        	for(int i : list) {
        		sum1 += i/10%10;
        		sum2 += i%10;
        	}
        	res = sum1 < sum2? sum1:sum2;
        }
        System.out.println(res);
    }
    
    
    public static boolean isSuShu(int n) {
    	if(n <= 1) return false;
    	for(int i = 2; i < n; i++) {
    		if(n % i == 0) return false;
    	}
    	return true;
    }
}