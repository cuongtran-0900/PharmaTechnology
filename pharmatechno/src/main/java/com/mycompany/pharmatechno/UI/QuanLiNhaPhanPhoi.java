/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pharmatechno.UI;

import com.mycompany.pharmatechno.Control.NhaPhanPhoiDao;
import com.mycompany.pharmatechno.Model.NhaPhanPhoi;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cuong
 */
public class QuanLiNhaPhanPhoi extends javax.swing.JPanel {

    /**
     * Creates new form QuanLiNhaPhanPhoi
     */
    int vitri = 0;

    public QuanLiNhaPhanPhoi() {
        initComponents();
        filltotable();
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
    }

    NhaPhanPhoiDao nppdao = new NhaPhanPhoiDao();
    List<NhaPhanPhoi> dsnpp = nppdao.filltoArrayList();

    private void filltotextbox(int index) {
        if (index >= 0 && index < dsnpp.size()) {
            // Lấy thông tin từ đối tượng Student tại chỉ mục index
            NhaPhanPhoi npp = dsnpp.get(index);

            txtMaNPP.setText(npp.getMaNPP());
            txtDiaChi.setText(npp.getDiaChi());
            txtSDT.setText(npp.getSDT());
            txtEmail.setText(npp.getEmail());
            txtTenNPP.setText(npp.getTenNPP());

        } else {
            txtMaNPP.setText("");
            txtTenNPP.setText("");
            txtDiaChi.setText("");
            txtSDT.setText("");
            txtEmail.setText("");
        }
    }

    public void filltotable() {
        DefaultTableModel model = (DefaultTableModel) tblQuanLiNhaPhanPhoi.getModel();
        model.setRowCount(0);
        for (NhaPhanPhoi npp : dsnpp) {
            model.addRow(new Object[]{npp.getMaNPP(), npp.getTenNPP(), npp.getSDT(), npp.getDiaChi(), npp.getEmail()});
        }
    }

    public void showDetail() {
        int viewIndex = tblQuanLiNhaPhanPhoi.getSelectedRow();
        if (viewIndex == -1) {
            return;
        }

        int modelIndex = tblQuanLiNhaPhanPhoi.convertRowIndexToModel(viewIndex);
        if (modelIndex >= 0 && modelIndex < dsnpp.size()) {
            NhaPhanPhoi npp = dsnpp.get(modelIndex);
            txtMaNPP.setText(npp.getMaNPP());
            txtTenNPP.setText(npp.getTenNPP());
            txtEmail.setText(npp.getEmail());
            txtSDT.setText(npp.getSDT());
            txtDiaChi.setText(npp.getDiaChi());
        }
    }

    private void save() {
        String patternEmail = "\\w+@\\w+(\\.\\w+){1,2}";
        String patternSdt = "0\\d{9,10}";
        if (nppdao.check(txtMaNPP.getText())) {
            NhaPhanPhoi npp = new NhaPhanPhoi();
            npp.setDiaChi(txtDiaChi.getText());
            npp.setSDT(txtSDT.getText());
            npp.setEmail(txtEmail.getText());
            npp.setMaNPP(txtMaNPP.getText());
            npp.setTenNPP(txtTenNPP.getText());
            if (txtEmail.getText().matches(patternEmail)) {
                if (txtSDT.getText().matches(patternSdt)) {
                    if (new NhaPhanPhoiDao().save(npp) > 0) {
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                        nppdao.filltoArrayList();
                        this.filltotable();
                        filltotextbox(dsnpp.size() - 1);
                        tblQuanLiNhaPhanPhoi.setRowSelectionInterval(dsnpp.size() - 1, dsnpp.size() - 1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Lưu thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số điện thoại");
                    txtSDT.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng email");
                txtEmail.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đã có mã sv này");
        }
    }

    private void delete() {
        if (txtMaNPP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã Nhân Viên Cần Xóa");
            txtMaNPP.requestFocus();
        } else {
            int opt = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa nhân viên này?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                nppdao.removeStaff(txtMaNPP.getText());
            }
        }
        nppdao.filltoArrayList();
        filltotable();
    }

    private void update() {
        vitri = tblQuanLiNhaPhanPhoi.getSelectedRow();
        NhaPhanPhoi npp = new NhaPhanPhoi();
        npp.setDiaChi(txtDiaChi.getText());
        npp.setSDT(txtSDT.getText());
        npp.setEmail(txtEmail.getText());
        npp.setMaNPP(txtMaNPP.getText());
        npp.setTenNPP(txtTenNPP.getText());
        tblQuanLiNhaPhanPhoi.setRowSelectionInterval(vitri, vitri);
        tblQuanLiNhaPhanPhoi.scrollRectToVisible(tblQuanLiNhaPhanPhoi.getCellRect(vitri, 0, true));
        if (CheckTextBox(txtEmail.getText(), txtSDT.getText(), vitri)) {
            if (nppdao.update(npp) > 0) {
                tblQuanLiNhaPhanPhoi.setRowSelectionInterval(vitri, vitri);
                tblQuanLiNhaPhanPhoi.scrollRectToVisible(tblQuanLiNhaPhanPhoi.getCellRect(vitri, 0, true));

            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
            nppdao.filltoArrayList();
            filltotable();
            filltotextbox(vitri);
            tblQuanLiNhaPhanPhoi.setRowSelectionInterval(vitri, vitri);
        }
    }

    public boolean CheckTextBox(String email, String sdt, int vitri) {
        String patternEmail = "\\w+@\\w+(\\.\\w+){1,2}";
        String patternSdt = "0\\d{9,10}";
        if (email.matches(patternEmail)) {
            if (sdt.matches(patternSdt)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng SDT");
                JOptionPane.showMessageDialog(null, vitri);
                tblQuanLiNhaPhanPhoi.setRowSelectionInterval(vitri, vitri);
                txtSDT.requestFocus();
                tblQuanLiNhaPhanPhoi.scrollRectToVisible(tblQuanLiNhaPhanPhoi.getCellRect(vitri, 0, true));
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng Email");
            JOptionPane.showMessageDialog(null, vitri);
            tblQuanLiNhaPhanPhoi.setRowSelectionInterval(vitri, vitri);
            txtEmail.requestFocus();
            tblQuanLiNhaPhanPhoi.scrollRectToVisible(tblQuanLiNhaPhanPhoi.getCellRect(vitri, 0, true));
            return false;
        }

    }

    private void find() {
        DefaultTableModel ob = (DefaultTableModel) tblQuanLiNhaPhanPhoi.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblQuanLiNhaPhanPhoi.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText()));
    }
    
    private void clearInput(){
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtMaNPP.setText(nppdao.Maphatsinh());
        txtSDT.setText("");
        txtTenNPP.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTenNPP = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaNPP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanLiNhaPhanPhoi = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTenNPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNPPActionPerformed(evt);
            }
        });

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel3.setText("Số Điện Thoại        :");

        jLabel1.setText("Mã Nhà Phân Phối  :");

        txtMaNPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNPPActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Nhà Phân Phối :");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel8.setText("Địa Chỉ :");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel7.setText("Email    :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaNPP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtTenNPP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaNPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenNPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Tìm Kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(195, 195, 195))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tblQuanLiNhaPhanPhoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NPP", "Tên NPP", "Số Điện Thoại", "Địa Chỉ", "Email"
            }
        ));
        tblQuanLiNhaPhanPhoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLiNhaPhanPhoiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQuanLiNhaPhanPhoi);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setBackground(new java.awt.Color(0, 204, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("QUẢN LÍ NHÀ PHÂN PHỐI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(181, 181, 181))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnCapNhat)
                            .addComponent(btnXoa))
                        .addGap(34, 34, 34)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenNPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNPPActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtMaNPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNPPActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        clearInput();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblQuanLiNhaPhanPhoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLiNhaPhanPhoiMouseClicked
        // TODO add your handling code here:
        showDetail();
        btnCapNhat.setEnabled(true);
        btnXoa.setEnabled(true);
    }//GEN-LAST:event_tblQuanLiNhaPhanPhoiMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQuanLiNhaPhanPhoi;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNPP;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNPP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
