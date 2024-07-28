/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.pharmatechno.Model.HoaDonNhap;
import com.mycompany.pharmatechno.UI.HoaDonNhapUI;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class HoaDonNhapDao extends ConnectSQL {

    List<HoaDonNhap> dshdn = new ArrayList<>();
    List<HoaDonNhap> dshdnls = new ArrayList<>();

    public List<HoaDonNhap> filltoArrayList() {
        try {
//            String sql = 
//                    """
//                    select hdn.mahdn, t.tenthuoc, hdn.manpp, cthdn.soluong, hdn.nguoigiao, hdn.nguoinhan, hdn.ngayviet, hdn.ngaynhap
//                    from hoadonnhap as hdn
//                    inner join chitiethoadonnhap as cthdn on hdn.maHDN = cthdn.MaHDN
//                    inner join Thuoc as t on t.MaThuoc = cthdn.MaThuoc;""";
            String sql
                    = """
                SELECT hdn.*, t.MaThuoc, t.TenThuoc, cthdn.SoLuong
                FROM hoadonnhap AS hdn
                INNER JOIN chitiethoadonnhap AS cthdn ON hdn.MaHDN = cthdn.MaHDN
                INNER JOIN Thuoc AS t ON t.MaThuoc = cthdn.MaThuoc;
                """;
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                dshdn.clear();
                while (rs.next()) {
                    HoaDonNhap hdn = new HoaDonNhap();
                    hdn.setMaHDN(rs.getString("MaHDN"));
                    hdn.setMaNPP(rs.getString("MaNPP"));
                    hdn.setMaThuoc(rs.getString("MaThuoc"));
                    hdn.setTenThuoc(rs.getString("TenThuoc"));
                    hdn.setSoLuong(rs.getInt("SoLuong"));
                    hdn.setNguoiGiao(rs.getString("nguoiGiao"));
                    hdn.setNguoiNhan(rs.getString("nguoiNhan"));
                    hdn.setNgayViet(rs.getDate("ngayViet"));
                    hdn.setNgayNhap(rs.getDate("ngayNhap"));
                    hdn.setTongTien(rs.getFloat("tongTien"));

                    dshdn.add(hdn);
                }
                rs.close();
                st.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dshdn;
    }

    public void add(HoaDonNhap hdn) {
        dshdn.add(hdn);
        // Logic to add hdn to the database or any other source
    }

    public void update(int index, HoaDonNhap hdn) {
        dshdn.set(index, hdn);
        // Logic to update hdn in the database or any other source
    }

    public void delete(int index) {
        dshdn.remove(index);
        // Logic to delete hdn from the database or any other source
    }
}
