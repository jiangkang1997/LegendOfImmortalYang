package com.jk.game.legend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jk
 */
@Data
@NoArgsConstructor
public class    HttpResponseBuilder {

    /**
     * 返回码  0：成功  -1：失败
     */
    private Integer code;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 返回消息
     */
    private String message;

    private HttpResponseBuilder(int status, Object data, String message) {
        this.code = status;
        this.data = data;
        this.message = message;
    }

    public static HttpResponseBuilder builderSuccess(){
        return new HttpResponseBuilder(0,null,"success");
    }

    public static HttpResponseBuilder builderSuccess(Object data){
        return new HttpResponseBuilder(0,data,"success");
    }

    public static HttpResponseBuilder builderFail(String message){
        return  new HttpResponseBuilder(-1,null,message);
    }
}
