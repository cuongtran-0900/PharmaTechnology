package com.mycompany.pharmatechno.Model;

import java.sql.Date;

public class Thuoc {
    private String maThuoc;
    private String tenThuoc;
    private String hinhAnh;
    private String thanhPhan;
    private int soLuongTon;
    private float giaNhap;
    private float donGia;
    private Date ngaySanXuat;
    private Date hanSuDung;
    private String donViTinh;
    private String loaiThuoc;
    private String xuatXu;
    private String barcode;  // Thêm thuộc tính barcode

    public Thuoc() {
    }

    public Thuoc(String maThuoc, String tenThuoc, String hinhAnh, String thanhPhan, int soLuongTon, float giaNhap, float donGia, Date ngaySanXuat, Date hanSuDung, String donViTinh, String loaiThuoc, String xuatXu, String barcode) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.hinhAnh = hinhAnh;
        this.thanhPhan = thanhPhan;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.donGia = donGia;
        this.ngaySanXuat = ngaySanXuat;
        this.hanSuDung = hanSuDung;
        this.donViTinh = donViTinh;
        this.loaiThuoc = loaiThuoc;
        this.xuatXu = xuatXu;
        this.barcode = barcode;  // Gán giá trị barcode trong constructor
    }

    // Getter và Setter cho thuộc tính barcode
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(String loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }
}


