package basic.jvm.chapter2;

/**
 * �����ֱ�ӽ��������
 * 1. �ʺ�serial��ParNew�ռ���
 * 2. ������Parallel Scavenge�ռ���
 * 
 * XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
 * or
 * XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC
 * @author Administrator
 *
 */
public class PretenureSize {
	
	private static final int _1MB = 1024*1024;
	
	public static void main(String[] args) {
		
		byte[] allocation1 = new byte[4 * _1MB];
		
	}

}
