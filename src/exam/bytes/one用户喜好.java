package exam.bytes;

import java.util.*;

public class one”√ªßœ≤∫√ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashMap<Integer, HashMap<Integer, Integer>> mapList = new HashMap<>();
		
		int[] plike = new int[n];
		for(int i = 0; i < n; i++) {
			int t = sc.nextInt();
			plike[i] = t;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			if(i != 0) {
				map.putAll(mapList.get(i-1));
			}
			if(map.containsKey(t)) {
				int v = map.get(t) + 1;
				map.put(t, v);
			} else {
				map.put(t, 1);
			}
			mapList.put(i, map);
		}
		//System.out.println(mapList);
		int q = sc.nextInt();
		for(int qi = 0; qi < q; qi++) {
			int count = 0;
			int left = sc.nextInt();
			int r = sc.nextInt();
			int v = sc.nextInt();
			int c1 = mapList.get(left-1).getOrDefault(v, 0);
			int c2 = mapList.get(r-1).getOrDefault(v, 0);
			
			count = c2 - c1;
			
			if(plike[left - 1] == v) {
				count++;
			}
			
			/*for(int i = left - 1; i < r; i++) {
				if(plike[i] == v) {
					count++;
				}
			}*/
			System.out.println(count);
		}
		sc.close();
	}

}
