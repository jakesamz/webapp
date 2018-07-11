package basic.switchToFactory.factory;

import basic.switchToFactory.Service.PAY_TYPE;
import basic.switchToFactory.types.Alipay;
import basic.switchToFactory.types.Apple;
import basic.switchToFactory.types.Cash;
import basic.switchToFactory.types.Pay;
import basic.switchToFactory.types.Wechat;

public class PayTypeFactory {
	
	
	
	public static Pay createPayType(String type) {
		
		PAY_TYPE payType = PAY_TYPE.valueOf(type);
		
		switch (payType) {
		case WECHAT:
			return new Wechat();
		case ALIPAY:
			return new Alipay();
		case CASH:
			return new Cash();
		case APPLEPAY:
			return new Apple();
		default:
			return new Cash();
		}
	}
	

}
