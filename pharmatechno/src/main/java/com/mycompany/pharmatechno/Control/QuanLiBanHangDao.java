/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.BanHang;
import com.mycompany.pharmatechno.UI.QuanLiBanHang;
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
public class QuanLiBanHangDao extends ConnectSQL{
        List<BanHang> dsbh = new ArrayList<>();
        
            public List<BanHang> filltoArrayList(){
    try {
            String sql = "select TenThuoc, DonViTinh, LoaiThuoc, DonGia, soluongton from thuoc where isdelete = 1 order by tenthuoc ";
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
          public int save(BanHang bh) {

        try {
            String sql1 = "insert into hoadon (MaHD,MaNV,TongTien,IsDelete) values(?,?,?,?)";
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setString(1, bh.getMaHD());
            st1.setString(2, bh.getMaNV());
            st1.setInt(3, bh.getTongTien());
            st1.setInt(4, 1);
            int row1 = st1.executeUpdate();
            
            String sql2 = "insert into ChiTietHoaDon (MaHD,MaThuoc,SoLuong,DonGia) values(?,?,?,?)";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setString(1, bh.getMaHD());
            st2.setString(2, bh.getMaThuoc());
            st2.setInt(3, bh.getSoluong());
            st2.setInt(4, bh.getDonGia());
            int row2 = st2.executeUpdate();
            
            int ttrow = row1 + row2;
            if (ttrow > 0) {
                JOptionPane.showMessageDialog(null, "Thanh toán thành công");
                return row1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }  
            
            
            
    public String fillmaphatsinh() {
    String mps = null; 
    try {
        String sql = "SELECT mahd FROM hoadon WHERE mahd LIKE 'hd%' ORDER BY mahd DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if (rs.next()) { 
            mps = rs.getString("mahd"); 
        }

        rs.close();
        st.close();
    } catch (SQLException ex) {
        Logger.getLogger(QuanLiBanHang.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    int so = Integer.parseInt(mps.substring(3,5));
        String manv = String.valueOf(so);
    return manv;
}
        public String Maphatsinh(){
    if(dsbh.size() <= 0){
        return "hd001";
    } else {
        int count = Integer.valueOf(fillmaphatsinh());
        int ma = Integer.valueOf(fillmaphatsinh());
        if( count >= 100 && count <= 999 ){
            return "hd"+(ma+1);
            }else if(count >= 10 && count <= 99){
                return "hd0" + (ma+1);
                } else {
                    return "hd00" + (ma+1);
                  }
    }
    }
    
}
