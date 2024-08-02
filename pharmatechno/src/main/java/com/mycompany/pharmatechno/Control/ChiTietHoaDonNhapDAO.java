/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.ChiTietHoaDonNhap;
import com.mycompany.pharmatechno.UI.HoaDonNhapUI;
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
public class ChiTietHoaDonNhapDAO extends ConnectSQL {
  List<ChiTietHoaDonNhap> cthdn = new ArrayList<>();
    
  public List<ChiTietHoaDonNhap> filltoArrayList(){
    try {
            String sql = "select * from chitiethoadonnhap where isdelete = 1 order by mahd ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            cthdn.clear();
            while(rs.next()) {
                ChiTietHoaDonNhap hd = new ChiTietHoaDonNhap();
                hd.setMaHDN(rs.getString("MaHDN"));
                 hd.setMaThuoc(rs.getString("Mathuoc"));
                  hd.setSoLuong(rs.getInt("soLuong"));
                   hd.setGiaNhap(rs.getFloat("gianhap"));
                cthdn.add(hd);   
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    return cthdn;
}
}

