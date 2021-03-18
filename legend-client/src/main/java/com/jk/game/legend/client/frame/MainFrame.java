package com.jk.game.legend.client.frame;
import com.jk.game.legend.client.service.UserService;
import com.jk.game.legend.client.util.SpringUtil;
import com.jk.game.legend.model.HttpResponseBuilder;

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
        label.setBounds(500,200,1000,100);
        label.setFont(new Font("Default", Font.BOLD,100));
        label.setText("阳阳仙侠传");

        JTextField idTxt=new JTextField();
        JPasswordField passwordTxt=new JPasswordField();
        JLabel idJbutton = new JLabel("账号:");
        JLabel passwordJbutton = new JLabel("密码:");
        idJbutton.setBounds(600,400,70,25);
        passwordJbutton.setBounds(600,450,70,25);
        idTxt.setBounds(670,400,230,25);
        passwordTxt.setBounds(670,450,230,25);
        add(idJbutton);
        add(passwordJbutton);
        add(idTxt);
        add(passwordTxt);

        JButton registerButton = new JButton("注册");
        JButton startButton = new JButton("登录");
        startButton.setBounds(800,500,100,30);
        registerButton.setBounds(600,500,100,30);
        add(registerButton);
        add(startButton);

        UserService userService = SpringUtil.getBean(UserService.class);


        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (idTxt.getText().length()>8){
                    JOptionPane.showMessageDialog(null, "您输入的账号不合法，长度必须<=8");
                    return;
                }else if (passwordTxt.getText().length()>20){
                    JOptionPane.showMessageDialog(null, "您输入的密码不合法，长度必须<=20");
                    return;
                }
                HttpResponseBuilder response = userService.register(idTxt.getText(), passwordTxt.getText());
                if (response.getCode()==0){
                    JOptionPane.showMessageDialog(null, "注册成功");
                }else if (response.getCode()==-1){
                    JOptionPane.showMessageDialog(null, response.getMessage());
                }
            }
        });
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (idTxt.getText().length()>8){
                    JOptionPane.showMessageDialog(null, "您输入的账号不合法，长度必须<=8");
                    return;
                }else if (passwordTxt.getText().length()>20){
                    JOptionPane.showMessageDialog(null, "您输入的密码不合法，长度必须<=20");
                    return;
                }
                HttpResponseBuilder response = userService.login(idTxt.getText(), passwordTxt.getText());
                if (response.getCode()==0){
                    JOptionPane.showMessageDialog(null, "登录成功");
                    setVisible(false);
                    JFrame mainFrame = new JFrame();
                    mainFrame.setBounds(100,100,1500,750);
                    mainFrame.setVisible(true);
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setLayout(null);
                }else if (response.getCode()==-1){
                    JOptionPane.showMessageDialog(null, response.getMessage());
                }
            }
        });
    }
}
