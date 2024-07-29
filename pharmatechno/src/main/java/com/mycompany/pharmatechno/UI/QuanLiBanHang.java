/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pharmatechno.UI;
import com.mycompany.pharmatechno.Control.QuanLiBanHangDao;
import com.mycompany.pharmatechno.Model.BanHang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cuong
 */
public class QuanLiBanHang extends javax.swing.JPanel {

    /**
     * Creates new form QuanLiBanHang
     */
    public QuanLiBanHang() {
        initComponents();
        filltotable();
        addToListCart();
        updateTotalAmount();
        txtMaHoaDon.setText(bhdao.Maphatsinh());
        txtTongTien.setEditable(false);
        txtMaHoaDon.setEditable(false);
        txtThoiGian.setEditable(false);
        
    }
    
    QuanLiBanHangDao bhdao = new QuanLiBanHangDao();
    List<BanHang> dsbh = bhdao.filltoArrayList();

    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(System.currentTimeMillis());

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanLiBanHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnLuuIn = new javax.swing.JButton();
        btbThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboHinhThuc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 255));

        tblQuanLiBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Thuốc", "Tên Thuốc", "Tồn Kho", "ĐVT", "Đơn Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblQuanLiBanHang);
        if (tblQuanLiBanHang.getColumnModel().getColumnCount() > 0) {
            tblQuanLiBanHang.getColumnModel().getColumn(1).setMinWidth(200);
            tblQuanLiBanHang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblQuanLiBanHang.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("QUẢN LÍ BÁN HÀNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel5.setText("Tìm Kiếm :");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("GIỎ HÀNG");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Thuốc", "Tên Thuốc", "ĐVT", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(1).setMinWidth(200);
            tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblGioHang.getColumnModel().getColumn(1).setMaxWidth(200);
            tblGioHang.getColumnModel().getColumn(3).setMinWidth(70);
            tblGioHang.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblGioHang.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jPanel2.setBackground(new java.awt.Color(51, 255, 204));

        btnLuuIn.setText("Lưu In");

        btbThanhToan.setText("Thanh Toán");
        btbThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã Nhân Viên :");

        jLabel10.setText("Hình Thức Thanh Toán     :");

        cboHinhThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản", " " }));

        jLabel11.setText("Tổng Tiền       :");

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel12.setText("Mã Hóa Đơn :");

        jLabel2.setText("Thời Gian        :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txtThoiGian))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboHinhThuc, 0, 150, Short.MAX_VALUE)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btbThanhToan)
                        .addGap(67, 67, 67)
                        .addComponent(btnLuuIn)
                        .addGap(66, 66, 66)
                        .addComponent(btnHuy)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cboHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbThanhToan)
                    .addComponent(btnLuuIn)
                    .addComponent(btnHuy))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnThem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnThem)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean isUpdatingTable = false;

public void filltotable() {
    DefaultTableModel model = new DefaultTableModel(
        new Object[]{"Mã Thuốc", "Tên Thuốc", "Tồn Kho", "ĐVT", "Đơn Giá"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    for (BanHang bh : dsbh) {
        model.addRow(new Object[]{
           bh.getMaThuoc(), bh.getTenThuoc(), bh.getTonKho(), bh.getDVT(), bh.getDonGia()
        });
    }
    tblQuanLiBanHang.setModel(model);
}

   

private void addToListCart() {
    tblQuanLiBanHang.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) { // Kiểm tra click đôi
                int selectedRow = tblQuanLiBanHang.rowAtPoint(e.getPoint()); // Lấy hàng tại vị trí chuột
                if (selectedRow != -1) {
                    addProductToCart(selectedRow);
                }
            }
        }
    });

    DefaultTableModel cartmodel = (DefaultTableModel) tblGioHang.getModel();
    cartmodel.setRowCount(0);

    // Thêm TableModelListener để lắng nghe sự thay đổi
    cartmodel.addTableModelListener(e -> {
        if (!isUpdatingTable) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == 3 || column == 5) { // Kiểm tra nếu cột là cột số lượng hoặc thành tiền
                updateRowTotal(row);
            }
        }
    });

    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem deleteItem = new JMenuItem("Delete");
    popupMenu.add(deleteItem);

    // Thêm sự kiện cho menu ngữ cảnh
    deleteItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = tblGioHang.getSelectedRow();
            if (selectedRow != -1) {
                cartmodel.removeRow(selectedRow);
                updateTotalAmount(); // Cập nhật tổng tiền khi xóa
            }
        }
    });

    // Thêm sự kiện chuột phải để hiển thị menu ngữ cảnh
    tblGioHang.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                int row = tblGioHang.rowAtPoint(e.getPoint());
                if (row >= 0 && row < tblGioHang.getRowCount()) {
                    tblGioHang.setRowSelectionInterval(row, row);
                } else {
                    tblGioHang.clearSelection();
                }

                int rowindex = tblGioHang.getSelectedRow();
                if (rowindex < 0) {
                    return;
                }
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    });
}

private void addProductToCart(int selectedRow) {
    DefaultTableModel cartmodel = (DefaultTableModel) tblGioHang.getModel();
    String MaThuoc = String.valueOf(tblQuanLiBanHang.getValueAt(selectedRow, 0));
    String TenThuoc = String.valueOf(tblQuanLiBanHang.getValueAt(selectedRow, 1));
    String DVT = String.valueOf(tblQuanLiBanHang.getValueAt(selectedRow, 3));
    int SoLuong = 1;
    Object donGiaObj = tblQuanLiBanHang.getValueAt(selectedRow, 4);
    int DonGia = 0;

    if (donGiaObj instanceof Number) {
        DonGia = ((Number) donGiaObj).intValue();
    } else if (donGiaObj instanceof String) {
        try {
            DonGia = Integer.parseInt((String) donGiaObj);
        } catch (NumberFormatException ex) {
            ex.printStackTrace(); // Xử lý lỗi nếu không thể chuyển đổi
            return; // Thoát nếu không thể chuyển đổi
        }
    }

    boolean productExists = false;
    for (int i = 0; i < tblGioHang.getRowCount(); i++) {
        Object tenThuocInCart = tblGioHang.getValueAt(i, 1); // Cột 1 là TenThuoc
        if (TenThuoc.equals(String.valueOf(tenThuocInCart))) {
            int currentQuantity = 0;
            Object currentQuantityObj = tblGioHang.getValueAt(i, 3); // Cột 3 là SoLuong
            if (currentQuantityObj instanceof Number) {
                currentQuantity = ((Number) currentQuantityObj).intValue();
            } else if (currentQuantityObj instanceof String) {
                try {
                    currentQuantity = Integer.parseInt((String) currentQuantityObj);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace(); // Xử lý lỗi nếu không thể chuyển đổi
                }
            }
            int newQuantity = currentQuantity + SoLuong;
            int thanhTien = newQuantity * DonGia;

            isUpdatingTable = true;
            tblGioHang.setValueAt(newQuantity, i, 3); // Cập nhật số lượng
            tblGioHang.setValueAt(thanhTien, i, 5); // Cập nhật thành tiền
            isUpdatingTable = false;

            productExists = true;
            break;
        }
    }
    if (!productExists) {
        int thanhTien = SoLuong * DonGia;
        cartmodel.addRow(new Object[]{MaThuoc, TenThuoc, DVT, SoLuong, DonGia, thanhTien});
    }
    updateTotalAmount(); // Cập nhật tổng tiền
}

private void updateRowTotal(int row) {
    int newQuantity = 0;
    Object newQuantityObj = tblGioHang.getValueAt(row, 3);
    if (newQuantityObj instanceof Number) {
        newQuantity = ((Number) newQuantityObj).intValue();
    } else if (newQuantityObj instanceof String) {
        try {
            newQuantity = Integer.parseInt((String) newQuantityObj);
        } catch (NumberFormatException ex) {
            ex.printStackTrace(); // Xử lý lỗi nếu không thể chuyển đổi
        }
    }
    Object donGiaObj = tblGioHang.getValueAt(row, 4);
    int DonGia = 0;
    if (donGiaObj instanceof Number) {
        DonGia = ((Number) donGiaObj).intValue();
    } else if (donGiaObj instanceof String) {
        try {
            DonGia = Integer.parseInt((String) donGiaObj);
        } catch (NumberFormatException ex) {
            ex.printStackTrace(); // Xử lý lỗi nếu không thể chuyển đổi
        }
    }
    int thanhTien = newQuantity * DonGia;

    isUpdatingTable = true;
    tblGioHang.setValueAt(thanhTien, row, 5); // Cập nhật thành tiền
    isUpdatingTable = false;

    updateTotalAmount(); // Cập nhật tổng tiền
}

private void updateTotalAmount() {
    DefaultTableModel cartmodel = (DefaultTableModel) tblGioHang.getModel();
    int totalAmount = 0;
    for (int i = 0; i < cartmodel.getRowCount(); i++) {
        Object thanhTienObj = cartmodel.getValueAt(i, 5); // Cột 5 là thành tiền
        int thanhTien = 0;
        if (thanhTienObj instanceof Number) {
            thanhTien = ((Number) thanhTienObj).intValue();
        } else if (thanhTienObj instanceof String) {
            try {
                thanhTien = Integer.parseInt((String) thanhTienObj);
            } catch (NumberFormatException ex) {
                ex.printStackTrace(); // Xử lý lỗi nếu không thể chuyển đổi
            }
        }
        totalAmount += thanhTien;
    }
    txtTongTien.setText(String.valueOf(totalAmount));
}


    private void find(){
        DefaultTableModel ob = (DefaultTableModel) tblQuanLiBanHang.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblQuanLiBanHang.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText()));
    }
    private void payment() {
    boolean allSuccess = true;
    QuanLiBanHangDao bhDao = new QuanLiBanHangDao();

    for (int i = 0; i < tblGioHang.getRowCount(); i++) {
        BanHang bh = new BanHang();
        bh.setMaHD(txtMaHoaDon.getText());
        bh.setMaNV(txtMaNV.getText());
        
        try {
            bh.setTongTien(Integer.parseInt(txtTongTien.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tổng tiền không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        bh.setMaThuoc((String) tblGioHang.getValueAt(i, 0));
        bh.setThoiGian(Timestamp.valueOf(txtThoiGian.getText()));
        bh.setTonKho((int) tblQuanLiBanHang.getValueAt(i, 2));
        
        try {
            bh.setSoluong((int) tblGioHang.getValueAt(i, 3));
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            bh.setDonGia((int) tblGioHang.getValueAt(i, 4));
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(this, "Đơn giá không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (bhDao.payment(bh) <= 0) {
            allSuccess = false;
        }
    }

    if (allSuccess) {
        JOptionPane.showMessageDialog(null, "Thanh toán thành công");
        bhdao.filltoArrayList();
        this.filltotable();
        ((DefaultTableModel) tblGioHang.getModel()).setRowCount(0); // Làm rỗng giỏ hàng
    } else {
        JOptionPane.showMessageDialog(this, "Thanh Toán thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}
       
            
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btbThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbThanhToanActionPerformed
        // TODO add your handling code here:
        payment();
        bhdao.filltoArrayList();
        txtMaHoaDon.setText("");
        txtThoiGian.setText("");
        txtMaHoaDon.setText(bhdao.Maphatsinh());
        txtThoiGian.setText(currentTimestamp.toString());
    }//GEN-LAST:event_btbThanhToanActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTongTienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbThanhToan;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuuIn;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cboHinhThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblQuanLiBanHang;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtThoiGian;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
