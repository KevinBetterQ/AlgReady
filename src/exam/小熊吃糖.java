package exam;
import java.util.*;

public class Ğ¡ĞÜ³ÔÌÇ {
	
	public static class Bear{
		int stack;
		int hur;
		public Bear(int s, int h) {
			stack = s;
			hur = h;
		}
	}
	
	public static class myComparator implements Comparator<Bear> {

		@Override
		public int compare(Bear o1, Bear o2) {
			return o2.stack - o1.stack;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] suger = new int[m];
		Bear[] pandas = new Bear[n];
		Map<Integer, Bear> map = new HashMap<Integer, Bear>();
		
		for(int i = 0; i < m; i++) {
			suger[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int h = sc.nextInt();
			pandas[i] = new Bear(s, h);
			map.put(i, pandas[i]);
		}
		
		Arrays.sort(pandas, new myComparator());
		Arrays.sort(suger);
		
		for(int p = 0; p < n; p++) {
			for(int i = suger.length - 1; i >= 0; i--) {
				if(suger[i] != -1 && pandas[p].hur - suger[i] >= 0) {
					
					pandas[p].hur = pandas[p].hur - suger[i];
					suger[i] = -1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(map.get(i).hur);
		}
		
		
		
	}

}
