package com.mypro.resultHandle;

public enum ReturnCode {
    RC200(200,"操作成功"),
    RC500(500,"操作失败"),
    RC401(401,"权限不足"),
    RC400(400,"前台问题"),
    RC301(301,"好友权限不足");
//    RC402(402,);;
    private final int code;
    private final String msg;
    ReturnCode(int code,String msg){
        this.code=code;
        this.msg = msg;
    }
    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
