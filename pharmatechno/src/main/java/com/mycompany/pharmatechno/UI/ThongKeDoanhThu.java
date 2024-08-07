/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pharmatechno.UI;

import com.mycompany.pharmatechno.Control.ThongKeDAO;
import com.mycompany.pharmatechno.Model.ThongKeModel;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public class ThongKeDoanhThu extends javax.swing.JPanel {
      ThongKeDAO tkdao = new ThongKeDAO();
    List<ThongKeModel> tkm = tkdao.filltoArrayList();
    List<ThongKeModel> tkm2 = tkdao.filltoArrayList2();
    public ThongKeDoanhThu() {
        initComponents();
        addChart();
        filltotable();
    }

   private void addChart() {
    // Create dataset
    CategoryDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createBarChart(
            "Biểu đồ cột", 
            "Thể loại", 
            "Giá trị", 
            dataset, 
            PlotOrientation.VERTICAL, 
            true, true, false);

    // Customize the chart
    customizeChart(chart);

    // Set up chart panel
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new Dimension(800, 600));

    // Add chart to JPanelThongKe
    JPanelThongKe.setLayout(new java.awt.BorderLayout());
    JPanelThongKe.add(chartPanel, java.awt.BorderLayout.CENTER);
}


private CategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Add data from the database
    for (ThongKeModel tk : tkm) {
        if (tk.getThoiGian() != null) {
            // Extract the month from Timestamp
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tk.getThoiGian());
            int month = calendar.get(Calendar.MONTH) + 1; // Months are 0-based in Calendar

            // You can format the month as needed (e.g., "January", "February", etc.)
            String monthLabel = String.format("Tháng %d", month);

            dataset.addValue(tk.getTongTien(), "Tổng tiền", monthLabel);
        } else {
            // Handle null ThoiGian
            System.err.println("Sai r em êy");
        }
    }

    return dataset;
}
    
private void customizeChart(JFreeChart chart) {
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Adjust the gap between bars
        renderer.setItemMargin(0.2); // Increase the gap between bars (as a percentage of bar width)

        // Adjust the maximum bar width
        renderer.setMaximumBarWidth(0.05); // Decrease the maximum bar width (as a percentage of available space)

        // Chỉnh cột X
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("Times New Roman", Font.PLAIN, 20)); // Font size of the X-axis label (Month)
        domainAxis.setTickLabelFont(new Font("Times New Roman", Font.PLAIN, 12)); // Font size of the X-axis tick labels

        // chỉnh cột Y
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("Times New Roman", Font.PLAIN, 13)); // Font size of the Y-axis label (Value)
        rangeAxis.setTickLabelFont(new Font("Times New Roman", Font.PLAIN, 10)); // Font size of the Y-axis tick labels
    }
             

        public void filltotable(){
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
        model.setRowCount(0);
        for(ThongKeModel tk:tkm2){
            model.addRow(new Object[] {tk.getThoiGian(),tk.getTongTien()});
        }
    }


    // Phần còn lại của code không thay đổi
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        JPanelThongKe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();

        javax.swing.GroupLayout JPanelThongKeLayout = new javax.swing.GroupLayout(JPanelThongKe);
        JPanelThongKe.setLayout(JPanelThongKeLayout);
        JPanelThongKeLayout.setHorizontalGroup(
            JPanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JPanelThongKeLayout.setVerticalGroup(
            JPanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        tabs.addTab("BIỂU ĐỒ", JPanelThongKe);

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "thơi gian", "tổng doanh thu"
            }
        ));
        jScrollPane1.setViewportView(tblThongKe);

        tabs.addTab("DANH SÁCH", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelThongKe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblThongKe;
    // End of variables declaration//GEN-END:variables
}
