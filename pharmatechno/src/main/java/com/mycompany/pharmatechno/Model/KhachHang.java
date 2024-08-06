/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Model;
import java.sql.Date;

/**
 *
 * @author Cuong
 */
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String Tuoikh;
    private String sdt;
    private String email;
    private String gioiTinh;
    private String diaChi;
    private Date ngayThamGia;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String Tuoikh, String sdt, String email, String gioiTinh, String diaChi, Date ngayThamGia) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.Tuoikh = Tuoikh;
        this.sdt = sdt;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngayThamGia = ngayThamGia;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTuoikh() {
        return Tuoikh;
    }

    public void setTuoikh(String Tuoikh) {
        this.Tuoikh = Tuoikh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(Date ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }




    
}
