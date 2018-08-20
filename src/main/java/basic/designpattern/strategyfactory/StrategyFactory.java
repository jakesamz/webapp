package basic.designpattern.strategyfactory;

public class StrategyFactory {
	
	public static PayStrategy getStrategy(String strategyType) throws Exception {
		
		//return (PayStrategy) Class.forName(PayEnum.valueOf(strategyType).getClassName()).newInstance();
		//Class parameterTypes = [];
		return (PayStrategy) Class.forName(PayEnum.valueOf(strategyType).getClassName())
				.getConstructor(new Class[] {}).newInstance(new Object[] {});
		
	}
	

}
