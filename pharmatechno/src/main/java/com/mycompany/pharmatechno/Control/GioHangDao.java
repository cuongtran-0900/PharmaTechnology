/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.pharmatechno.bean.GiohangBean;
import javax.swing.JTextField;

/**
 *
 * @author Cuong
 */
public class GioHangDao {
    
    public static List<GiohangBean> convertTableDataToBeans(JTable tblGioHang) {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        List<GiohangBean> beans = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            String tenThuoc = (String) model.getValueAt(i, 1);
            int soLuong = (Integer) model.getValueAt(i, 3);
            int donGia = (int) model.getValueAt(i, 4);
            int thanhTien = (int) model.getValueAt(i, 5);
            GiohangBean bean = new GiohangBean(tenThuoc, soLuong, donGia,thanhTien );
            beans.add(bean);
        }

        return beans;
    }
    public static GiohangBean convertTextFieldsToBean(JTextField txtMaNV, JTextField txtThoiGian, JTextField txtTongTien,
                                                      JTextField txtMaHoaDon) {
        String MaNV = txtMaNV.getText();
        String ThoiGian = txtThoiGian.getText();
        String MaHD = txtMaHoaDon.getText();
        int TongTien = Integer.parseInt(txtTongTien.getText());

        return new GiohangBean(MaNV, TongTien, ThoiGian, MaHD);
    }

    
}
