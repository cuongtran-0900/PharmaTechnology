/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;

import java.util.Date;

/**
 *
 * @author Cuong
 */
public class HoaDonNhap {
    
    private String MaHDN;   
    private String MaNPP; 
    private String nguoiGiao;
    private String nguoiNhan;
    private Date ngayViet;
    private Date ngayNhap;
    private float tongTien;
    private String MaThuoc;
    private String TenThuoc;
    private int SoLuong;

    public HoaDonNhap() {
    }

    public HoaDonNhap(String MaHDN, String MaNPP, String nguoiGiao, String nguoiNhan, Date ngayViet, Date ngayNhap, float tongTien, String MaThuoc, String TenThuoc, int SoLuong) {
        this.MaHDN = MaHDN;
        this.MaNPP = MaNPP;
        this.nguoiGiao = nguoiGiao;
        this.nguoiNhan = nguoiNhan;
        this.ngayViet = ngayViet;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.MaThuoc = MaThuoc;
        this.TenThuoc = TenThuoc;
        this.SoLuong = SoLuong;
    }

    public String getMaHDN() {
        return MaHDN;
    }

    public void setMaHDN(String MaHDN) {
        this.MaHDN = MaHDN;
    }

    public String getMaNPP() {
        return MaNPP;
    }

    public void setMaNPP(String MaNPP) {
        this.MaNPP = MaNPP;
    }

    public String getNguoiGiao() {
        return nguoiGiao;
    }

    public void setNguoiGiao(String nguoiGiao) {
        this.nguoiGiao = nguoiGiao;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public Date getNgayViet() {
        return ngayViet;
    }

    public void setNgayViet(Date ngayViet) {
        this.ngayViet = ngayViet;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    
}
