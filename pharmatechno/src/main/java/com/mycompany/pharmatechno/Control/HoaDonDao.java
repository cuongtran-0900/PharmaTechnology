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
    List<HoaDon> tblhd = new ArrayList<>();

    public List<HoaDon> filltoArrayList() {
        try {
          String sql = 
                    """
                    select hd.MaHD, hd.thoiGian, nv.Ten, t.TenThuoc, cthd.SoLuong, cthd.DonGia,hd.tongTien, thanhtien = cthd.SoLuong * cthd.DonGia from hoadon as hd inner join ChiTietHoaDon as cthd on hd.MaHD = cthd.MaHD
                    inner join thuoc as t on t.MaThuoc = cthd.MaThuoc
                    inner join NhanVien as nv on nv.MaNV = hd.MaNV 
                    where hd.mahd like 'hd%'
                    order by mahd desc 
                    """;

            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                dshd.clear();
                while (rs.next()) {
                    HoaDon hd = new HoaDon();
                    hd.setMaHD(rs.getString("mahd"));
                    hd.setTenNV(rs.getString("Ten"));
                    hd.setThoiGian(rs.getTimestamp("thoigian"));
                    hd.setTenThuoc(rs.getString("TenThuoc"));
                    hd.setSoLuong(rs.getInt("SoLuong"));
                    hd.setDonGia(rs.getFloat("dongia"));
                    hd.setThanhTien(rs.getFloat("thanhtien"));
                    hd.setTongTien(rs.getFloat("tongtien"));
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

public List<HoaDon> filltoArrayListForTblHD() {
    try {
        String sql = 
                """
                SELECT t.TenThuoc, cthd.SoLuong, cthd.DonGia, 
                                       cthd.SoLuong * cthd.DonGia AS thanhtien
                                FROM hoadon AS hd
                                INNER JOIN ChiTietHoaDon AS cthd ON hd.MaHD = cthd.MaHD
                                INNER JOIN thuoc AS t ON t.mathuoc = cthd.mathuoc
                                WHERE cthd.MaHD = (SELECT MAX(MaHD) FROM ChiTietHoaDon where MaHD like 'hd%')
                """;

        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            tblhd.clear();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setTenThuoc(rs.getString("TenThuoc"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setDonGia(rs.getFloat("DonGia"));
                hd.setThanhTien(rs.getFloat("thanhtien"));
                
                tblhd.add(hd);
            }
            rs.close();
            st.close();
        }

    } catch (SQLException ex) {
        Logger.getLogger(hoadon.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tblhd;
}

    
    
    
    
}
