package com.ryan.wangbw.retrofit;


/**
 * API返回基类
 * @author LILONGFEI
 *
 */
public class BaseResponse<T> {

	private int ret;
	private String msg;
	private T data;
	public int time;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BaseResponse{" +
				"ret=" + ret +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
