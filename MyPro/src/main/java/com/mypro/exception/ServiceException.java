package com.mypro.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException{
    private int code;
    public ServiceException(){

    }
    public ServiceException(int code,String msg){
        super(msg);
        this.code=code;
    }
}
