import java.util.*;

import algCommon.自定义类别排序.Bear;
public class Main {
	
	//熊类
    public static class Bear {
        int attack; //战斗力
        int hungry; //饥饿值
 
        public Bear(int attack, int hungry) {
            this.attack = attack;
            this.hungry = hungry;
        }
    }
	
    public static void main(String[] args) {
        Map<Integer, Bear> map = new HashMap<>();
        Bear[] pandas = new Bear[2];
        for(int i = 0; i < 2; i++) {
        	 pandas[i] = new Bear(i, i);
             map.put(i, pandas[i]);
        }
        for(int i = 0; i < 2; i++) {
        	System.out.println(map.get(i).attack);
        }
        pandas[0].attack = 100;
        for(int i = 0; i < 2; i++) {
        	System.out.println(map.get(i).attack);
        }
    }
}