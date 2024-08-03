/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.bean;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import com.mycompany.pharmatechno.Model.GiohangBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


public class ReportUtils {
    //
    public static void generateReport(List<GiohangBean> data) {
    try {
        // Tạo nguồn dữ liệu từ danh sách GiohangBean
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

        // Đường dẫn tới file báo cáo .jasper
        String reportPath = "C:\\Users\\Cuong\\JaspersoftWorkspace\\MyReports\\hoadon.jasper";

        // Tạo đối tượng JasperReport từ file .jasper
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

        // Tạo đối tượng JasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        // Xuất báo cáo ra file PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, "F:\\Hoc IT\\Du An\\Dự Án 1\\hoadon\\report.pdf");

    } catch (JRException e) {
        e.printStackTrace();
    }
}



}

