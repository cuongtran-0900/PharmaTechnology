/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.UI.DoanhThu;
import com.mycompany.pharmatechno.Model.DoanhThuModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author acer to you
 */
public class DoanhThuDAO extends ConnectSQL {
    
    private java.util.List<DoanhThuModel> tdt = new ArrayList<>();
    
    public java.util.List<DoanhThuModel> filltoArrayList() {
        String sql = """
                     select hd.thoigian, t.tenthuoc, cthd.soluong, hd.tongTien from hoadon as hd 
                     inner join ChiTietHoaDon as cthd 
                     on hd.MaHD = cthd.MaHD
                     inner join thuoc as t 
                     on t.MaThuoc = cthd.MaThuoc;
                     """;

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            tdt.clear();
            while (rs.next()) {
                DoanhThuModel dt = new DoanhThuModel();
                dt.setThoiGian(rs.getTimestamp(1));
                dt.setTenThuoc(rs.getString(2));
                dt.setSoLuong(rs.getInt(3));
                dt.setTongTien(rs.getFloat(4));
                tdt.add(dt); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tdt;
    }
}