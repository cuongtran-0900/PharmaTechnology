package com.mycompany.pharmatechno.UI;
import com.mycompany.pharmatechno.Control.Auth;
import com.mycompany.pharmatechno.Model.TaiKhoanNhanVien;
import com.mycompany.pharmatechno.Control.TaiKhoanNhanVienDao;
import com.mycompany.pharmatechno.Model.NhanVien;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.mycompany.pharmatechno.UI.main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author tranp
 */
public class TaiKhoan extends javax.swing.JPanel {
        TaiKhoanNhanVienDao tknvd = new TaiKhoanNhanVienDao();
    private NhanVien tknv;  
    

    /**
     * Creates new form TaiKhoan
     */
public TaiKhoan() {
   initComponents();
        if (Auth.isLogin()) {
            tknv = Auth.user;
            fillToTextBox();
        } else {
            // Xử lý khi không có người dùng đăng nhập
        }
      //  updateUserInfo();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDiaChi = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pwfPassword = new javax.swing.JPasswordField();
        btnDoiMatKhau = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        tglbtnMat = new javax.swing.JToggleButton();

        jCheckBox1.setText("jCheckBox1");

        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("TÀI KHOẢN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("MÃ NV :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("TÊN :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("TUỔI :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("SĐT :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("EMAIL :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("GIỚI TÍNH :");

        buttonGroup1.add(rbtnNam);
        rbtnNam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtnNam.setText("NAM");

        buttonGroup1.add(rbtnNu);
        rbtnNu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbtnNu.setText("NỮ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("ĐỊA CHỈ :");

        taDiaChi.setColumns(20);
        taDiaChi.setRows(5);
        jScrollPane1.setViewportView(taDiaChi);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("USERNAME :");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("PASSWORD :");

        pwfPassword.setText("jPasswordField1");

        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnDoiMatKhau.setText("ĐỔI MẬT KHẨU");
        btnDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMatKhauMouseClicked(evt);
            }
        });
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnDangXuat.setText("ĐĂNG XUẤT");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnThoat.setText("THOÁT");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        tglbtnMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Pointer.png"))); // NOI18N
        tglbtnMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglbtnMatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDoiMatKhau)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnNu))
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(185, 185, 185))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTuoi, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtMaNV)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(txtEmail)
                        .addComponent(txtSDT)))
                .addGap(195, 195, 195)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtUsername)
                                    .addComponent(pwfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tglbtnMat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnNam)
                            .addComponent(rbtnNu))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tglbtnMat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        DoiMatKhau dmk = new DoiMatKhau();
        dmk.setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMatKhauMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDoiMatKhauMouseClicked

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
       // Hiển thị hộp thoại xác nhận đăng xuất
    int response = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
    
    // Kiểm tra kết quả của hộp thoại
    if (response == JOptionPane.YES_OPTION) {
        // Đăng xuất thành công
        JOptionPane.showMessageDialog(this, "Đăng xuất thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        
        // Lấy JFrame chứa JPanel hiện tại
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        // Đóng JFrame hiện tại
        parentFrame.dispose();
        
        // Tạo và hiển thị JFrame mới của bạn (ví dụ: màn hình đăng nhập)
        JFrame newFrame = new DangNhap(); // Khởi tạo JFrame mới của bạn
        newFrame.setVisible(true);
    } else {

    }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
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
    
      
        
        
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tglbtnMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglbtnMatActionPerformed
        // TODO add your handling code here:
           if (tglbtnMat.isSelected()) {
        // Hiển thị mật khẩu
        pwfPassword.setEchoChar((char) 0);
    } else {
        // Ẩn mật khẩu
        pwfPassword.setEchoChar('*');
    }
           
    }//GEN-LAST:event_tglbtnMatActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed
  public void fillToTextBox() {
    if (tknv != null) {
        // Điền thông tin vào các trường
        txtMaNV.setText(tknv.getMaNV());
        txtTen.setText(tknv.getTenNV());
        txtTuoi.setText(String.valueOf(tknv.getTuoiNV()));
        txtSDT.setText(tknv.getSDT());
        txtEmail.setText(tknv.getEmail());
        taDiaChi.setText(tknv.getDiaChi());
        txtUsername.setText(tknv.getUserName());
        pwfPassword.setText(tknv.getPassWord());

        // Cài đặt giới tính
        if ("Nam".equalsIgnoreCase(tknv.getGioiTinh())) {
            rbtnNam.setSelected(true);
        } else if ("Nữ".equalsIgnoreCase(tknv.getGioiTinh())) {
            rbtnNu.setSelected(true);
        } else {
            // Xử lý nếu giới tính không hợp lệ hoặc không có giá trị
            rbtnNam.setSelected(false);
            rbtnNu.setSelected(false);
        }

        // Thiết lập các trường không thể chỉnh sửa
        txtMaNV.setEditable(false);
        txtTen.setEditable(false);
        txtTuoi.setEditable(false);
        txtSDT.setEditable(false);
        txtEmail.setEditable(false);
        taDiaChi.setEditable(false);
        txtUsername.setEditable(false);
        pwfPassword.setEditable(false);
        rbtnNam.setEnabled(false);
        rbtnNu.setEnabled(false);
    } else {
        // Xử lý nếu tknv là null, ví dụ: hiển thị thông báo lỗi hoặc làm trống các trường
        JOptionPane.showMessageDialog(this, "Thông tin người dùng không hợp lệ.");
    }
}



     

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnThoat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField pwfPassword;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTextArea taDiaChi;
    private javax.swing.JToggleButton tglbtnMat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTuoi;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
