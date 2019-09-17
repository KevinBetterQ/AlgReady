package structure;

import java.util.*;


// 参考 ： https://www.jb51.net/article/128734.htm
public class 树 {

	/*
	 * 1、定义树
	 * 2、创建树
	 * 3、遍历树
	 * 4、树的深度
	 */
	static class TreeNode {
		Object data;
		List<TreeNode> childs;
		public TreeNode(Object v) {
			data = v;
			childs = new ArrayList<TreeNode>();
		}
	}

	public static void main(String[] args) {
		// 创建树
		/*
		 *          1A
		 *     2A        2B       2C     2D
		 * 3A 3B 3C    3D 3E 3F
		 */
		TreeNode root = new TreeNode("1A");
		root.childs.add(new TreeNode("2A"));
		root.childs.add(new TreeNode("2B"));
		root.childs.add(new TreeNode("2C"));
		root.childs.add(new TreeNode("2D"));
		TreeNode t1 = root.childs.get(0);
		t1.childs.add(new TreeNode("3A"));
		t1.childs.add(new TreeNode("3B"));
		t1.childs.add(new TreeNode("3C"));
		TreeNode t2 = root.childs.get(1);
		t2.childs.add(new TreeNode("3D"));
		t2.childs.add(new TreeNode("3E"));
		t2.childs.add(new TreeNode("3F"));
		
		System.out.println("前序遍历：");
		preTraverse(root);
		System.out.println();
		System.out.println("后序遍历：");
		postTraverse(root);
		System.out.println();
		System.out.println("层次遍历：");
		levelTraverse(root);
	}
	
	// 先序遍历
	static void preTraverse(TreeNode root) {
		if(root == null) return;
		System.out.print(root.data + " ");
		for(TreeNode t : root.childs) {
			preTraverse(t);
		}
	}
	
	// 后序遍历
	static void postTraverse(TreeNode root) {
		if(root == null) return;
		for(TreeNode t : root.childs) {
			preTraverse(t);
		}
		System.out.print(root.data + " ");
	}
	
	// 层次遍历
	static void levelTraverse(TreeNode root){
		if(root == null) return;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			System.out.print(t.data + " ");
			for(TreeNode child : t.childs) {
				q.add(child);
			}
		}
	}

}






