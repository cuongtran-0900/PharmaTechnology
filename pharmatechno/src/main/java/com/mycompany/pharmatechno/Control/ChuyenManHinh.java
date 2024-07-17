
package com.mycompany.pharmatechno.Control;

import com.mycompany.pharmatechno.UI.QuanLiBanHang;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cuong
 */
public class ChuyenManHinh {
    private JPanel root;
    private String kindSelected="";

    public ChuyenManHinh(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new QuanLiBanHang());
        root.validate();
        root.repaint();
    }
    public void setEvent(){
        
    }
}
