package algCommon;
import java.util.*;

/*
����
2 5
5 6 10 20 30
4 34
3 35
���
4
0
 */

public class �Զ���������� {
	//����
    public static class Bear {
        int attack; //ս����
        int hungry; //����ֵ
 
        public Bear(int attack, int hungry) {
            this.attack = attack;
            this.hungry = hungry;
        }
    }
 
    //�Ƚ�������ս������������
    public static class descComparator implements Comparator<Bear> {
        public int compare(Bear p1, Bear p2) {
            return p1.attack != p2.attack ? p2.attack - p1.attack : p1.hungry - p2.hungry;
        }
    }
 
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Bear[] pandas = new Bear[n];
        int[] sugar = new int[m];
        for (int i = 0; i < m; i++) {
            sugar[i] = sc.nextInt();
        }
        //�ù�ϣ��֤���ս���ܹ������������
        HashMap<Integer, Bear> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int attack = sc.nextInt();
            int hungry = sc.nextInt();
            pandas[i] = new Bear(attack, hungry);
            map.put(i, pandas[i]);
        }
 
        //��ս����������������
        Arrays.sort(pandas, new descComparator());
        //���Ǹ�������������������
        Arrays.sort(sugar);
 
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (sugar[j] != -1 && pandas[i].hungry - sugar[j] >= 0) {
                    pandas[i].hungry -= sugar[j];
                    sugar[j] = -1; //�����ǽ�����Ϊ-1
                }
            }
        }
        //��ӡ���
        for (int i = 0; i < n; i++) {
            System.out.println(map.get(i).hungry);
        }
    }

}
