/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.KhachHang;
import com.mycompany.pharmatechno.UI.QuanLiKhachHang;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author hongo
 */
public class KhachHangDao extends ConnectSQL{
      List<KhachHang> dskh = new ArrayList<>();
      
    public List<KhachHang> filltoArrayList(){
    try {
            String sql = "select * from khachhang where isdelete = 1 order by makh ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dskh.clear();
            while(rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("Makh"));
                kh.setTenKH(rs.getString("tenkh"));
                kh.setTuoikh(rs.getString("tuoi"));
                kh.setSdt(rs.getString("sdt"));
                kh.setEmail(rs.getString("email"));
                kh.setGioiTinh(rs.getString("gioitinh"));
                kh.setDiaChi(rs.getString("diachi"));
                kh.setNgayThamGia(rs.getDate("NgayThamGia"));
                dskh.add(kh);   
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dskh;
}

        public boolean check(String ma) {
        for (KhachHang kh : dskh) {
            if (ma.equals(kh.getMaKH())) {
                return false;
            }
        }
        return true;
    }
    
        public boolean removeStaff(String makh) {
    try {
        String sql = "UPDATE khachang SET isdelete = ? WHERE makh like ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, 0); 
        st.setString(2, makh);
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
         public int save(KhachHang kh) {
        try {
            String sql = "INSERT INTO KhachHang (MaKh,TenKh,Tuoi,sdt,email,gioitinh,DiaChi,NgayThamGia,isDelete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getTuoikh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getEmail());
            ps.setString(6, kh.getGioiTinh());
            ps.setString(7, kh.getDiaChi());
            ps.setDate(8, new Date(kh.getNgayThamGia().getTime()));
            ps.setInt(9, 1);
            int row1 = ps.executeUpdate();

            if (row1 > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return row1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
  public int update(KhachHang kh) {
        try {
            String sql = "update khachhang set Tenkh=?,tuoi=?,sdt=?, email=?, gioitinh=?, diachi=?, ngaythamgia=? where makh=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getTuoikh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getGioiTinh());
            ps.setString(6, kh.getDiaChi());
             ps.setDate(7, new Date(kh.getNgayThamGia().getTime()));
            ps.setString(8,kh.getMaKH());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "cập nhật thành công");
                return rows;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
  
  
public String fillMaPhatSinh() {
    String mps = null;
    int maxSo = 0; // Biến lưu số lớn nhất của mã khách hàng có định dạng mong muốn
    try {
        String sql = "SELECT maKh FROM khachHang";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) { 
            mps = rs.getString("maKH"); 
            if (mps.startsWith("KH")) {
                try {
                    int so = Integer.parseInt(mps.substring(2)); // Lấy phần số sau tiền tố "KH"
                    if (so > maxSo) {
                        maxSo = so;
                    }
                } catch (NumberFormatException e) {
                    // Bỏ qua mã khách hàng không đúng định dạng
                }
            }
        }

        rs.close();
        st.close();
    } catch (SQLException ex) {
        Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    // Tạo mã khách hàng mới
    String newMaKhachHang = "KH" + String.format("%03d", maxSo + 1);
    return newMaKhachHang;
}

  
  

    public List<KhachHang> searchKhachHangByName(String name) {
        List<KhachHang> result = new ArrayList<>();
        for (KhachHang thuoc : filltoArrayList()) { // Giả sử filltoArrayList() trả về danh sách tất cả thuốc
            if (thuoc.getTenKH().toLowerCase().contains(name.toLowerCase())) {
                result.add(thuoc);
            }
        }
        return result;
    }
}


