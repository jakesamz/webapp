package basic.switchToFactory;

import basic.switchToFactory.beans.PayVO;
import basic.switchToFactory.factory.PayTypeFactory;
import basic.switchToFactory.types.Pay;

public class Service {
	
	/*public static final String WEIXIN = "WEIXIN";
	public static final String ALIPAY = "ALIPAY";
	public static final String CASH = "CASH";*/
	
	public enum PAY_TYPE {
		WECHAT, 
		ALIPAY,
		APPLEPAY,
		CASH;
	}
	
	public void pay(String type) {
		
		PAY_TYPE payType = PAY_TYPE.valueOf(type);
		
		switch (payType) {
		case WECHAT:
			payByWechat();
			break;
		case ALIPAY:
			payByAlipay();
			break;
		case CASH:
			payByCash();
			break;
		default:
			break;
		}
		
	}
	
	public void pay2(PayVO payVO) {
		Pay payType = PayTypeFactory.createPayType(payVO.getPayType());
		payType.pay(payVO);
	}

	private void payByCash() {
		// TODO Auto-generated method stub
		System.out.println("pay by cash");
	}

	private void payByAlipay() {
		// TODO Auto-generated method stub
		System.out.println("pay by alipay");
	}

	private void payByWechat() {
		// TODO Auto-generated method stub
		System.out.println("pay by wechat");
	}
	

}
