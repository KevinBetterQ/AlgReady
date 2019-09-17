package structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// �ο�  : https://blog.csdn.net/weixin_42636552/article/details/82973190
// https://www.jianshu.com/p/0190985635eb

/*
 * �ؼ��㣺
 * 1����������ʱ��һ��Ҫע��ʹ�� �ݹ飬ʹ�õݹ�һ��Ҫ��д�߽�����
 * 2�����Ի���һ������Ȼ��������˼·
 * 3���ж�����ʱ���жϵ�ǰ�ڵ㣬Ȼ��ݹ��ж� ������+������
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


public class b������ {

	public static void main(String[] args) {
		// ��������α���������
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
		
		System.out.println("=== ���������� == ");
		System.out.println(getDepth(root));
		
		System.out.println("=== ������� �ݹ� == ");
		List<TreeNode> list = new ArrayList<TreeNode>();
		preOrderRecur(root, list);
		System.out.println(list);
		
		System.out.println("=== ������� �ݹ� == ");
		list = new ArrayList<TreeNode>();
		inOrderRecur(root, list);
		System.out.println(list);
		
		System.out.println("=== ������� �ݹ� == ");
		list = new ArrayList<TreeNode>();
		postOrderRecur(root, list);
		System.out.println(list);
		
		System.out.println("=== ǰ����� �ǵݹ� == ");
		list = new ArrayList<TreeNode>();
		preOrder(root, list);
		System.out.println(list);
		
		System.out.println("=== ������� �ǵݹ� == ");
		list = new ArrayList<TreeNode>();
		inOrder(root, list);
		System.out.println(list);
		
		System.out.println("=== ��������������� == ");
		int[] preorder = {3, 9, 20, 15, 99, 7};
		int[] inorder = {9, 3, 99, 15, 20, 7};
		levelOrder(buildTree(preorder, inorder));
		
		System.out.println("=== ��ýڵ������� ==");
		System.out.println(getNodeNums(root));
		
		System.out.println("=== ���Ҷ�ӽڵ������� ==");
		System.out.println(getLeafNums(root));
		
		System.out.println("=== ���Ҷ�ӽڵ������� ==");
		System.out.println(getKLevelNums(root, 3));
		
		System.out.println("=== �ж��Ƿ�Ϊƽ������� ==");
		System.out.println("except false : " + isBalance(root));
		int[] datas2 = {3,1,20,0,0,15,27,0,0,0,0,9};
		List<TreeNode> tree2 = new ArrayList<>();
		create1(datas2, tree2);
		TreeNode root2 = tree2.get(0);
		System.out.println("except true : " + isBalance(root2));
		
		System.out.println("=== �ж��Ƿ�Ϊ��ȫ������ ==");
		System.out.println("except false : " + isCompleteTree(root));
		System.out.println("except true : " + isCompleteTree(root2));
		
		System.out.println("=== �ж��Ƿ�Ϊ��������� ==");
		int[] datas3 = {3,1,20,-1,-1,15,27,-1,-1,-1,-1,9};
		List<TreeNode> tree3 = new ArrayList<>();
		create1(datas3, tree3);
		TreeNode root3 = tree3.get(0);
		System.out.println("except false : " + isBST(root));
		System.out.println("except true : " + isBST(root3));
		
		
		
	}
	
	// �������鴴��������
	static void create1(int[] datas, List<TreeNode> list){
		// new �ڵ㣬��ͳһ�ŵ� list ��
		for(int i = 0; i < datas.length; i++) {
			TreeNode node = new TreeNode(datas[i]);
			list.add(node);
		}
		
		// �ڵ��������
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
		
		// �����������һ�����ڵ�
		int index = list.size() / 2 - 1;
		list.get(index).left = list.get(index*2+1);
		if(list.size()%2==1) {
			list.get(index).right = list.get(index*2+2);
		}
	}

	// �ݹ����봴��������
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
	
	// ��α���������(�ֲ����)
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
	
	// �������(�ݹ�)
	static void preOrderRecur(TreeNode root, List<TreeNode> list) {
		if(root == null) return;
		list.add(root);
		preOrderRecur(root.left, list);
		preOrderRecur(root.right, list);
	}
	
	// �������
	static void inOrderRecur(TreeNode root, List<TreeNode> list) {
		if(root == null) return;
		inOrderRecur(root.left, list);
		list.add(root);
		inOrderRecur(root.right, list);
	}
	
	// �������
	static void postOrderRecur(TreeNode root, List<TreeNode> list) {
		if(root == null) return;
		postOrderRecur(root.left, list);
		postOrderRecur(root.right, list);
		list.add(root);
	}
	
	// ����������ǵݹ飩 ��ջ
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

	// �������(�ǵݹ�)
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

	// �����������ǵݹ飩
	
	// ǰ������ͺ���������������: д���������Ա�����˼·��Ȼ��д�����ܣ�Ȼ�����ϸ��
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
	
	// ��������ڵ����
	static int getNodeNums(TreeNode root){
		if(root == null) {
			return 0;
		}
		int countLeft = getNodeNums(root.left);
		int countRight = getNodeNums(root.right);
		return countLeft + countRight + 1;
	}
	
	// �������Ҷ�ӽڵ����
	static int getLeafNums(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) {
			return 1;
		}
		int left = getLeafNums(root.left);
		int right = getLeafNums(root.right);
		return left + right;
	}
	
	// ������������
	static int getDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(getDepth(root.left), getDepth(root.right))+1;
	}
	
	// ���������k��Ľڵ����
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
	
	// �ж϶������Ƿ�Ϊƽ�������
	static boolean isBalance(TreeNode root) {
		if(root == null) return true;
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if(Math.abs(leftDepth - rightDepth) > 1) 
			return false;
		return isBalance(root.left) & isBalance(root.right);
	}

	// �ж϶������Ƿ�Ϊ��ȫ������ : ��α������м����ж����������ж��ϾͿ�����
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
	
	// �ж϶������Ƿ�Ϊ���������
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
	
	// �ж�2���������Ƿ���ͬ
	
	// �ж�2���������Ƿ�Ϊ����
	
	// ��ת������
	
	// 
}














