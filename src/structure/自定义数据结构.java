package structure;

import java.util.List;

public class �Զ������ݽṹ {

	// ����ڵ�
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	// ˫����ڵ�
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
	// �������ڵ�
	class BTreeNode {
		int val;
		BTreeNode left;
		BTreeNode right;
		BTreeNode(int v) {
			this.val = v;
		}
	}
	// ���ڵ�
	class TreeNode {
		int val;
		List<TreeNode> childs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
