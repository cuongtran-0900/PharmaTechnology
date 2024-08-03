/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;
import java.time.LocalDateTime;
import java.sql.Timestamp;
/**
 *
 * @author Cuong
 */
public class BanHang {
    private String TenThuoc;
    private String Loai;
    private String DVT;
    private int DonGia;
    private int TonKho;
    
    private String MaThuoc;
    private String MaHD;
    private int TongTien;
    private int Soluong;
    private Timestamp ThoiGian;
    
    private String MaNV;
    
    
    public BanHang() {
    }

    public BanHang(String TenThuoc, String Loai, String DVT, int DonGia, int TonKho, String MaThuoc, String MaHD, int TongTien, int Soluong, Timestamp ThoiGian, String MaNV) {
        this.TenThuoc = TenThuoc;
        this.Loai = Loai;
        this.DVT = DVT;
        this.DonGia = DonGia;
        this.TonKho = TonKho;
        this.MaThuoc = MaThuoc;
        this.MaHD = MaHD;
        this.TongTien = TongTien;
        this.Soluong = Soluong;
        this.ThoiGian = ThoiGian;
        this.MaNV = MaNV;
    }


    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenThuoc() {
        return TenThuoc;
    }

    public void setTenThuoc(String TenThuoc) {
        this.TenThuoc = TenThuoc;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(String MaThuoc) {
        this.MaThuoc = MaThuoc;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public Timestamp getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Timestamp ThoiGian) {
        this.ThoiGian = ThoiGian;
    }
    

    
}
