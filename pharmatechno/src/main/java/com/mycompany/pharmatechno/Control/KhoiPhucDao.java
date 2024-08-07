/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.Thuoc;
import com.mycompany.pharmatechno.UI.QuanLiThuoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Cuong
 */
public class KhoiPhucDao extends ConnectSQL{
    List<Thuoc> dssv = new ArrayList<>();
    
        public List<Thuoc> filltoArrayList() {
        try {
            String sql = "select MaThuoc, TenThuoc, SoLuongTon, DonGia from thuoc where isdelete = 0 order by MaThuoc ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            dssv.clear();
            while (rs.next()) {
                Thuoc s = new Thuoc();
                s.setMaThuoc(rs.getString("MaThuoc"));
                s.setTenThuoc(rs.getString("TenThuoc"));
                s.setSoLuongTon(rs.getInt("SoLuongTon"));
                s.setDonGia(rs.getFloat("DonGia"));
                dssv.add(s);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dssv;
    }
        public int restore(String maThuoc) {
        try {
            String sql = "update Thuoc set isdelete = 1 where maThuoc=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,maThuoc);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "khôi phục thành công");
                return rows;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiThuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
        public Thuoc find(String maThuoc) {
        for (Thuoc sv : dssv) {
            if (sv.getMaThuoc().equals(maThuoc)) {
                return sv; 
            }
        }
        return null; 
    }
}
