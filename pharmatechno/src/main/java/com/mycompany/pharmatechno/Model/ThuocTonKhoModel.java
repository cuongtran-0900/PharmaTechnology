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
    private int SoLuongNhap;
    private int SoLuongBan;
    private int SoLuongTon;

    public ThuocTonKhoModel() {
    }

    public ThuocTonKhoModel(String MaThuoc, String TenThuoc, int SoLuongNhap, int SoLuongBan, int SoLuongTon) {
        this.MaThuoc = MaThuoc;
        this.TenThuoc = TenThuoc;
        this.SoLuongNhap = SoLuongNhap;
        this.SoLuongBan = SoLuongBan;
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

    public int getSoLuongNhap() {
        return SoLuongNhap;
    }

    public void setSoLuongNhap(int SoLuongNhap) {
        this.SoLuongNhap = SoLuongNhap;
    }

    public int getSoLuongBan() {
        return SoLuongBan;
    }

    public void setSoLuongBan(int SoLuongBan) {
        this.SoLuongBan = SoLuongBan;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }
    
}
