/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pharmatechno.UI;

import com.mycompany.pharmatechno.Control.DoanhThuDAO;
import com.mycompany.pharmatechno.Model.DoanhThuModel;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author acer to you
 */
public class DoanhThu extends javax.swing.JPanel {

    /**
     * Creates new form DoanhThu
     */
    public DoanhThu() {
        initComponents();
        filltotable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
       DoanhThuDAO nvdao = new DoanhThuDAO();
    List<DoanhThuModel> dtm = nvdao.filltoArrayList();
    
//        private void filltotextbox(int index) {
//        if (index >= 0 && index < dtm.size()) {
//            // Lấy thông tin từ đối tượng Student tại chỉ mục index
//            DoanhThuModel dt = dtm.get(index);
//
//            txtMaNV.setText(nv.getMaNV());
//            txtTenNV.setText(nv.getTenNV());
//            txtDiaChi.setText(nv.getDiaChi());
//            txtSDT.setText(nv.getSDT());
//            txtEmail.setText(nv.getEmail());
//            if(nv.getRoll().equalsIgnoreCase("Nhân Viên")){
//                cboVaiTro.setSelectedIndex(0);
//            }else{
//                cboVaiTro.setSelectedIndex(1);
//            }
//            
//            txtTuoi.setText(nv.getTuoiNV());
//
//            if (nv.getGioiTinh().equalsIgnoreCase("Nam")) {
//                btnNam.setSelected(true);
//            } else {
//                btnNu.setSelected(true);
//            }
//
//        } else {
//
//            txtMaNV.setText("");
//            txtTenNV.setText("");
//            txtDiaChi.setText("");
//            txtSDT.setText("");
//            txtEmail.setText("");
//            txtTuoi.setText("");
//            cboVaiTro.setSelectedIndex(-1);
//            btnNam.setSelected(false);
//            btnNu.setSelected(false);
//
//        }
//    }
    
    public void filltotable(){
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        for(DoanhThuModel dt:dtm){
            model.addRow(new Object[] {dt.getThoiGian(),dt.getTenThuoc(),dt.getSoLuong(),dt.getTongTien(),
                dt.getTenThuoc()});
        }
    }
        private void showDetail(int index) {
        if (index >= 0 && index < dtm.size()) {
            DoanhThuModel dt = dtm.get(index);
            // Hiển thị chi tiết của đối tượng dt lên các trường nhập liệu (nếu có)
        }
    }
        
        private void navigate(int index) {
        tblDoanhThu.setRowSelectionInterval(index, index);
        showDetail(index);
    }
        

    public void btnFirst() {
        navigate(0);
        scrollToVisible(0);
    }
    public void btnBack() {
        int currentIndex = tblDoanhThu.getSelectedRow();
        if (currentIndex > 0) {
            navigate(currentIndex - 1);
            scrollToVisible(currentIndex - 1);
        }
    }
    
       private void btnNext() {
        int currentIndex = tblDoanhThu.getSelectedRow();
        if (currentIndex < dtm.size() - 1) {
            navigate(currentIndex + 1);
            scrollToVisible(currentIndex + 1);
        }
    }
       
          private void btnLast() {
        int lastIndex = dtm.size() - 1;
        navigate(lastIndex);
        scrollToVisible(lastIndex);
    }
    
        public void showtoTable() {
        dtm = nvdao.filltoArrayList();
        filltotable();
    }

    private void scrollToVisible(int rowIndex) {
    tblDoanhThu.scrollRectToVisible(tblDoanhThu.getCellRect(rowIndex, 0, true));
}
    
    
//    private void btnLamMoi() {                                          
//    // Thực hiện truy vấn SQL và cập nhật dữ liệu
//    updateDataFromDatabase();
//    // Cập nhật bảng dữ liệu
//    filltotable();
//}                                         
//
//    
//    
//    
//private void updateDataFromDatabase() {
//    try {
//        // Tạo đối tượng DoanhThuDAO và gọi phương thức truy vấn
//        DoanhThuDAO nvdao = new DoanhThuDAO();
//        dtm = nvdao.filltoArrayList(); // Phương thức này sẽ thực hiện truy vấn SQL
//        
//        // Tính tổng tiền
//        double tongTien = 0;
//        for (DoanhThuModel dt : dtm) {
//            tongTien += dt.getTongTien(); // Giả sử `getTongTien` trả về số tiền
//        }
//        lblTongTien.setText(String.format("%.2f", tongTien));
//    } catch (Exception e) {
//        e.printStackTrace(); // Xử lý ngoại lệ
//    }
//}

    
        private void find(){
        DefaultTableModel ob = (DefaultTableModel) tblDoanhThu.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblDoanhThu.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText()));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        btnInRa = new javax.swing.JButton();
        lblTongTien = new javax.swing.JTextField();
        lblTimKiemTheoNgay = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 255));
        setForeground(new java.awt.Color(51, 255, 255));

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Thời Gian", "Tên Thuốc", "Số Lượng", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(tblDoanhThu);

        jLabel2.setText("Tổng Tiền :");

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnInRa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Print.png"))); // NOI18N
        btnInRa.setText("In Ra");

        lblTimKiemTheoNgay.setText("Tìm kiếm theo ngày :");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBack.setText("<<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 0));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("DOANH THU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnInRa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFirst)
                                .addGap(18, 18, 18)
                                .addComponent(btnBack)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTimKiemTheoNgay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem)))
                        .addGap(246, 246, 246)
                        .addComponent(btnThoat))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnBack)
                    .addComponent(btnFirst))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThoat)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLamMoi)
                        .addComponent(btnInRa)
                        .addComponent(lblTimKiemTheoNgay)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        showtoTable();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        btnFirst();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        btnBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        btnNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        btnLast();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtTimKiemKeyReleased
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInRa;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTimKiemTheoNgay;
    private javax.swing.JTextField lblTongTien;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
