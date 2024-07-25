package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.UI.DoanhThu;
import com.mycompany.pharmatechno.Model.DoanhThuModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data Access Object for sales data (DoanhThu).
 */
public class DoanhThuDAO extends ConnectSQL {

    private final List<DoanhThuModel> dtm = new ArrayList<>();

    /**
     * Fills a list with sales data retrieved from the database.
     * 
     * @return a list of DoanhThuModel objects containing sales data.
     */
    public List<DoanhThuModel> filltoArrayList() {
        String sql = """
                     SELECT hd.thoigian, t.tenthuoc, cthd.soluong, hd.tongTien 
                     FROM hoadon AS hd 
                     INNER JOIN ChiTietHoaDon AS cthd ON hd.MaHD = cthd.MaHD
                     INNER JOIN thuoc AS t ON t.MaThuoc = cthd.MaThuoc;
                     """;

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            dtm.clear();
            while (rs.next()) {
                DoanhThuModel dt = new DoanhThuModel();
                dt.setThoiGian(rs.getTimestamp("thoigian"));
                dt.setTenThuoc(rs.getString("tenthuoc"));
                dt.setSoLuong(rs.getInt("soluong"));
                dt.setTongTien(rs.getFloat("tongTien"));
                dtm.add(dt); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }
}
