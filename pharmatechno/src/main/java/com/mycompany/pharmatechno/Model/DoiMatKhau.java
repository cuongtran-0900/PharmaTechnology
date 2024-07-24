package com.mycompany.pharmatechno.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tranp
 */
public class DoiMatKhau { 
    private String MatKhauHienTai;
    private String MatKhauMoi;
    private String XacNhanMatKhauMoi;

    public DoiMatKhau() {
    }

    public DoiMatKhau(String MatKhauHienTai, String MatKhauMoi, String XacNhanMatKhauMoi) {
        this.MatKhauHienTai = MatKhauHienTai;
        this.MatKhauMoi = MatKhauMoi;
        this.XacNhanMatKhauMoi = XacNhanMatKhauMoi;
    }

    public String getMatKhauHienTai() {
        return MatKhauHienTai;
    }

    public void setMatKhauHienTai(String MatKhauHienTai) {
        this.MatKhauHienTai = MatKhauHienTai;
    }

    public String getMatKhauMoi() {
        return MatKhauMoi;
    }

    public void setMatKhauMoi(String MatKhauMoi) {
        this.MatKhauMoi = MatKhauMoi;
    }

    public String getXacNhanMatKhauMoi() {
        return XacNhanMatKhauMoi;
    }

    public void setXacNhanMatKhauMoi(String XacNhanMatKhauMoi) {
        this.XacNhanMatKhauMoi = XacNhanMatKhauMoi;
    }
    
    
   
}
