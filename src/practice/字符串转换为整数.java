package practice;

public class 字符串转换为整数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int myAtoi(String str) {
        str = str.trim();
        //System.out.println(str);
        if(str == null || str.length() == 0) return 0;
        
        long res = 0;
        int sign = 1;
        
        int index = 0;
        if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            sign = 1;
        }else if(str.charAt(0) == '-') {
            sign = -1;
            index = 1;
        }else if(str.charAt(0) == '+') {
            sign = 1;
            index = 1;
        }else {
            return 0;
        }
        //System.out.println("flag");
        for(;index < str.length(); index++) {
            if(str.charAt(index) < '0' || str.charAt(index) > '9') {
            	break;
            }else {
                int t = str.charAt(index) - '0';
                res = res * 10 + t;
            }
        }
        System.out.println(sign);
        
        res = res * sign;
        if(res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int)res;
    }
	
	
	//好解法
	 public int myAtoi2(String str) {
	        int i = 0, j = 0, len = str.length();
	        boolean negative = false;
	        for (i = 0; i < len; i++) {
	            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
	                break;
	            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
	                negative = str.charAt(i) == '-';
	                i++;
	                break;
	            } else if (str.charAt(i) != ' ') {
	                return 0;
	            }
	        }
	        for (j = i; j < len; j++) {
	            if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
	                break;
	            }
	        }
	        int ret = 0;
	        String num = str.substring(i, j);
	        for (int x = 0; x < num.length(); x++) {
	            int cur = num.charAt(x) - '0';
	            if (negative) {
	                //这里判断溢出的情况和第7题一样
	                if (ret < Integer.MIN_VALUE / 10|| ret == Integer.MIN_VALUE / 10 && cur > 8) {
	                    return Integer.MIN_VALUE;
	                }
	                ret = ret * 10 - cur;
	            } else {
	                if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
	                    return Integer.MAX_VALUE;
	                }
	                ret = ret * 10 + cur;
	            }
	        }
	        return ret;
	    }


}
