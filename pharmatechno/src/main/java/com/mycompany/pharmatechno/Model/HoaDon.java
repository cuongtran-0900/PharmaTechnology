/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;

import java.sql.Timestamp;


/**
 *
 * @author Cuong
 */
public class HoaDon {

    private String MaHD;
    private Timestamp thoiGian;
    private String MaNV;
    private String MaKH;
     private String TenThuoc;
    private float tongTien;
    private String tenKH;
    private int donGia;
    private int soLuong;
    
    public HoaDon() {

    }

    public HoaDon(String MaHD, Timestamp thoiGian, String MaNV, String MaKH, String TenThuoc, float tongTien, String tenKH, int donGia, int soLuong) {
        this.MaHD = MaHD;
        this.thoiGian = thoiGian;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.TenThuoc = TenThuoc;
        this.tongTien = tongTien;
        this.tenKH = tenKH;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
        
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenThuoc() {
        return TenThuoc;
    }

    public void setTenThuoc(String TenThuoc) {
        this.TenThuoc = TenThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
   

  
}
