/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.NhanVien;
import com.mycompany.pharmatechno.Model.TaiKhoanNhanVien;
import com.mycompany.pharmatechno.UI.DangNhap;
import com.mycompany.pharmatechno.UI.TaiKhoan;
import com.mycompany.pharmatechno.UI.main;
import javax.swing.JOptionPane;

/**
 *
 * @author hongo
 */
public class LoginControl {
      private TaiKhoanNhanVienDao dao = new TaiKhoanNhanVienDao();
       private TaiKhoanNhanVien currentUser;
       private DangNhap loginFrame;
    private main mainFrame;
    
    public LoginControl(DangNhap loginFrame) {
        this.loginFrame = loginFrame;
        this.mainFrame = new main();
    }
    
   

    public TaiKhoanNhanVien getCurrentUser() {
        return currentUser;
    }
 public void handleLogin(String username, String password) {
    NhanVienDao nvDao = new NhanVienDao();
    NhanVien nhanVien = nvDao.selectByUsername(username);

    if (nhanVien != null && nhanVien.getPassWord().equals(password)) {
        Auth.user = nhanVien;  // Thiết lập thông tin người dùng sau khi đăng nhập
        loginFrame.dispose(); // Đóng frame đăng nhập

        // Tạo và hiển thị MainFrame JFrame
        main mainFrame = new main();
        mainFrame.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(loginFrame, "Tên đăng nhập hoặc mật khẩu không đúng.");
    }
}




    
}
