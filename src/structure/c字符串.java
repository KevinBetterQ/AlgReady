package structure;

/*
 * �ַ������ò�����length()��charAt()��equals()��equalsIgnoreCase()��isEmpty()��String.valueOf()
 * ���ң�indexOf()��lastIndexOf()
 * ��ȡ��substring()
 * �ָsplit()
 * �滻��replace()��trim()��replaceAll()
 * ת����toCharArray()��toLowerCase()��toUpperCase() 
 */
/*
 * �ַ�������
 * str.toLowerCase()
 * str.toCharArray()
 * Character.isLetter(ch)
 * Character.toLowerCase(ch)
 * Character.toUpperCase(ch)
 */

public class c�ַ��� {
	

	public static void main(String[] args) {
		/*
         * �����Ӵ�
         */
        String str1="dwqae12232aebdalf";
        //����ָ���ַ���һ�γ��ֵ�λ��
        int first1=str1.indexOf(97);//����Ϊ�ַ���ascii��
        //����ָ���ַ�����һ�γ��ֵ�λ��
        int first2=str1.indexOf("12");
        //����ָ���ַ���һ�γ��ֵ�λ�ã�����������ʼ��������������
        int first3=str1.indexOf(97, 0);
        //����ָ���ַ�����һ�γ��ֵ�λ�ã�����������ʼ������������
        int first4=str1.indexOf("12232",0);
        System.out.println("first1="+first1);
        System.out.println("first1="+first2);
        System.out.println("first1="+first3);
        System.out.println("first1="+first4);
        System.out.println("-------------");
        
        /*
         * ��ȡ�ַ���
         */
        //����������ĩβ��������������
        String substr1=str1.substring(5);
        //ָ�����䣨������ʼ��������������������������
        String substr2=str1.substring(5, 10);
        System.out.println("substr1="+substr1);
        System.out.println("substr2="+substr2);
        System.out.println("-------------");
        
        /*
         * �ָ��ַ���
         */
        String[] splitstr = str1.split("a");
        for(String s : splitstr) {
        	System.out.print(s + " ");
        }
        System.out.println("-------------");

        /*
         * ����
         */
        String s1 = "HellO";
        String s2 = "hello";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
	}
}
