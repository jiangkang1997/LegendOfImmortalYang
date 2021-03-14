package com.jk.game.legend.client.util;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.model.User;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author jk
 * @date 2021/3/13 21:36
 */
public class HttpUtil {

    private static final String ADDRESS = "127.0.0.1";
    private static final Integer PORT = 8083;
    private static final String CONNECTION = "/test/connection";
    private static final String LOGIN = "/user/login";

    public static String connectionTest(){
        String url = "http://" + ADDRESS + ":" + PORT + CONNECTION;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 请求后端的登录服务
     * @param userName
     * @param password
     * @return
     */
    public static HttpResponseBuilder login(String userName,String password){
        String url = "http://" + ADDRESS + ":" + PORT + LOGIN;
        RestTemplate restTemplate = new RestTemplate();
        //这里就是拼接请求的参数
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("userName", userName);
        requestEntity.add("password", password);
        //第三个参数表示把服务返回的json字符串转换成哪个类的对象
        HttpResponseBuilder response = restTemplate.postForObject(url,requestEntity,HttpResponseBuilder.class);
        return response;
    }
}
