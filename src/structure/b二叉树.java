package structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 参考  : https://blog.csdn.net/weixin_42636552/article/details/82973190
// https://www.jianshu.com/p/0190985635eb

/*
 * 关键点：
 * 1、遍历树的时候，一定要注意使用 递归，使用递归一定要先写边界条件
 * 2、可以画出一棵树，然后再来想思路
 * 3、判断树的时候，判断当前节点，然后递归判断 左子树+右子树
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
	
	public String toString(){
		return this.val + "";
	}
}


public class b二叉树 {

	public static void main(String[] args) {
		// 创建并层次遍历二叉树
		/*
		 *        3
		 *    9       20
		 * 	0   0   15   7
		 * 0 0 0 0 99 0 0 0
		 */
		int[] datas = {3,9,20,-1,-1,15,7,-1,-1,-1,-1,99};
		String str = 
		 "        3\n" + 
		 "    9       20\n" +
		 "  0   0   15   7\n" +
		 " 0 0 0 0 99 0 0 0\n";
		System.out.println(str);
		
		List<TreeNode> tree = new ArrayList<>();
		create1(datas, tree);
		TreeNode root = tree.get(0);
		// levelOrder(root);
		
		System.out.println("=== 获得树的深度 == ");
		System.out.println(getDepth(root));
		
		System.out.println("=== 先序遍历 递归 == ");
		List<TreeNode> list = new ArrayList<TreeNode>();
		preOrderRecur(root, list);
		System.out.println(list);
		
		System.out.println("=== 中序遍历 递归 == ");
		list = new ArrayList<TreeNode>();
		inOrderRecur(root, list);
		System.out.println(list);
		
		System.out.println("=== 后序遍历 递归 == ");
		list = new ArrayList<TreeNode>();
		postOrderRecur(root, list);
		System.out.println(list);
		
		System.out.println("=== 前序遍历 非递归 == ");
		list = new ArrayList<TreeNode>();
		preOrder(root, list);
		System.out.println(list);
		
		System.out.println("=== 中序遍历 非递归 == ");
		list = new ArrayList<TreeNode>();
		inOrder(root, list);
		System.out.println(list);
		
		System.out.println("=== 先序中序构造二叉树 == ");
		int[] preorder = {3, 9, 20, 15, 99, 7};
		int[] inorder = {9, 3, 99, 15, 20, 7};
		levelOrder(buildTree(preorder, inorder));
		
		System.out.println("=== 获得节点数个数 ==");
		System.out.println(getNodeNums(root));
		
		System.out.println("=== 获得叶子节点数个数 ==");
		System.out.println(getLeafNums(root));
		
		System.out.println("=== 获得叶子节点数个数 ==");
		System.out.println(getKLevelNums(root, 3));
		
		System.out.println("=== 判断是否为平衡二叉树 ==");
		System.out.println("except false : " + isBalance(root));
		int[] datas2 = {3,1,20,0,0,15,27,0,0,0,0,9};
		List<TreeNode> tree2 = new ArrayList<>();
		create1(datas2, tree2);
		TreeNode root2 = tree2.get(0);
		System.out.println("except true : " + isBalance(root2));
		
		System.out.println("=== 判断是否为完全二叉树 ==");
		System.out.println("except false : " + isCompleteTree(root));
		System.out.println("except true : " + isCompleteTree(root2));
		
		System.out.println("=== 判断是否为二叉查找树 ==");
		int[] datas3 = {3,1,20,-1,-1,15,27,-1,-1,-1,-1,9};
		List<TreeNode> tree3 = new ArrayList<>();
		create1(datas3, tree3);
		TreeNode root3 = tree3.get(0);
		System.out.println("except false : " + isBST(root));
		System.out.println("except true : " + isBST(root3));
		
		
		
	}
	
	// 利用数组创建二叉树
	static void create1(int[] datas, List<TreeNode> list){
		// new 节点，并统一放到 list 中
		for(int i = 0; i < datas.length; i++) {
			TreeNode node = new TreeNode(datas[i]);
			list.add(node);
		}
		
		// 节点关联成树
		for(int index = 0; index < list.size()/2-1; index++) {
			if(list.get(2 * index + 1).val == -1) 
				list.get(index).left = null;
			else 
				list.get(index).left = list.get(2 * index + 1);
			
			if(list.get(2 * index + 2).val == -1)
				list.get(index).right = null;
			else 
				list.get(index).right = list.get(2 * index + 2);
		}
		
		// 单独处理最后一个父节点
		int index = list.size() / 2 - 1;
		list.get(index).left = list.get(index*2+1);
		if(list.size()%2==1) {
			list.get(index).right = list.get(index*2+2);
		}
	}

	// 递归输入创建二叉树
	static TreeNode create2(TreeNode node) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input node value: ");
		int val = sc.nextInt();
		if(val != 0) {
			node = new TreeNode(val);
			node.left = create2(node.left);
			node.right = create2(node.right);
		}else {
			node = null;
		}
		sc.close();
		return node;
	}
	
	// 层次遍历二叉树(分层输出)
	static void levelOrder(TreeNode root) {
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count;
		while(!queue.isEmpty()) {
			count = queue.size();
			while(count > 0) {
				TreeNode node = queue.remove();
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
				count--;
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	}
	
	// 先序遍历(递归)
	static void preOrderRecur(TreeNode root, List<TreeNode> list) {
		if(root == null) return;
		list.add(root);
		preOrderRecur(root.left, list);
		preOrderRecur(root.right, list);
	}
	
	// 中序遍历
	static void inOrderRecur(TreeNode root, List<TreeNode> list) {
		if(root == null) return;
		inOrderRecur(root.left, list);
		list.add(root);
		inOrderRecur(root.right, list);
	}
	
	// 后序遍历
	static void postOrderRecur(TreeNode root, List<TreeNode> list) {
		if(root == null) return;
		postOrderRecur(root.left, list);
		postOrderRecur(root.right, list);
		list.add(root);
	}
	
	// 先序遍历（非递归） 用栈
	static void preOrder(TreeNode root, List<TreeNode> list) {
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p !=  null || !stack.isEmpty()) {
			while(p != null) {
				list.add(p);
				stack.push(p);
				p = p.left;
			}
			if(!stack.empty()) {
				p = stack.pop();
				p = p.right;
			}
		}
	}

	// 中序遍历(非递归)
	static void inOrder(TreeNode root, List<TreeNode> list) {
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null || !stack.isEmpty()) {
			while(p != null) {
				stack.push(p);
				p = p.left;
			}
			if(!stack.empty()) {
				p = stack.pop();
				list.add(p);
				p = p.right;
			}
		}
	}

	// 后续遍历（非递归）
	
	// 前序遍历和后序遍历构造二叉树: 写出例子来对比着想思路，然后写出大框架，然后填充细节
	static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length != inorder.length) return null;
		return buildTreeCore(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
	}
	static TreeNode buildTreeCore(int[] inorder, int instart, int inend, int[]preorder, int prestart, int preend) {
		if(instart > inend) return null;
		TreeNode root = new TreeNode(preorder[prestart]);
		int position = -1;
		for(int i = instart; i <= inend; i++) {
			if(root.val == inorder[i]){
				position = i;
				break;
			}
		}
		root.left = buildTreeCore(inorder, instart, position-1, preorder, prestart+1, prestart+position-instart);
		root.right = buildTreeCore(inorder, position+1, inend, preorder,prestart+position-instart+1, preend);
		return root;
	}
	
	// 求二叉树节点个数
	static int getNodeNums(TreeNode root){
		if(root == null) {
			return 0;
		}
		int countLeft = getNodeNums(root.left);
		int countRight = getNodeNums(root.right);
		return countLeft + countRight + 1;
	}
	
	// 求二叉树叶子节点个数
	static int getLeafNums(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) {
			return 1;
		}
		int left = getLeafNums(root.left);
		int right = getLeafNums(root.right);
		return left + right;
	}
	
	// 求二叉树的深度
	static int getDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(getDepth(root.left), getDepth(root.right))+1;
	}
	
	// 求二叉树第k层的节点个数
	static int getKLevelNums(TreeNode root,int k){
        if(root == null || k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int numsLeft = getKLevelNums(root.left, k-1);
        int numsRight = getKLevelNums(root.right, k-1);
        return numsLeft + numsRight;
    }
	
	// 判断二叉树是否为平衡二叉树
	static boolean isBalance(TreeNode root) {
		if(root == null) return true;
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if(Math.abs(leftDepth - rightDepth) > 1) 
			return false;
		return isBalance(root.left) & isBalance(root.right);
	}

	// 判断二叉树是否为完全二叉树 : 层次遍历，有几个判断条件，都判断上就可以了
	static boolean isCompleteTree(TreeNode root) {
		if(root == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean res = true;
		boolean hasNoChild = false;
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if(hasNoChild == true) {
				if(node.left != null || node.right != null) {
					res = false;
					break;
				}	
			}
			else{
				if(node.left == null && node.right != null) {
					res = false;
					break;
				} else if (node.left != null && node.right == null) {
					queue.add(node.left);
					hasNoChild = true;
				} else if (node.left == null && node.right == null) {
					hasNoChild = true;
				} else {
					queue.add(node.left);
					queue.add(node.right);
				}
			}
		}
		return res;
	}
	
	// 判断二叉树是否为二叉查找树
	static boolean isBST(TreeNode root) {
		if(root == null) return true;
		int leftv = Integer.MIN_VALUE;
		int rightv = Integer.MAX_VALUE;
		if(root.left != null) leftv = root.left.val;
		if(root.right != null) rightv = root.right.val;
		if(leftv >= root.val || rightv <= root.val)
			return false;
		return isBST(root.left) & isBST(root.right);
	}
	
	// 判断2个二叉树是否相同
	
	// 判断2个二叉树是否互为镜像
	
	// 翻转二叉树
	
	// 
}














