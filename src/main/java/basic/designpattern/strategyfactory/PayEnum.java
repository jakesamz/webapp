package basic.designpattern.strategyfactory;

public enum PayEnum {
	
	ALIPAY("AliPay", "basic.designpattern.strategyfactory.Alipay"),
	WECHATPAY("WechatPay", "basic.designpattern.strategyfactory.WechatPay"),
	EBANKPAY("EbankPay", "basic.designpattern.strategyfactory.EbankPay");
	
	PayEnum(String payType, String className) {
		this.setPayType(payType);
		this.setClassName(className);
	}
	
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	private String payType;
	private String className;

}
