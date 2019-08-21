package structure;

import java.util.List;

public class 自定义数据结构 {

	// 链表节点
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	// 双链表节点
	class DListNode {
		int val;
		DListNode pre;
		DListNode next;
		DListNode(int x) {
			this.val = x;
			this.pre = null;
			this.next = null;
		}
	}
	// 二叉树节点
	class BTreeNode {
		int val;
		BTreeNode left;
		BTreeNode right;
		BTreeNode(int v) {
			this.val = v;
		}
	}
	// 树节点
	class TreeNode {
		int val;
		List<TreeNode> childs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
