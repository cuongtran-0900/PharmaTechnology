/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

/**
 *
 * @author tu
 */
public class ChiTietHoaDonNhapDAO {
     private String maHDN;
    private String maThuoc;
    private int soLuong;
    private float giaNhap;

    public ChiTietHoaDonNhapDAO() {
    }

    public ChiTietHoaDonNhapDAO(String maHDN, String maThuoc, int soLuong, float giaNhap) {
        this.maHDN = maHDN;
        this.maThuoc = maThuoc;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }

    public String getMaHDN() {
        return maHDN;
    }

    public void setMaHDN(String maHDN) {
        this.maHDN = maHDN;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }
    
    
}
