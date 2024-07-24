/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pharmatechno.UI;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.sun.tools.javac.Main;
import java.math.MathContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Cuong
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        mniLightActionPerformed(null);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnQuanLiBanHang = new javax.swing.JPanel();
        jlbQuanLiBanHang = new javax.swing.JLabel();
        jpnQuanLiNV = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jpnQuanLiThuoc = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jpnDangXuat = new javax.swing.JPanel();
        lblDangXuat = new javax.swing.JLabel();
        jpnTaiKhoan = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jpnDoanhThu = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JpnScreen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMnTrangChu = new javax.swing.JMenu();
        jMnHeThong = new javax.swing.JMenu();
        mniDangXuat = new javax.swing.JMenuItem();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        mniThoat = new javax.swing.JMenuItem();
        mniTaiKhoan = new javax.swing.JMenuItem();
        jMnQuanLi = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        MniNhanVien = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        mniQuanLiNPP = new javax.swing.JMenuItem();
        jMnXuLi = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMnThongKe = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMnTroGiup = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        mniLight = new javax.swing.JMenuItem();
        mniDark = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 939, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jpnMenu.setBackground(new java.awt.Color(255, 255, 255));

        jpnQuanLiBanHang.setBackground(new java.awt.Color(153, 255, 204));
        jpnQuanLiBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnQuanLiBanHangMouseClicked(evt);
            }
        });

        jlbQuanLiBanHang.setBackground(new java.awt.Color(255, 255, 255));
        jlbQuanLiBanHang.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jlbQuanLiBanHang.setForeground(new java.awt.Color(51, 51, 51));
        jlbQuanLiBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Basket.png"))); // NOI18N
        jlbQuanLiBanHang.setText("QUẢN LÍ BÁN HÀNG");

        javax.swing.GroupLayout jpnQuanLiBanHangLayout = new javax.swing.GroupLayout(jpnQuanLiBanHang);
        jpnQuanLiBanHang.setLayout(jpnQuanLiBanHangLayout);
        jpnQuanLiBanHangLayout.setHorizontalGroup(
            jpnQuanLiBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiBanHangLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlbQuanLiBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnQuanLiBanHangLayout.setVerticalGroup(
            jpnQuanLiBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLiBanHangLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jlbQuanLiBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jpnQuanLiNV.setBackground(new java.awt.Color(153, 255, 204));
        jpnQuanLiNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnQuanLiNVMouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/employee.png"))); // NOI18N
        jLabel8.setText("QUẢN LÍ NHÂN VIÊN");

        javax.swing.GroupLayout jpnQuanLiNVLayout = new javax.swing.GroupLayout(jpnQuanLiNV);
        jpnQuanLiNV.setLayout(jpnQuanLiNVLayout);
        jpnQuanLiNVLayout.setHorizontalGroup(
            jpnQuanLiNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiNVLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQuanLiNVLayout.setVerticalGroup(
            jpnQuanLiNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiNVLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnQuanLiThuoc.setBackground(new java.awt.Color(153, 255, 204));
        jpnQuanLiThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnQuanLiThuocMouseClicked(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/medicine.png"))); // NOI18N
        jLabel9.setText("QUẢN LÍ THUỐC");

        javax.swing.GroupLayout jpnQuanLiThuocLayout = new javax.swing.GroupLayout(jpnQuanLiThuoc);
        jpnQuanLiThuoc.setLayout(jpnQuanLiThuocLayout);
        jpnQuanLiThuocLayout.setHorizontalGroup(
            jpnQuanLiThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLiThuocLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnQuanLiThuocLayout.setVerticalGroup(
            jpnQuanLiThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLiThuocLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jpnDangXuat.setBackground(new java.awt.Color(153, 255, 204));

        lblDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(51, 51, 51));
        lblDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Logout_30px_1.png"))); // NOI18N
        lblDangXuat.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout jpnDangXuatLayout = new javax.swing.GroupLayout(jpnDangXuat);
        jpnDangXuat.setLayout(jpnDangXuatLayout);
        jpnDangXuatLayout.setHorizontalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangXuatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDangXuatLayout.setVerticalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDangXuatLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jpnTaiKhoan.setBackground(new java.awt.Color(153, 255, 204));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        jLabel12.setText("TÀI KHOẢN");

        javax.swing.GroupLayout jpnTaiKhoanLayout = new javax.swing.GroupLayout(jpnTaiKhoan);
        jpnTaiKhoan.setLayout(jpnTaiKhoanLayout);
        jpnTaiKhoanLayout.setHorizontalGroup(
            jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaiKhoanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnTaiKhoanLayout.setVerticalGroup(
            jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaiKhoanLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnDoanhThu.setBackground(new java.awt.Color(153, 255, 204));
        jpnDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnDoanhThuMouseClicked(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Dollar.png"))); // NOI18N
        jLabel13.setText("DOANH THU");

        javax.swing.GroupLayout jpnDoanhThuLayout = new javax.swing.GroupLayout(jpnDoanhThu);
        jpnDoanhThu.setLayout(jpnDoanhThuLayout);
        jpnDoanhThuLayout.setHorizontalGroup(
            jpnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoanhThuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDoanhThuLayout.setVerticalGroup(
            jpnDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoanhThuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnQuanLiBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQuanLiNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQuanLiThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jpnQuanLiBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnQuanLiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnQuanLiThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addComponent(jpnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jpnView.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo-64.png"))); // NOI18N
        jLabel1.setText("PharmaStore");

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JpnScreen.setBackground(new java.awt.Color(204, 255, 255));
        JpnScreen.setLayout(new java.awt.BorderLayout(1, 0));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cuahangthuoc.png"))); // NOI18N
        JpnScreen.add(jLabel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JpnScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpnScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 255));
        jMenuBar1.setBorder(null);

        jMnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home.png"))); // NOI18N
        jMnTrangChu.setText("Trang Chủ");
        jMenuBar1.add(jMnTrangChu);

        jMnHeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Gear.png"))); // NOI18N
        jMnHeThong.setText("Hệ Thống");

        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Logout_30px_1.png"))); // NOI18N
        mniDangXuat.setText("Đăng Xuất");
        jMnHeThong.add(mniDangXuat);

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_find_and_replace_30px.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi Mật Khẩu");
        jMnHeThong.add(mniDoiMatKhau);

        mniThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        mniThoat.setText("Thoát");
        jMnHeThong.add(mniThoat);

        mniTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        mniTaiKhoan.setText("Tài Khoản");
        jMnHeThong.add(mniTaiKhoan);

        jMenuBar1.add(jMnHeThong);

        jMnQuanLi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/To do list.png"))); // NOI18N
        jMnQuanLi.setText("Quản Lí");
        jMnQuanLi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMnQuanLiMouseClicked(evt);
            }
        });
        jMnQuanLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnQuanLiActionPerformed(evt);
            }
        });

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/medicine.png"))); // NOI18N
        jMenuItem5.setText("Thuốc");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMnQuanLi.add(jMenuItem5);

        MniNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/employee.png"))); // NOI18N
        MniNhanVien.setText("Nhân Viên");
        MniNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MniNhanVienActionPerformed(evt);
            }
        });
        jMnQuanLi.add(MniNhanVien);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        jMenuItem7.setText("Khách Hàng");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMnQuanLi.add(jMenuItem7);

        mniQuanLiNPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Conference.png"))); // NOI18N
        mniQuanLiNPP.setText("Nhà Phân Phối");
        mniQuanLiNPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLiNPPActionPerformed(evt);
            }
        });
        jMnQuanLi.add(mniQuanLiNPP);

        jMenuBar1.add(jMnQuanLi);

        jMnXuLi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cash register.png"))); // NOI18N
        jMnXuLi.setText("Xử Lí");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill-import.png"))); // NOI18N
        jMenuItem9.setText("Hóa Đơn");
        jMnXuLi.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        jMenuItem10.setText("Hóa Đơn Nhập");
        jMnXuLi.add(jMenuItem10);

        jMenuBar1.add(jMnXuLi);

        jMnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics.png"))); // NOI18N
        jMnThongKe.setText("Thống Kê");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Dollar.png"))); // NOI18N
        jMenuItem11.setText("Doanh Thu");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMnThongKe.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png"))); // NOI18N
        jMenuItem12.setText("Khách Hàng");
        jMnThongKe.add(jMenuItem12);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Diagram.png"))); // NOI18N
        jMenuItem13.setText("Thuốc ");
        jMnThongKe.add(jMenuItem13);

        jMenuBar1.add(jMnThongKe);

        jMnTroGiup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/info.png"))); // NOI18N
        jMnTroGiup.setText("Trợ Giúp");
        jMenuBar1.add(jMnTroGiup);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Color wheel.png"))); // NOI18N
        jMenu1.setText("Chế Độ");

        mniLight.setText("Light");
        mniLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLightActionPerformed(evt);
            }
        });
        jMenu1.add(mniLight);

        mniDark.setText("Dark");
        mniDark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDarkActionPerformed(evt);
            }
        });
        jMenu1.add(mniDark);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
private void changePanel(JPanel newPanel) {
    JpnScreen.removeAll();
    JpnScreen.add(newPanel);
    newPanel.setVisible(true);
    JpnScreen.updateUI();
}

private void updateBackgroundColors(JPanel activePanel) {
    jpnQuanLiNV.setBackground(new java.awt.Color(153, 255, 204));
    jpnQuanLiBanHang.setBackground(new java.awt.Color(153, 255, 204));
    jpnQuanLiThuoc.setBackground(new java.awt.Color(153, 255, 204));
    jpnTaiKhoan.setBackground(new java.awt.Color(153, 255, 204));
    jpnDoanhThu.setBackground(new java.awt.Color(153, 255, 204));
    activePanel.setBackground(new java.awt.Color(153, 153, 255));
}
private void updateBackgroundColorsformni() {
    jpnQuanLiNV.setBackground(new java.awt.Color(153, 255, 204));
    jpnQuanLiBanHang.setBackground(new java.awt.Color(153, 255, 204));
    jpnQuanLiThuoc.setBackground(new java.awt.Color(153, 255, 204));
    jpnTaiKhoan.setBackground(new java.awt.Color(153, 255, 204));
    jpnDoanhThu.setBackground(new java.awt.Color(153, 255, 204));
}
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void MniNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MniNhanVienActionPerformed
        // TODO add your handling code here:
        jpnQuanLiNVMouseClicked(null);
    }//GEN-LAST:event_MniNhanVienActionPerformed
    private void mniLightActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        SwingUtilities.invokeLater(()->{
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    } 
    private void jMnQuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnQuanLiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMnQuanLiActionPerformed

    private void jpnQuanLiNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQuanLiNVMouseClicked
        // TODO add your handling code here:
    changePanel(new QuanLiNhanVien());
    updateBackgroundColors(jpnQuanLiNV);
    }//GEN-LAST:event_jpnQuanLiNVMouseClicked

    private void jMnQuanLiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnQuanLiMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMnQuanLiMouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mniDarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDarkActionPerformed
        // TODO add your handling code here:
                SwingUtilities.invokeLater(()->{
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }//GEN-LAST:event_mniDarkActionPerformed

    private void mniQuanLiNPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLiNPPActionPerformed
        // TODO add your handling code here:
    changePanel(new QuanLiNhaPhanPhoi());
    updateBackgroundColorsformni();
    
    }//GEN-LAST:event_mniQuanLiNPPActionPerformed

    private void jpnQuanLiBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQuanLiBanHangMouseClicked
        // TODO add your handling code here:
    changePanel(new QuanLiBanHang());
    updateBackgroundColors(jpnQuanLiBanHang);
    }//GEN-LAST:event_jpnQuanLiBanHangMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jpnDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnDoanhThuMouseClicked
        // TODO add your handling code here:
    changePanel(new DoanhThu());
    updateBackgroundColors(jpnDoanhThu);
    }//GEN-LAST:event_jpnDoanhThuMouseClicked

    private void jpnQuanLiThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQuanLiThuocMouseClicked
        // TODO add your handling code here:
    changePanel(new Thuoc());
    updateBackgroundColors(jpnQuanLiThuoc);
    }//GEN-LAST:event_jpnQuanLiThuocMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpnScreen;
    private javax.swing.JMenuItem MniNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jMnHeThong;
    private javax.swing.JMenu jMnQuanLi;
    private javax.swing.JMenu jMnThongKe;
    private javax.swing.JMenu jMnTrangChu;
    private javax.swing.JMenu jMnTroGiup;
    private javax.swing.JMenu jMnXuLi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlbQuanLiBanHang;
    private javax.swing.JPanel jpnDangXuat;
    private javax.swing.JPanel jpnDoanhThu;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnQuanLiBanHang;
    private javax.swing.JPanel jpnQuanLiNV;
    private javax.swing.JPanel jpnQuanLiThuoc;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTaiKhoan;
    private javax.swing.JPanel jpnView;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDark;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniLight;
    private javax.swing.JMenuItem mniQuanLiNPP;
    private javax.swing.JMenuItem mniTaiKhoan;
    private javax.swing.JMenuItem mniThoat;
    // End of variables declaration//GEN-END:variables
}
