/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pharmatechno.UI;

import com.mycompany.pharmatechno.Control.KhachHangDao;
import com.mycompany.pharmatechno.Control.Xdate;
import com.mycompany.pharmatechno.Model.KhachHang;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.crypto.Data;

/**
 *
 * @author hongo
 */
public class QuanLiKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form KhachHang
     */
     int vitri = 0;
    public QuanLiKhachHang() {
        initComponents();
         someMethod(vitri);
        filltotextbox(vitri);
        filltotable();
        txtMaKH.setEnabled(false);
          btnSua.setEnabled(false);
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
    }
    KhachHangDao khdao = new KhachHangDao();
    List<KhachHang> dskh = khdao.filltoArrayList();
    
    
   private void filltotextbox(int index) {
        if (index >= 0 && index < dskh.size()) {
            KhachHang kh = dskh.get(index);
            txtMaKH.setText(kh.getMaKH());
            txtTenkh.setText(kh.getTenKH());
            txtTuoi.setText(kh.getTuoikh());
            txtSDT.setText(kh.getSdt());
            txtEmail.setText(kh.getEmail());
            if (kh.getGioiTinh().equalsIgnoreCase("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtDiaChi.setText(kh.getDiaChi());
              dcsNgayThamGia.setDate(kh.getNgayThamGia());
        } else {

            txtMaKH.setText("");
            txtTenkh.setText("");
             txtTuoi.setText("");
             txtSDT.setText("");
             txtEmail.setText("");
            txtDiaChi.setText("");         
            rdoNam.setSelected(false);
            rdoNu.setSelected(false);
            dcsNgayThamGia.setDate(null);
        }
    }  
      public void filltotable(){
        DefaultTableModel model = (DefaultTableModel) tblQuanliKhachHang.getModel();
        model.setRowCount(0);
        for(KhachHang kh:dskh){
            model.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getTuoikh(),kh.getSdt(),
                kh.getEmail(),kh.getDiaChi(),kh.getGioiTinh(), Xdate.toString(kh.getNgayThamGia()),});
        }
    }
               public void showDetail() {
    int viewIndex = tblQuanliKhachHang.getSelectedRow();
    if (viewIndex == -1) {
        return;
    }
    int Index = tblQuanliKhachHang.convertRowIndexToModel(viewIndex);
    if (Index >= 0 && Index < dskh.size()) {
         KhachHang kh = dskh.get(Index);
        txtMaKH.setText(kh.getMaKH());
        txtTenkh.setText(kh.getTenKH());
         txtTuoi.setText(kh.getTuoikh());
          txtSDT.setText(kh.getSdt());
        txtEmail.setText(kh.getEmail());     
          txtDiaChi.setText(kh.getDiaChi());
        rdoNam.setSelected(kh.getGioiTinh().equalsIgnoreCase("nam"));
        rdoNu.setSelected(kh.getGioiTinh().equalsIgnoreCase("nữ"));
    }
}
      
    public void someMethod(int v) {
    if (v >= 0 && v < dskh.size()) {
        filltotextbox(v);
    } else {
        JOptionPane.showMessageDialog(this, "Chỉ mục không hợp lệ");
    }
}

    private void resetForm() {
    // Xóa nội dung các JTextField
    txtMaKH.setText(khdao.fillMaPhatSinh()); // Hàm lấy mã khách hàng sẽ được gọi khi thêm mới
    txtTenkh.setText(""); 
    txtTuoi.setText(""); 
    txtSDT.setText(""); 
    txtEmail.setText(""); 

    // Đặt lại trạng thái các nút giới tính (Nam/Nữ)
    rdoNam.setSelected(false);
    rdoNu.setSelected(false);

    // Xóa nội dung trường địa chỉ
    txtDiaChi.setText(""); 

    // Xóa nội dung trường ngày tham gia
    dcsNgayThamGia.setDate(null); 
}
    
    private void save() {
    KhachHang khachHang = new KhachHang();
    
    // Kiểm tra mã khách hàng có tồn tại không
    if (khdao.check(txtMaKH.getText())) {
        try {
            khachHang.setMaKH(txtMaKH.getText().trim()); // Trim để loại bỏ khoảng trắng thừa
            khachHang.setTenKH(txtTenkh.getText().trim());
            khachHang.setTuoikh(txtTuoi.getText().trim());
            khachHang.setDiaChi(txtDiaChi.getText().trim());

            // Kiểm tra và chuyển đổi số điện thoại
            String sdt = txtSDT.getText().trim();
            if (!sdt.matches("\\d{10,11}")) { // Kiểm tra định dạng số điện thoại (10 hoặc 11 chữ số)
                throw new IllegalArgumentException("Số điện thoại phải là 10 hoặc 11 chữ số.");
            }
            khachHang.setSdt(sdt);

            // Kiểm tra định dạng email
            String email = txtEmail.getText().trim();
            if (!email.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+$")) { // Biểu thức chính quy kiểm tra email
                throw new IllegalArgumentException("Email không hợp lệ.");
            }
            khachHang.setEmail(email);

            // Xử lý giới tính
            String gioiTinh = rdoNam.isSelected() ? "Nam" : "Nữ";
            khachHang.setGioiTinh(gioiTinh);

            // Kiểm tra ngày tham gia
            Date ngayThamGiaUntil = dcsNgayThamGia.getDate();
            if (ngayThamGiaUntil == null) {
                throw new IllegalArgumentException("Ngày tham gia không được để trống.");
            }

            java.sql.Date ngayThamGia = new java.sql.Date(ngayThamGiaUntil.getTime());
            khachHang.setNgayThamGia(ngayThamGia);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        // Lưu thông tin khách hàng vào cơ sở dữ liệu
        int result = khdao.save(khachHang);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            khdao.filltoArrayList();
            filltotable();
            filltotextbox(dskh.size() - 1);
            tblQuanliKhachHang.setRowSelectionInterval(dskh.size() - 1, dskh.size() - 1);
        } else {
            JOptionPane.showMessageDialog(this, "Lưu thất bại");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại.");
    }
}
    
    // update khách hàng 
    
    private void update() {
    KhachHang khachHang = new KhachHang();
    
    // Kiểm tra mã khách hàng có tồn tại không
    if (!khdao.check(txtMaKH.getText())) {
        try {
            khachHang.setMaKH(txtMaKH.getText().trim());
            khachHang.setTenKH(txtTenkh.getText().trim());
            khachHang.setTuoikh(txtTuoi.getText().trim());
            khachHang.setDiaChi(txtDiaChi.getText().trim());

            // Kiểm tra và chuyển đổi số điện thoại
            String sdt = txtSDT.getText().trim();
            if (!sdt.matches("\\d{10,11}")) { // Kiểm tra định dạng số điện thoại (10 hoặc 11 chữ số)
                throw new IllegalArgumentException("Số điện thoại phải là 10 hoặc 11 chữ số.");
            }
            khachHang.setSdt(sdt);

            // Kiểm tra định dạng email
            String email = txtEmail.getText().trim();
            if (!email.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+$")) { // Biểu thức chính quy kiểm tra email
                throw new IllegalArgumentException("Email không hợp lệ.");
            }
            khachHang.setEmail(email);

            // Xử lý giới tính
            String gioiTinh = rdoNam.isSelected() ? "Nam" : "Nữ";
            khachHang.setGioiTinh(gioiTinh);

            // Kiểm tra ngày tham gia
            Date ngayThamGiaUntil = dcsNgayThamGia.getDate();
            if (ngayThamGiaUntil == null) {
                throw new IllegalArgumentException("Ngày tham gia không được để trống.");
            }

            java.sql.Date ngayThamGia = new java.sql.Date(ngayThamGiaUntil.getTime());
            khachHang.setNgayThamGia(ngayThamGia);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số hợp lệ.");
            return;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        // Cập nhật thông tin khách hàng vào cơ sở dữ liệu
        int result = khdao.update(khachHang);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            khdao.filltoArrayList();
            this.filltotable();
            filltotextbox(dskh.size() - 1);
            tblQuanliKhachHang.setRowSelectionInterval(dskh.size() - 1, dskh.size() - 1);
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Mã khách hàng không tồn tại");
    }
}
// xóa khách hàng 
    
     private void delete(){
               if (txtMaKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã thuốc Cần Xóa");
            txtMaKH.requestFocus();
        } else {
            int opt = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa thuốc này?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                khdao.removeStaff(txtMaKH.getText());
            }
        }
        khdao.filltoArrayList();
        filltotable();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblMaKh = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        lblTuoi = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenkh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblNgayThamGia = new javax.swing.JLabel();
        dcsNgayThamGia = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        lblDiaChi = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuanliKhachHang = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản Lý Khách Hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nội Dung Quản Lý"));

        lblMaKh.setText("Mã Khách Hàng:");

        lblTuoi.setText("Tuổi:");

        jLabel4.setText("Tên Khách Hàng:");

        jLabel5.setText("Số điện thoại:");

        lblEmail.setText("Email:");

        jLabel7.setText("Giới Tính:");

        lblNgayThamGia.setText("Ngày Tham Gia ");

        dcsNgayThamGia.setDateFormatString("dd-MM-yyyy");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        lblDiaChi.setText("Địa Chỉ:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblDiaChi)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNgayThamGia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dcsNgayThamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu))
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtTenkh))))
                .addGap(62, 62, 62))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(btnMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKh)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTuoi)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(lblEmail)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcsNgayThamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayThamGia))
                .addGap(34, 34, 34)
                .addComponent(lblDiaChi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        tblQuanliKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MãKH", "Tênkh", "tuoikh", "sdt", "email", "Địa Chỉ ", "Giới TÍnh", "NgàyTG"
            }
        ));
        tblQuanliKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanliKhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuanliKhachHang);

        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });
        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyReleased(evt);
            }
        });

        jLabel1.setText("Tìm Kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        resetForm();
         btnThem.setEnabled(true);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblQuanliKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanliKhachHangMouseClicked
        // TODO add your handling code here:
        showDetail();
        int row = tblQuanliKhachHang.getSelectedRow(); // Lấy chỉ số hàng được chọn
    if (row >= 0) {
        // Lấy dữ liệu từ hàng được chọn
        String maKh = (String) tblQuanliKhachHang.getValueAt(row, 0); // Cột mã khách hàng
        String tenKh = (String) tblQuanliKhachHang.getValueAt(row, 1); // Cột tên khách hàng
        String tuoi = (String) tblQuanliKhachHang.getValueAt(row, 2); // Cột tuổi
        String sdt = (String) tblQuanliKhachHang.getValueAt(row, 3); // Cột số điện thoại
        String email = (String) tblQuanliKhachHang.getValueAt(row, 4); // Cột email
         String diaChi = (String) tblQuanliKhachHang.getValueAt(row, 5);
        String gioiTinh = (String) tblQuanliKhachHang.getValueAt(row, 6); // Cột giới tính
        // Cột địa chỉ

        // Kiểm tra kiểu dữ liệu ngày tháng và chuyển đổi nếu cần
        Object ngayThamGiaObj = tblQuanliKhachHang.getValueAt(row, 7); // Cột ngày tham gia

        java.util.Date ngayThamGia = null;
        if (ngayThamGiaObj instanceof java.util.Date) {
            ngayThamGia = (java.util.Date) ngayThamGiaObj;
        } else if (ngayThamGiaObj instanceof String) {
            ngayThamGia = Xdate.toDate((String) ngayThamGiaObj, "dd/MM/yyyy");
        }

        // Cập nhật các JTextField và các trường khác
        txtMaKH.setText(maKh);
        txtTenkh.setText(tenKh);
        txtTuoi.setText(tuoi); // Chuyển đổi Integer thành String
        txtSDT.setText(sdt);
        txtEmail.setText(email);
        
        txtDiaChi.setText(diaChi);
         if (gioiTinh.equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
            rdoNu.setSelected(true);
        }
        
        dcsNgayThamGia.setDate(ngayThamGia); // Đặt ngày tham gia
    }
     btnSua.setEnabled(true);
                btnXoa.setEnabled(true);
                btnThem.setEnabled(false);
    }//GEN-LAST:event_tblQuanliKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtTimkiemKeyReleased
 private void find(){
        DefaultTableModel ob = (DefaultTableModel) tblQuanliKhachHang.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblQuanliKhachHang.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimkiem.getText()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dcsNgayThamGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMaKh;
    private javax.swing.JLabel lblNgayThamGia;
    private javax.swing.JLabel lblTuoi;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblQuanliKhachHang;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenkh;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
