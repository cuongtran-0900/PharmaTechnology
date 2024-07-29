package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.Model.HoaDon;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class XuatHoaDon {
    public void xuatHoaDon(List<HoaDon> listHoaDon, String Fileluutru) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Hóa đơn");

            // Tạo style cho tiêu đề và các ô có khung
            XSSFCellStyle headerStyle = workbook.createCellStyle();
            XSSFCellStyle cellStyle = workbook.createCellStyle();

            // Định dạng tiêu đề
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            // Định dạng các ô
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            // Tiêu đề bảng
            Row row = spreadsheet.createRow(0);
            row.setHeight((short) 500);
            Cell cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH HÓA ĐƠN");
            cell.setCellStyle(headerStyle);
            spreadsheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));

            // Tiêu đề cột
            String[] headers = {"STT", "Mã HD", "Mã NV", "Mã KH", "Thời gian", "Tổng tiền"};
            row = spreadsheet.createRow(1);
            row.setHeight((short) 500);
            for (int i = 0; i < headers.length; i++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            // Điền dữ liệu vào bảng
            for (int i = 0; i < listHoaDon.size(); i++) {
                HoaDon hd = listHoaDon.get(i);
                row = spreadsheet.createRow(2 + i);
                row.setHeight((short) 400);
                cell = row.createCell(0);
                cell.setCellValue(i + 1);
                cell.setCellStyle(cellStyle);
                cell = row.createCell(1);
                cell.setCellValue(hd.getMaHD());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(2);
                cell.setCellValue(hd.getMaNV());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(3);
                cell.setCellValue(hd.getMaKH());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(4);
                cell.setCellValue(hd.getThoiGian().toString());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(5);
                cell.setCellValue(hd.getTongTien());
                cell.setCellStyle(cellStyle);
            }

            // Kiểm tra và tạo thư mục nếu cần thiết
            File file = new File(Fileluutru);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Xuất file
            try (FileOutputStream out = new FileOutputStream(Fileluutru)) {
                workbook.write(out);
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
