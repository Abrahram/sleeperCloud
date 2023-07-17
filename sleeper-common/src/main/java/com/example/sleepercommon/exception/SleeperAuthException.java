package com.example.sleepercommon.exception;

/**
 * @author zhouxz
 * @date 2023/7/15 16:55
 * @description
 */
public class SleeperAuthException extends Exception{
    private static final long serialVersionUID = -6916154462432027437L;

    public SleeperAuthException(String message){
        super(message);
    }
}
