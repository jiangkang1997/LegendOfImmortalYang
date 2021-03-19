package com.jk.game.legend.client.util;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author jk
 * @date 2021/3/13 21:36
 */
@Component
public class HttpUtil {

    private static final String ADDRESS = "127.0.0.1";
    private static final Integer PORT = 8083;
    private static final String LOGIN = "/user/login";
    private static final String REGISTER = "/user/register";

    private List<String> cookies;
    private RestTemplate restTemplate = new RestTemplate();


    public HttpResponseBuilder doPost(String path, MultiValueMap values){
        String url = "http://" + ADDRESS + ":" + PORT + path;
        HttpHeaders httpHeaders = new HttpHeaders();
        if(cookies != null){
            httpHeaders.put(HttpHeaders.COOKIE, cookies);
        }
        HttpEntity httpEntity = new HttpEntity<>(values, httpHeaders);
        ResponseEntity<HttpResponseBuilder> response = restTemplate.postForEntity(url,httpEntity,HttpResponseBuilder.class);
        cookies = response.getHeaders().get("Set-Cookie");
        return response.getBody();
    }


    /**
     * 请求后端的注册服务
     * @param userName
     * @param password
     * @return
     */
    public static HttpResponseBuilder register(String userName,String password){
        String url = "http://" + ADDRESS + ":" + PORT + REGISTER;
        RestTemplate restTemplate = new RestTemplate();
        //这里就是拼接请求的参数
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("userName", userName);
        requestEntity.add("password", password);
        //第三个参数表示把服务返回的json字符串转换成该类的对象
        ResponseEntity<HttpResponseBuilder> response = restTemplate.postForEntity(url, requestEntity, HttpResponseBuilder.class);
        return response.getBody();
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
        //第三个参数表示把服务返回的json字符串转换成该类的对象
        ResponseEntity<HttpResponseBuilder> response = restTemplate.postForEntity(url, requestEntity, HttpResponseBuilder.class);
        return response.getBody();
    }
}
