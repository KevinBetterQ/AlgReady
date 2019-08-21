package exam;

import java.util.*;

public class 回合制游戏 {

	public static int func(int hp, int normalAttack, int buffedAttack) {
        int res = 0;
        /**
         * 如果buffedAttack > 2 * normalAttack，那么一定优先使用buffedAttack划算
         */
        if (buffedAttack > 2 * normalAttack) {
            res = hp % buffedAttack;
            /**
             * 如果hp % normalAttack > 0
             * 当余数小于normalAttack，最后一回合用normalAttack就能杀死敌人
             * 其它情况，一直使用buffedAttack攻击
             */
            if (res > 0 && res <= normalAttack) {
                res = (hp / buffedAttack) * 2 + 1;
            } else {
                res = ((hp - 1) / buffedAttack) * 2 + 2;
            }
        } else {
            /**
             * 如果buffedAttack <= 2 * normalAttack，一直单回合普通攻击更划算
             */
            res = (hp - 1) / normalAttack + 1;
        }
        return res;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        int normal = sc.nextInt();
        int buffed = sc.nextInt();
        System.out.println(func(hp, normal, buffed));
    }
}
