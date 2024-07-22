/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;

/**
 *
 * @author Cuong
 */
public class NhaPhanPhoi {
    private String MaNPP;
    private String TenNPP;
    private String SDT;
    private String DiaChi;
    private String Email;

    public NhaPhanPhoi() {
    }

    public NhaPhanPhoi(String MaNPP, String TenNPP, String SDT, String DiaChi, String Email) {
        this.MaNPP = MaNPP;
        this.TenNPP = TenNPP;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.Email = Email;
    }



    public String getMaNPP() {
        return MaNPP;
    }

    public void setMaNPP(String MaNPP) {
        this.MaNPP = MaNPP;
    }

    public String getTenNPP() {
        return TenNPP;
    }

    public void setTenNPP(String TenNPP) {
        this.TenNPP = TenNPP;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}

