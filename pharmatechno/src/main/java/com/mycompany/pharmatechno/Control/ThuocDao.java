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

public class ThuocDao extends ConnectSQL{
   List<Thuoc> dsthuoc = new ArrayList<>();
     public List<Thuoc> filltoArrayList(){
             try {
            String sql = "select * from Thuoc where isdelete = 1 order by maThuoc ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dsthuoc.clear();
            
            while(rs.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setMaThuoc(rs.getString("MaThuoc"));
                thuoc.setTenThuoc(rs.getString("TenThuoc"));                
                thuoc.setSoLuong(rs.getString("SoLuong"));
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
    
public boolean addThuoc(Thuoc thuoc) {
    String sql = "INSERT INTO Thuoc (MaThuoc, TenThuoc, SoLuong, HinhAnh, ThanhPhan, Soluongton, GiaNhap, DonGia, NgaySanXuat, HanSuDung, DonViTinh, LoaiThuoc, XuatXu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, thuoc.getMaThuoc());
        ps.setString(2, thuoc.getTenThuoc());
        ps.setString(3, thuoc.getSoLuong());
        ps.setString(4, thuoc.getHinhAnh());
        ps.setString(5, thuoc.getThanhPhan());
        ps.setInt(6, thuoc.getSoLuongTon());
        ps.setFloat(7, thuoc.getGiaNhap());
        ps.setFloat(8, thuoc.getDonGia());
        
        // Kiểm tra và xử lý giá trị null cho NgaySanXuat và HanSuDung
        if (thuoc.getNgaySanXuat() != null) {
            ps.setDate(9, new java.sql.Date(thuoc.getNgaySanXuat().getTime()));
        } else {
            ps.setNull(9, java.sql.Types.DATE);
        }

        if (thuoc.getHanSuDung() != null) {
            ps.setDate(10, new java.sql.Date(thuoc.getHanSuDung().getTime()));
        } else {
            ps.setNull(10, java.sql.Types.DATE);
        }

        ps.setString(11, thuoc.getDonViTinh());
        ps.setString(12, thuoc.getLoaiThuoc());
        ps.setString(13, thuoc.getXuatXu());
        
        int result = ps.executeUpdate();
        return result > 0;
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDao.class.getName()).log(Level.SEVERE, "Error adding Thuoc: " + ex.getMessage(), ex);
    }
    return false;
}


  
 
   // update thuoc
  public boolean updateThuoc(Thuoc thuoc) {
    String sql = "UPDATE Thuoc SET TenThuoc = ?, SoLuong = ?, HinhAnh = ?, ThanhPhan = ?, Soluongton = ?, GiaNhap = ?, DonGia = ?, NgaySanXuat = ?, HanSuDung = ?, DonViTinh = ?, LoaiThuoc = ?, XuatXu = ? WHERE MaThuoc = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, thuoc.getTenThuoc());
        ps.setString(2, thuoc.getSoLuong());
        ps.setString(3, thuoc.getHinhAnh());
        ps.setString(4, thuoc.getThanhPhan());
        ps.setInt(5, thuoc.getSoLuongTon());
        ps.setFloat(6, thuoc.getGiaNhap());
        ps.setFloat(7, thuoc.getDonGia());
        ps.setDate(8, thuoc.getNgaySanXuat());
        ps.setDate(9, thuoc.getHanSuDung());
        ps.setString(10, thuoc.getDonViTinh());
        ps.setString(11, thuoc.getLoaiThuoc());
        ps.setString(12, thuoc.getXuatXu());
        ps.setString(13, thuoc.getMaThuoc());
        
        int result = ps.executeUpdate();
        return result > 0;
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}
// xóa thuoc
  
  public boolean deleteThuoc(String maThuoc) {
    String sql = "DELETE FROM Thuoc WHERE MaThuoc = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, maThuoc);
        int result = ps.executeUpdate();
        return result > 0;
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
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

