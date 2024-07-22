                                                                                                                                                                                                                                                        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.NhanVien;
import com.mycompany.pharmatechno.UI.QuanLiNhanVIen;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cuong
 */
public class NhanVienDao extends ConnectSQL{
    
    List<NhanVien> dsnv = new ArrayList<>();
                                                       
    public List<NhanVien> filltoArrayList(){
    try {
            String sql = "select * from nhanvien where isdelete = 1 order by manv ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dsnv.clear();
            while(rs.next()) {                                                  
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString(2));
                nv.setTuoiNV(rs.getString(3));
                nv.setSDT(rs.getString(4));
                nv.setEmail(rs.getString(5));
                nv.setGioiTinh(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setRoll(rs.getString(8));
                nv.setUserName(rs.getString(9));
                nv.setPassWord(rs.getString(10));
                dsnv.add(nv);   
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiNhanVIen.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dsnv;
}
    
}
