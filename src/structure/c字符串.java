package structure;

/*
 * 字符串常用操作：length()、charAt()、equals()、equalsIgnoreCase()、isEmpty()、String.valueOf()
 * 查找：indexOf()、lastIndexOf()
 * 截取：substring()
 * 分割：split()
 * 替换：replace()、trim()、replaceAll()
 * 转换：toCharArray()、toLowerCase()、toUpperCase() 
 */
/*
 * 字符操作：
 * str.toLowerCase()
 * str.toCharArray()
 * Character.isLetter(ch)
 * Character.toLowerCase(ch)
 * Character.toUpperCase(ch)
 */

public class c字符串 {
	

	public static void main(String[] args) {
		/*
         * 查找子串
         */
        String str1="dwqae12232aebdalf";
        //查找指定字符第一次出现的位置
        int first1=str1.indexOf(97);//参数为字符的ascii码
        //查找指定字符串第一次出现的位置
        int first2=str1.indexOf("12");
        //查找指定字符第一次出现的位置，从索引处开始（包括索引处）
        int first3=str1.indexOf(97, 0);
        //查找指定字符串第一次出现的位置，从索引处开始（包括索引处
        int first4=str1.indexOf("12232",0);
        System.out.println("first1="+first1);
        System.out.println("first1="+first2);
        System.out.println("first1="+first3);
        System.out.println("first1="+first4);
        System.out.println("-------------");
        
        /*
         * 截取字符串
         */
        //从索引处到末尾（包括索引处）
        String substr1=str1.substring(5);
        //指定区间（包含开始索引处，不包括结束索引处）
        String substr2=str1.substring(5, 10);
        System.out.println("substr1="+substr1);
        System.out.println("substr2="+substr2);
        System.out.println("-------------");
        
        /*
         * 分割字符串
         */
        String[] splitstr = str1.split("a");
        for(String s : splitstr) {
        	System.out.print(s + " ");
        }
        System.out.println("-------------");

        /*
         * 其他
         */
        String s1 = "HellO";
        String s2 = "hello";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
	}
}
