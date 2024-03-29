package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//注意："." 、"\"、“|”是特殊字符，需要转义，"\\." 、"\\\"、“\\|”

public class IP地址合法字符串检查 {
	
	public static void main(String[] args) {
		System.out.println("input IP indress: ");
		Scanner sc = new Scanner(System.in);
		String ipStr = sc.next();
		
		boolean isIpLegel = isIPLegel(ipStr);
		if(isIpLegel) {
	        System.out.println(ipStr + " 合法");
	    }
	    else{
	        System.out.println(ipStr + " 非法!!!");
	    }
		sc.close();
	}

	private static boolean isIPLegel(String str) {
		//1.检查ip是否为空
	    if(str == null){
	        return false;
	    }

	    //2.检查ip长度，最短为：x.x.x.x(7位)，最长为：xxx.xxx.xxx.xxx(15位)
	    if(str.length() < 7 || str.length() > 15){
	        return false;
	    }

	    //3.解决问题(1)(2): 对输入字符串的首末字符判断，如果是"."则是非法IP
	    if(str.charAt(0) == '.' || str.charAt(str.length()-1) == '.'){
	        return false;
	    }

	    //4.按"."分割字符串，并判断分割出来的个数，如果不是4个，则是非法IP
	    String[] arr = str.split("\\.");
	    if(arr.length != 4){
	        return false;
	    }

	    //5.对分割出来的每个字符串进行单独判断
	    for(int i = 0; i < arr.length; i++){
	        //解决问题(3): 如果每个字符串不是一位字符，且以'0'开头，则是非法的IP，如：01.002.03.004
	        if(arr[i].length() > 1 && arr[i].charAt(0) == '0'){
	            return false;
	        }
	        //对每个字符串的每个字符进行逐一判断，如果不是数字0-9，则是非法的IP
	        for(int j = 0; j < arr[i].length(); j++){
	            if (arr[i].charAt(j) < '0' || arr[i].charAt(j) > '9'){
	                return false;
	            }
	        }
	    }

	    //6.对拆分的每一个字符串进行转换成数字，并判断是否在0~255
	    for(int i = 0; i < arr.length; i++){
	        int temp = Integer.parseInt(arr[i]);
	        if(i == 0){
	            if (temp < 1 || temp > 255){
	                return false;
	            }
	        }
	        else{
	            if(temp < 0 || temp > 255){
	                return false;
	            }
	        }
	    }

	    //7.最后，如果经过前面验证都没返回到false，返回true
	    return true;
	}

	// 正则方法
	public static boolean isIpLegal(String ipStr) {
	    //ip地址范围：(1~255).(0~255).(0~255).(0~255)
	    String ipRegEx = "^([1-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))(\\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))){3}$";
	    //String ipRegEx = "^([1-9]|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))(\\.(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))){3}$";
	    //String ipRegEx = "^(([1-9]\\d?)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))(\\.(0|([1-9]\\d?)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))){3}$";
	    Pattern pattern = Pattern.compile(ipRegEx);
	    Matcher matcher = pattern.matcher(ipStr);
	    if (matcher.matches()) {
	        return true;
	    } else {
	        return false;
	    }
	}

}
