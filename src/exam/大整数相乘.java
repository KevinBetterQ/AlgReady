package exam;

import java.util.Scanner;

public class 大整数相乘 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		if(s1.length() < s2.length()) {
			String s = s1;
			s1 = s2;
			s2 = s;
		}
		
		String res = "0";
		for(int i = s2.length()-1; i >= 0; i--) {
			String sum = cheng(s1, s2.charAt(i));
			for(int j = s2.length() - 1 - i;j>0;j--) {
				sum  = sum + "0";
			}
			res = add(res, sum);
		}
		
		
		System.out.println(res);

	}
	
	static String add(String s1, String s2) {
		String sb = "";
		if(s1.length() < s2.length()) {
			String s = s1;
			s1 = s2;
			s2 = s;
		}
		int add = 0;
		int j = s1.length() - 1;
		for(int i = s2.length()-1; i >= 0; i--,j--) {
			int is1 = s1.charAt(j) - '0';
			int is2 = s2.charAt(i) - '0';
			int sum = is1 + is2 + add;
			add = sum / 10;
			sb = String.valueOf(sum % 10) + sb;
		}
		for(; j>=0; j--) {
			int sum = s1.charAt(j) - '0' + add;
			add = sum / 10;
			sb = String.valueOf(sum % 10) + sb;
		}
		if(add != 0) sb = add + sb;
		
		return sb;
	}
	
	static String cheng(String s, char c) {
		String ans = "";
		
		int ic = c - '0';
		
		int add = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			int is = s.charAt(i) - '0';
			int sum = is * ic + add;
			add = sum / 10;
			ans = String.valueOf(sum%10) + ans;
		}
		if(add != 0) ans = String.valueOf(add) + ans; 
		
		return ans;
	}

}
