/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;
import java.sql.Timestamp;


/**
 *
 * @author acer to you
 */
public class DoanhThuModel {
    private Timestamp ThoiGian;
    private String TenThuoc;
    private int SoLuong;
    private float TongTien;

    public DoanhThuModel() {
    }

    public DoanhThuModel(Timestamp ThoiGian, String TenThuoc, int SoLuong, float TongTien) {
        this.ThoiGian = ThoiGian;
        this.TenThuoc = TenThuoc;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
    }

    public Timestamp getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Timestamp ThoiGian) {
        this.ThoiGian = ThoiGian;
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

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }
    
}
