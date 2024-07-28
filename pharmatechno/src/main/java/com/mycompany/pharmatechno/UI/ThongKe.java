package com.mycompany.pharmatechno.UI;


import com.mycompany.pharmatechno.Control.ThongKeDAO;
import com.mycompany.pharmatechno.Model.ThongKeModel;
import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ThongKe extends javax.swing.JPanel {
    
    ThongKeDAO tkdao = new ThongKeDAO();
    List<ThongKeModel> tkm = tkdao.filltoArrayList();

    public ThongKe(List<ThongKeModel> tkm) {
        this.tkm = tkm;
        initComponents();
        addChart();
    }

    private void addChart() {
        // Tạo dataset
        CategoryDataset dataset = createDataset();

        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ cột", 
                "Thể loại", 
                "Giá trị", 
                dataset, 
                PlotOrientation.VERTICAL, 
                true, true, false);

        // Tùy chỉnh biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(694, 400));

        // Thêm biểu đồ vào JPanelThongKe
        JPanelThongKe.setLayout(new java.awt.BorderLayout());
        JPanelThongKe.add(chartPanel, java.awt.BorderLayout.CENTER);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (ThongKeModel tk : tkm) {
            tk.getTongTien();
        }

        return dataset;
    }


    // Phần còn lại của code không thay đổi
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelThongKe = new javax.swing.JPanel();

        javax.swing.GroupLayout JPanelThongKeLayout = new javax.swing.GroupLayout(JPanelThongKe);
        JPanelThongKe.setLayout(JPanelThongKeLayout);
        JPanelThongKeLayout.setHorizontalGroup(
            JPanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
        );
        JPanelThongKeLayout.setVerticalGroup(
            JPanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelThongKe;
    // End of variables declaration//GEN-END:variables
}
