package com.mycompany.pharmatechno.Model;

import java.sql.Timestamp;

public class ThongKeModel {
    private Timestamp ThoiGian;
    private float tongTien;

    public ThongKeModel() {
    }

    public ThongKeModel(Timestamp ThoiGian, float tongTien) {
        this.ThoiGian = ThoiGian;
        this.tongTien = tongTien;
    }

    public Timestamp getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Timestamp ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
}


