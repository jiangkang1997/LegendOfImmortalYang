package com.jk.game.legend.client;

import com.jk.game.legend.client.config.SpringConfig;
import com.jk.game.legend.client.frame.MainFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jk
 * @date 2021/3/13 21:18
 */
public class Client {

    public static void main(String[] args) {
        //创建Spring上下文（加载bean.xml）
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        new MainFrame();
    }
}
