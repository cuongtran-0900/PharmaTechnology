package com.mycompany.pharmatechno.UI;
import com.mycompany.pharmatechno.Control.TaiKhoanNhanVienDao;
import com.mycompany.pharmatechno.Model.DoiMatKhau;
import com.mycompany.pharmatechno.Model.TaiKhoanNhanVien;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author tranp
 */
public class ThayDoiMatKhau extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public ThayDoiMatKhau() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThayDoiMatKhau = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtXacNhanMatKhauMoi = new javax.swing.JTextField();
        txtMatKhauMoi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtXacNhanMatKhauMoi1 = new javax.swing.JTextField();
        txtMatKhauMoi1 = new javax.swing.JTextField();
        txtMatKhauHienTai = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        pnlThayDoiMatKhau.setBackground(new java.awt.Color(0, 255, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("THAY ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout pnlThayDoiMatKhauLayout = new javax.swing.GroupLayout(pnlThayDoiMatKhau);
        pnlThayDoiMatKhau.setLayout(pnlThayDoiMatKhauLayout);
        pnlThayDoiMatKhauLayout.setHorizontalGroup(
            pnlThayDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThayDoiMatKhauLayout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThayDoiMatKhauLayout.setVerticalGroup(
            pnlThayDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThayDoiMatKhauLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("XÁC NHẬN MẬT KHẨU MỚI :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("MẬT KHẨU MỚI                      :");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("MẬT KHẨU HIỆN TẠI             :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Accept.png"))); // NOI18N
        jLabel5.setText("XÁC NHẬN");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("XÁC NHẬN MẬT KHẨU MỚI :");

        txtXacNhanMatKhauMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXacNhanMatKhauMoiActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/No.png"))); // NOI18N
        btnHuy.setText("HỦY");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXacNhan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Accept.png"))); // NOI18N
        btnXacNhan.setText("XÁC NHẬN");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlThayDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnXacNhan)
                        .addGap(119, 119, 119)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(20, 20, 20))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(22, 22, 22)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMatKhauHienTai, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtXacNhanMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlThayDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhauHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtXacNhanMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnHuy))
                .addGap(0, 284, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    public void fillToTextBox(DoiMatKhau dmk) {
    txtMatKhauHienTai.setText(dmk.getMatKhauHienTai());
    txtMatKhauMoi.setText(dmk.getMatKhauMoi());
    txtXacNhanMatKhauMoi.setText(dmk.getXacNhanMatKhauMoi());


}
    private void txtXacNhanMatKhauMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXacNhanMatKhauMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXacNhanMatKhauMoiActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
    // Lấy thông tin từ các trường nhập liệu
    String matKhauHienTai = txtMatKhauHienTai.getText().trim();
    String matKhauMoi = txtMatKhauMoi.getText().trim();
    String xacNhanMatKhauMoi = txtXacNhanMatKhauMoi.getText().trim();
    
    // Kiểm tra các trường nhập liệu
    if (matKhauHienTai.isEmpty() || matKhauMoi.isEmpty() || xacNhanMatKhauMoi.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Kiểm tra mật khẩu mới và xác nhận mật khẩu mới
    if (!matKhauMoi.equals(xacNhanMatKhauMoi)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Mật khẩu mới và xác nhận mật khẩu không khớp.", "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Kiểm tra mật khẩu hiện tại
    TaiKhoanNhanVienDao dao = new TaiKhoanNhanVienDao();
    List<TaiKhoanNhanVien> dstknv = dao.filltoArrayList();
    boolean isCurrentPasswordValid = false;
    String username = "exampleUser"; // Thay thế bằng username thực tế của người dùng hiện tại
    
    for (TaiKhoanNhanVien tk : dstknv) {
        if (tk.getUsername().equals(username) && tk.getPassword().equals(matKhauHienTai)) {
            isCurrentPasswordValid = true;
            break;
        }
    }
    
    if (!isCurrentPasswordValid) {
        javax.swing.JOptionPane.showMessageDialog(this, "Mật khẩu hiện tại không đúng.", "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Cập nhật mật khẩu mới
    boolean isUpdated = dao.updatePassword(username, matKhauMoi);
    
    if (isUpdated) {
        javax.swing.JOptionPane.showMessageDialog(this, "Mật khẩu đã được thay đổi thành công.", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        // Đóng hoặc quay lại trang trước đó
        this.setVisible(false); // hoặc thực hiện hành động quay lại trang trước đó
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Không thể thay đổi mật khẩu.", "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

                   
        
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
          int response = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
        // Lấy JFrame chứa JPanel hiện tại
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        // Đóng JFrame hiện tại
        parentFrame.dispose();
        
        // Tạo và hiển thị JFrame mới (ví dụ: màn hình chính)
        JFrame newFrame = new main(); // Khởi tạo JFrame mới của bạn
        newFrame.setVisible(true);
        
    }
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnlThayDoiMatKhau;
    private javax.swing.JTextField txtMatKhauHienTai;
    private javax.swing.JTextField txtMatKhauMoi;
    private javax.swing.JTextField txtMatKhauMoi1;
    private javax.swing.JTextField txtXacNhanMatKhauMoi;
    private javax.swing.JTextField txtXacNhanMatKhauMoi1;
    // End of variables declaration//GEN-END:variables
}
