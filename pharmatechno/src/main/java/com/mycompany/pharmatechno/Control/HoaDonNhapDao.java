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
                    currentHDN.setChiTietHoaDonNhap(new ArrayList<>()); // Khởi tạo danh sách chi tiết hóa đơn
                    dshdn.add(currentHDN);
                }

                // Thêm chi tiết hóa đơn vào danh sách của hóa đơn nhập hiện tại
                ChiTietHoaDonNhap chiTiet = new ChiTietHoaDonNhap();
                chiTiet.setMaThuoc(rs.getString("MaThuoc"));
                chiTiet.setTenThuoc(rs.getString("TenThuoc"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setGiaNhap(rs.getInt("GiaNhap"));
                chiTiet.setThanhTien(rs.getInt("ThanhTien"));
                currentHDN.getChiTietHoaDonNhap().add(chiTiet);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dshdn;
}

public boolean check(String ma) {
        for (HoaDonNhap hdn : dshdn) {
            if (ma.equals(hdn.getMaHDN())) {
                return false;
            }
        }
        return true;
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

        for (ChiTietHoaDonNhap chiTiet : hdn.getChiTietHoaDonNhap()) {
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
                String insertSql = "INSERT INTO Thuoc (MaThuoc, TenThuoc, GiaNhap, SoLuongTon, IsDelete) VALUES (?, ?, ?, ?,?)";
                PreparedStatement insertSt = con.prepareStatement(insertSql);
                insertSt.setString(1, chiTiet.getMaThuoc());
                insertSt.setString(2, chiTiet.getTenThuoc());
                insertSt.setInt(3, chiTiet.getGiaNhap());
                insertSt.setInt(4, chiTiet.getSoLuong());
                insertSt.setInt(5, 1);
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

public int update(HoaDonNhap hdn) {
    try {
        // Cập nhật bảng HoaDonNhap
        String sql1 = "UPDATE HoaDonNhap SET maNPP = ?, NguoiGiao = ?, NguoiNhan = ?, NgayViet = ?, NgayNhap = ?, TongTien = ? WHERE maHDN = ?";
        PreparedStatement st1 = con.prepareStatement(sql1);
        st1.setString(1, hdn.getMaNPP());
        st1.setString(2, hdn.getNguoiGiao());
        st1.setString(3, hdn.getNguoiNhan());
        st1.setDate(4, (Date) hdn.getNgayViet()); // Chuyển đổi từ LocalDate sang Date
        st1.setDate(5, (Date) hdn.getNgayNhap());
        st1.setInt(6, hdn.getTongTien());
        st1.setString(7, hdn.getMaHDN());

        int rows1 = st1.executeUpdate(); // Thực thi câu lệnh update

        // Cập nhật bảng ChiTietHoaDonNhap và Thuoc
        String sqlCheck = "SELECT COUNT(*) FROM ChiTietHoaDonNhap WHERE maHDN = ? AND MaThuoc = ?";
        PreparedStatement stCheck = con.prepareStatement(sqlCheck);

        String sqlUpdate = "UPDATE ChiTietHoaDonNhap SET SoLuong = ?, GiaNhap = ? WHERE maHDN = ? AND MaThuoc = ?";
        PreparedStatement stUpdate = con.prepareStatement(sqlUpdate);

        String sqlInsert = "INSERT INTO ChiTietHoaDonNhap (maHDN, MaThuoc, SoLuong, GiaNhap) VALUES (?, ?, ?, ?)";
        PreparedStatement stInsert = con.prepareStatement(sqlInsert);

        String sql3 = "UPDATE Thuoc SET GiaNhap = ?, SoLuongTon = SoLuongTon + ?, TenThuoc = ? WHERE MaThuoc = ?";
        PreparedStatement st3 = con.prepareStatement(sql3);

        List<ChiTietHoaDonNhap> chitiet = hdn.getChiTietHoaDonNhap(); // Lấy danh sách ChiTietHoaDonNhap từ HoaDonNhap

        for (ChiTietHoaDonNhap cthdn : chitiet) {
            // Kiểm tra xem bản ghi đã tồn tại chưa
            stCheck.setString(1, hdn.getMaHDN());
            stCheck.setString(2, cthdn.getMaThuoc());
            ResultSet rs = stCheck.executeQuery();
            rs.next();
            
            if (rs.getInt(1) > 0) {
                // Nếu bản ghi tồn tại, thực hiện cập nhật
                stUpdate.setInt(1, cthdn.getSoLuong());
                stUpdate.setDouble(2, cthdn.getGiaNhap());
                stUpdate.setString(3, hdn.getMaHDN());
                stUpdate.setString(4, cthdn.getMaThuoc());
                stUpdate.addBatch();
            } else {
                // Nếu bản ghi không tồn tại, thực hiện chèn mới
                stInsert.setString(1, hdn.getMaHDN());
                stInsert.setString(2, cthdn.getMaThuoc());
                stInsert.setInt(3, cthdn.getSoLuong());
                stInsert.setDouble(4, cthdn.getGiaNhap());
                stInsert.addBatch();
            }

            // Cập nhật bảng Thuoc
            st3.setDouble(1, cthdn.getGiaNhap());
            st3.setInt(2, cthdn.getSoLuong());
            st3.setString(3, cthdn.getTenThuoc());
            st3.setString(4, cthdn.getMaThuoc());
            st3.addBatch();
        }

        int[] rowsUpdate = stUpdate.executeBatch(); // Thực thi batch cập nhật ChiTietHoaDonNhap
        int[] rowsInsert = stInsert.executeBatch(); // Thực thi batch chèn mới ChiTietHoaDonNhap
        int[] rows3 = st3.executeBatch(); // Thực thi batch cập nhật Thuoc

        // Kiểm tra kết quả cập nhật/chèn
        if (rows1 > 0 && (rowsUpdate.length > 0 || rowsInsert.length > 0) && rows3.length > 0) {
            return rows1;
        }
    } catch (SQLException ex) {
        Logger.getLogger(HoaDonNhapDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}

public String fillmaphatsinh() {
    String mps = null; 
    try {
        String sql = "SELECT mahdn FROM hoadonnhap WHERE mahdn LIKE 'hdn%' ORDER BY mahdn DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if (rs.next()) { 
            mps = rs.getString("mahdn"); 
        }

        rs.close();
        st.close();
    } catch (SQLException ex) {
        Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    int so = Integer.parseInt(mps.substring(4,6));
        String manv = String.valueOf(so);
    return manv;
}
    
    public String Maphatsinh() {
    if (dshdn.size() <= 0) {
        return "hdn001";
    } else {
        int ma = Integer.valueOf(fillmaphatsinh()) + 1;
        return String.format("hdn%03d", ma);
    }
}


}


