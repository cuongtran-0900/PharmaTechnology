/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;

import java.util.Date;


/**
 *
 * @author acer to you
 */
public class ThongTinThanhVien {
    private String MaKH;
    private String TenKH;
    private String Tuoi;
    private String SDT;
    private String Email;
    private String GioiTinh;
    private String DiaChi;
    private Date NgayThamGia;
    
    public ThongTinThanhVien() {
    }
    
    public ThongTinThanhVien(String MaKH, String TenKH, String Tuoi, String SDT, String Email, String GioiTinh, String DiaChi,Date NgayThamGia) {
    this.MaKH = MaKH;
    this.TenKH = TenKH;
    this.Tuoi = Tuoi;
    this.SDT = SDT;
    this.Email = Email;
    this.GioiTinh = GioiTinh;
    this.DiaChi = DiaChi;
    this.NgayThamGia = NgayThamGia;
    }
    
    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getTuoi() {
        return Tuoi;
    }

    public void setTuoi(String Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgayThamGia() {
        return NgayThamGia;
    }

    public void setNgayThamGia(Date NgayThamGia) {
        this.NgayThamGia = NgayThamGia;
    }
        
}

