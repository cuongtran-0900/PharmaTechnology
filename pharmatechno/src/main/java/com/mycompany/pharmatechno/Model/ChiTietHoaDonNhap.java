
package com.mycompany.pharmatechno.Model;

/**
 *
 * @author Cuong
 */
public class ChiTietHoaDonNhap {
    private String MaThuoc;
    private String tenThuoc;
    private int soLuong;
    private int giaNhap;
    private int ThanhTien;

    public ChiTietHoaDonNhap() {
    }

    public ChiTietHoaDonNhap(String MaThuoc, String tenThuoc, int soLuong, int giaNhap, int ThanhTien) {
        this.MaThuoc = MaThuoc;
        this.tenThuoc = tenThuoc;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.ThanhTien = ThanhTien;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(String MaThuoc) {
        this.MaThuoc = MaThuoc;
    }


}

