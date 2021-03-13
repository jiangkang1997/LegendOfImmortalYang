package com.jk.game.legend.client.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author jk
 * @date 2021/3/13 21:36
 */
public class HttpUtil {

    private static final String ADDRESS = "127.0.0.1";
    private static final Integer PORT = 8083;
    private static final String CONNECTION = "/test/connection";

    public static String connectionTest(){
        String url = "http://" + ADDRESS + ":" + PORT + CONNECTION;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
