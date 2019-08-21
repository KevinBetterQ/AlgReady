package exam;

import java.util.Scanner;

public class ×î´ó³Ë»ú {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] max = {-1,-1,-1};
		long[] fu = {1,1,1};
        long n = sc.nextLong();
		
		for(int t = 0; t < n; t++) {
			long num = sc.nextLong();
			if(num >= 0) {
				for(int i=0;i<3;i++){
					if(num > max[i]) {
						for(int j = 2; j>i;j--) {
							max[j] = max[j-1];
						}
						max[i] = num;
						break;
					}
				}
			}else {
				for(int i=0;i<2;i++) {
					if(num < fu[i]) {
						for(int j = 1; j>i;j--) {
							fu[j] = fu[j-1];
						}
						fu[i] = num;
						break;
					}
				}
			}
		}
		long a = fu[0] * fu[1] * max[0];
		long b = max[0] * max[1] * max[2];
		if(a > b) System.out.println(a);
		else System.out.println(b);
	}

}
