/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.HoaDon;
import com.mycompany.pharmatechno.UI.hoadon;
import com.mycompany.pharmatechno.Model.Thuoc;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class HoaDonDao extends ConnectSQL {

    List<HoaDon> dshd = new ArrayList<>();
    List<HoaDon> dshdls = new ArrayList<>();

    public List<HoaDon> filltoArrayList() {
        try {
          String sql = 
                    """
                    SELECT hd.MaHD, hd.MaKH, hd.MaNV, hd.ThoiGian,t.TenThuoc, cthd.Soluong, cthd.Dongia,TongTien = cthd.SoLuong * cthd.DonGia ,TongTienTheoNgay.TongTienNgay
                    FROM HoaDon hd 
                    JOIN KhachHang kh ON hd.MaKH = kh.MaKH
                    JOIN ChiTietHoaDon cthd ON hd.MaHD = cthd.MaHD
                    JOIN Thuoc t ON cthd.MaThuoc = t.MaThuoc
                    JOIN ( SELECT CAST(thoigian AS DATE) AS Ngay,SUM(tongtien) AS TongTienNgay FROM HoaDon WHERE isDelete = 1
                    GROUP BY CAST(thoigian AS DATE))
                    AS TongTienTheoNgay
                    ON CAST(hd.ThoiGian AS DATE) = TongTienTheoNgay.Ngay
                    WHERE hd.isDelete = 1
                    ORDER BY CAST(hd.ThoiGian AS DATE) ASC, hd.MaHD;
                    """;

            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                dshd.clear();
                while (rs.next()) {
                    HoaDon hd = new HoaDon();
                    hd.setMaHD(rs.getString("mahd"));
                    hd.setMaNV(rs.getString("manv"));
                    hd.setThoiGian(rs.getTimestamp("thoigian"));
                    hd.setMaKH(rs.getString("makh"));
//                    hd.setTongTien(rs.getFloat("tongtien"));  
                    hd.setTenThuoc(rs.getString("TenThuoc"));
                    hd.setSoLuong(rs.getInt("SoLuong"));
                    hd.setDonGia(rs.getFloat("dongia"));                  
                    hd.setThanhTien(rs.getFloat("tongtien"));  
                    hd.setTongTienNgay(rs.getFloat("tongtienngay"));
                    dshd.add(hd);
                }
                rs.close();
                st.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(hoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dshd;
    }
    // fillto cho bảng lịch sử hóa đơn

    public List<HoaDon> filltoArrayList2() {
        try {
            String sql = """
                         SELECT HoaDon.MaHD, HoaDon.MaKH, KhachHang.TenKH, HoaDon.ThoiGian, HoaDon.TongTien 
                         FROM HoaDon 
                         JOIN KhachHang ON HoaDon.MaKH = KhachHang.MaKH 
                         WHERE HoaDon.isDelete = 1 
                         ORDER BY HoaDon.MaHD;
                         """;
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                dshdls.clear();
                while (rs.next()) {
                    HoaDon hd = new HoaDon();
                    hd.setMaHD(rs.getString("MaHD"));
                    hd.setMaKH(rs.getString("MaKH"));                  
                    hd.setThoiGian(rs.getTimestamp("thoiGian"));
                    hd.setTongTien(rs.getFloat("tongtien"));

                    dshdls.add(hd);
                }
                rs.close();
                st.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(hoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dshdls;
    }

}
