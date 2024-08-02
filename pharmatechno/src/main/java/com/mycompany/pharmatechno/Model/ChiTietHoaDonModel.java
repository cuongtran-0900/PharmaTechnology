
package com.mycompany.pharmatechno.Model;

/**
 *
 * @author Cuong
 */
public class ChiTietHoaDonModel {
    private String MaHD;
    private String MaThuoc;
    private int SoLuong;
    private float DonGia;

    public ChiTietHoaDonModel() {
    }

    public ChiTietHoaDonModel(String MaHD, String MaThuoc, int SoLuong, float DonGia) {
        this.MaHD = MaHD;
        this.MaThuoc = MaThuoc;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(String MaThuoc) {
        this.MaThuoc = MaThuoc;
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
    
}
