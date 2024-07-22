/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.HoaDonNhap;
import com.mycompany.pharmatechno.UI.hoadonnhap;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class HoaDonNhapDao extends ConnectSQL {

    List<HoaDonNhap> dsnv = new ArrayList<>();
    
    public List<HoaDonNhap> filltoArrayList() {
        try {
            String sql = "select * from hoadonnhap where isdelete = 1 order by mahdn ";
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                dsnv.clear();
                while (rs.next()) {
                    HoaDonNhap hdn = new HoaDonNhap();
                    hdn.setMaHDN(rs.getString("MaHDN"));
                    hdn.setMaNPP(rs.getString("MaNPP"));  
                    hdn.setNguoiGiao(rs.getString("nguoiGiao"));
                    hdn.setNguoiNhan(rs.getString("nguoiNhan"));
                    hdn.setNgayViet(rs.getDate("ngayViet"));
                    hdn.setNgayNhap(rs.getDate("ngayNhap"));
                    hdn.setTongTien(rs.getFloat("tongTien"));
                

                    dsnv.add(hdn);
                }
                rs.close();
                st.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(hoadonnhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsnv;
    }
}
