package practice;

// 注意32位int能保存的数据范围为 [2^31,  2^31-1]

public class 整数反转 {
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE%10);
	}
	// 正确方式
	public int reverse(int x) {
        int xabs = x;
        int y = 0;
        while(xabs != 0) {
            int remain = xabs % 10;
            if (y > Integer.MAX_VALUE/10 || (y == Integer.MAX_VALUE / 10 && remain > Integer.MAX_VALUE%10)) return 0;
            if (y < Integer.MIN_VALUE/10 || (y == Integer.MIN_VALUE / 10 && remain < Integer.MIN_VALUE%10)) return 0;
            y = (y * 10) + remain;
            xabs = xabs / 10;
        }
        return y;
    }
	
	// 错误方式
	public int reverse2(int x) {
        int xabs = (x >= 0) ? x : -x;
        int y = 0;
        while(xabs != 0) {
            y = (y * 10) + (xabs % 10);
            xabs = xabs / 10;
        }
        return (x > 0) ? y : -y;
    }
	
}
