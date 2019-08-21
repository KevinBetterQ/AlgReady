package exam.bytes;

import java.util.*;

public class ×ÖÄ¸½»»» {
	
	static int maxNum  = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] cstr = s.toCharArray();
		int m = sc.nextInt();
		//System.out.println(getNums(cstr));
		getLongNum(cstr, m);
		System.out.println(maxNum);

	}
	
	public static void getLongNum(char[] cstr, int m) {
		if(m <= 0) return ;
		
		int n = getNums(cstr);
		maxNum = maxNum > n ? maxNum : n;
		
		m = m - 1;
		for(int i = 0; i < cstr.length - 1; i++) {
			char t = cstr[i];
			cstr[i] = cstr[i+1];
			cstr[i+1] = t;
			getLongNum(cstr, m);
			t = cstr[i];
			cstr[i] = cstr[i+1];
			cstr[i+1] = t;
		}
	}
	
	public static int getNums(char[] s) {
		int max = 0;
		int num = 1;
		for(int i = 0; i < s.length - 1; i++) {
			if(s[i] == s[i+1]) {
				num++;
				max = max < num ? num : max;
			}
			else {
				num = 1;
			}
		}
		return max;
	}

}
