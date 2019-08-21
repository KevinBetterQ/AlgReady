package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ע�⣺"." ��"\"����|���������ַ�����Ҫת�壬"\\." ��"\\\"����\\|��

public class IP��ַ�Ϸ��ַ������ {
	
	public static void main(String[] args) {
		System.out.println("input IP indress: ");
		Scanner sc = new Scanner(System.in);
		String ipStr = sc.next();
		
		boolean isIpLegel = isIPLegel(ipStr);
		if(isIpLegel) {
	        System.out.println(ipStr + " �Ϸ�");
	    }
	    else{
	        System.out.println(ipStr + " �Ƿ�!!!");
	    }
		sc.close();
	}

	private static boolean isIPLegel(String str) {
		//1.���ip�Ƿ�Ϊ��
	    if(str == null){
	        return false;
	    }

	    //2.���ip���ȣ����Ϊ��x.x.x.x(7λ)���Ϊ��xxx.xxx.xxx.xxx(15λ)
	    if(str.length() < 7 || str.length() > 15){
	        return false;
	    }

	    //3.�������(1)(2): �������ַ�������ĩ�ַ��жϣ������"."���ǷǷ�IP
	    if(str.charAt(0) == '.' || str.charAt(str.length()-1) == '.'){
	        return false;
	    }

	    //4.��"."�ָ��ַ��������жϷָ�����ĸ������������4�������ǷǷ�IP
	    String[] arr = str.split("\\.");
	    if(arr.length != 4){
	        return false;
	    }

	    //5.�Էָ������ÿ���ַ������е����ж�
	    for(int i = 0; i < arr.length; i++){
	        //�������(3): ���ÿ���ַ�������һλ�ַ�������'0'��ͷ�����ǷǷ���IP���磺01.002.03.004
	        if(arr[i].length() > 1 && arr[i].charAt(0) == '0'){
	            return false;
	        }
	        //��ÿ���ַ�����ÿ���ַ�������һ�жϣ������������0-9�����ǷǷ���IP
	        for(int j = 0; j < arr[i].length(); j++){
	            if (arr[i].charAt(j) < '0' || arr[i].charAt(j) > '9'){
	                return false;
	            }
	        }
	    }

	    //6.�Բ�ֵ�ÿһ���ַ�������ת�������֣����ж��Ƿ���0~255
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

	    //7.����������ǰ����֤��û���ص�false������true
	    return true;
	}

	// ���򷽷�
	public static boolean isIpLegal(String ipStr) {
	    //ip��ַ��Χ��(1~255).(0~255).(0~255).(0~255)
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
