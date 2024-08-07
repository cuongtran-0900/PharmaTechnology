/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pharmatechno.UI;

import com.mycompany.pharmatechno.Control.HoaDonNhapDao;
import com.mycompany.pharmatechno.Model.ChiTietHoaDonNhap;
import com.mycompany.pharmatechno.Model.HoaDonNhap;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author tu
 */
public class HoaDonNhapUI extends javax.swing.JPanel {

    int vitri = 0;

    /**
     * Creates new form NewJPanel
     */
    public HoaDonNhapUI() {
        initComponents();
        filltotbllichsuHD();
//        txtMaHDN.setEditable(false);
//        txtMaNPP.setEditable(false);
        txtTongTien.setEditable(false);
        BtnSua.setEnabled(false);
        btnHoanThanh.setEnabled(false);
        btnThemThuoc.setEnabled(false);
        
        DefaultTableModel modelHDN = (DefaultTableModel) tblHDN.getModel();
        tblHDN.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tblHDN.getSelectedRow();
                if (row >= 0) {
                    txtMaThuoc.setText(modelHDN.getValueAt(row, 0).toString());
                    txtTenThuoc.setText(modelHDN.getValueAt(row, 1).toString());
                    txtDonGia.setText(modelHDN.getValueAt(row, 3).toString());
                    txtSoLuong.setText(modelHDN.getValueAt(row, 2).toString());
                }
            }
        });
        tblHDN.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                updateTableInfo(); // Cập nhật thông tin bảng
            }
        });

        // Xử lý sự kiện khi thay đổi giá trị của txtSoLuong
        txtSoLuong.addActionListener(e -> {
            int row = tblHDN.getSelectedRow();
            if (row >= 0) {
                try {
                    int soLuong = Integer.parseInt(txtSoLuong.getText());
                    int donGia = (int) tblHDN.getValueAt(row, 3); // Đơn giá
                    int thanhTien = donGia * soLuong;
                    tblHDN.setValueAt(soLuong, row, 2); // Cập nhật số lượng
                    tblHDN.setValueAt(thanhTien, row, 4); // Cập nhật thành tiền

                    // Cập nhật tổng tiền
                    updateTotalAmount();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    String tenthuoc = txtTenThuoc.getText();
                    tblHDN.setValueAt(tenthuoc, row, 1); // Cập nhật số lượng
                    // Cập nhật tổng tiền
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Tên thuốc không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Xử lý sự kiện khi thay đổi giá trị của txtDonGia
        txtDonGia.addActionListener(e -> {
            int row = tblHDN.getSelectedRow();
            if (row >= 0) {
                try {
                    int donGia = Integer.parseInt(txtDonGia.getText());
                    int soLuong = (int) tblHDN.getValueAt(row, 2); // Số lượng
                    int thanhTien = (int) (donGia * soLuong);
                    tblHDN.setValueAt(donGia, row, 3); // Cập nhật đơn giá
                    tblHDN.setValueAt(thanhTien, row, 4); // Cập nhật thành tiền

                    // Cập nhật tổng tiền
                    updateTotalAmount();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    String tenthuoc = txtTenThuoc.getText();
                    tblHDN.setValueAt(tenthuoc, row, 1); // Cập nhật số lượng
                    // Cập nhật tổng tiền
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Tên thuốc không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        txtTenThuoc.addActionListener(e -> {
            int row = tblHDN.getSelectedRow();
            if (row >= 0) {
                try {
                    String tenthuoc = txtTenThuoc.getText();
                    tblHDN.setValueAt(tenthuoc, row, 1); // Cập nhật số lượng
                    // Cập nhật tổng tiền
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Tên thuốc không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    int soLuong = Integer.parseInt(txtSoLuong.getText());
                    int donGia = (int) tblHDN.getValueAt(row, 3); // Đơn giá
                    int thanhTien = donGia * soLuong;
                    tblHDN.setValueAt(soLuong, row, 2); // Cập nhật số lượng
                    tblHDN.setValueAt(thanhTien, row, 4); // Cập nhật thành tiền

                    // Cập nhật tổng tiền
                    updateTotalAmount();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    int donGia = Integer.parseInt(txtDonGia.getText());
                    int soLuong = (int) tblHDN.getValueAt(row, 2); // Số lượng
                    int thanhTien = (int) (donGia * soLuong);
                    tblHDN.setValueAt(donGia, row, 3); // Cập nhật đơn giá
                    tblHDN.setValueAt(thanhTien, row, 4); // Cập nhật thành tiền

                    // Cập nhật tổng tiền
                    updateTotalAmount();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    HoaDonNhapDao hdndao = new HoaDonNhapDao();
    List<HoaDonNhap> dshdn = hdndao.filltoArrayList();

//    private void initComponents() {
//        // Existing initComponents code
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
// frame hoa dơn nhập xuất


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichSuHDN = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHDN = new javax.swing.JTable();
        txtMaHDN = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtMaNPP = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtNguoiGiao = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtNguoiNhan = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtNgayNhap = new com.toedter.calendar.JDateChooser();
        txtNgayViet = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        BtnSua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnHoanThanh = new javax.swing.JButton();
        txtMaThuoc = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtTenThuoc = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btnThemThuoc = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÓA ĐƠN NHẬP HÀNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        tblLichSuHDN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HĐN", "Mã NPP", "Ngày Viết ", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLichSuHDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLichSuHDNMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLichSuHDN);

        tblHDN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Thuốc", "Tên Thuốc", "Số Lượng", "Giá Nhập", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDNMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHDN);

        txtMaHDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDNActionPerformed(evt);
            }
        });

        jLabel30.setText("Mã HĐN :");

        txtMaNPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNPPActionPerformed(evt);
            }
        });

        jLabel31.setText("Mã NPP :");

        jLabel32.setText("Người Giao :");

        jLabel33.setText("Người Nhận :");

        jLabel34.setText("Ngày Viết :");

        jLabel35.setText("Ngày Nhập :");

        jLabel36.setText("Tổng Tiền :");

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        txtNgayNhap.setDateFormatString("dd-MM-yyyy");

        txtNgayViet.setDateFormatString("dd-MM-yyyy");

        jLabel2.setText("Tìm Kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnThem.setText("Thêm HĐN");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        BtnSua.setText("Cập Nhật");
        BtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSuaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LỊCH SỬ HDN");

        btnHoanThanh.setText("Hoàn Thành");
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        txtMaThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaThuocMouseClicked(evt);
            }
        });
        txtMaThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaThuocActionPerformed(evt);
            }
        });

        jLabel37.setText("Mã Thuốc :");

        txtTenThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenThuocMouseClicked(evt);
            }
        });
        txtTenThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenThuocActionPerformed(evt);
            }
        });

        jLabel38.setText("Tên Thuốc :");

        txtSoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSoLuongMouseClicked(evt);
            }
        });
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        txtDonGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDonGiaMouseClicked(evt);
            }
        });
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        jLabel39.setText("Giá Nhập :");

        jLabel40.setText("Số Lượng :");

        btnThemThuoc.setText("Thêm Thuốc");
        btnThemThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel37)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtMaHDN, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtMaNPP, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtNgayViet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(80, 80, 80)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(jLabel33))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtNguoiNhan)
                                                    .addComponent(txtNguoiGiao)
                                                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtSoLuong)
                                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(218, Short.MAX_VALUE))
                            .addComponent(jScrollPane6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnThemThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(BtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayViet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNguoiGiao)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(BtnSua))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemThuoc)
                            .addComponent(btnHoanThanh))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void showDetail() {
        int viewIndex = tblLichSuHDN.getSelectedRow();
        if (viewIndex == -1) {
            return;
        }

        int modelIndex = tblLichSuHDN.convertRowIndexToModel(viewIndex);
        if (modelIndex >= 0 && modelIndex < dshdn.size()) {
            HoaDonNhap hdn = dshdn.get(modelIndex); // Lấy hóa đơn nhập từ danh sách

            txtMaHDN.setText(hdn.getMaHDN());
            txtMaNPP.setText(hdn.getMaNPP());
            txtNguoiGiao.setText(hdn.getNguoiGiao());
            txtNguoiNhan.setText(hdn.getNguoiNhan());
            txtTongTien.setText(String.valueOf(hdn.getTongTien()));
            txtNgayNhap.setDate(hdn.getNgayNhap());
            txtNgayViet.setDate(hdn.getNgayViet());
            showDetailInTblHDN(hdn);

        }

    }

    private void showDetailInTblHDN(HoaDonNhap hdn) {
        DefaultTableModel model = (DefaultTableModel) tblHDN.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trong tblHDN

        for (ChiTietHoaDonNhap chiTiet : hdn.getChiTietHoaDonNhap()) {
            Object[] row = {
                chiTiet.getMaThuoc(),
                chiTiet.getTenThuoc(),
                chiTiet.getSoLuong(),
                chiTiet.getGiaNhap(),
                chiTiet.getThanhTien()
            };
            model.addRow(row);
        }
    }

    private void updateTableInfo() {
        int row = tblHDN.getSelectedRow();
        if (row >= 0) {
            // Lấy giá trị từ bảng
            String maThuoc = (String) tblHDN.getValueAt(row, 0); // Cột mã thuốc
            String tenThuoc = (String) tblHDN.getValueAt(row, 1); // Cột tên thuốc
            int donGia = (int) tblHDN.getValueAt(row, 2); // Cột đơn giá
            int soLuong = (int) tblHDN.getValueAt(row, 3); // Cột số lượng

            // Cập nhật các trường văn bản
            txtMaThuoc.setText(maThuoc);
            txtTenThuoc.setText(tenThuoc);
            txtDonGia.setText(String.format("%d", donGia));
            txtSoLuong.setText(String.valueOf(soLuong));

            // Cập nhật thành tiền
            int thanhTien = donGia * soLuong;
            tblHDN.setValueAt(thanhTien, row, 4); // Cột thành tiền

            // Cập nhật tổng tiền
            updateTotalAmount();
        }
    }

    private void updateTotalAmount() {
        int totalAmount = 0;
        for (int i = 0; i < tblHDN.getRowCount(); i++) {
            totalAmount += (int) tblHDN.getValueAt(i, 4); // Cột thành tiền
        }
        txtTongTien.setText(String.format("%d", totalAmount));
    }

    private void save() {
        HoaDonNhap hdn = new HoaDonNhap();

        // Kiểm tra mã hóa đơn nhập có tồn tại không
        if (hdndao.check(txtMaHDN.getText())) {
            try {
                // Thiết lập thông tin cho hóa đơn nhập
                hdn.setMaHDN(txtMaHDN.getText().trim()); // Mã hóa đơn nhập
                hdn.setMaNPP(txtMaNPP.getText().trim()); // Mã nhà phân phối
                hdn.setNguoiGiao(txtNguoiGiao.getText().trim()); // Người giao hàng
                hdn.setNguoiNhan(txtNguoiNhan.getText().trim()); // Người nhận hàng

                // Chuyển đổi và gán giá trị tổng tiền từ JTextField
                hdn.setTongTien(Integer.parseInt(txtTongTien.getText().trim())); // Tổng tiền

                // Kiểm tra và thiết lập ngày nhập và ngày viết
                Date NgayNhapUntil = txtNgayNhap.getDate();
                Date NgayVietUntil = txtNgayViet.getDate();

                if (NgayNhapUntil == null || NgayVietUntil == null) {
                    throw new IllegalArgumentException("Ngày nhập và ngày viết không được để trống.");
                }
                if (txtNguoiGiao == null || txtNguoiNhan == null) {
                    throw new IllegalArgumentException("Người giao và người nhận không được để trống.");
                }

                java.sql.Date NgayNhap = new java.sql.Date(NgayNhapUntil.getTime());
                java.sql.Date NgayViet = new java.sql.Date(NgayVietUntil.getTime());

                hdn.setNgayNhap(NgayNhap);
                hdn.setNgayViet(NgayViet);

                // Thêm chi tiết hóa đơn nhập
                List<ChiTietHoaDonNhap> chiTietList = new ArrayList<>();
                for (int i = 0; i < tblHDN.getRowCount(); i++) {
                    ChiTietHoaDonNhap chitiet = new ChiTietHoaDonNhap();

                    chitiet.setMaThuoc((String) tblHDN.getValueAt(i, 0)); // Mã thuốc
                    chitiet.setTenThuoc((String) tblHDN.getValueAt(i, 1)); // Tên thuốc
                    chitiet.setSoLuong((int) tblHDN.getValueAt(i, 2)); // Số lượng
                    chitiet.setGiaNhap((int) tblHDN.getValueAt(i, 3)); // Giá nhập
                    chitiet.setThanhTien((int) tblHDN.getValueAt(i, 4)); // Thành tiền

                    chiTietList.add(chitiet);
                }
                hdn.setChiTietHoaDonNhap(chiTietList);

                // Lưu thông tin hóa đơn nhập vào cơ sở dữ liệu
                int result = hdndao.save(hdn);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    hdndao.filltoArrayList(); // Tải lại danh sách thuốc
                    filltotbllichsuHD(); // Cập nhật bảng hiển thị
                } else {
                    JOptionPane.showMessageDialog(this, "Lưu thất bại");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Tổng tiền phải là số nguyên hợp lệ.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn nhập đã tồn tại.");
        }
    }

    private void addChiTietHoaDonNhap() {
        try {
            String maThuoc = txtMaThuoc.getText();
            String tenThuoc = txtTenThuoc.getText();
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            int giaNhap = Integer.parseInt(txtDonGia.getText());
            int thanhTien = soLuong * giaNhap;

            if (maThuoc.isEmpty() || tenThuoc.isEmpty() || soLuong <= 0 || giaNhap <= 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ và hợp lệ thông tin.");
                return;
            }

            DefaultTableModel modelHDN = (DefaultTableModel) tblHDN.getModel();
            modelHDN.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();

                    if (row != -1 && (column == 2 || column == 3)) { // Kiểm tra nếu cột số lượng hoặc giá nhập thay đổi
                        int soLuong = Integer.parseInt(tblHDN.getValueAt(row, 2).toString());
                        int giaNhap = Integer.parseInt(tblHDN.getValueAt(row, 3).toString());
                        int thanhTien = soLuong * giaNhap;

                        // Cập nhật lại cột thành tiền
                        tblHDN.setValueAt(thanhTien, row, 4);

                        // Tính toán lại tổng tiền
                        int tongTien = 0;
                        for (int i = 0; i < tblHDN.getRowCount(); i++) {
                            tongTien += Integer.parseInt(tblHDN.getValueAt(i, 4).toString());
                        }
                        txtTongTien.setText(String.valueOf(tongTien));
                    }
                }
            });

            // Cập nhật JTable bằng cách thêm hàng mới vào mô hình dữ liệu
            modelHDN.addRow(new Object[]{maThuoc, tenThuoc, soLuong, giaNhap, thanhTien});

            // Cập nhật tổng tiền
            int tongTienHienTai = Integer.parseInt(txtTongTien.getText());
            int tongTienMoi = tongTienHienTai + thanhTien;
            txtTongTien.setText(String.valueOf(tongTienMoi));

            // Hiển thị thông báo
            JOptionPane.showMessageDialog(null, "Đã thêm thuốc vào danh sách chi tiết hóa đơn nhập.");

            // Xóa nội dung trong JTextField sau khi thêm
            txtMaThuoc.setText("");
            txtTenThuoc.setText("");
            txtSoLuong.setText("");
            txtDonGia.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng và giá nhập hợp lệ.");
        }
    }

    private void update() {
        // Lấy mã hóa đơn nhập từ JTextField
        String maHDN = txtMaHDN.getText().trim();

        // Tìm kiếm hóa đơn nhập cần cập nhật trong danh sách
        HoaDonNhap hdnToUpdate = null;
        for (HoaDonNhap hdn : dshdn) {
            if (hdn.getMaHDN().equals(maHDN)) {
                hdnToUpdate = hdn;
                break;
            }
        }

        // Nếu không tìm thấy hóa đơn nhập
        if (hdnToUpdate == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn nhập với mã: " + maHDN);
            return;
        }

        try {
            // Cập nhật thông tin cho hóa đơn nhập
            hdnToUpdate.setMaNPP(txtMaNPP.getText().trim());
            hdnToUpdate.setNguoiGiao(txtNguoiGiao.getText().trim());
            hdnToUpdate.setNguoiNhan(txtNguoiNhan.getText().trim());
            hdnToUpdate.setTongTien(Integer.parseInt(txtTongTien.getText().trim()));

            // Cập nhật ngày nhập và ngày viết
            Date NgayNhapUntil = txtNgayNhap.getDate();
            Date NgayVietUntil = txtNgayViet.getDate();

            if (NgayNhapUntil == null || NgayVietUntil == null) {
                throw new IllegalArgumentException("Ngày nhập và ngày viết không được để trống.");
            }

            hdnToUpdate.setNgayNhap(new java.sql.Date(NgayNhapUntil.getTime()));
            hdnToUpdate.setNgayViet(new java.sql.Date(NgayVietUntil.getTime()));

            // Cập nhật chi tiết hóa đơn nhập
            List<ChiTietHoaDonNhap> chiTietList = new ArrayList<>();
            for (int i = 0; i < tblHDN.getRowCount(); i++) {
                ChiTietHoaDonNhap chitiet = new ChiTietHoaDonNhap();
                chitiet.setMaThuoc((String) tblHDN.getValueAt(i, 0));
                chitiet.setTenThuoc((String) tblHDN.getValueAt(i, 1));
                chitiet.setSoLuong((int) tblHDN.getValueAt(i, 2));
                chitiet.setGiaNhap((int) tblHDN.getValueAt(i, 3));
                chitiet.setThanhTien((int) tblHDN.getValueAt(i, 4));
                chiTietList.add(chitiet);
            }
            hdnToUpdate.setChiTietHoaDonNhap(chiTietList);

            // Cập nhật thông tin vào cơ sở dữ liệu
            int result = hdndao.update(hdnToUpdate);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                filltotbllichsuHD(); // Cập nhật lại bảng hiển thị
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tổng tiền phải là số nguyên hợp lệ.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    private void clearInputFields() {
        DefaultTableModel model = (DefaultTableModel) tblHDN.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trong tblHDN
        txtMaHDN.setText(hdndao.Maphatsinh());
        txtMaNPP.setText("");
        txtNguoiGiao.setText("");
        txtNguoiNhan.setText("");
        txtNgayNhap.setDate(null);
        txtNgayViet.setDate(null);
        txtTongTien.setText("");
    }

    public void filltotbllichsuHD() {
        DefaultTableModel model = (DefaultTableModel) tblLichSuHDN.getModel();
        model.setRowCount(0);
        for (HoaDonNhap hd : dshdn) {
            model.addRow(new Object[]{hd.getMaHDN(), hd.getMaNPP(), hd.getNgayViet(), hd.getTongTien()});
        }
    }

    private void find() {
        DefaultTableModel ob = (DefaultTableModel) tblLichSuHDN.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblLichSuHDN.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText()));
    }
    



    private void txtMaHDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDNActionPerformed

    private void txtMaNPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNPPActionPerformed

    private void BtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_BtnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
         clearInputFields();
         
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void txtMaThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaThuocActionPerformed

    private void txtTenThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenThuocActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void btnThemThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocActionPerformed
        // TODO add your handling code here:
//        addtotblhdn();
        addChiTietHoaDonNhap();
    }//GEN-LAST:event_btnThemThuocActionPerformed

    private void tblLichSuHDNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSuHDNMouseClicked
        // TODO add your handling code here:
        showDetail();
        BtnSua.setEnabled(true);
    }//GEN-LAST:event_tblLichSuHDNMouseClicked

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void tblHDNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDNMouseClicked
        // TODO add your handling code here:
        btnThemThuoc.setEnabled(false);
    }//GEN-LAST:event_tblHDNMouseClicked

    private void txtMaThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaThuocMouseClicked
        // TODO add your handling code here:
        btnThemThuoc.setEnabled(true);
    }//GEN-LAST:event_txtMaThuocMouseClicked

    private void txtTenThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenThuocMouseClicked
        // TODO add your handling code here:
        btnThemThuoc.setEnabled(true);
    }//GEN-LAST:event_txtTenThuocMouseClicked

    private void txtSoLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoLuongMouseClicked
        // TODO add your handling code here:
        btnThemThuoc.setEnabled(true);
    }//GEN-LAST:event_txtSoLuongMouseClicked

    private void txtDonGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDonGiaMouseClicked
        // TODO add your handling code here:
        btnThemThuoc.setEnabled(true);
    }//GEN-LAST:event_txtDonGiaMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        btnHoanThanh.setEnabled(true);
    }//GEN-LAST:event_btnThemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSua;
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemThuoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblHDN;
    private javax.swing.JTable tblLichSuHDN;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaHDN;
    private javax.swing.JTextField txtMaNPP;
    private javax.swing.JTextField txtMaThuoc;
    private com.toedter.calendar.JDateChooser txtNgayNhap;
    private com.toedter.calendar.JDateChooser txtNgayViet;
    private javax.swing.JTextField txtNguoiGiao;
    private javax.swing.JTextField txtNguoiNhan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
