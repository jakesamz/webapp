package basic.designpattern.strategyfactory;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
		String payStrategyParam = "ALIPAY";//Param from front end
		
		PayStrategy strategy = StrategyFactory.getStrategy(payStrategyParam);
		strategy.pay(12);
		
		payStrategyParam = "WECHATPAY";//Param from front end
		
		strategy = StrategyFactory.getStrategy(payStrategyParam);
		strategy.pay(12);
		
		payStrategyParam = "EBANKPAY";//Param from front end
		
		strategy = StrategyFactory.getStrategy(payStrategyParam);
		strategy.pay(12);
		
		if(payStrategyParam == "ALIPAY") {
			//...a bunch of code here
			System.out.println("pay with alipay: " + 12);
		}else
		if(payStrategyParam == "WECHATPAY") {
			//...a bunch of code here
			System.out.println("pay with wechatpay: " + 12);
		}else
		if(payStrategyParam == "EBANKPAY") {
			//...a bunch of code here
			System.out.println("pay with ebankpay: " + 12);
		}
		
	}

}
/**
ʵ����Ŀ�о�����������Ҫʹ��if..elseif�ķ�֧�жϣ�
����д������һЩ���⣬
��һ��һ����֧��̫�࣬�߼����ӣ��ᵼ�´���ʮ���߳��������Ķ��Ѷȣ�
�ڶ��������Ҫ���ӻ���ٷ�֧����Ҫ�Ķ�if...elseif�����������ա�Υ���˿���ԭ��
���ֱִɣ���ª�Ĵ��������ǲ��ܽ��ܵġ�

����⣬����ķ����ǣ����ǿ���ͨ������ģʽ+����ģʽ����������÷�����ƺ�ö�����valueof��������ܵ�if...elseif����д�������ı׶ˡ�����ͨ��һ���������ʵ���������������������
 */