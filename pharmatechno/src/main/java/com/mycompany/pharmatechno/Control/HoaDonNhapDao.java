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
        String sql = 
        " SELECT hdn.maHDN, hdn.MaNPP, hdn.NguoiGiao, hdn.NguoiNhan, hdn.NgayViet, hdn.NgayNhap, hdn.TongTien,t.MaThuoc, t.TenThuoc, cthdn.Soluong, cthdn.GiaNhap, cthdn.Soluong * cthdn.GiaNhap AS ThanhTien FROM hoadonnhap AS hdn INNER JOIN chitiethoadonnhap AS cthdn ON hdn.MaHDN = cthdn.MaHDN INNER JOIN Thuoc AS t ON t.MaThuoc = cthdn.MaThuoc WHERE hdn.IsDelete = 1";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            dshdn.clear();
            HoaDonNhap currentHDN = null;
            while (rs.next()) {
                String maHDN = rs.getString("maHDN");

                // Kiểm tra nếu hóa đơn nhập mới
                if (currentHDN == null || !currentHDN.getMaHDN().equals(maHDN)) {
                    currentHDN = new HoaDonNhap();
                    currentHDN.setMaHDN(maHDN);
                    currentHDN.setMaNPP(rs.getString("MaNPP"));
                    currentHDN.setNguoiGiao(rs.getString("NguoiGiao"));
                    currentHDN.setNguoiNhan(rs.getString("NguoiNhan"));
                    currentHDN.setNgayViet(rs.getDate("NgayViet"));
                    currentHDN.setNgayNhap(rs.getDate("NgayNhap"));
                    currentHDN.setTongTien(rs.getInt("TongTien"));
                    currentHDN.setChiTietHoaDon(new ArrayList<>()); // Khởi tạo danh sách chi tiết hóa đơn
                    dshdn.add(currentHDN);
                }

                // Thêm chi tiết hóa đơn vào danh sách của hóa đơn nhập hiện tại
                ChiTietHoaDonNhap chiTiet = new ChiTietHoaDonNhap();
                chiTiet.setTenThuoc(rs.getString("TenThuoc"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setGiaNhap(rs.getInt("GiaNhap"));
                chiTiet.setThanhTien(rs.getInt("ThanhTien"));
                currentHDN.getChiTietHoaDon().add(chiTiet);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dshdn;
}



    public int save(HoaDonNhap hdn) {
    try {
        String sql1 = "INSERT INTO HoaDonNhap (MaHDN, MaNPP, NguoiGiao, NguoiNhan, NgayViet, NgayNhap, TongTien, isdelete) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement st1 = con.prepareStatement(sql1);

        st1.setString(1, hdn.getMaHDN());
        st1.setString(2, hdn.getMaNPP());
        st1.setString(3, hdn.getNguoiGiao());
        st1.setString(4, hdn.getNguoiNhan());
        st1.setDate(5, new Date(hdn.getNgayViet().getTime()));
        st1.setDate(6, new Date(hdn.getNgayNhap().getTime()));
        st1.setFloat(7, hdn.getTongTien());
        st1.setInt(8, 1);

        int row1 = st1.executeUpdate();

        for (ChiTietHoaDonNhap chiTiet : hdn.getChiTietHoaDon()) {
            String sql2 = "INSERT INTO ChiTietHoaDonNhap (MaHDN, MaThuoc, Soluong, GiaNhap) VALUES(?,?,?,?)";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setString(1, hdn.getMaHDN());
            st2.setString(2, chiTiet.getMaThuoc());
            st2.setInt(3, chiTiet.getSoLuong());
            st2.setInt(4, chiTiet.getGiaNhap());

            String checkSql = "SELECT SoLuongTon FROM Thuoc WHERE MaThuoc = ?";
            PreparedStatement checkSt = con.prepareStatement(checkSql);
            checkSt.setString(1, chiTiet.getMaThuoc());
            ResultSet rs = checkSt.executeQuery();

            if (rs.next()) {
                // Nếu mã thuốc đã tồn tại, cập nhật số lượng tồn và giá nhập
                int currentSoLuongTon = rs.getInt("SoLuongTon");
                int newSoLuongTon = currentSoLuongTon + chiTiet.getSoLuong();

                String updateSql = "UPDATE Thuoc SET SoLuongTon = ?, GiaNhap = ? WHERE MaThuoc = ?";
                PreparedStatement updateSt = con.prepareStatement(updateSql);
                updateSt.setInt(1, newSoLuongTon);
                updateSt.setInt(2, chiTiet.getGiaNhap());
                updateSt.setString(3, chiTiet.getMaThuoc());
                updateSt.executeUpdate();
            } else {
                // Nếu mã thuốc chưa tồn tại, thêm mới
                String insertSql = "INSERT INTO Thuoc (MaThuoc, TenThuoc, GiaNhap, SoLuongTon) VALUES (?, ?, ?, ?)";
                PreparedStatement insertSt = con.prepareStatement(insertSql);
                insertSt.setString(1, chiTiet.getMaThuoc());
                insertSt.setString(2, chiTiet.getTenThuoc());
                insertSt.setInt(3, chiTiet.getGiaNhap());
                insertSt.setInt(4, chiTiet.getSoLuong());
                insertSt.executeUpdate();
            }

            st2.executeUpdate();
        }

        if (row1 > 0) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return row1;
        }
    } catch (SQLException ex) {
        Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}

}
