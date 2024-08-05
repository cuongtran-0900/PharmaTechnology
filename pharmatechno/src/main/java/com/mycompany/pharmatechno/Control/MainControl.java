/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.UI.main;
import static org.jfree.ui.UIUtilities.setupUI;

/**
 *
 * @author hongo
 */
public class MainControl {
      private main mainFrame;
      
   public MainControl(main mainFrame) {
        this.mainFrame = mainFrame;
        // Thiết lập và quản lý MainFrame
        setupUI();
    }
    
  private void setupUI() {
        if (Auth.isManager()) {
            mainFrame.showAdminPanel(); // Hiển thị panel dành cho quản trị viên
            mainFrame.hideEmployeePanel(); // Ẩn panel dành cho nhân viên
        } else {
            mainFrame.hideAdminPanel(); // Ẩn panel dành cho quản trị viên
            mainFrame.showEmployeePanel(); // Hiển thị panel dành cho nhân viên
        }
    } 
      
}
