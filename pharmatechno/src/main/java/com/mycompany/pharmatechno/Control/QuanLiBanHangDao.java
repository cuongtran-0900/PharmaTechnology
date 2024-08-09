/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.BanHang;
import com.mycompany.pharmatechno.UI.QuanLiBanHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cuong
 */
public class QuanLiBanHangDao extends ConnectSQL{
        List<BanHang> dsbh = new ArrayList<>();
        
    public List<BanHang> filltoArrayList(){
    try {
            String sql = "select Mathuoc, TenThuoc, DonViTinh, LoaiThuoc, DonGia, soluongton,barcode from thuoc where isdelete = 1 order by tenthuoc ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dsbh.clear();
            while(rs.next()) {
                BanHang bh = new BanHang();
                bh.setMaThuoc(rs.getString("MaThuoc"));
                bh.setTenThuoc(rs.getString("TenThuoc"));
                bh.setDVT(rs.getString("DonViTinh"));
                bh.setLoai(rs.getString("LoaiThuoc"));
                bh.setDonGia(rs.getInt("DonGia"));
                bh.setTonKho(rs.getInt("soluongton"));
                bh.setBarCode(rs.getString("barcode"));
                dsbh.add(bh);   
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiBanHang.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dsbh;
}
            
    public int payment(BanHang bh) {
    try {
        con.setAutoCommit(false); // Bắt đầu giao dịch

        String checkMaHD = "SELECT COUNT(*) FROM HoaDon WHERE MaHD = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkMaHD);
        checkStmt.setString(1, bh.getMaHD());
        ResultSet rs = checkStmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        if (count == 0) {
            String sql1 = "INSERT INTO HoaDon (MaHD, thoigian, MaNV, TongTien, IsDelete) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setString(1, bh.getMaHD());
            st1.setTimestamp(2, bh.getThoiGian());
            st1.setString(3, bh.getMaNV());
            st1.setInt(4, bh.getTongTien());
            st1.setInt(5, 1);
            int row1 = st1.executeUpdate();

            if (row1 > 0) {
                String sql2 = "INSERT INTO ChiTietHoaDon (MaHD, MaThuoc, SoLuong, DonGia) VALUES (?, ?, ?, ?)";
                PreparedStatement st2 = con.prepareStatement(sql2);
                st2.setString(1, bh.getMaHD());
                st2.setString(2, bh.getMaThuoc());
                st2.setInt(3, bh.getSoluong());
                st2.setInt(4, bh.getDonGia());
                int row2 = st2.executeUpdate();

                String sql3 = "UPDATE thuoc SET SoLuongTon = SoLuongTon - ? WHERE MaThuoc = ?";
                PreparedStatement st3 = con.prepareStatement(sql3);
                st3.setInt(1, bh.getSoluong());
                st3.setString(2, bh.getMaThuoc());
                int row3 = st3.executeUpdate();

                if (row2 > 0 && row3 > 0) {
                    con.commit(); // Commit giao dịch
                    return row1 + row2 + row3;
                }
            }
        } else {
            String sql2 = "INSERT INTO ChiTietHoaDon (MaHD, MaThuoc, SoLuong, DonGia) VALUES (?, ?, ?, ?)";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setString(1, bh.getMaHD());
            st2.setString(2, bh.getMaThuoc());
            st2.setInt(3, bh.getSoluong());
            st2.setInt(4, bh.getDonGia());
            int row2 = st2.executeUpdate();

            String sql3 = "UPDATE thuoc SET SoLuongTon = SoLuongTon - ? WHERE MaThuoc = ?";
            PreparedStatement st3 = con.prepareStatement(sql3);
            st3.setInt(1, bh.getSoluong());
            st3.setString(2, bh.getMaThuoc());
            int row3 = st3.executeUpdate();

            if (row2 > 0 && row3 > 0) {
                con.commit(); // Commit giao dịch
                return row2 + row3;
            }
        }
        con.rollback(); // Rollback giao dịch nếu có lỗi
    } catch (SQLException ex) {
        if (con != null) {
            try {
                con.rollback(); // Rollback giao dịch khi có lỗi
            } catch (SQLException rollbackEx) {
                Logger.getLogger(QuanLiBanHangDao.class.getName()).log(Level.SEVERE, null, rollbackEx);
            }
        }
        Logger.getLogger(QuanLiBanHangDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            con.setAutoCommit(true); // Đặt lại AutoCommit về true
        } catch (SQLException e) {
            Logger.getLogger(QuanLiBanHangDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    return -1;
}

               
            
            
   public String fillmaphatsinh() {
    String mps = null; 
    try {
        String sql = "SELECT mahd FROM hoadon WHERE mahd LIKE 'hd%' ORDER BY mahd DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if (rs.next()) { 
            mps = rs.getString("mahd"); 
        }

        rs.close();
        st.close();
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiBanHang.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    if (mps != null && mps.length() >= 5) {
        int so = Integer.parseInt(mps.substring(3, 5));
        String manv = String.valueOf(so);
        return manv;
    } else {
        return "00"; // Giá trị mặc định hoặc xử lý cho trường hợp mps là null hoặc không đủ độ dài
    }
}
    
    public String Maphatsinh() {
    if (dsbh.size() <= 0) {
        return "hd001";
    } else {
        int ma = Integer.valueOf(fillmaphatsinh()) + 1;
        return String.format("hd%03d", ma);
    }
}


    
}
