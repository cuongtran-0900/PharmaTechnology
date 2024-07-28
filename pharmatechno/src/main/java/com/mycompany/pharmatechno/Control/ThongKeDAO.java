/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.ThongKeModel;
import com.mycompany.pharmatechno.UI.ThongKe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer to you
 */
public class ThongKeDAO extends ConnectSQL{
    
        private final List<ThongKeModel> tkm = new ArrayList<>();

    public List<ThongKeModel> filltoArrayList() {
        String sql ="select tongtien from HoaDon where IsDelete = 1;";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            tkm.clear();
            while (rs.next()) {
                ThongKeModel tk = new ThongKeModel();
                tk.setTongTien(rs.getFloat("tongTien"));
                tkm.add(tk); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tkm;
    }
}
