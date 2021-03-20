package com.jk.game.legend.client.util;

import com.jk.game.legend.model.HttpResponseBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author jk
 * @date 2021/3/13 21:36
 */
@Component
public class HttpUtil {

    private static final String ADDRESS = "127.0.0.1";
    private static final Integer PORT = 8083;

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

}
