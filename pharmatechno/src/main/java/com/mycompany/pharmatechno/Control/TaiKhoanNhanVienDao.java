package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.TaiKhoanNhanVien;
import com.mycompany.pharmatechno.UI.TaiKhoan;
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
    try {
            String sql = "select * from TaiKhoanNhanVien where isdelete = 1 order by MaNV ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dstknv.clear();
            while(rs.next()) {
                TaiKhoanNhanVien tknv = new TaiKhoanNhanVien();
                tknv.setMaNV(rs.getString(1));
                tknv.setTen(rs.getString(2));
                tknv.setTuoi(rs.getString(3));
                tknv.setSDT(rs.getString(4));
                tknv.setEmail(rs.getString(5));
                   tknv.setGioiTinh(rs.getString(5));
                   tknv.setDiaChi(rs.getString(5));
                   tknv.setUsername(rs.getString(5));
                    tknv.setPassword(rs.getString(5));
                dstknv.add(tknv);
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dstknv;
}
}

    

