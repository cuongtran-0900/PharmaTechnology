package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.NhanVien;
import com.mycompany.pharmatechno.Model.TaiKhoanNhanVien;
import com.mycompany.pharmatechno.UI.TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tranp
 */
public class TaiKhoanNhanVienDao extends ConnectSQL{
      List<TaiKhoanNhanVien> dstknv = new ArrayList<>();
        
public NhanVien selectByUsername(String username) {
    NhanVien nhanVien = null;
    try {
        String sql = "SELECT * FROM NhanVien WHERE Username = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nhanVien = new NhanVien();
                nhanVien.setMaNV(rs.getString("MaNV"));
                nhanVien.setTenNV(rs.getString("Ten"));
                nhanVien.setTuoiNV(rs.getString("Tuoi"));
                nhanVien.setSDT(rs.getString("SDT"));
                nhanVien.setEmail(rs.getString("Email"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setDiaChi(rs.getString("DiaChi"));
                nhanVien.setUserName(rs.getString("Username"));
                nhanVien.setPassWord(rs.getString("Password"));
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return nhanVien;
}



    public boolean updatePassword(String username, String newPassword) {
        String sql = "UPDATE TaiKhoanNhanVien SET Password = ? WHERE Username = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, newPassword);
            pst.setString(2, username);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }




}



