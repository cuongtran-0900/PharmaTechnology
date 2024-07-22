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
   private String maNPP;
   private String tenNPP;
   private String dienThoai;
   private String diaChi;
   private String email;

    public NhaPhanPhoi() {
    }

    public NhaPhanPhoi(String maNPP, String tenNPP, String dienThoai, String diaChi, String email) {
        this.maNPP = maNPP;
        this.tenNPP = tenNPP;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getMaNPP() {
        return maNPP;
    }

    public void setMaNPP(String maNPP) {
        this.maNPP = maNPP;
    }

    public String getTenNPP() {
        return tenNPP;
    }

    public void setTenNPP(String tenNPP) {
        this.tenNPP = tenNPP;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}

