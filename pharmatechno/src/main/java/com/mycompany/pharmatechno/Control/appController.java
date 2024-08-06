/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.UI.Chao;
import com.mycompany.pharmatechno.UI.DangNhap;
import com.mycompany.pharmatechno.UI.main;
import javax.swing.Timer;

/**
 *
 * @author hongo
 */
    
public class appController {

    private DangNhap loginFrame;
    private main mainFrame;
    public void showChao() {
        Chao chaoFrame = new Chao();
        chaoFrame.setVisible(true);
        
        // Tạo một Timer để ẩn màn hình chào sau một khoảng thời gian
        new Timer(2000, e -> {
            chaoFrame.dispose(); // Ẩn màn hình chào
            showLogin();
        }).start();
    }

     public void showLogin() {
        // Chỉ tạo và hiển thị DangNhap nếu chưa được tạo
        if (loginFrame == null) {
            loginFrame = new DangNhap();
            loginFrame.setLoginCallback(success -> {
                if (success) {
                    // Ẩn frame đăng nhập và hiển thị frame chính
                    loginFrame.dispose();
                    showMainFrame();
                } else {
                    // Không làm gì nếu đăng nhập thất bại
                }
            });
            loginFrame.setVisible(true);
        }
    }

    public void showMainFrame() {
        if (mainFrame == null) {
            mainFrame = new main();
        }
        mainFrame.setVisible(true);
    }
}

