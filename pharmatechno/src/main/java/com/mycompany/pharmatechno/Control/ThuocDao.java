/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.Thuoc;
import com.mycompany.pharmatechno.UI.QuanLiThuoc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThuocDao extends ConnectSQL {

    List<Thuoc> dsthuoc = new ArrayList<>();

    public List<Thuoc> filltoArrayList() {
        try {
            String sql = "select * from Thuoc where isdelete = 1 order by maThuoc ";
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                dsthuoc.clear();

                while (rs.next()) {
                    Thuoc thuoc = new Thuoc();
                    thuoc.setMaThuoc(rs.getString("MaThuoc"));
                    thuoc.setTenThuoc(rs.getString("TenThuoc"));
                    thuoc.setHinhAnh(rs.getString("HinhAnh"));
                    thuoc.setThanhPhan(rs.getString("ThanhPhan"));
                    thuoc.setSoLuongTon(rs.getInt("Soluongton"));
                    thuoc.setGiaNhap(rs.getFloat("GiaNhap"));
                    thuoc.setDonGia(rs.getFloat("DonGia"));
                    thuoc.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                    thuoc.setHanSuDung(rs.getDate("HanSuDung"));
                    thuoc.setDonViTinh(rs.getString("DonViTinh"));
                    thuoc.setLoaiThuoc(rs.getString("LoaiThuoc"));
                    thuoc.setXuatXu(rs.getString("XuatXu"));
                    thuoc.setBarcode(rs.getString("barcode"));
                    dsthuoc.add(thuoc);
                }
                rs.close();
                st.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuanLiThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsthuoc;
    }

    public boolean check(String ma) {
        for (Thuoc thuoc : dsthuoc) {
            if (ma.equals(thuoc.getMaThuoc())) {
                return false;
            }
        }
        return true;
    }

    public boolean removeStaff(String mathuoc) {
        try {
            String sql = "UPDATE thuoc SET isdelete = ? WHERE mathuoc like ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, 0);
            st.setString(2, mathuoc);
            int row = st.executeUpdate();

            return row > 0;
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            String errorMessage = e.getMessage();
            System.out.println("SQL Error Code: " + errorCode);
            System.out.println("SQL Error Message: " + errorMessage);
            e.printStackTrace();
        }
        return false;
    }

   public int save(Thuoc thuoc) {
    try {
        String sql = "INSERT INTO Thuoc (MaThuoc, TenThuoc, HinhAnh, ThanhPhan, SoLuongTon, GiaNhap, DonGia, NgaySanXuat, HanSuDung, DonViTinh, LoaiThuoc, XuatXu, Barcode, IsDelete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, thuoc.getMaThuoc());
        ps.setString(2, thuoc.getTenThuoc());
        ps.setString(3, thuoc.getHinhAnh());
        ps.setString(4, thuoc.getThanhPhan());
        ps.setInt(5, thuoc.getSoLuongTon());
        ps.setFloat(6, thuoc.getGiaNhap());
        ps.setFloat(7, thuoc.getDonGia());
        ps.setDate(8, new Date(thuoc.getNgaySanXuat().getTime()));
        ps.setDate(9, new Date(thuoc.getHanSuDung().getTime()));
        ps.setString(10, thuoc.getDonViTinh());
        ps.setString(11, thuoc.getLoaiThuoc());
        ps.setString(12, thuoc.getXuatXu());
        ps.setString(13, thuoc.getBarcode()); // Thêm mã barcode
        ps.setInt(14, 1);
        int row1 = ps.executeUpdate();

        if (row1 > 0) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return row1;
        }
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}


    // lấy dữ liệu từ combobox
    public List<String> getDonViTinhList() {
    List<String> donViTinhList = new ArrayList<>();
    String sql = "SELECT DISTINCT DonViTinh FROM Thuoc WHERE IsDelete = 1";

    try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            donViTinhList.add(rs.getString("DonViTinh"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return donViTinhList;
}
    // update thuoc
   

   public int update(Thuoc thuoc) {
    try {
        String sql = "UPDATE Thuoc SET TenThuoc = ?, HinhAnh = ?, ThanhPhan = ?, Soluongton = ?, GiaNhap = ?, DonGia = ?, NgaySanXuat = ?, HanSuDung = ?, DonViTinh = ?, LoaiThuoc = ?, XuatXu = ?, Barcode = ? WHERE MaThuoc = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, thuoc.getTenThuoc());
        ps.setString(2, thuoc.getHinhAnh());
        ps.setString(3, thuoc.getThanhPhan());
        ps.setInt(4, thuoc.getSoLuongTon());
        ps.setFloat(5, thuoc.getGiaNhap());
        ps.setFloat(6, thuoc.getDonGia());
        ps.setDate(7, new Date(thuoc.getNgaySanXuat().getTime()));
        ps.setDate(8, new Date(thuoc.getHanSuDung().getTime()));
        ps.setString(9, thuoc.getDonViTinh());
        ps.setString(10, thuoc.getLoaiThuoc());
        ps.setString(11, thuoc.getXuatXu());
        ps.setString(12, thuoc.getBarcode()); // Cập nhật mã barcode
        ps.setString(13, thuoc.getMaThuoc()); // Điều kiện WHERE

        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            return rows;
        }
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}


public String fillmaphatsinh() {
    String mps = null;
    int maxSo = 0; // Biến lưu số lớn nhất của mã thuốc có định dạng mong muốn
    try {
        String sql = "SELECT mathuoc FROM thuoc";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) { 
            mps = rs.getString("mathuoc"); 
            if (mps.startsWith("thuoc")) {
                try {
                    int so = Integer.parseInt(mps.substring(5));
                    if (so > maxSo) {
                        maxSo = so;
                    }
                } catch (NumberFormatException e) {
                    // Bỏ qua mã thuốc không đúng định dạng
                }
            }
        }

        rs.close();
        st.close();
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    // Tạo mã thuốc mới
    String newMaThuoc = "thuoc" + String.format("%03d", maxSo + 1);
    return newMaThuoc;
}




    public List<Thuoc> searchThuocByName(String name) {
        List<Thuoc> result = new ArrayList<>();
        for (Thuoc thuoc : filltoArrayList()) { // Giả sử filltoArrayList() trả về danh sách tất cả thuốc
            if (thuoc.getTenThuoc().toLowerCase().contains(name.toLowerCase())) {
                result.add(thuoc);
            }
        }
        return result;
    }
}
