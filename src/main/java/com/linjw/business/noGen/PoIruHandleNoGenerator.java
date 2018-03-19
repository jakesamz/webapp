/*
 *File Name: YOUR FILE NAME
 *Copyright pccw.com. 2003-2011, All rights reserved.
 *Created by: YOUR  NAME
 *Created Date:  2013-04-22 10:14:34
 */
package com.linjw.business.noGen;

/**
 * <p>閸欐垼鎹ｆ禍鐑樺絹娴溿倕顓搁幍瑙勬 閻㈢喐鍨氭稉锟芥稉顏呮付閺傛壆娈戞径鍕倞閸楁洖褰块敍灞藉絺鐠ц渹姹夐幓鎰唉鐎光剝澹掗惃鍕槱閻炲棜顫哖oIRUHandleRuntimeEvent.java
 * 
 * <p>婢跺嫮鎮婇崡鏇炲娇閺嶇厧绱￠敍娆籄NDLE_NO_PREFIX - YYMM - 4娴ｅ秵绁﹀鏉戝娇 
 * <p>
 * 4娴ｅ秵绁﹀鏉戝娇閻ㄥ嫯顫夐崚娆愭Ц 娴狅拷1瀵拷婵拷 0001,0002,0003
 * 濮ｅ繋閲滈獮缈犲敜娴狅拷0001闁插秵鏌婄粻妤勬崳
 * @param userId
 * @return
 */
public class PoIruHandleNoGenerator  extends AbstractSystemAutoNoGenerator {
	
	/**
	 * IRU-RFS 婢跺嫮鎮婇崡鏇炲娇 閸撳秶绱� 
	 */
	public static final String HANDLE_NO_PREFIX = "RFS";
	
	public String getPrefix() {
		return HANDLE_NO_PREFIX;
	}

	public String getDate() {
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(String.format("%07d", 1));
	}

	public int bits() {
		// TODO Auto-generated method stub
		return 0;
	}

}
