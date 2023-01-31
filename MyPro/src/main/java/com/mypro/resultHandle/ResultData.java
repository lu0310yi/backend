package com.mypro.resultHandle;

import lombok.Data;

@Data
public class ResultData<T> {
    private int code;
    private String msg;
    private T data;
    private Long timestamp;
    public ResultData(){
        this.timestamp=System.currentTimeMillis();
    }
    public static <T> ResultData<T> success(T data){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCode.RC200.getCode());
        resultData.setMsg(ReturnCode.RC200.getMsg());
        resultData.setData(data);
        return resultData;
    }
    public static <T> ResultData<T> success(){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCode.RC200.getCode());
        resultData.setMsg(ReturnCode.RC200.getMsg());
        resultData.setData(null);
        return resultData;
    }
    public static <T> ResultData<T> fail(){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCode.RC500.getCode());
        resultData.setMsg(ReturnCode.RC500.getMsg());
        return resultData;
    }
    public static <T> ResultData<T> fail(int code,String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }
}
