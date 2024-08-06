/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;

/**
 *
 * @author Cuong
 */
public class GiohangBean {

    private String MaHD;
    private String ThoiGian;
    private String TenNV;
    private String TenThuoc;
    private int SoLuong;
    private int DonGia;
    private int ThanhTien;
    private int TongTien;

    // Constructor mặc định
    public GiohangBean() {
    }

    // Constructor với tất cả các tham số
    public GiohangBean(String MaHD, String ThoiGian, String TenNV, int TongTien, String TenThuoc, int SoLuong, int DonGia, int ThanhTien) {
        this.MaHD = MaHD;
        this.ThoiGian = ThoiGian;
        this.TenNV = TenNV;
        this.TongTien = TongTien;
        this.TenThuoc = TenThuoc;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
    }

    // Các phương thức getter và setter
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
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

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
}
