package basic.string;

//String �ڴ��������
public class Test {

	public static String appendStr(String str) {
		str += "!!!";
		return str;
	}
	
	public static void main(String[] args) {
		String s = "a";
		String b = Test.appendStr(s);
		System.out.println(b);
	}
	
}
