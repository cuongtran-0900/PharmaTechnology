/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.ChiTietHoaDonNhap;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.HoaDonNhap;
import com.mycompany.pharmatechno.UI.HoaDonNhapUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class HoaDonNhapDao extends ConnectSQL {

    List<HoaDonNhap> dshdn = new ArrayList<>();
    List<HoaDonNhap> dshdnls = new ArrayList<>();

    public List<HoaDonNhap> filltoArrayList() {
        try {
            String sql
                    = """
                SELECT hdn.maHDN,hdn.MaNPP,hdn.NguoiGiao,hdn.NguoiNhan,hdn.NgayViet,hdn.NgayNhap,hdn.TongTien, t.MaThuoc, t.TenThuoc
                FROM hoadonnhap AS hdn
                INNER JOIN chitiethoadonnhap AS cthdn ON hdn.MaHDN = cthdn.MaHDN
                INNER JOIN Thuoc AS t ON t.MaThuoc = cthdn.MaThuoc
                where hdn.IsDelete = 1;
                """;
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                dshdn.clear();
                while (rs.next()) {
                    HoaDonNhap hdn = new HoaDonNhap();
                    hdn.setMaHDN(rs.getString("MaHDN"));
                    hdn.setMaNPP(rs.getString("MaNPP"));                 
                    hdn.setNguoiGiao(rs.getString("nguoiGiao"));
                    hdn.setNguoiNhan(rs.getString("nguoiNhan"));
                    hdn.setNgayViet(rs.getDate("ngayViet"));
                    hdn.setNgayNhap(rs.getDate("ngayNhap"));
                    hdn.setTongTien(rs.getFloat("tongTien"));
                    hdn.setTenThuoc(rs.getString("TenThuoc"));
                    hdn.setMaThuoc(rs.getString("MaThuoc"));
                    dshdn.add(hdn);
                }
                rs.close();
                st.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dshdn;
    }
        
   public List<HoaDonNhap> filltoArrayList2() {
    List<HoaDonNhap> dshdnls = new ArrayList<>(); // Tạo danh sách mới nếu chưa có

    String sql = """
                  SELECT hdn.MaHDN, hdn.MaNPP, t.TenThuoc, cthdn.Soluong, hdn.NgayNhap, hdn.TongTien
                  FROM hoadonnhap AS hdn
                  INNER JOIN chitiethoadonnhap AS cthdn ON hdn.MaHDN = cthdn.MaHDN
                  INNER JOIN Thuoc AS t ON t.MaThuoc = cthdn.MaThuoc
                  WHERE hdn.IsDelete = 1;
                  """;
    
    try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
        dshdnls.clear(); // Xóa dữ liệu cũ nếu có
        
        while (rs.next()) {
            HoaDonNhap hdn = new HoaDonNhap();
            ChiTietHoaDonNhap cthdn = new ChiTietHoaDonNhap();
            hdn.setMaHDN(rs.getString("MaHDN"));
            hdn.setMaNPP(rs.getString("MaNPP"));
            hdn.setTenThuoc(rs.getString("TenThuoc"));
            cthdn.setSoLuong(rs.getInt("Soluong")); // Đảm bảo rằng tên cột chính xác
            hdn.setNgayNhap(rs.getDate("NgayNhap")); // Đảm bảo rằng tên cột chính xác
            hdn.setTongTien(rs.getFloat("TongTien")); // Đảm bảo rằng tên cột chính xác
            dshdnls.add(hdn);
        }
    } catch (SQLException ex) {
        Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, "SQL Error", ex);}
    return dshdnls;
   }
}
   
   
   
   
   
  


    
    

