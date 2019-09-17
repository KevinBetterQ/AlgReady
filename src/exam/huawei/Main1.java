package exam.huawei;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
        	String str = sc.nextLine();
        	String[] arr = str.split(" ");
        	String res = "";
        	//String[] arrstr = new String[arr.length];
        	int count = 0;
        	for(int i = 1; i < arr.length; i++) {
        		if(arr[i].equals("A")){
        			count++;
        			res = res + " " + "12 34";
        		}else if(arr[i].equals("B")) {
        			count++;
        			res = res + " " + "AB CD";
        		}else {
        			//System.out.println(res);
        			res = res + " " + arr[i];
        		}
        	}
        	int num;
        	switch(arr[0]) {
        	case "A": num = 10;break;
        	case "B": num = 11;break;
        	case "C":  num = 12;break;
        	case "D":  num = 13;break;
        	case "E":  num = 14;break;
        	case "F":  num = 15;break;
        	default : num = Integer.parseInt(arr[0]);
        	}
        	
        	num += count;
        	switch(num){
        	case 10: res = "A" + res;break;
        	case 11: res = "B" + res;break;
        	case 12: res = "C" + res;break;
        	case 13: res = "D" + res;break;
        	case 14: res = "E" + res;break;
        	case 15: res = "F" + res;break;
        	default:res = num + res;
        	}
        	
        	
        	System.out.println(res);
        }
   
    }
}