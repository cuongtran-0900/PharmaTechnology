/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;

/**
 *
 * @author acer to you
 */
public class ThuocTonKhoModel {
    private String MaThuoc;
    private String TenThuoc;
    private int SoLuongTon;

    public ThuocTonKhoModel() {
    }

    public ThuocTonKhoModel(String MaThuoc, String TenThuoc, int SoLuongTon) {
        this.MaThuoc = MaThuoc;
        this.TenThuoc = TenThuoc;
        this.SoLuongTon = SoLuongTon;
    }

    public String getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(String MaThuoc) {
        this.MaThuoc = MaThuoc;
    }

    public String getTenThuoc() {
        return TenThuoc;
    }

    public void setTenThuoc(String TenThuoc) {
        this.TenThuoc = TenThuoc;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }
    
}
