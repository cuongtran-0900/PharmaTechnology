package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.ThongKeModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThongKeDAO extends ConnectSQL {
    
    public ThongKeDAO() {
        super();
    }

    public List<ThongKeModel> filltoArrayList() {
        List<ThongKeModel> tkm = new ArrayList<>();
        String sql = """
                     SELECT t.tenthuoc, SUM(hd.tongTien) as tongTien
                     FROM HoaDon hd
                     INNER JOIN ChiTietHoaDon cthd ON hd.MaHD = cthd.MaHD
                     INNER JOIN Thuoc t ON cthd.MaThuoc = t.MaThuoc
                     WHERE hd.IsDelete = 1
                     GROUP BY t.tenthuoc;
                     """;

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                ThongKeModel tk = new ThongKeModel();
                tk.setTenThuoc(rs.getString("tenthuoc"));
                tk.setTongTien(rs.getFloat("tongTien"));
                tkm.add(tk); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tkm;
    }
}
