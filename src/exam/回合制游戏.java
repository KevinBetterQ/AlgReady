package exam;

import java.util.*;

public class �غ�����Ϸ {

	public static int func(int hp, int normalAttack, int buffedAttack) {
        int res = 0;
        /**
         * ���buffedAttack > 2 * normalAttack����ôһ������ʹ��buffedAttack����
         */
        if (buffedAttack > 2 * normalAttack) {
            res = hp % buffedAttack;
            /**
             * ���hp % normalAttack > 0
             * ������С��normalAttack�����һ�غ���normalAttack����ɱ������
             * ���������һֱʹ��buffedAttack����
             */
            if (res > 0 && res <= normalAttack) {
                res = (hp / buffedAttack) * 2 + 1;
            } else {
                res = ((hp - 1) / buffedAttack) * 2 + 2;
            }
        } else {
            /**
             * ���buffedAttack <= 2 * normalAttack��һֱ���غ���ͨ����������
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
