package practice;

// 滑动窗口 + Map存值优化

import java.util.HashMap;

public class 无重复字符的最长子串 {
	
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i); 
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
