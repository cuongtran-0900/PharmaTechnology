package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.ThongKeModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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
                 SELECT month(thoigian) AS month, AVG(tongtien) AS tongtien 
                 FROM HoaDon 
                 WHERE isdelete = 1
                 GROUP BY month(thoigian);
                 """;

    try (Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            int month = rs.getInt("month");
            float avgTongTien = rs.getFloat("tongtien");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // Placeholder
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, month - 1);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            timestamp.setTime(cal.getTimeInMillis());

            ThongKeModel tk = new ThongKeModel();
            tk.setThoiGian(timestamp);
            tk.setTongTien(avgTongTien); 
            tkm.add(tk);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tkm;
}

public List<ThongKeModel> filltoArrayList2() {
    List<ThongKeModel> tkm2 = new ArrayList<>();
    String sql = "select thoigian, tongtien from hoadon;";

    try (Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        tkm2.clear();
        while (rs.next()) {
           ThongKeModel tk = new ThongKeModel();
                tk.setThoiGian(rs.getTimestamp("thoigian"));
                tk.setTongTien(rs.getFloat("tongTien"));
            tkm2.add(tk);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tkm2;
}
}
