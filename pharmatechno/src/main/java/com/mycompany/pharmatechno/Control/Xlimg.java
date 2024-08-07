package com.mycompany.pharmatechno.Control;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Xlimg {
    public static Image getAppIcon() {
        // Sử dụng đường dẫn tương đối để lấy tài nguyên trong thư mục resources
        URL url = Xlimg.class.getResource("/icon/logo-64.png");
        if (url != null) {
            return new ImageIcon(url).getImage();
        } else {
            System.err.println("Icon not found!");
            return null; // Trả về null nếu không tìm thấy hình ảnh
        }
    }
}
