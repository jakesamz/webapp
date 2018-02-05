package com.linjw.business.utils;

import net.sf.json.JSONObject;

/**
 * 返回处理结果，判断两种情况，处理结果是true还是false。特别�?�合ajax使用�?
 * @author Administrator
 *
 */
public class Result {
	/**
	 * 成功或�?�失败�?�true or false.
	 */
	@Deprecated
	private boolean success;
	
	/**
	 * true or false Flag比success含义上更普遍。用作标记�?�有时�?�用来代替success字段。某些业务情境下用success不合�?.比如判断用户角色是否是xxx
	 */
	private boolean flag;
	
	//处理或验证返回信�?
	private String msg;
	
	public Result(){
	}
	
	public Result(boolean flag, String msg){
		this.flag = flag;
		this.msg = msg;
	}
	
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		JSONObject obj = JSONObject.fromObject(this);
		return obj.toString();
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
