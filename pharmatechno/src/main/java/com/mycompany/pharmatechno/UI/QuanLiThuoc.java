/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pharmatechno.UI;

import com.mycompany.pharmatechno.Control.ThuocDao;
import com.mycompany.pharmatechno.Model.Thuoc;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.mycompany.pharmatechno.Control.Xdate;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author hongo
 */
public class QuanLiThuoc extends javax.swing.JPanel {

    /**
     * Creates new form Thuoc
     */
    int vitri =0;
    String  strHinhAnh = null;
    public QuanLiThuoc() {
        initComponents();
          someMethod(vitri);
        filltotextbox(vitri);
        filltotable();
        tblQuanliThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblQuanliThuocMouseClicked(evt);
    }
});
        txtMaThuoc.setEnabled(false);
        btnSua.setEnabled(false);
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        loadDonViTinhData();
    }
 ThuocDao thuocdao = new ThuocDao();
    List<Thuoc> dsthuoc = thuocdao.filltoArrayList();
    
        private void filltotextbox(int index) {
        if (index >= 0 && index < dsthuoc.size()) {
            // Lấy thông tin từ đối tượng Student tại chỉ mục index
            Thuoc thuoc = dsthuoc.get(index);
            tblQuanliThuocMouseClicked(null);
//            txtMaThuoc.setText(thuoc.getMaThuoc());
//            txtTenThuoc.setText(thuoc.getTenThuoc());
//            txtSoLuong.setText(thuoc.getSoLuong());
////            lblHinhAnh.setText(thuoc.getHinhAnh());
//            txtThanhPhan.setText(thuoc.getThanhPhan());
//            txtSoLuongTon.setText(String.valueOf(thuoc.getSoLuongTon()));
//            txtGiaNhap.setText(String.valueOf(thuoc.getGiaNhap()));
//            txtDonGia.setText(String.valueOf(thuoc.getDonGia()));
//            dcsNgaySanXuat.setDate(thuoc.getNgaySanXuat());
//            dcsHanSuDung.setDate(thuoc.getHanSuDung());
//            txtDonViTinh.setText(thuoc.getDonViTinh());
//            txtLoaiThuoc.setText(thuoc.getLoaiThuoc());
//            txtXuatXu.setText(thuoc.getXuatXu());
//            imagine(thuoc.getHinhAnh());

        } else {

     txtMaThuoc.setText("");
txtTenThuoc.setText("");
lblHinhAnh.setText("");
txtThanhPhan.setText("");
txtSoLuongTon.setText("");
txtGiaNhap.setText("");
txtDonGia.setText("");
dcsNgaySanXuat.setDate(null);
dcsHanSuDung.setDate(null);
cboDonViTinh.setSelectedItem(null); // Sử dụng setSelectedItem để thiết lập giá trị null
txtLoaiThuoc.setText("");
txtXuatXu.setText("");
txtBarcode.setText("");
        }
    }
   
           public void filltotable(){
        DefaultTableModel model = (DefaultTableModel) tblQuanliThuoc.getModel();
        model.setRowCount(0);
        for(Thuoc thuoc:dsthuoc){
            model.addRow(new Object[] {
                thuoc.getMaThuoc(),
                thuoc.getTenThuoc(),
                thuoc.getHinhAnh(),
                thuoc.getThanhPhan(),
                thuoc.getSoLuongTon(),
                thuoc.getGiaNhap(),
                thuoc.getDonGia(),
//               thuoc.getNgaySanXuat(),
                 Xdate.toString(thuoc.getNgaySanXuat()), // Định dạng ngày tháng
                 Xdate.toString(thuoc.getHanSuDung()),   // Định dạng ngày tháng
             //   thuoc.getHanSuDung(),
                
                thuoc.getDonViTinh(),
                thuoc.getLoaiThuoc(),
                thuoc.getXuatXu(),
                thuoc.getBarcode(),
            });              
        }
    }
void imagine(String hinh) {
    // Tạo đường dẫn đầy đủ cho hình ảnh
    String basePath = "E:\\PharmaTechnology\\pharmatechno\\src\\main\\java\\com\\mycompany\\pharmatechno\\product-image\\";
    String imagePath = basePath + hinh;
    
    ImageIcon image1 = new ImageIcon(imagePath);

    // Kiểm tra kích thước của hình ảnh
    if (image1.getIconWidth() <= 0 || image1.getIconHeight() <= 0) {
        throw new IllegalArgumentException("Width and height of the image must be non-zero. Check the image path: " + imagePath);
    }

    Image im = image1.getImage();

    SwingUtilities.invokeLater(() -> {
        // Đảm bảo kích thước của lblHinhAnh không phải là 0
        int width = lblHinhAnh.getWidth();
        int height = lblHinhAnh.getHeight();

        if (width <= 0 || height <= 0) {
            // Nếu kích thước là 0, sử dụng kích thước mặc định
            width = 200;
            height = 200;
            lblHinhAnh.setPreferredSize(new Dimension(width, height));
            lblHinhAnh.revalidate(); // Yêu cầu layout lại
            lblHinhAnh.repaint();    // Vẽ lại giao diện
        }

        // Cập nhật lại kích thước sau khi revalidate
        width = lblHinhAnh.getWidth();
        height = lblHinhAnh.getHeight();

        // Thay đổi kích thước hình ảnh và tạo ImageIcon mới
        ImageIcon icon = new ImageIcon(im.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        lblHinhAnh.setIcon(icon);
    });
}


        
  public void showDetail() {
    int viewIndex = tblQuanliThuoc.getSelectedRow();
    if (viewIndex == -1) {
        return;
    }

    int modelIndex = tblQuanliThuoc.convertRowIndexToModel(viewIndex);
    if (modelIndex >= 0 && modelIndex < dsthuoc.size()) {
        Thuoc thuoc = dsthuoc.get(modelIndex);
        
        txtMaThuoc.setText(thuoc.getMaThuoc());
        txtTenThuoc.setText(thuoc.getTenThuoc());
        lblHinhAnh.setText(thuoc.getHinhAnh());
        txtThanhPhan.setText(thuoc.getThanhPhan());
        txtSoLuongTon.setText(String.valueOf(thuoc.getSoLuongTon()));
        txtGiaNhap.setText(String.valueOf(thuoc.getGiaNhap()));
        txtDonGia.setText(String.valueOf(thuoc.getDonGia()));
        dcsNgaySanXuat.setDate(thuoc.getNgaySanXuat());
        dcsHanSuDung.setDate(thuoc.getHanSuDung());
       
        // Cập nhật JComboBox với giá trị từ Thuoc
        cboDonViTinh.setSelectedItem(thuoc.getDonViTinh());
      
        txtLoaiThuoc.setText(thuoc.getLoaiThuoc());
        txtXuatXu.setText(thuoc.getXuatXu());
        txtBarcode.setText(strHinhAnh);
        imagine(thuoc.getHinhAnh());
    }
} 
        
        
        
                   public void someMethod(int v) {
    if (v >= 0 && v < dsthuoc.size()) {
        filltotextbox(v);
    } else {
        JOptionPane.showMessageDialog(this, "Chỉ mục không hợp lệ");
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblMaThuoc = new javax.swing.JLabel();
        txtMaThuoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenThuoc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtThanhPhan = new javax.swing.JTextField();
        lblSoLuongTon = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        lblNgaySanXuat = new javax.swing.JLabel();
        lblHanSuDung = new javax.swing.JLabel();
        dcsNgaySanXuat = new com.toedter.calendar.JDateChooser();
        dcsHanSuDung = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtLoaiThuoc = new javax.swing.JTextField();
        lblXuatXu = new javax.swing.JLabel();
        txtXuatXu = new javax.swing.JTextField();
        cboDonViTinh = new javax.swing.JComboBox<>();
        txtBarcode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuanliThuoc = new javax.swing.JTable();
        btnMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnAnh = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        lblTimkiem = new javax.swing.JLabel();
        btnKhoiPhuc = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản Lý Thuốc ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(565, 565, 565)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nội Dung Quản Lý"));

        lblMaThuoc.setText("Mã Thuốc :");

        jLabel4.setText("Tên Thuốc:");

        jLabel5.setText("Thành Phần:");

        lblSoLuongTon.setText("Số Lượng tồn ");

        jLabel7.setText("Giá Nhập ");

        jLabel8.setText("Đơn Giá:");

        lblNgaySanXuat.setText("Ngày Sản Xuất:");

        lblHanSuDung.setText("Hạn Sử Dụng:");

        dcsNgaySanXuat.setDateFormatString("dd-MM-yyyy");

        dcsHanSuDung.setDateFormatString("dd-MM-yyyy");

        jLabel11.setText("Đơn Vị Tính:");

        jLabel12.setText("Loại Thuốc:");

        lblXuatXu.setText("Xuất Xứ ");

        cboDonViTinh.setToolTipText("");
        cboDonViTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDonViTinhActionPerformed(evt);
            }
        });

        jLabel1.setText("Barcode");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNgaySanXuat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcsNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHanSuDung)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblXuatXu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBarcode)
                                    .addComponent(dcsHanSuDung, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(txtXuatXu))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSoLuongTon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThanhPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(txtLoaiThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(cboDonViTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaThuoc)
                            .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtThanhPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoLuongTon)
                        .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNgaySanXuat))
                    .addComponent(dcsNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dcsHanSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(lblXuatXu)
                            .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblHanSuDung))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtLoaiThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblHinhAnh.setText("Hinh Anh");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tblQuanliThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Thuốc", "Tên Thuốc ", "Hình Ảnh ", "Thành Phần ", "Số Lượng Tồn ", "Giá Nhập ", "Đơn Giá ", "Ngày Sản Xuất ", "Hạn Sử dụng ", "Đơn Vị Tính ", "Loại Thuốc ", "Xuất Xứ ", "Barcode"
            }
        ));
        tblQuanliThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanliThuocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuanliThuoc);

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

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

        btnAnh.setText("Chọn Ảnh");
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });

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

        lblTimkiem.setText("Tìm kiếm");

        btnKhoiPhuc.setText("Khôi phục ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(lblTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(btnMoi))
                            .addComponent(btnAnh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKhoiPhuc)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMoi)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnKhoiPhuc))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimkiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
        
    }//GEN-LAST:event_btnSuaActionPerformed
private void resetForm() {
    // Xóa nội dung các JTextField
    txtMaThuoc.setText(thuocdao.fillmaphatsinh());  // hàm lấy mã thuôc gọi lại thông tin từ mã thuốc dao 
    txtTenThuoc.setText(""); 
    lblHinhAnh.setText(""); 
    txtThanhPhan.setText(""); 
    cboDonViTinh.setSelectedItem(null); 
    txtLoaiThuoc.setText(""); 
    txtXuatXu.setText(""); 
    txtBarcode.setText("");
    // Xóa nội dung các trường số lượng tồn, giá nhập, đơn giá
    txtSoLuongTon.setText("");
    txtGiaNhap.setText(""); 
    txtDonGia.setText("");
    dcsNgaySanXuat.setDate(null); 
    dcsHanSuDung.setDate(null); 
}
private void save() {
    Thuoc thuoc = new Thuoc();
    
    // Kiểm tra mã thuốc có tồn tại không
    if (thuocdao.check(txtMaThuoc.getText())) {
        try {
            thuoc.setMaThuoc(txtMaThuoc.getText().trim()); // Trim để loại bỏ khoảng trắng thừa
            thuoc.setTenThuoc(txtTenThuoc.getText().trim());
            thuoc.setThanhPhan(txtThanhPhan.getText().trim());
            thuoc.setDonViTinh((String) cboDonViTinh.getSelectedItem());
            thuoc.setLoaiThuoc(txtLoaiThuoc.getText().trim());
            thuoc.setXuatXu(txtXuatXu.getText().trim());

            // Kiểm tra mã barcode
            String barcode = txtBarcode.getText().trim();
            if (barcode.isEmpty()) {
                throw new IllegalArgumentException("Mã barcode không được để trống.");
            } else if (!barcode.matches("^[0-9A-Za-z]+$")) { // Ví dụ kiểm tra barcode chỉ chứa ký tự chữ và số
                throw new IllegalArgumentException("Mã barcode chỉ được chứa chữ cái và số.");
            }
            thuoc.setBarcode(barcode);
            
            // Kiểm tra và chuyển đổi các giá trị số
            try {
                int soLuongTon = Integer.parseInt(txtSoLuongTon.getText().trim());
                float giaNhap = Float.parseFloat(txtGiaNhap.getText().trim());
                float donGia = Float.parseFloat(txtDonGia.getText().trim());

                thuoc.setSoLuongTon(soLuongTon);
                thuoc.setGiaNhap(giaNhap);
                thuoc.setDonGia(donGia);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Số lượng tồn kho, giá nhập, và đơn giá phải là số hợp lệ.");
                return;
            }

            // Kiểm tra ngày hết hạn và ngày sản xuất
            Date hanSuDungUntil = dcsHanSuDung.getDate();
            Date ngaySanXuatUntil = dcsNgaySanXuat.getDate();
            if (hanSuDungUntil == null || ngaySanXuatUntil == null) {
                throw new IllegalArgumentException("Ngày hết hạn và ngày sản xuất không được để trống.");
            }

            java.sql.Date hanSuDung = new java.sql.Date(hanSuDungUntil.getTime());
            java.sql.Date ngaySanXuat = new java.sql.Date(ngaySanXuatUntil.getTime());

            thuoc.setHanSuDung(hanSuDung);
            thuoc.setNgaySanXuat(ngaySanXuat);

            // Xử lý hình ảnh
            String hinhAnh = lblHinhAnh.getText().trim();
            if (hinhAnh.isEmpty()) {
                throw new IllegalArgumentException("Hình ảnh không được để trống.");
            }
            // Lấy tên tệp hình ảnh từ đường dẫn đầy đủ
            String[] parts = hinhAnh.split("\\\\");
            String tenTepHinhAnh = parts[parts.length - 1];
            thuoc.setHinhAnh(tenTepHinhAnh);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        // Lưu thông tin thuốc vào cơ sở dữ liệu
        int result = thuocdao.save(thuoc);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            thuocdao.filltoArrayList();
            filltotable();
            filltotextbox(dsthuoc.size() - 1);
            tblQuanliThuoc.setRowSelectionInterval(dsthuoc.size() - 1, dsthuoc.size() - 1);
        } else {
            JOptionPane.showMessageDialog(this, "Lưu thất bại");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Mã thuốc đã tồn tại.");
    }
}



public void loadDonViTinhData() {
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    // Giả sử bạn có phương thức trong lớp Dao của bạn để lấy danh sách dữ liệu
    List<String> donViTinhList = thuocdao.getDonViTinhList(); // Điều chỉnh phương thức này nếu cần

    // Thêm các mục vào model
    for (String donViTinh : donViTinhList) {
        model.addElement(donViTinh);
    }

    // Cập nhật model cho JComboBox
    cboDonViTinh.setModel(model);
}

private void update() {
    Thuoc thuoc = new Thuoc();
    if (!thuocdao.check(txtMaThuoc.getText())) {
        try {
            thuoc.setMaThuoc(txtMaThuoc.getText().trim());
            thuoc.setTenThuoc(txtTenThuoc.getText().trim());
            thuoc.setThanhPhan(txtThanhPhan.getText().trim());
            thuoc.setDonViTinh((String) cboDonViTinh.getSelectedItem());
            thuoc.setLoaiThuoc(txtLoaiThuoc.getText().trim());
            thuoc.setXuatXu(txtXuatXu.getText().trim());
            
            // Kiểm tra mã barcode
            String barcode = txtBarcode.getText().trim();
            if (barcode.isEmpty()) {
                throw new IllegalArgumentException("Mã barcode không được để trống.");
            } else if (!barcode.matches("^[0-9A-Za-z]+$")) { // Kiểm tra barcode chỉ chứa ký tự chữ và số
                throw new IllegalArgumentException("Mã barcode chỉ được chứa chữ cái và số.");
            }
            thuoc.setBarcode(barcode);
            
            int soLuongTon = Integer.parseInt(txtSoLuongTon.getText().trim());
            float giaNhap = Float.parseFloat(txtGiaNhap.getText().trim());
            float donGia = Float.parseFloat(txtDonGia.getText().trim());

            Date hanSuDungUntil = dcsHanSuDung.getDate();
            Date ngaySanXuatUntil = dcsNgaySanXuat.getDate();

            if (hanSuDungUntil == null || ngaySanXuatUntil == null) {
                throw new IllegalArgumentException("Ngày không hợp lệ.");
            }

            java.sql.Date hanSuDung = new java.sql.Date(hanSuDungUntil.getTime());
            java.sql.Date ngaySanXuat = new java.sql.Date(ngaySanXuatUntil.getTime());

            thuoc.setHanSuDung(hanSuDung);
            thuoc.setNgaySanXuat(ngaySanXuat);
            thuoc.setSoLuongTon(soLuongTon);
            thuoc.setGiaNhap(giaNhap);
            thuoc.setDonGia(donGia);

            String hinhAnh = lblHinhAnh.getText().trim();
            System.out.println("Giá trị hình ảnh: " + hinhAnh);

            if (hinhAnh.isEmpty()) {
                throw new IllegalArgumentException("Hình ảnh không được để trống");
            }
            String[] parts = hinhAnh.split("\\\\");
            String tenTepHinhAnh = parts[parts.length - 1];
            thuoc.setHinhAnh(tenTepHinhAnh);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng, giá nhập, và đơn giá phải là số hợp lệ.");
            return;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        int result = thuocdao.update(thuoc);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            thuocdao.filltoArrayList();
            this.filltotable();
            filltotextbox(dsthuoc.size() - 1);
            tblQuanliThuoc.setRowSelectionInterval(dsthuoc.size() - 1, dsthuoc.size() - 1);
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Mã thuốc không tồn tại");
    }
}



 private void delete(){
               if (txtMaThuoc.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã thuoc Cần Xóa");
            txtMaThuoc.requestFocus();
        } else {
            int opt = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa thuoc này?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                thuocdao.removeStaff(txtMaThuoc.getText());
            }
        }
        thuocdao.filltoArrayList();
        filltotable();
    }


    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        resetForm();
         btnThem.setEnabled(true);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
        // TODO add your handling code here:
    JFileChooser fileChooser = new JFileChooser("C:\\Users\\hongo\\Documents\\GitHub\\PharmaTechnology\\pharmatechno\\src\\main\\java\\com\\mycompany\\pharmatechno\\product-image\\");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int returnValue = fileChooser.showOpenDialog(this);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        String pathFile = file.getAbsolutePath();
        
        // Thay đổi kích thước ảnh
        int labelWidth = lblHinhAnh.getWidth();
        int labelHeight = lblHinhAnh.getHeight();
        
        ImageIcon icon = resizeImage(pathFile, labelWidth, labelHeight);
        if (icon != null) {
            lblHinhAnh.setIcon(icon);
        } else {
            System.out.println("Lỗi khi tải hình ảnh.");
        }
        
        lblHinhAnh.setText(pathFile); // Gán đường dẫn tệp hình ảnh vào lblHinhAnh
    }

    }//GEN-LAST:event_btnAnhActionPerformed

    
    private ImageIcon resizeImage(String imagePath, int width, int height) {
    try {
        BufferedImage originalImage = ImageIO.read(new File(imagePath));
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
            save();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed


    
    private void tblQuanliThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanliThuocMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
    showDetail();
    int row = tblQuanliThuoc.getSelectedRow(); // Lấy chỉ số hàng được chọn
    if (row >= 0) {
        // Lấy dữ liệu từ hàng được chọn
        String maThuoc = (String) tblQuanliThuoc.getValueAt(row, 0);  // Cột mã thuốc
        String tenThuoc = (String) tblQuanliThuoc.getValueAt(row, 1);  // Cột tên thuốc
        String hinhAnh = (String) tblQuanliThuoc.getValueAt(row, 2);   // Cột hình ảnh
        String thanhPhan = (String) tblQuanliThuoc.getValueAt(row, 3);  // Cột thành phần
       
        // Lấy và chuyển đổi số lượng tồn từ Integer
        Integer soLuongTon = (Integer) tblQuanliThuoc.getValueAt(row, 4); // Cột số lượng tồn

        // Lấy và chuyển đổi giá nhập từ Float
        Float giaNhap = (Float) tblQuanliThuoc.getValueAt(row, 5);     // Cột giá nhập

        // Lấy và chuyển đổi đơn giá từ Float
        Float donGia = (Float) tblQuanliThuoc.getValueAt(row, 6);      // Cột đơn giá

        // Kiểm tra kiểu dữ liệu ngày tháng và chuyển đổi nếu cần
        Object ngaySanXuatObj = tblQuanliThuoc.getValueAt(row, 7); // Cột ngày sản xuất
        Object hanSuDungObj = tblQuanliThuoc.getValueAt(row, 8);  // Cột hạn sử dụng

        java.util.Date ngaySanXuat = null;
        java.util.Date hanSuDung = null;

        if (ngaySanXuatObj instanceof java.util.Date) {
            ngaySanXuat = (java.util.Date) ngaySanXuatObj;
        } else if (ngaySanXuatObj instanceof String) {
            ngaySanXuat = Xdate.toDate((String) ngaySanXuatObj, "dd/MM/yyyy");
        }

        if (hanSuDungObj instanceof java.util.Date) {
            hanSuDung = (java.util.Date) hanSuDungObj;
        } else if (hanSuDungObj instanceof String) {
            hanSuDung = Xdate.toDate((String) hanSuDungObj, "dd/MM/yyyy");
        }

        // Lấy dữ liệu cho các trường donViTinh, loaiThuoc, xuatXu
        String donViTinh = (String) tblQuanliThuoc.getValueAt(row, 9); // Cột đơn vị tính
        String loaiThuoc = (String) tblQuanliThuoc.getValueAt(row, 10);  // Cột loại thuốc
        String xuatXu = (String) tblQuanliThuoc.getValueAt(row, 11);     // Cột xuất xứ
        String barcode =(String) tblQuanliThuoc.getValueAt(row, 12);
        // In ra console để kiểm tra
        System.out.println("donViTinh: " + donViTinh);

        // Cập nhật các JTextField và hình ảnh
        txtMaThuoc.setText(maThuoc);
        txtTenThuoc.setText(tenThuoc);
        lblHinhAnh.setText(hinhAnh);
        txtThanhPhan.setText(thanhPhan);
        txtSoLuongTon.setText(soLuongTon.toString()); // Chuyển đổi Integer thành String
        txtGiaNhap.setText(giaNhap.toString()); // Chuyển đổi Float thành String
        txtDonGia.setText(donGia.toString()); // Chuyển đổi Float thành String
        dcsNgaySanXuat.setDate(ngaySanXuat); // Đặt ngày sản xuất
        dcsHanSuDung.setDate(hanSuDung); // Đặt hạn sử dụng
        cboDonViTinh.setSelectedItem(donViTinh); // Đặt đơn vị tính
        txtLoaiThuoc.setText(loaiThuoc); // Đặt loại thuốc
        txtXuatXu.setText(xuatXu); // Đặt xuất xứ
        imagine(hinhAnh); // Cập nhật hình ảnh
      txtBarcode.setText(barcode);
    }
    btnSua.setEnabled(true);
    btnXoa.setEnabled(true);
    btnThem.setEnabled(false);
    }//GEN-LAST:event_tblQuanliThuocMouseClicked

    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_txtTimkiemKeyReleased

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void cboDonViTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDonViTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDonViTinhActionPerformed
  private void find(){
        DefaultTableModel ob = (DefaultTableModel) tblQuanliThuoc.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblQuanliThuoc.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimkiem.getText()));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnh;
    private javax.swing.JButton btnKhoiPhuc;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboDonViTinh;
    private com.toedter.calendar.JDateChooser dcsHanSuDung;
    private com.toedter.calendar.JDateChooser dcsNgaySanXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblHanSuDung;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblMaThuoc;
    private javax.swing.JLabel lblNgaySanXuat;
    private javax.swing.JLabel lblSoLuongTon;
    private javax.swing.JLabel lblTimkiem;
    private javax.swing.JLabel lblXuatXu;
    private javax.swing.JTable tblQuanliThuoc;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtLoaiThuoc;
    private javax.swing.JTextField txtMaThuoc;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextField txtThanhPhan;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}

