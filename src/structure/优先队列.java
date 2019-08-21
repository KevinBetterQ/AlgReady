package structure;

import java.util.*;

public class ���ȶ��� {

	public static void PrintPr(Queue<?> queue){
		while(queue.peek()!=null){
			System.out.print(queue.remove()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
		
		
		//���ȼ����д����������
		Random random=new Random(47);
		for(int i=0;i<10;i++){
			priorityQueue.offer(random.nextInt(i+10));
		}
		PrintPr(priorityQueue);
		////
		List<Integer> ints=Arrays.asList(25,22,20,18,14,9,3,1,1,2,3,9,2,5,1,5,25,30,0,10);
		priorityQueue.addAll(ints);
		PrintPr(priorityQueue);
		
		priorityQueue=new PriorityQueue<Integer>(ints.size(),Collections.reverseOrder());
		priorityQueue.addAll(ints);
		PrintPr(priorityQueue);
		
		//���ȼ����д���ַ�
		String fact="UDJKKDJL WSAPLMAD IUJSAA ATHSHJ";
		List<String> list=Arrays.asList(fact.split(""));
		PriorityQueue<String> priorityQueueStrings=new PriorityQueue<String>(list);
		PrintPr(priorityQueueStrings);
		
		priorityQueueStrings=new PriorityQueue<String>(list.size(),Collections.reverseOrder());
		priorityQueueStrings.addAll(list);
		PrintPr(priorityQueueStrings);
		
		//setȥ��������
		Set<Character> set=new HashSet<Character>();
		for(char c:fact.toCharArray()){
			set.add(c);
		}
		PriorityQueue<Character> pQCharacters=new PriorityQueue<Character>(set);
		PrintPr(pQCharacters);
		
		
		
		
	}

}


