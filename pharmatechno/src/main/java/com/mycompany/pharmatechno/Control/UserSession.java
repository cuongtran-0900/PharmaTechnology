/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.TaiKhoanNhanVien;

/**
 *
 * @author hongo
 */public class UserSession {
    private static UserSession instance;
    private TaiKhoanNhanVien currentAccount;

    private UserSession() {}

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public TaiKhoanNhanVien getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(TaiKhoanNhanVien currentAccount) {
        this.currentAccount = currentAccount;
    }
}

