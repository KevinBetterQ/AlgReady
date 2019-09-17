package structure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/*
 * 插入方法（offer()、poll()、remove() 、add() 方法）时间复杂度为O(log(n)) ；
	remove(Object) 和 contains(Object) 时间复杂度为O(n)
        所以从头创建小根堆的过程是  O(nlog(n)) 的
   但是，如果只是调整一个数组变为小根堆，复杂度是 O(n)
 */

public class 优先队列2{        
    public static void main(String args[]){  
    	
        /*PriorityQueue<People> queue = new PriorityQueue<People>(11, new Comparator<People>() {  
            public int compare(People p1, People p2) {  
                return p2.age - p1.age;  
              }  
          });       
              
        for (int i = 1; i <= 10; i++) {  
            queue.add(new People("张"+ i, (new Random().nextInt(100))));  
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
        return "姓名："+name + " 年龄：" + age;  
    }  
}