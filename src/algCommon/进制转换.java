package algCommon;

public class ����ת�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
ʮ����ת��ʮ�����ƣ� 

Integer.toHexString(int i) 

ʮ����ת�ɰ˽��� 

Integer.toOctalString(int i) 

ʮ����ת�ɶ����� 

Integer.toBinaryString(int i) 

ʮ������ת��ʮ���� 

Integer.valueOf("FFFF",16).toString() 

�˽���ת��ʮ���� 

Integer.valueOf("876",8).toString() 

������תʮ���� 

Integer.valueOf("0101",2).toString()

��ʲô��������ֱ�ӽ�2,8,16����ֱ��ת��Ϊ10���Ƶ���

java.lang.Integer�� 

parseInt(String s, int radix)

ʹ�õڶ�������ָ���Ļ��������ַ�����������Ϊ�з��ŵ�������

examples from jdk: 
parseInt("0", 10) returns 0 
parseInt("473", 10) returns 473 
parseInt("-0", 10) returns 0 
parseInt("-FF", 16) returns -255 
parseInt("1100110", 2) returns 102 
parseInt("2147483647", 10) returns 2147483647 
parseInt("-2147483648", 10) returns -2147483648 
parseInt("2147483648", 10) throws a NumberFormatException 
parseInt("Kona", 10) throws a NumberFormatException 
parseInt("Kona", 27) returns 411787

����ת�����д�������ˣ�ʮ���������㷨

Integer.toBinaryString 
Integer.toOctalString 
Integer.toHexString
*/