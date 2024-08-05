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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tu
 */
public class HoaDonNhapDao extends ConnectSQL {

    List<HoaDonNhap> dshdn = new ArrayList<>();

    public List<HoaDonNhap> filltoArrayList() {
        try {
            String sql
                    = """
                SELECT hdn.maHDN,hdn.MaNPP,hdn.NguoiGiao,hdn.NguoiNhan,hdn.NgayViet,hdn.NgayNhap,hdn.TongTien, t.MaThuoc, t.TenThuoc,cthdn.Soluong
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
                    hdn.setSoLuong(rs.getInt("Soluong"));
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
   
   
   public int save(HoaDonNhap hdn) {

        try {
            String sql1 = "insert into HoaDonNhap (MaHDN,MaNPP,NguoiGiao,NguoiNhan,NgayViet,NgayNhap,TongTien,isdelete) values(?,?,?,?,?,?,?,?)";
            PreparedStatement st1 = con.prepareStatement(sql1);
            
            
            st1.setString(1, hdn.getMaHDN());
            st1.setString(2, hdn.getMaNPP());
            st1.setString(3, hdn.getNguoiGiao());
            st1.setString(4, hdn.getNguoiNhan());
            st1.setDate(5, (Date) hdn.getNgayViet());
            st1.setDate(6, (Date) hdn.getNgayNhap());
            st1.setString(7, String.valueOf(hdn.getTongTien()));
            st1.setInt(8,1);
           
            
            String sql2 = "insert into Thuoc (MaThuoc,TenThuoc) values(?,?)";
            PreparedStatement st2 = con.prepareStatement(sql1);
            
            
            st2.setString(1, hdn.getMaThuoc());
            st2.setString(2, hdn.getTenThuoc());
            int row1 = st2.executeUpdate();
            
            if (row1 > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return row1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
   
   
   
   
   
  


    
    

