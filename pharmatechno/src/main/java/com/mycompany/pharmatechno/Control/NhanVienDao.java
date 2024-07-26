/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.NhanVien;
import com.mycompany.pharmatechno.UI.QuanLiNhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            ResultSet rs = st.executeQuery(sql)){
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
        Logger.getLogger(QuanLiNhanVien.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dsnv;
}
        public boolean check(String ma) {
        for (NhanVien nv : dsnv) {
            if (ma.equals(nv.getMaNV())) {
                return false;
            }
        } 
        return true;
    }
    public boolean removeStaff(String manv) {
    try {
        String sql = "UPDATE NhanVien SET isdelete = ? WHERE manv like ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, 0); 
        st.setString(2, manv);
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
        public int save(NhanVien nv) {

        try {
            String sql1 = "insert into NhanVien (manv,ten,tuoi,email,sdt,gioitinh,diachi,username,password,roll,isdelete) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st1 = con.prepareStatement(sql1);
            
            st1.setString(1, nv.getMaNV());
            st1.setString(2, nv.getTenNV());
            st1.setString(3, nv.getTuoiNV());
            st1.setString(4, nv.getEmail());
            st1.setString(5, nv.getSDT());
            st1.setString(6, nv.getGioiTinh());
            st1.setString(7, nv.getDiaChi());
            st1.setString(8, "nhanvien");
            st1.setString(9, "123");
            st1.setString(10, nv.getRoll());
            st1.setInt(11,1);
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
    public int update(NhanVien nv) {
        try {
            String sql = "update NhanVien set ten=?,tuoi=?,sdt=?, email=?, gioitinh=?, diachi=?, roll=? where manv=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nv.getTenNV());
            st.setString(2, nv.getTuoiNV());
            st.setString(3, nv.getSDT());
            st.setString(4, nv.getEmail());
            st.setString(5, nv.getGioiTinh());
            st.setString(6, nv.getDiaChi());
            st.setString(7, nv.getRoll());
            st.setString(8,nv.getMaNV());
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "cập nhật thành công");
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
        String sql = "SELECT TOP 1 manv FROM nhanvien ORDER BY manv DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if (rs.next()) { 
            mps = rs.getString("manv"); 
        }

        rs.close();
        st.close();
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiNhanVien.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    int so = Integer.parseInt(mps.substring(3,5));
        String manv = String.valueOf(so);
    return manv;
}
        public String Maphatsinh(){
    if(dsnv.size() <= 0){
        return "nv001";
    } else {
        int count = Integer.valueOf(fillmaphatsinh());
        int ma = Integer.valueOf(fillmaphatsinh());
        if( count >= 100 && count <= 999 ){
            return "nv"+(ma+1);
            }else if(count >= 10 && count <= 99){
                return "nv0" + (ma+1);
                } else {
                    return "nv00" + (ma+1);
                  }
    }
    }
    
}
