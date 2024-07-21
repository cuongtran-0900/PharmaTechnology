/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.ThongTinThanhVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author acer to you
 */
public class ThongTinThanhVienDAO {
    List<ThongTinThanhVien> dstv = new ArrayList<>();
    
    public List<ThongTinThanhVien> filltoArrayList() throws SQLException{
            String sql = "select * from khachhang where isdelete = 1 order by makh ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dstv.clear();
            while(rs.next()) {
                ThongTinThanhVien tttv = new ThongTinThanhVien();
                tttv.setMaKH(rs.getString(1));
                tttv.setTenKH(rs.getString(2));
                tttv.setTuoi(rs.getString(3));
                tttv.setSDT(rs.getString(4));
                tttv.setEmail(rs.getString(5));
                tttv.setGioiTinh(rs.getString(6));
                tttv.setDiaChi(rs.getString(7));
                tttv.setNgayThamGia(rs.getDate(8));
                dstv.add(tttv);   
            }
            rs.close();
            st.close();
        }
        
    return dstv;
}
}
