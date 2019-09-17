package practice;

import java.util.*;

// ref: https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E5%AD%97%E7%AC%A6%E4%B8%B2.md

public class 字符串练习 {

	public static void main(String[] args) {
		System.out.println(countSubstrings("aaa"));
	}
	
	// 两个字符串包含的字符是否完全相同
	public boolean isSame(String str1, String str2) {
		int[] counts = new int[26];
		for(char c : str1.toCharArray()) {
			counts[c - 'a']++;
		}
		for(char c : str2.toCharArray()) {
			counts[c - 'a']--;
		}
		for(int i : counts) {
			if(i != 0) return false;
		}
		return true;
	}
	
	// 字符串反转
	static String reverse(String str) {
		char[] strc = str.toCharArray();
		int a = 0, b = strc.length - 1;
		while(a < b) {
			char t = strc[a];
			strc[a] = strc[b];
			strc[b] = t;
			a++;
			b--;
		}
		return String.valueOf(strc);
	}

	// 字符串是否同构
	public static boolean isIsomorphic(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		int[] preIndexOfStr1 = new int[256];
		int[] preIndexOfStr2 = new int[256];
		for(int i = 0; i < str1.length(); i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if(preIndexOfStr1[c1] != preIndexOfStr2[c2]) return false;
			preIndexOfStr1[c1] = i + 1;
			preIndexOfStr2[c2] = i + 1;
		}
		return true;
	}
	
	// 回文子字符串个数
	static int cnt = 0;
	public static int countSubstrings(String s) {
		for(int i = 0; i < s.length(); i++) {
			extend(s, i, i);
			extend(s, i, i+1);
		}
		return cnt;
	}
	private static void extend(String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			cnt++;
			start--;
			end++;
		}
	}
}
