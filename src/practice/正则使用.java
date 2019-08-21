package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ����ʹ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ���򷽷�
	public static boolean isIpLegal(String ipStr) {
		// ip��ַ��Χ��(1~255).(0~255).(0~255).(0~255)
		String ipRegEx = "^([1-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))(\\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))){3}$";
		// String ipRegEx =
		// "^([1-9]|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))(\\.(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))){3}$";
		// String ipRegEx =
		// "^(([1-9]\\d?)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))(\\.(0|([1-9]\\d?)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))){3}$";
		Pattern pattern = Pattern.compile(ipRegEx);
		Matcher matcher = pattern.matcher(ipStr);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

}
