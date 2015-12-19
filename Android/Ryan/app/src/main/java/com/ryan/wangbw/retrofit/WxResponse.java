package com.ryan.wangbw.retrofit;


/**
 * 实际API返回类
 * @author WEI
 *
 * @param <T>
 */
public class WxResponse<T> {
    private T info;
    private String msg;
    private int code;
    private T events;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getEvents() {
        return events;
    }

    public void setEvents(T events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "WxResponse{" +
              "info=" + info +
              ", msg='" + msg + '\'' +
              ", code=" + code +
              ", events=" + events +
              '}';
    }
}
