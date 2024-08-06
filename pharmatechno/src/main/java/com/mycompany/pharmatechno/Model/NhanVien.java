/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;

/**
 *
 * @author Cuong
 */
public class NhanVien {
     private TaiKhoanNhanVien taiKhoanNhanVien;
    
    private String MaNV;
    private String TenNV;
    private String TuoiNV;
    private String SDT;
    private String Email;
    private String GioiTinh;
    private String DiaChi;
    private String Roll;
    private String UserName;
    private String PassWord;
    
    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, String TuoiNV, String SDT, String Email, String GioiTinh, String DiaChi, String Roll, String UserName, String PassWord) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.TuoiNV = TuoiNV;
        this.SDT = SDT;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Roll = Roll;
        this.UserName = UserName;
        this.PassWord = PassWord;
    }


    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getTuoiNV() {
        return TuoiNV;
    }

    public void setTuoiNV(String TuoiNV) {
        this.TuoiNV = TuoiNV;
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

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String Roll) {
        this.Roll = Roll;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
      public TaiKhoanNhanVien getTaiKhoanNhanVien() {
        return taiKhoanNhanVien;
    }

    public void setTaiKhoanNhanVien(TaiKhoanNhanVien taiKhoanNhanVien) {
        this.taiKhoanNhanVien = taiKhoanNhanVien;
    }
    
}
