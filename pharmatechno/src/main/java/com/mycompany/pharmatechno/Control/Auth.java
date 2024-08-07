/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.NhanVien;
import com.mycompany.pharmatechno.Model.TaiKhoanNhanVien;

/**
 *
 * @author hongo
 */

public class Auth {
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVien user = null;

    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear() {
        Auth.user = null;
    }

    /**
     * Kiểm tra xem đăng nhập hay chưa
     */
    public static boolean isLogin() {
        return Auth.user != null;
    }
  public static TaiKhoanNhanVien getTaiKhoanNhanVien() {
        if (user != null) {
            return user.getTaiKhoanNhanVien(); // Hoặc thuộc tính tương tự
        }
        return null;
    }
    /**
     * Kiểm tra xem có phải là admin hay không
     */
    public static boolean isManager() {
        return Auth.isLogin() && "Admin".equals(user.getRoll());
    }
}

