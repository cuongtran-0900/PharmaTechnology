/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.ThuocTonKhoModel;
import com.mycompany.pharmatechno.UI.ThuocTonKho;
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
public class ThuocTonKhoDAO extends ConnectSQL{
    
    private final List<ThuocTonKhoModel> ttkm = new ArrayList<>();
     
    public List<ThuocTonKhoModel> filltoArrayList() {
        String sql = """
                    SELECT t.MaThuoc, t.TenThuoc, cthdn.SoLuong, cthd.SoLuong, t.SoLuongTon
                    FROM Thuoc AS t 
                    INNER JOIN chitiethoadonnhap AS cthdn ON t.MaThuoc = cthdn.MaThuoc
                    INNER JOIN ChiTietHoaDon AS cthd ON cthd.MaThuoc = cthdn.MaThuoc;
                     """;

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            ttkm.clear();
            while (rs.next()) {
                ThuocTonKhoModel ttk = new ThuocTonKhoModel();
                ttk.setMaThuoc(rs.getString("MaThuoc"));
                ttk.setTenThuoc(rs.getString("TenThuoc"));
                ttk.setSoLuongNhap(rs.getInt("SoLuongNhap"));
                ttk.setSoLuongBan(rs.getInt("SoLuongBan"));
                ttk.setSoLuongTon(rs.getInt("SoLuongTon"));
                ttkm.add(ttk); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuocTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ttkm;
    }
}
