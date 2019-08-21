package structure;
/*
 * ×Ö·û²Ù×÷£º
 * str.toLowerCase()
 * str.toCharArray()
 * Character.isLetter(ch)
 * Character.toLowerCase(ch)
 * Character.toUpperCase(ch)
 */

public class ×Ö·û {

	public static void main(String[] args) {
		
		String str = "HeLL123o";
		String strLower = str.toLowerCase();
		System.out.println(strLower);
		
		String letters = "";
		
		char[] chrs = str.toCharArray();
		for(int i = 0; i < chrs.length; i++) {
			if(Character.isLetter(chrs[i])) {
				char ch = Character.toLowerCase(chrs[i]);
				letters = letters + ch;
			}
		}
		System.out.println(letters);

	}

}
