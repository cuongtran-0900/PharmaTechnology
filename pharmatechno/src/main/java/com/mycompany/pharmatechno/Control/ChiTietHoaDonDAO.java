/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.ChiTietHoaDonModel;
import com.mycompany.pharmatechno.UI.hoadon;
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
public class ChiTietHoaDonDAO extends ConnectSQL {
  List<ChiTietHoaDonModel> cthd = new ArrayList<>();
    
  public List<ChiTietHoaDonModel> filltoArrayList(){
    try {
            String sql = "select * from chitiethoadon where isdelete = 1 order by mahd ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            cthd.clear();
            while(rs.next()) {
                ChiTietHoaDonModel hd = new ChiTietHoaDonModel();
                hd.setMaHD(rs.getString("MaHD"));
                 hd.setMaThuoc(rs.getString("Mathuoc"));
                  hd.setSoLuong(rs.getInt("soLuong"));
                   hd.setDonGia(rs.getFloat("dongia"));
                cthd.add(hd);   
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(hoadon.class.getName()).log(Level.SEVERE, null, ex);
    }
    return cthd;
}
}
