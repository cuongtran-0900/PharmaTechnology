package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.DoiMatKhau;
import com.mycompany.pharmatechno.UI.ThayDoiMatKhau;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tranp
 */
public class DoiMatKhauDao extends ConnectSQL{
    List<DoiMatKhau> dsdmk = new ArrayList<>();
    
     public List<DoiMatKhau> filltoArrayList(){
    try {
            String sql = "select * from DoiMatKhau where isdelete = 1 order by MaNV ";
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            dsdmk.clear();
            while(rs.next()) {
                DoiMatKhau dmk = new DoiMatKhau();
                dmk.setMatKhauHienTai(rs.getString(1));
                dmk.setMatKhauMoi(rs.getString(2));
                dmk.setXacNhanMatKhauMoi(rs.getString(3));
     
                dsdmk.add(dmk);
            }
            rs.close();
            st.close();
        }
        
    } catch (SQLException ex) {
            Logger.getLogger(ThayDoiMatKhau.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dsdmk;
}
}

    
    

