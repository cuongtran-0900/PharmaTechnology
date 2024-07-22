/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.NhaPhanPhoi;
import com.mycompany.pharmatechno.UI.QuanLiNhaPhanPhoi;
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
public class NhaPhanPhoiDao extends ConnectSQL{
    List<NhaPhanPhoi> dsnpp = new ArrayList<>();
     public List<NhaPhanPhoi> filltoArrayList(){
    try {
            String sql = "select * from nhaphanphoi where isdelete = 1 order by manpp ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dsnpp.clear();
            while(rs.next()) {
                NhaPhanPhoi npp = new NhaPhanPhoi();
                npp.setMaNPP(rs.getString("MaNPP"));
                npp.setTenNPP(rs.getString("TenNPP"));                
                npp.setDienThoai(rs.getString("DienThoai"));
                npp.setEmail(rs.getString("Email"));               
                npp.setDiaChi(rs.getString("DiaChi"));
                dsnpp.add(npp);   
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiNhaPhanPhoi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dsnpp;
}
}
