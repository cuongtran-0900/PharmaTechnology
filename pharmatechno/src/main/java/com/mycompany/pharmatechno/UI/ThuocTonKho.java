/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pharmatechno.UI;

import com.mycompany.pharmatechno.Control.ThuocTonKhoDAO;
import com.mycompany.pharmatechno.Model.ThuocTonKhoModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer to you
 */
public class ThuocTonKho extends javax.swing.JPanel {

    /**
     * Creates new form ThuocTonKho
     */
    public ThuocTonKho() {
        initComponents();
        filltotable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
           ThuocTonKhoDAO ttkdao = new ThuocTonKhoDAO();
    List<ThuocTonKhoModel> ttkm = ttkdao.filltoArrayList();
    
    public void filltotable(){
        DefaultTableModel model = (DefaultTableModel) tblThuocTonKho.getModel();
        model.setRowCount(0);
        for(ThuocTonKhoModel ttk:ttkm){
            model.addRow(new Object[] 
            {ttk.getMaThuoc(),
            ttk.getTenThuoc(),
            ttk.getSoLuongTon()});
        }
    }
        private void showDetail(int index) {
        if (index >= 0 && index < ttkm.size()) {
            ThuocTonKhoModel ttk = ttkm.get(index);
            // Hiển thị chi tiết của đối tượng ttk lên các trường nhập liệu (nếu có)
        }
    }

        
   private void navigate(int index) {
    // Kiểm tra xem index có hợp lệ không
    if (index >= 0 && index < tblThuocTonKho.getRowCount()) {
        tblThuocTonKho.setRowSelectionInterval(index, index);
        showDetail(index);
    } else {
        // Nếu không hợp lệ, có thể hiển thị thông báo lỗi hoặc xử lý phù hợp
        System.err.println("Đã đến cuối");
    }
}
        

    public void btnFirst() {
        navigate(0);
        scrollToVisible(0);
    }
    private void btnNext() {
        int currentIndex = tblThuocTonKho.getSelectedRow();
        if (currentIndex >= 0 && currentIndex < ttkm.size() - 1) {
            navigate(currentIndex + 1);
            scrollToVisible(currentIndex + 1);
        }
    }

    private void btnBack() {
        int currentIndex = tblThuocTonKho.getSelectedRow();
        if (currentIndex > 0) {
            navigate(currentIndex - 1);
            scrollToVisible(currentIndex - 1);
        }
    }
       
          private void btnLast() {
        int lastIndex = ttkm.size() - 1;
        navigate(lastIndex);
        scrollToVisible(lastIndex);
    }
    
        public void showtoTable() {
        ttkm = ttkdao.filltoArrayList();
        filltotable();
    }

    private void scrollToVisible(int rowIndex) {
    tblThuocTonKho.scrollRectToVisible(tblThuocTonKho.getCellRect(rowIndex, 0, true));
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblThuocTonKho = new javax.swing.JTable();
        btnLamMoi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        lblTim = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        tblThuocTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Thuốc", "Tên Thuốc", "Số Lượng Tồn Kho"
            }
        ));
        jScrollPane1.setViewportView(tblThuocTonKho);

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit.png"))); // NOI18N
        btnThoat.setText("Thoát");

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        lblTim.setText("Tìm thuốc");

        btnBack.setText("<<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
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

        btnTim.setText("Tìm");

        jPanel1.setBackground(new java.awt.Color(0, 255, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("THUỐC GẦN HẾT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTim)
                        .addGap(18, 18, 18)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim)
                        .addGap(173, 173, 173))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnBack)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTim)
                    .addComponent(btnTim))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTim;
    private javax.swing.JTable tblThuocTonKho;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
