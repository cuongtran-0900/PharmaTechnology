/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Xlimg {
    public static Image getAppIcon(){
        URL url = Xlimg.class.getResource("/com/mycompany/pharmatechno/icon/logo-64.png");
        return new ImageIcon(url).getImage();
    }
}
