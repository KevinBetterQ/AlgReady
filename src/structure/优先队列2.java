package structure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/*
 * ���뷽����offer()��poll()��remove() ��add() ������ʱ�临�Ӷ�ΪO(log(n)) ��
	remove(Object) �� contains(Object) ʱ�临�Ӷ�ΪO(n)
        ���Դ�ͷ����С���ѵĹ�����  O(nlog(n)) ��
   ���ǣ����ֻ�ǵ���һ�������ΪС���ѣ����Ӷ��� O(n)
 */

public class ���ȶ���2{        
    public static void main(String args[]){  
    	
        /*PriorityQueue<People> queue = new PriorityQueue<People>(11, new Comparator<People>() {  
            public int compare(People p1, People p2) {  
                return p2.age - p1.age;  
              }  
          });       
              
        for (int i = 1; i <= 10; i++) {  
            queue.add(new People("��"+ i, (new Random().nextInt(100))));  
        }  
        while (!queue.isEmpty()) {  
              System.out.println(queue.poll().toString());  
        }  */
    }  
}  
  
class People {   
    String name;  
    int age;  
    public People(String name, int age){  
        this.name = name;  
        this.age = age;  
    }      
    public String toString() {  
        return "������"+name + " ���䣺" + age;  
    }  
}