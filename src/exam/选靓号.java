package exam;

import java.util.*;

public class Ñ¡ö¦ºÅ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String str = sc.next();
		
		int[] arr = new int[str.length()];
		int[] arrsort = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
			arrsort[i] = str.charAt(i) - '0';
		}
	
		Arrays.sort(arrsort);

		int mid = arrsort[arrsort.length-1];
		
	}

}
