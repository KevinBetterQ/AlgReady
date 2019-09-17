package structure;

import java.util.LinkedList;  
import java.util.Queue;  
import java.util.Stack;


/*
图的遍历有2种：
一：遍历是为了把整个遍历路径给展示出来
二：遍历是为了遍历到最后有一个判断条件

DFS用递归；BFS用队列

 */

public class 图 {   
	// 和图相关的东西要声明在递归函数外边
    private int number = 9;	// 点的个数 
    private boolean[] flag;	// 点访问Flag
    private String[] vertexs = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };  // 点的值
    private int[][] edges = {   // 边的值
            { 0, 1, 0, 0, 0, 1, 1, 0, 0 }, 
            { 1, 0, 1, 0, 0, 0, 1, 0, 1 }, 
            { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  
            { 0, 0, 1, 0, 1, 0, 1, 1, 1 }, 
            { 0, 0, 0, 1, 0, 1, 0, 1, 0 }, 
            { 1, 0, 0, 0, 1, 0, 1, 0, 0 },  
            { 0, 1, 0, 1, 0, 1, 0, 1, 0 }, 
            { 0, 0, 0, 1, 1, 0, 1, 0, 0 }, 
            { 0, 1, 1, 1, 0, 0, 0, 0, 0 }   
            };  

    void DFSTraverse() {  
        flag = new boolean[number];  
        for (int i = 0; i < number; i++) {  
            if (flag[i] == false) {// 当前顶点没有被访问  
                DFS(i);  
            }  
        }  
    }  

    void DFS(int i) {  
        flag[i] = true;// 第i个顶点被访问  
        System.out.print(vertexs[i] + " ");  
        for (int j = 0; j < number; j++) {  
            if (flag[j] == false && edges[i][j] == 1) {  
                DFS(j);
            }  
        }  
    }  

    void DFS_Map(){
        flag = new boolean[number];
        Stack<Integer> stack =new Stack<Integer>();
        for(int i=0;i<number;i++){
            if(flag[i]==false){
                flag[i]=true;
                System.out.print(vertexs[i]+" ");
                stack.push(i);
            }
            while(!stack.isEmpty()){
                int k = stack.pop();
                for(int j=0;j<number;j++){
                    if(edges[k][j]==1&&flag[j]==false){
                        flag[j]=true;
                        System.out.print(vertexs[j]+" ");
                        stack.push(j);
                        break;
                    }
                }

            }
        }
    }

    void BFS_Map(){
        flag = new boolean[number];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<number;i++){
            if(flag[i]==false){
                flag[i]=true;
                System.out.print(vertexs[i]+" ");
                queue.add(i);
                while(!queue.isEmpty()){
                    int k=queue.poll();
                    for(int j=0;j<number;j++){
                        if(edges[k][j]==1&&flag[j]==false){
                            flag[j] = true;
                            System.out.print(vertexs[j]+" ");
                            queue.add(j);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {  
        图  graph = new 图();  
        System.out.println("DFS递归:");  
        graph.DFSTraverse();
        System.out.println();
        System.out.println("DFS非递归:");  
        graph.DFS_Map();
        System.out.println();  
        System.out.println("BFS非递归:");  
        graph.BFS_Map();
    }  
} 