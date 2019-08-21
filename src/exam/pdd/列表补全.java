package exam.pdd;

import java.util.*;

// 反思：涉及大小比较，可以考虑用  Math.max 或  Math.min 的

public class 列表补全 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int offset = sc.nextInt();
			int n = sc.nextInt();
			int len1 = sc.nextInt();
			int len2 = sc.nextInt();
			
			int start1 = 0, end1 = 0, start2 = 0, end2 = 0;
			if(offset <= 0) {
				start1 = 0;
				if(n <= len1) {
					end1 = n;
					start2 = 0;
					end2 = 0;
				} else if(n > len1 && n < len1 + len2) {
					end1 = len1;
					start2 = 0;
					end2 = n - len1;
				} else {
					end1 = len1;
					start2 = 0;
					end2 = len2;
				}
			} else if(offset <= len1) {
				start1 = offset;
				if(n <= len1-offset) {
					end1 = offset + n;
					start2 = 0;
					end2 = 0;
				}else if(n <= len1 - offset + len2) {
					end1 = len1;
					start2 = 0;
					end2 = n - len1 + offset;
				}else {
					end1 = len1;
					start2 = 0;
					end2 = len2;
				}
				
			} else if(offset <= len1 + len2) {
				start1 = len1;
				end1 = len1;
				if( n <= len2 + len1 - offset) {
					start2 = offset - len1;
					end2 = offset - len1 + n;
				} else {
					start2 = offset - len1;
					end2 = len2;
				}
			} else {
				start1 = len1;
				end1 = len1;
				start2 = len2;
				end2 = len2;
			}
			
			System.out.print(start1 + " ");
			System.out.print(end1 + " ");
			System.out.print(start2 + " ");
			System.out.print(end2);
		}
		sc.close();
	}

	
	/* 好答案：
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] strs = line.split(" ");
            int offset = Integer.parseInt(strs[0]), n = Integer.parseInt(strs[1]);
            int len1 = Integer.parseInt(strs[2]), len2 = Integer.parseInt(strs[3]);
 
            int s1 = Math.min(offset, len1);
            int e1 = Math.min(offset + n, len1);
            int s2 = Math.min(len2, Math.max(0, offset - len1));
            int e2 = Math.max(0, Math.min(len2, offset + n - len1));
            System.out.println(s1 + " " + e1 + " " + s2 + " " + e2);
        }
    }
	 */
}
