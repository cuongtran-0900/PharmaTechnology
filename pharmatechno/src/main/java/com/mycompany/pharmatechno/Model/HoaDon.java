
package com.mycompany.pharmatechno.Model;

import java.sql.Timestamp;

public class HoaDon {
    
    private String TenThuoc;
    private int SoLuong;
    private float DonGia;
    private float TongTien;
    private String MaHD;
    private Timestamp thoiGian;
    private float ThanhTien;
    private float TongTienNgay;
    private String TenNV;

    public HoaDon() {
    }

    public HoaDon(String TenThuoc, int SoLuong, float DonGia, float TongTien, String MaHD, Timestamp thoiGian, float ThanhTien, float TongTienNgay, String TenNV) {
        this.TenThuoc = TenThuoc;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.TongTien = TongTien;
        this.MaHD = MaHD;
        this.thoiGian = thoiGian;
        this.ThanhTien = ThanhTien;
        this.TongTienNgay = TongTienNgay;
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

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
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

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public float getTongTienNgay() {
        return TongTienNgay;
    }

    public void setTongTienNgay(float TongTienNgay) {
        this.TongTienNgay = TongTienNgay;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }
    
    
}
