package algCommon;

import java.util.Arrays;
import java.util.Scanner;

public class IOÄ£°å {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(numbers));
		String str = sc.next();
		System.out.println(str);
		sc.close();
		
		System.out.printf("%.2f",3.1415926) ;
	}

}
