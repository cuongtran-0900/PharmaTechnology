/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.KhachHang;
import com.mycompany.pharmatechno.UI.QuanLiKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hongo
 */
public class KhachHangDao extends ConnectSQL{
      List<KhachHang> dskh = new ArrayList<>();
      
    public List<KhachHang> filltoArrayList(){
    try {
            String sql = "select * from khachhang where isdelete = 1 order by makh ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dskh.clear();
            while(rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("Makh"));
                kh.setTenKH(rs.getString("tenkh"));
                kh.setTuoikh(rs.getString("tuoi"));
                kh.setSdt(rs.getString("sdt"));
                kh.setEmail(rs.getString("email"));
                kh.setGioiTinh(rs.getString("gioitinh"));
                kh.setDiaChi(rs.getString("diachi"));
                kh.setNgayThamGia(rs.getDate("NgayThamGia"));
                dskh.add(kh);   
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dskh;
}
}


