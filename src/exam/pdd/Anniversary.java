package exam.pdd;

import java.util.*;

class TreeNode {
	int v;
	List<TreeNode> childs;

	public TreeNode(int v) {
		this.v = v;
	}
}

public class Anniversary {

	static int number;  
    static boolean[] flag;  
    static int[][] edges;
    List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    static void DFS(int i, int cost) {  
        flag[i] = true;// 第i个顶点被访问  
        for (int j = 0; j < number; j++) {  
        	boolean tmp = false;
            if (flag[j] == false && edges[i][j] != 0) {  
            	cost  = cost + edges[i][j];
                DFS(j, cost);  
                tmp = true;
            } 
            if(tmp == false) {
            	
            }
        }  
    }  

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lim = sc.nextInt();
		int number = sc.nextInt();
		edges = new int[number][number];
		flag = new boolean[number];
		int cost = 0;
		for (int i = 0; i < number - 1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int d = sc.nextInt();
			edges[u][v] = d;
		}
		DFS(0, cost);
	}

}
