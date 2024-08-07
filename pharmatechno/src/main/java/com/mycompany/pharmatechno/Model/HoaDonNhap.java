/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;

import java.util.Date;
import java.util.List;

public class HoaDonNhap {
    private String maHDN;
    private String maNPP;
    private String nguoiGiao;
    private String nguoiNhan;
    private Date ngayViet;
    private Date ngayNhap;
    private int tongTien;
    private List<ChiTietHoaDonNhap> chiTietHoaDonNhap;

    // Constructor
    public HoaDonNhap() {
    }

    public HoaDonNhap(String maHDN, String maNPP, String nguoiGiao, String nguoiNhan, Date ngayViet, Date ngayNhap, int tongTien, List<ChiTietHoaDonNhap> chiTietHoaDon) {
        this.maHDN = maHDN;
        this.maNPP = maNPP;
        this.nguoiGiao = nguoiGiao;
        this.nguoiNhan = nguoiNhan;
        this.ngayViet = ngayViet;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.chiTietHoaDonNhap = chiTietHoaDon;
    }

    // Getters and Setters
    public String getMaHDN() {
        return maHDN;
    }

    public void setMaHDN(String maHDN) {
        this.maHDN = maHDN;
    }

    public String getMaNPP() {
        return maNPP;
    }

    public void setMaNPP(String maNPP) {
        this.maNPP = maNPP;
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

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public List<ChiTietHoaDonNhap> getChiTietHoaDonNhap() {
        return chiTietHoaDonNhap;
    }

    public void setChiTietHoaDonNhap(List<ChiTietHoaDonNhap> chiTietHoaDon) {
        this.chiTietHoaDonNhap = chiTietHoaDon;
    }

    // Method to add a ChiTietHoaDonNhap object to the list
    public void addChiTietHoaDonNhap(ChiTietHoaDonNhap chiTiet) {
        this.chiTietHoaDonNhap.add(chiTiet);
    }
}

