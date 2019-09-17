package structure;

// 参考：https://www.jianshu.com/p/a64d1ef95980 一篇文章搞定面试中的链表题目(java实现)
/*
 * 链表关键点：
 * 0、注意使用 cur、pre、kNode、dummy这几个定义节点
 * 1、双指针
 * 2、头节点：涉及找第几个节点的时候一定要用这个，不会乱
 * 3、注意可以定义new Node保存中间过程使用的节点
 * 4、null是没有next类型的。注意多判断！！
 * 5、可以把链表写出来 1-2-3-4-5-null，注意最后的null
 */

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
		next = null;
	}
	
	// 统计链表长度
	int size() {
		int size = 0;
		ListNode node = this;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}
}

public class a链表 {
	
	public static void main(String[] args) {
		// 链表创建、删除与遍历
		ListNode head = new ListNode(1);
		ListNode cur = head;
		for(int i = 2; i <= 5; i++) {
			ListNode node = new ListNode(i);
			cur.next = node;
			cur = cur.next;
		}
		traverse(head);
		System.out.println("size: " + head.size());
		
		System.out.println("===得到倒数第k个值===");
		System.out.println("last 3: " + getLastKNode(head,3));
		System.out.println("last 5: " + getLastKNode(head,5));
		System.out.println("last 1: " + getLastKNode(head,1));		
	
		System.out.println("===排序链表：===");
		ListNode tmp4 = mergeSort(head);
		traverse(tmp4);
		
		System.out.println("===获得中间值：===");
		System.out.println(middleNode(tmp4).val);
		
		System.out.println("===判断是否有环：===");
		System.out.println("expect false : " + hasCycle(head));
		cur.next = head;
		System.out.println("expect true : " + hasCycle(head));
		cur.next = null;
		
		System.out.println("===反转链表：===");
		ListNode reverseHead = reverse(head);
		traverse(reverseHead);
		reverseHead = reverse(reverseHead);
		traverse(reverseHead);
		
		System.out.println("===反转链表m2n：===");
		ListNode tmp2 = reverseM2N(head,1,3);
		traverse(tmp2);
		tmp2 = reverseM2N(tmp2,1,3);
		traverse(tmp2);
		tmp2 = reverseM2N(tmp2,1,5);
		traverse(tmp2);
		tmp2 = reverseM2N(tmp2,1,5);
		traverse(tmp2);
		
		System.out.println("===旋转链表k：===");
		ListNode tmp3 = rotateRight(tmp2,3);
		traverse(tmp3);
		tmp3 = rotateRight(tmp3,4);
		traverse(tmp3);
		tmp3 = rotateRight(tmp3,5);
		traverse(tmp3);
		tmp3 = rotateRight(tmp3,2);
		traverse(tmp3);
		
		System.out.println("===删除重复元素1：===");
		ListNode headDeleteMu = new ListNode(1);
		cur = headDeleteMu;
		cur.next = new ListNode(2);
		cur = cur.next;
		cur.next = new ListNode(2);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(4);
		cur = cur.next;
		cur.next = new ListNode(5);

		traverse(headDeleteMu);
		headDeleteMu = deleteMuNode2(headDeleteMu);
		traverse(headDeleteMu);
		
		
	}
	// 遍历链表
	static void traverse(ListNode head) {
		if(head == null) {
			System.out.println("list is null");
		}
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	// 反转链表 （pre、cur 和 tmp指针）
	static ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}
	
	// 反转链表从 m 到 n 之间的节点  dum-1-2-3-4-5-null ===>  3-2-1-4-5
	static ListNode reverseM2N(ListNode head, int m, int n) {
		if(m >= n || head == null) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;		
		ListNode cur = dummy;
		for(int i = 1; i <= m - 1; i++) {
			if(cur == null) return null;
			cur = cur.next;
		}
		ListNode mNode = cur.next;
		
		ListNode pre = cur;
		cur = mNode;
		for(int i = m; i <= n; i++) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		mNode.next = cur;
		return pre;
	}
	
	// 旋转链表：1-2-3-4-5-null ==> 4-5-1-2-3-null
	static ListNode rotateRight(ListNode head, int k) {
		if(head == null || k <=1) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		for(int i = 1; i <= k-1; i++) {
			if(cur == null) return null;
			cur = cur.next;
		}
		if(cur.next == null) return null;
		ListNode kNode = cur.next;
		cur.next = null;
		
		cur = kNode;
		while(cur.next != null) {
			cur = cur.next;	
		}
		cur.next = head;
		return kNode;
	}
	
	// 判断链表是否有环 (快慢指针)
	static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != slow) {
			if(fast.next == null || slow == null) {
				return false;
			}
			if(fast.next.next == null) return false;
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
	}

	// 得到倒数第k个节点  1-2-3-4-5-null
	static int getLastKNode(ListNode head, int k){
		if(head == null) return -1;
		ListNode slow = head;
		ListNode fast = head;
		for(int i = 0; i <= k-1; i++) {
			if(fast == null) return -1;
			fast = fast.next;
		}
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.val;
	}
	
	// 链表排序
	// 链表排序 10-6-9-7-2-null  ==> 10-6-9-null 和 7-2-null
	static ListNode mergeSort(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode list1 = head;
		ListNode list2 = slow.next;
		slow.next = null;
		list1 = mergeSort(list1);
		list2 = mergeSort(list2);
		return mergeList(list1, list2);
	}
	
	// 获得链表中间值 1-2-3-4-5-6
	static ListNode middleNode(ListNode head){
		if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	
	// 合并排序链表
	public static ListNode mergeList(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		if (list1.val < list2.val) {
			list1.next = mergeList(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeList(list1, list2.next);
			return list2;
		}
	}

	// 删除链表中重复节点1 删除重复元素 1 2 2 3 3 3 4 5 null ==》 1-1-2-3-4-5-null
	static ListNode deleteMuNode(ListNode head) {
		if(head == null) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode res = dummy;
		ListNode cur = dummy;
		while(cur != null && cur.next != null) {
			if(cur.next.val != cur.val) {
				res.next = cur.next;
				res = res.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
	
	// 删除链表中重复节点2： 1 1 2 2 3 3 3 4 5 null ==》4-5-null
	static ListNode deleteMuNode2(ListNode head) {
		if(head == null) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode res = dummy;
		ListNode cur = dummy;
		while(cur != null && cur.next != null) {
			if(cur.next.val != cur.val) {
				if(cur.next.next == null || cur.next.next.val != cur.next.val) {
					res.next = cur.next;
					res = res.next;
				}
			}
			cur = cur.next;
		}
		return dummy.next;
	}
	
	
}
