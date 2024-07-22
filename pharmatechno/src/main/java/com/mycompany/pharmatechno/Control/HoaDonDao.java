/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.HoaDon;
import com.mycompany.pharmatechno.UI.hoadon;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tu
 */
public class HoaDonDao extends ConnectSQL{
      List<HoaDon> dsnv = new ArrayList<>();
   
    public List<HoaDon> filltoArrayList(){
    try {
            String sql = "select * from HoaDon where isdelete = 1 order by mahd ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dsnv.clear();  
            while(rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setThoiGian(rs.getTimestamp("thoiGian"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setTongTien(rs.getFloat("tongTien"));
              
                dsnv.add(hd);   
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(hoadon.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dsnv;
}
    
    
}
