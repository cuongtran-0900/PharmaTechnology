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
    private float tongTien;
    private String tenKH;
   
    
    public HoaDon() {

    }

    public HoaDon(String MaHD, Timestamp thoiGian, String MaNV, String MaKH, float tongTien, String tenKH) {
        this.MaHD = MaHD;
        this.thoiGian = thoiGian;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.tongTien = tongTien;
        this.tenKH = tenKH;
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

    
   

  
}
