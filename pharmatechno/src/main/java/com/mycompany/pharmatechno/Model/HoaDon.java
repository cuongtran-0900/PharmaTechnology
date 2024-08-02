

package com.mycompany.pharmatechno.Model;

import java.sql.Timestamp;


/**
 *
 * @author Cuong
 */
public class HoaDon {
    private String TenThuoc;
    private int SoLuong;
    private float DonGia;
    private String MaHD;
    private Timestamp thoiGian;
    private String MaNV;
    private String MaKH; 
    private float ThanhTien;
private float TongTien;
    public HoaDon() {
    }

    public HoaDon(String TenThuoc, int SoLuong, float DonGia, String MaHD, Timestamp thoiGian, String MaNV, String MaKH, float ThanhTien,float TongTien) {
        this.TenThuoc = TenThuoc;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.MaHD = MaHD;
        this.thoiGian = thoiGian;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.ThanhTien = ThanhTien;
         this.TongTien = TongTien;
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

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }
   

}
