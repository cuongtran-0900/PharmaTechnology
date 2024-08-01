/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.BanHang;
import com.mycompany.pharmatechno.UI.QuanLiBanHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cuong
 */
public class QuanLiBanHangDao extends ConnectSQL{
        List<BanHang> dsbh = new ArrayList<>();
        
            public List<BanHang> filltoArrayList(){
    try {
            String sql = "select TenThuoc, DonViTinh, LoaiThuoc, DonGia, soluongton,barcode from thuoc where isdelete = 1 order by tenthuoc ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dsbh.clear();
            while(rs.next()) {
                BanHang bh = new BanHang();
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
    
}
