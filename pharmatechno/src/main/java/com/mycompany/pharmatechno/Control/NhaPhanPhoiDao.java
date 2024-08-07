/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;
import com.mycompany.pharmatechno.Model.NhaPhanPhoi;
import com.mycompany.pharmatechno.UI.QuanLiNhaPhanPhoi;
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
                npp.setMaNPP(rs.getString(1));
                npp.setTenNPP(rs.getString(2));
                npp.setSDT(rs.getString(3));
                npp.setDiaChi(rs.getString(4));
                npp.setEmail(rs.getString(5));
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
    
    public boolean check(String ma) {
        for (NhaPhanPhoi npp : dsnpp) {
            if (ma.equals(npp.getMaNPP())) {
                return false;
            }
        } 
        return true;
    }
    
    public boolean removeStaff(String manpp) {
        try {
            String sql = "UPDATE NhaPhanPhoi SET isdelete = ? WHERE manpp LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, 0);
            st.setString(2, manpp);
            int row = st.executeUpdate();

            return row > 0;
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            String errorMessage = e.getMessage();
            System.out.println("SQL Error Code: " + errorCode);
            System.out.println("SQL Error Message: " + errorMessage);
            e.printStackTrace();
        }
        return false;
    }
    
    public int save(NhaPhanPhoi npp) {
        try {
            String sql1 = "INSERT INTO NhaPhanPhoi (manpp, tennpp, sdt, diachi,email, isdelete) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st1 = con.prepareStatement(sql1);

            st1.setString(1, npp.getMaNPP());
            st1.setString(2, npp.getTenNPP());
            st1.setString(3, npp.getSDT());
            st1.setString(4, npp.getDiaChi());
            st1.setString(5, npp.getEmail());
            st1.setInt(6, 1);
            int row1 = st1.executeUpdate();

            if (row1 > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return row1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int update(NhaPhanPhoi npp) {
        try {
            String sql = "UPDATE NhaPhanPhoi SET tenpp = ?, sdt = ?, diachi = ?, email = ? WHERE manpp = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, npp.getTenNPP());
            st.setString(2, npp.getSDT());
            st.setString(3, npp.getDiaChi());
            st.setString(4, npp.getEmail());
            st.setString(5, npp.getMaNPP());
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                return rows;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public String fillmaphatsinh() {
    String mps = null; 
    try {
        String sql = "SELECT manpp FROM NhaPhanPhoi WHERE manpp LIKE 'npp%' ORDER BY manpp DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if (rs.next()) { 
            mps = rs.getString("manpp"); 
        }

        rs.close();
        st.close();
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiNhaPhanPhoi.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    int so = Integer.parseInt(mps.substring(4,6));
        String manv = String.valueOf(so);
    return manv;
}
    
    public String Maphatsinh() {
    if (dsnpp.size() <= 0) {
        return "npp001";
    } else {
        int ma = Integer.valueOf(fillmaphatsinh()) + 1;
        return String.format("npp%03d", ma);
    }
}
}
