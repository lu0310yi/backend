package com.mypro.exception;

import com.mypro.resultHandle.ResultData;
import com.mypro.resultHandle.ReturnCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ServiceExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResultData handle(ServiceException se){
        return ResultData.fail(se.getCode(),se.getMessage());
    }

}
