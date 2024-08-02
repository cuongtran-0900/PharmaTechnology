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
    HoaDonDao nvhdls = new HoaDonDao(); // Khởi tạo đối tượng HoaDonDao khác để quản lý lịch sử hóa đơn
    List<HoaDon> dshd = nvhd.filltoArrayList(); // Lấy danh sách hóa đơn từ cơ sở dữ liệu
    List<HoaDon> dshdls = nvhdls.filltoArrayList2(); // Lấy danh sách lịch sử hóa đơn từ cơ sở dữ liệu

    public void filltotable() {     
        DefaultTableModel model = (DefaultTableModel) tbl_HoaDon.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có
        for (HoaDon hd : dshd) { // Duyệt qua danh sách hóa đơn
            model.addRow(new Object[]{hd.getTenThuoc(), hd.getSoLuong(), hd.getDonGia(),hd.getThanhTien()});
        }
    }

    public void filltotable2() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon_lichsu.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có
        for (HoaDon hd : dshdls) { // Duyệt qua danh sách lịch sử hóa đơn
            model.addRow(new Object[]{hd.getMaHD(), hd.getMaKH(), hd.getThoiGian(),hd.getTongTien()}); // Thêm hàng mới vào bảng
        }
    }

    void fillToTextBox(int index) {
        if (index >= 0 && index < dshd.size()) {
            HoaDon hd = dshd.get(index);
            txtMaHD.setText(hd.getMaHD());
            txtMaKH.setText(hd.getMaKH());
            txtMaNV.setText(hd.getMaNV());
            txtThoiGian.setDate(hd.getThoiGian());
            txtTongTien.setText(String.valueOf(hd.getTongTienNgay()));
        }
    }
    
        void fillToTextBox2(int index) {
        if (index >= 0 && index < dshdls.size()) {
            HoaDon hd = dshdls.get(index);
            txtMaHD.setText(hd.getMaHD());
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
            txtMaNV.setText(hd.getMaNV());
            txtMaKH.setText(hd.getMaKH());
            txtTongTien.setText(String.valueOf(hd.getTongTienNgay()));
        }
    }

    public void showDetail2() {
        int viewIndex = tblHoaDon_lichsu.getSelectedRow();
        if (viewIndex == -1) {
            return;
        }
        int modelIndex = tblHoaDon_lichsu.convertRowIndexToModel(viewIndex);
        if (modelIndex >= 0 && modelIndex < dshdls.size()) {
            HoaDon hd = dshdls.get(modelIndex);
//            txtMaHD.setText(hd.getMaHD());

        }
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
            graphics.drawString("Mã nhân viên: " + hd.getMaNV(), x, y);
            y += lineHeight;
            graphics.drawString("Mã khách hàng: " + hd.getMaKH(), x, y);
            y += lineHeight;
            // graphics.drawString("Tên thuốc: " + hd.getTenThuoc(), x, y);
            y += lineHeight;
            graphics.drawString("Thời gian: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(hd.getThoiGian()), x, y);
            y += lineHeight;
            // graphics.drawString("Số lượng: " + hd.getSoLuong(), x, y);
            y += lineHeight;
            // graphics.drawString("Đơn giá: " + hd.getDonGia(), x, y);
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

   private void addTableMouseListener() {
    tbl_HoaDon.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tbl_HoaDon.rowAtPoint(e.getPoint());
            if (row >= 0) {
                fillToTextBox(row); // Update text boxes with the selected row's data
            }
        }
    });
}
   
   
   
   
   
   
   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon_lichsu = new javax.swing.JTable();
        btnInHoaDon1 = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HoaDon = new javax.swing.JTable();
        btnInHoaDon = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtThoiGian = new com.toedter.calendar.JDateChooser();
        btnFirst1 = new javax.swing.JButton();
        btnPrev1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        txtMaNV = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(51, 255, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        tblHoaDon_lichsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã khách hàng", "Ngày mua hàng", "Tổng tiền"
            }
        ));
        tblHoaDon_lichsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDon_lichsuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon_lichsu);
        if (tblHoaDon_lichsu.getColumnModel().getColumnCount() > 0) {
            tblHoaDon_lichsu.getColumnModel().getColumn(3).setHeaderValue("Tổng tiền");
        }

        btnInHoaDon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Printer.png"))); // NOI18N
        btnInHoaDon1.setText("In hóa đơn");
        btnInHoaDon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDon1ActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
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
                .addComponent(btnFirst)
                .addGap(18, 18, 18)
                .addComponent(btnPrev)
                .addGap(32, 32, 32)
                .addComponent(btnNext)
                .addGap(29, 29, 29)
                .addComponent(btnLast)
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
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(btnInHoaDon1))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử hóa đơn", jPanel2);

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

        jLabel28.setText("Mã khách hàng");

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHjTextField3ActionPerformed(evt);
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

        btnPrev1.setText("<<");
        btnPrev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev1ActionPerformed(evt);
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

        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVjTextField1ActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaNV)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel27)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(45, 45, 45)
                                .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaKH))))
                    .addComponent(jLabel33))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnFirst1)
                .addGap(18, 18, 18)
                .addComponent(btnPrev1)
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
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst1)
                    .addComponent(btnPrev1)
                    .addComponent(btnNext1)
                    .addComponent(btnLast1)
                    .addComponent(btnInHoaDon))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Hóa đơn xuất", jPanel1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaKHjTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHjTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHjTextField3ActionPerformed

    private void txtMaHDjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDjTextField2ActionPerformed

    private void tbl_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonMouseClicked
        // TODO add your handling code here:
        fillToTextBox(vitri);
        
    }//GEN-LAST:event_tbl_HoaDonMouseClicked

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        int viewIndex = tblHoaDon_lichsu.getSelectedRow();
        if (viewIndex != -1) {
            int modelIndex = tblHoaDon_lichsu.convertRowIndexToModel(viewIndex);
            if (modelIndex + 1 < dshdls.size()) {
                tblHoaDon_lichsu.setRowSelectionInterval(dshdls.size() - 1, dshdls.size() - 1);
                showDetail2();
            }
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        int viewIndex = tblHoaDon_lichsu.getSelectedRow();
        if (viewIndex != -1) {
            int modelIndex = tblHoaDon_lichsu.convertRowIndexToModel(viewIndex);
            if (modelIndex + 1 < dshdls.size()) {
                tblHoaDon_lichsu.setRowSelectionInterval(viewIndex + 1, viewIndex + 1);
                showDetail2();
            }
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        int viewIndex = tblHoaDon_lichsu.getSelectedRow();
        if (viewIndex != -1) {
            int modelIndex = tblHoaDon_lichsu.convertRowIndexToModel(viewIndex);
            if (modelIndex > 0) {
                tblHoaDon_lichsu.setRowSelectionInterval(viewIndex - 1, viewIndex - 1);
                showDetail2();
            }
        }

    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        vitri = 0;
        this.fillToTextBox(vitri);
        tblHoaDon_lichsu.setRowSelectionInterval(vitri, vitri);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        // TODO add your handling code here:
        vitri = 0;
        this.fillToTextBox(vitri);
        tbl_HoaDon.setRowSelectionInterval(vitri, vitri);
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        // TODO add your handling code here:
        int viewIndex = tbl_HoaDon.getSelectedRow();
        if (viewIndex != -1) {
            int modelIndex = tbl_HoaDon.convertRowIndexToModel(viewIndex);
            if (modelIndex > 0) {
                tbl_HoaDon.setRowSelectionInterval(viewIndex - 1, viewIndex - 1);
                showDetail();
            }
        }

    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
        int viewIndex = tbl_HoaDon.getSelectedRow();
        if (viewIndex != -1) {
            int modelIndex = tbl_HoaDon.convertRowIndexToModel(viewIndex);
            if (modelIndex + 1 < dshd.size()) {
                tbl_HoaDon.setRowSelectionInterval(viewIndex + 1, viewIndex + 1);
                showDetail();
            }
        }
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
        int viewIndex = tbl_HoaDon.getSelectedRow();
        if (viewIndex != -1) {
            int modelIndex = tbl_HoaDon.convertRowIndexToModel(viewIndex);
            if (modelIndex + 1 < dshd.size()) {
                tbl_HoaDon.setRowSelectionInterval(dshd.size() - 1, dshd.size() - 1);
                showDetail();
            }
        }
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        int selectedRow = tbl_HoaDon.getSelectedRow();
        if (selectedRow >= 0) {
            HoaDon hd = dshd.get(tbl_HoaDon.convertRowIndexToModel(selectedRow));
            printBill(hd);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để in.");
        }
//        xuatHoaDon();
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtMaNVjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVjTextField1ActionPerformed

    private void btnInHoaDon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDon1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInHoaDon1ActionPerformed

    private void txtTongTienjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienjTextField1ActionPerformed

    private void tblHoaDon_lichsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon_lichsuMouseClicked
        // TODO add your handling code here:
        fillToTextBox2(vitri);
    }//GEN-LAST:event_tblHoaDon_lichsuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnInHoaDon1;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblHoaDon_lichsu;
    private javax.swing.JTable tbl_HoaDon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtThoiGian;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

//    private void xuatHoaDon() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    private void XuatHoaDon() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
