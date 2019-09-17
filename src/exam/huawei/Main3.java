package exam.huawei;
import java.util.*;
public class Main3 {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        String firstp = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<String>> rooms = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < n; i++) {
        	String s = sc.nextLine();
        	//System.out.println(s);
        	String[] sarr = s.split(",");
        	ArrayList<String> persions = new ArrayList<String>();
        	for(int j = 0; j < sarr.length; j++) {
        		persions.add(sarr[j]);
        	}
        	rooms.add(persions);
        }
        /*for(int i = 0; i < n; i++) {
        	ArrayList<String> persions = rooms.get(i);
        	for(int j = 0; j < persions.size(); j++) {
        		System.out.print(persions.get(j) + " ");
        	}
        	System.out.println();
        }*/
        
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<String>();
        q.add(firstp);
        set.add(firstp);
        while(!q.isEmpty()) {
        	String name = q.poll();
        	for(int i = 0; i < n; i++) {
        		ArrayList<String> persions = rooms.get(i);
        		boolean inRoom = false;
        		for(int j = 0; j < persions.size(); j++) {
        			if(persions.get(j).equals(name)){
        				inRoom = true;
        				break;
        			}
            	}
        		if(inRoom) {
        			for(int j = 0; j < persions.size(); j++) {
            			String tmp = persions.get(j);
            			if(!set.contains(tmp)){
                    		q.add(tmp);
                    		set.add(tmp);
                    	}
                	}
        		}
        	}
        	
        }
        if(set.size() == 1) System.out.print(0);
        else System.out.print(set.size());
        
    }
}