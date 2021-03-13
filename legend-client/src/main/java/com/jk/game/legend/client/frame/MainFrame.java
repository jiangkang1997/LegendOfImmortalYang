package com.jk.game.legend.client.frame;

import com.jk.game.legend.client.util.HttpUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 主界面
 * @author jk
 * @date 2021/3/13 21:17
 */
public class MainFrame extends JFrame {

    public MainFrame(){
        setBounds(100,100,1500,750);
        setTitle("阳阳仙侠传");
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel();
        add(label);
        label.setBounds(250,200,1000,100);
        label.setFont(new Font("Default", Font.BOLD,100));
        label.setText("欢迎来到阳阳仙侠传");

        JButton startButton = new JButton("开始游戏");
        add(startButton);
        startButton.setBounds(600,500,300,50);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String response = HttpUtil.connectionTest();
                System.out.println(response);
            }
        });
    }
}
