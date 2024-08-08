package com.mycompany.pharmatechno.UI;

import com.mycompany.pharmatechno.Control.HoaDonDao;
import com.mycompany.pharmatechno.Model.HoaDon;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;

/**
 *
 * @author tu
 */
public class hoadon extends javax.swing.JPanel {

    int vitri = 0;

    /**
     * Creates new form hoadon
     */
    public hoadon() {
        initComponents();
        filltotable(); // đổ dữ liệu vào bảng
        filltotable2();
        fillToTextBox(vitri);
        addTableMouseListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    HoaDonDao nvhd = new HoaDonDao(); // Khởi tạo đối tượng HoaDonDao để quản lý dữ liệu hóa đơn
    List<HoaDon> dshd = nvhd.filltoArrayList(); // Lấy danh sách hóa đơn từ cơ sở dữ liệu
    List<HoaDon> tblhd = nvhd.filltoArrayListForTblHD(); // Lấy danh sách hóa đơn từ cơ sở dữ liệu


    public void filltotable() {     
        DefaultTableModel model = (DefaultTableModel) tbl_HoaDon.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có
        for (HoaDon hd : tblhd) { // Duyệt qua danh sách hóa đơn
            model.addRow(new Object[]{hd.getTenThuoc(), hd.getSoLuong(), hd.getDonGia(),hd.getThanhTien()});
        }
    }

    public void filltotable2() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon_lichsu.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có
        for (HoaDon hd : dshd) { // Duyệt qua danh sách lịch sử hóa đơn
            model.addRow(new Object[]{hd.getMaHD(), hd.getTenNV(), hd.getThoiGian(),hd.getTongTien()}); // Thêm hàng mới vào bảng
        }
    }

    void fillToTextBox(int index) {
        if (index >= 0 && index < dshd.size()) {
            HoaDon hd = dshd.get(index);
            txtMaHD.setText(hd.getMaHD());
            txtTongTien.setText(String.valueOf(hd.getTongTienNgay()));
            txtTenNV.setText(hd.getTenNV());
            txtThoiGian.setDate(hd.getThoiGian());
        }
        
    }
    

    public void showDetail() {
        int viewIndex = tbl_HoaDon.getSelectedRow();
        if (viewIndex == -1) {
            return;
        }

        int modelIndex = tbl_HoaDon.convertRowIndexToModel(viewIndex);
        if (modelIndex >= 0 && modelIndex < dshd.size()) {
            HoaDon hd = dshd.get(modelIndex);
            txtMaHD.setText(hd.getMaHD());
            txtTenNV.setText(hd.getTenNV());
            txtTongTien.setText(String.valueOf(hd.getTongTienNgay()));
            txtThoiGian.setDate(hd.getThoiGian());
            
        }
        DefaultTableModel model = (DefaultTableModel) tbl_HoaDon.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có
        for (HoaDon hd : dshd) { // Duyệt qua danh sách hóa đơn
            model.addRow(new Object[]{hd.getTenThuoc(), hd.getSoLuong(), hd.getDonGia(),hd.getThanhTien()});
        }
    }


    private void addTableMouseListener() {
    tbl_HoaDon.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tbl_HoaDon.rowAtPoint(e.getPoint());
            if (row >= 0) {
                fillToTextBox(row); // Cập nhật các ô văn bản với dữ liệu của hàng được chọn
            }
        }
    });
}
    
    
    
    
    
    
    private void find() {
        DefaultTableModel ob = (DefaultTableModel) tblHoaDon_lichsu.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblHoaDon_lichsu.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText()));
    }

    private void printBill(HoaDon hd) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }

            // Lấy kích thước trang và điều chỉnh độ rộng
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            g2d.setFont(new Font("Serif", Font.PLAIN, 12));

            // Tạo nội dung cần in
            int x = 100;
            int y = 100;
            int lineHeight = 15; // Chiều cao mỗi dòng

            graphics.drawString("HÓA ĐƠN", x, y);
            y += lineHeight;
            graphics.drawString("Mã hóa đơn: " + hd.getMaHD(), x, y);
            y += lineHeight;
            graphics.drawString("Tên nhân viên: " + hd.getTenNV(), x, y);
            y += lineHeight;
             graphics.drawString("Tên thuốc: " + hd.getTenThuoc(), x, y);
            y += lineHeight;
            graphics.drawString("Thời gian: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(hd.getThoiGian()), x, y);
            y += lineHeight;
             graphics.drawString("Số lượng: " + hd.getSoLuong(), x, y);
            y += lineHeight;
             graphics.drawString("Đơn giá: " + hd.getDonGia(), x, y);
            y += lineHeight;
            graphics.drawString("Tổng tiền: " + hd.getThanhTien(), x, y);

            return PAGE_EXISTS;
        });

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }

//   private void addTableMouseListener() {
//    tbl_HoaDon.addMouseListener(new MouseAdapter() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            int row = tbl_HoaDon.rowAtPoint(e.getPoint());
//            if (row >= 0) {
//                fillToTextBox(row); // Update text boxes with the selected row's data
//            }
//        }
//    });
//}
   











// Bảng Hóa Đơn
   
    private void navigate1(int index) {
        tbl_HoaDon.setRowSelectionInterval(index, index);
        showDetail();
    }  
   
    public void btnFirst1() {
        navigate1(0);
        scrollToVisible1(0);
    }
    public void btnBack1() {
        int currentIndex = tbl_HoaDon.getSelectedRow();
        if (currentIndex > 0) {
            navigate1(currentIndex - 1);
            scrollToVisible1(currentIndex - 1);
        }
    }
    
       private void btnNext1() {
        int currentIndex = tbl_HoaDon.getSelectedRow();
        if (currentIndex < dshd.size() - 1) {
            navigate1(currentIndex + 1);
            scrollToVisible1(currentIndex + 1);
        }
    }
       
          private void btnLast1() {
        int lastIndex = dshd.size() - 1;
        navigate1(lastIndex);
        scrollToVisible1(lastIndex);
    }
          
              private void scrollToVisible1(int rowIndex) {
    tbl_HoaDon.scrollRectToVisible(tbl_HoaDon.getCellRect(rowIndex, 0, true));
}
   
   
              
    // Bảng Lịch Sử Hóa Đơn
              
   private void navigate2(int index) {
        tblHoaDon_lichsu.setRowSelectionInterval(index, index);
        showDetail();
    }  
   
    public void btnFirst2() {
        navigate2(0);
        scrollToVisible2(0);
    }
    public void btnBack2() {
        int currentIndex = tblHoaDon_lichsu.getSelectedRow();
        if (currentIndex > 0) {
            navigate2(currentIndex - 1);
            scrollToVisible2(currentIndex - 1);
        }
    }
    
       
          
              private void scrollToVisible2(int rowIndex) {
    tblHoaDon_lichsu.scrollRectToVisible(tblHoaDon_lichsu.getCellRect(rowIndex, 0, true));
              }
   
   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HoaDon = new javax.swing.JTable();
        btnInHoaDon = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtThoiGian = new com.toedter.calendar.JDateChooser();
        btnFirst1 = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        txtTenNV = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon_lichsu = new javax.swing.JTable();
        btnInHoaDon1 = new javax.swing.JButton();
        btnFirst2 = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();
        btnNext2 = new javax.swing.JButton();
        btnLast2 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        tbl_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên thuốc", "Số lượng", "Đơn giá", "Thành Tiền"
            }
        ));
        tbl_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_HoaDon);

        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Printer.png"))); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        jLabel29.setText("Thời gian");

        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDjTextField2ActionPerformed(evt);
            }
        });

        jLabel26.setText("Mã hóa đơn");

        jLabel27.setText("Mã nhân viên");

        txtThoiGian.setDateFormatString("dd-MM-yyyy");

        btnFirst1.setText("|<");
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });

        btnBack1.setText("<<");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        btnNext1.setText(">>");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnLast1.setText(">|");
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVjTextField1ActionPerformed(evt);
            }
        });

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienjTextField1ActionPerformed(evt);
            }
        });

        jLabel33.setText("Tổng Tiền :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenNV)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel27))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(45, 45, 45)
                        .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnFirst1)
                .addGap(18, 18, 18)
                .addComponent(btnBack1)
                .addGap(32, 32, 32)
                .addComponent(btnNext1)
                .addGap(29, 29, 29)
                .addComponent(btnLast1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInHoaDon)
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29))
                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst1)
                    .addComponent(btnBack1)
                    .addComponent(btnNext1)
                    .addComponent(btnLast1)
                    .addComponent(btnInHoaDon))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Hóa đơn xuất", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        tblHoaDon_lichsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Tên NV", "Ngày mua hàng", "Tổng tiền"
            }
        ));
        tblHoaDon_lichsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDon_lichsuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon_lichsu);

        btnInHoaDon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Printer.png"))); // NOI18N
        btnInHoaDon1.setText("In hóa đơn");
        btnInHoaDon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDon1ActionPerformed(evt);
            }
        });

        btnFirst2.setText("|<");
        btnFirst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst2ActionPerformed(evt);
            }
        });

        btnBack2.setText("<<");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        btnNext2.setText(">>");
        btnNext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext2ActionPerformed(evt);
            }
        });

        btnLast2.setText(">|");
        btnLast2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast2ActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel3.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnFirst2)
                .addGap(18, 18, 18)
                .addComponent(btnBack2)
                .addGap(32, 32, 32)
                .addComponent(btnNext2)
                .addGap(29, 29, 29)
                .addComponent(btnLast2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
                .addComponent(btnInHoaDon1)
                .addGap(70, 70, 70))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(496, 496, 496))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst2)
                    .addComponent(btnBack2)
                    .addComponent(btnNext2)
                    .addComponent(btnLast2)
                    .addComponent(btnInHoaDon1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử hóa đơn", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 26)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(386, 386, 386))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaHDjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDjTextField2ActionPerformed

    private void tbl_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonMouseClicked
        // TODO add your handling code here:
        fillToTextBox(vitri);
        
    }//GEN-LAST:event_tbl_HoaDonMouseClicked

    private void btnLast2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast2ActionPerformed
        // TODO add your handling code here:
        btnBack2.setEnabled(true);
        btnFirst2.setEnabled(true);
        btnNext2.setEnabled(false);
        btnLast2.setEnabled(false);
    }//GEN-LAST:event_btnLast2ActionPerformed

    private void btnNext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext2ActionPerformed
        // TODO add your handling code here:
        btnBack2.setEnabled(true);
        btnFirst2.setEnabled(true);
        btnNext2.setEnabled(true);
        btnLast2.setEnabled(true);
    }//GEN-LAST:event_btnNext2ActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
        btnBack2();
        btnBack2.setEnabled(true);
        btnFirst2.setEnabled(true);
        btnNext2.setEnabled(true);
        btnLast2.setEnabled(true);
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void btnFirst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst2ActionPerformed
        // TODO add your handling code here:
        btnFirst2();
        btnBack2.setEnabled(false);
        btnFirst2.setEnabled(false);
        btnNext2.setEnabled(true);
        btnLast2.setEnabled(true);
    }//GEN-LAST:event_btnFirst2ActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        // TODO add your handling code here:
        btnFirst1();
        btnBack1.setEnabled(false);
        btnFirst1.setEnabled(false);
        btnNext1.setEnabled(true);
        btnLast1.setEnabled(true);
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
    btnBack1();
        btnBack1.setEnabled(true);
        btnFirst1.setEnabled(true);
        btnNext1.setEnabled(true);
        btnLast1.setEnabled(true);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
     btnNext1();
        btnBack1.setEnabled(true);
        btnFirst1.setEnabled(true);
        btnNext1.setEnabled(true);
        btnLast1.setEnabled(true);
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
        btnLast1();
            btnBack1.setEnabled(true);
            btnFirst1.setEnabled(true);
            btnNext1.setEnabled(false);
            btnLast1.setEnabled(false);       
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        int selectedRow = tbl_HoaDon.getSelectedRow();
        if (selectedRow >= 0) {
            HoaDon hd = dshd.get(tbl_HoaDon.convertRowIndexToModel(selectedRow));
            printBill(hd);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để in.");
        }
    xuatHoaDon();
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTenNVjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVjTextField1ActionPerformed

    private void btnInHoaDon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDon1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnInHoaDon1ActionPerformed

    private void txtTongTienjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienjTextField1ActionPerformed

    private void tblHoaDon_lichsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon_lichsuMouseClicked
        // TODO add your handling code here:
        showDetail();
    }//GEN-LAST:event_tblHoaDon_lichsuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnFirst2;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnInHoaDon1;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnLast2;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnNext2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblHoaDon_lichsu;
    private javax.swing.JTable tbl_HoaDon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtTenNV;
    private com.toedter.calendar.JDateChooser txtThoiGian;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void xuatHoaDon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
