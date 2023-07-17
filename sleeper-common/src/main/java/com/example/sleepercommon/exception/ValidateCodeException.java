package com.example.sleepercommon.exception;

/**
 * @author zhouxz
 * @date 2023/7/16 21:09
 * @description
 */
public class ValidateCodeException extends Exception{
    private static final long serialVersionUID = 7514854456967620043L;

    public ValidateCodeException(String message){
        super(message);
    }
}
