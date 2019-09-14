package algAdvance;
import java.util.*;
/*
0 6 0 5 9 3 0 0 0
9 0 1 0 0 0 5 0 0
0 3 0 4 0 0 0 9 0
1 0 8 0 2 0 0 0 4
4 0 0 3 0 9 0 0 1
2 0 0 0 1 0 6 0 9
0 8 0 0 0 6 0 2 0
0 0 4 0 0 0 8 0 7
0 0 0 7 8 5 0 1 0

// 另外：https://www.cnblogs.com/zhangbaochong/p/5847364.html
// https://www.cnblogs.com/theskulls/p/5289593.html
 */

public class dfs {
	
	static int[][] mat;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mat = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(j == 8) System.out.println(mat[i][j]);
				else {
					System.out.print(mat[i][j] + " ");
				}
			}
		}
		
	}
	
	static void dfs(int n) {
		if(n == 81) {
			flag = true;
			return;
		}
		int x = n / 9;
		int y = n % 9;
		
		if(mat[x][y] != 0) {
			dfs(n+1);
		}else {
			for(int i = 1; i <= 9; i++) {
				if(isCheck(x, y, i)) {
					mat[x][y] = i;
					dfs(n+1);
					if(flag == true) return;
					mat[x][y] = 0;
				}
			}
		}
		
	}

	private static boolean isCheck(int x, int y, int key) {
		
		// 判断行
		for(int col = 0; col < 9; col++) {
			if(mat[x][col] == key) return false;
		}
		
		// 判断列
		for(int row = 0; row < 9; row++) {
			if(mat[row][y] == key) return false;
		}
		
		// 判断小方格
		int xi = x / 3 * 3;
		int yi = y / 3 * 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(mat[xi+i][yi+i] == key) return false;
			}
		}
		
		return true;
	}

}










