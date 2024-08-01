
package com.mycompany.pharmatechno.Model;

/**
 *
 * @author Cuong
 */
public class ChiTietHoaDonNhap {
    private String MaHDN;
    private String MaThuoc;
    private int SoLuong;
    private float GiaNhap;

    public ChiTietHoaDonNhap() {
    }
    
    
    
    public ChiTietHoaDonNhap(String MaHDN, String MaThuoc, int SoLuong, float GiaNhap) {
        this.MaHDN = MaHDN;
        this.MaThuoc = MaThuoc;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
    }

    public String getMaHDN() {
        return MaHDN;
    }

    public void setMaHDN(String MaHDN) {
        this.MaHDN = MaHDN;
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

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }
    
    
}
