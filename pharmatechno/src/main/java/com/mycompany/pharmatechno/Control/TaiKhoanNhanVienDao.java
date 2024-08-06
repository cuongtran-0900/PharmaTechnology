package com.mycompany.pharmatechno.Control;
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
        
     public List<TaiKhoanNhanVien> filltoArrayList(){
    List<TaiKhoanNhanVien> dstknv = new ArrayList<>();
    try {
        String sql = "select * from NhanVien where isdelete = 1 order by MaNV";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            dstknv.clear();
            while (rs.next()) {
                TaiKhoanNhanVien tknv = new TaiKhoanNhanVien();
                tknv.setMaNV(rs.getString("MaNV"));
                tknv.setTen(rs.getString("Ten"));
                tknv.setTuoi(rs.getString("Tuoi"));
                tknv.setSDT(rs.getString("SDT"));
                tknv.setEmail(rs.getString("Email"));
                tknv.setGioiTinh(rs.getString("GioiTinh"));
                tknv.setDiaChi(rs.getString("DiaChi"));
                tknv.setUsername(rs.getString("Username"));
                tknv.setPassword(rs.getString("Password"));
                dstknv.add(tknv);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dstknv;
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



