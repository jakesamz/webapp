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
实际项目中经常会碰到需要使用if..elseif的分支判断，
这种写法带来一些问题，
第一，一旦分支多太多，逻辑复杂，会导致代码十分冗长，增加阅读难度；
第二，如果需要增加或减少分支，需要改动if...elseif，增大出错风险。违背了开闭原则。
这种粗鄙，丑陋的代码是我们不能接受的。

如标题，解决的方法是，我们可以通过策略模式+工厂模式，巧妙地利用反射机制和枚举类的valueof方法，规避掉if...elseif这种写法带来的弊端。我们通过一个付款这个实际例子来理解这种做法。
 */