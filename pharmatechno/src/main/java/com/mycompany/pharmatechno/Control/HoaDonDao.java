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
                    SELECT hd.MaHD, hd.manv, hd.makh, t.tenthuoc, hd.thoigian, cthd.soluong, cthd.dongia,
                    cthd.soluong * cthd.dongia AS TongTien
                    FROM hoadon hd
                    INNER JOIN ChiTietHoaDon cthd ON hd.MaHD = cthd.MaHD
                    INNER JOIN thuoc t ON t.MaThuoc = cthd.MaThuoc;
                    """;

            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                dshd.clear();
                while (rs.next()) {
                    HoaDon hd = new HoaDon();
                    hd.setTenThuoc(rs.getString("TenThuoc"));
                    hd.setSoLuong(rs.getInt("SoLuong"));
                    hd.setDonGia(rs.getFloat("dongia"));                  
                    hd.setThanhTien(rs.getFloat("tongtien"));                    

                    

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
                    hd.setThanhTien(rs.getFloat("tongTien"));

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
