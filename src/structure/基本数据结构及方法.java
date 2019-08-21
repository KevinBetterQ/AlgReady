package structure;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 基本数据结构及方法 {
	
	public static void main(String[] args) {
		// MapDemo();
		// QueueDemo();
		// StackDemo();
		 ListDemo();
	}
	
	// Map 遍历
	public static void MapDemo() {
		Map<String, Integer> map = new HashMap<>();
		// Map<String, Integer> map = new TreeMap<>();
		
		map.put("str1", 1);
		map.put("str2", 2);
		map.put("str3", 3);
		map.remove("str2");
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		for(String key : map.keySet()) {
			int value = map.get(key);
			System.out.println(key + ":" +value);
		}
	}
	
	// 数组
	
	// 链表
	public static void ListDemo() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(9);
		list.add(4);
		list.remove(0);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		Collections.reverse(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	// 字符串
	
	// 栈
	public static void StackDemo() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		while( !stack.isEmpty() ) {
			System.out.println(stack.pop());
		}
	}
	
	// 队列
	public static void QueueDemo() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.poll();
		for(Integer x : q) {
			System.out.println(x);
		}
		while (q.peek() != null) {
			System.out.println(q.poll());
		}
	}
	
	// 集合
}
