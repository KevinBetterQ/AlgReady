package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ÁùÒ»¶ùÍ¯½Ú {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> h = new ArrayList<>();
		List<Integer> w = new ArrayList<>();
	
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int num  = sc.nextInt();
			h.add(num);
		}
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			int num  = sc.nextInt();
			w.add(num);
		}	
		
		Collections.sort(h);
		Collections.sort(w);
		
		int res = 0;
		
		for(int i = w.size()-1; i >= 0; i--) {
			int ww = w.get(i);
			for(int j = h.size()-1; j>=0; j--){
				int hh = h.get(j);
				if(ww >= hh) {
					res++;
					h.remove(j);
					break;
				}
			}
		}
		System.out.println(res);
	}

}
