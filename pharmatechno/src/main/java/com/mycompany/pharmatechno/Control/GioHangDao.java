package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.GiohangBean;
import com.mycompany.pharmatechno.bean.ReportUtils;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class GioHangDao {

    public static List<GiohangBean> convertTableDataToBeans(JTable tblGioHang, GiohangBean beanFromTextFields) {
    DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
    List<GiohangBean> beans = new ArrayList<>();

    for (int i = 0; i < model.getRowCount(); i++) {
        String tenThuoc = (String) model.getValueAt(i, 1);
        int soLuong = (Integer) model.getValueAt(i, 3);
        int donGia = (Integer) model.getValueAt(i, 4);
        int thanhTien = (Integer) model.getValueAt(i, 5);

        // Tạo đối tượng GiohangBean cho mỗi hàng dữ liệu từ bảng
        GiohangBean bean = new GiohangBean(
            beanFromTextFields.getMaHD(), // Sử dụng mã hóa đơn từ trường văn bản
            beanFromTextFields.getThoiGian(), // Sử dụng thời gian từ trường văn bản
            beanFromTextFields.getTenNV(), // Sử dụng tên nhân viên từ trường văn bản
            beanFromTextFields.getTongTien(), // Sử dụng tổng tiền từ trường văn bản
            tenThuoc, 
            soLuong, 
            donGia, 
            thanhTien
        );
        beans.add(bean);
    }

    return beans;
}



    // Chuyển đổi dữ liệu từ các JTextField thành một đối tượng GiohangBean
    public static GiohangBean convertTextFieldsToBean(JTextField txtMaNV, JTextField txtThoiGian, JTextField txtTongTien, JTextField txtMaHoaDon) {
    String MaNV = txtMaNV.getText();
    String ThoiGian = txtThoiGian.getText();
    String MaHD = txtMaHoaDon.getText();
    int TongTien = Integer.parseInt(txtTongTien.getText());

    // Tạo một GiohangBean với thông tin từ các trường văn bản
    return new GiohangBean(MaHD, ThoiGian, MaNV, TongTien, null, 0, 0, 0);
}


//    public void combineDataAndGenerateReport(JTable tblGioHang, JTextField txtMaNV, JTextField txtThoiGian, JTextField txtTongTien, JTextField txtMaHoaDon) {
//    // Chuyển đổi dữ liệu từ các trường văn bản thành một đối tượng GiohangBean
//    GiohangBean beanFromTextFields = convertTextFieldsToBean(txtMaNV, txtThoiGian, txtTongTien, txtMaHoaDon);
//
//    // Chuyển đổi dữ liệu từ bảng thành danh sách GiohangBean
//    List<GiohangBean> dshd = convertTableDataToBeans(tblGioHang, beanFromTextFields);
//
//    // Tạo báo cáo
//    ReportUtils.generateReport(dshd);
//}

}

