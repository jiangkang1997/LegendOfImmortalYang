package com.jk.game.legend.server.common;

/**
 * 自定义业务异常类
 * @author jk
 */
public class BusinessException extends Exception {

    public BusinessException(){
    }

    public BusinessException(String message){
        super(message);
    }

}
