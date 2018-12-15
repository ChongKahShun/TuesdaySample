/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class setMonth extends javax.swing.JFrame {
    public sortedListInterface<Product> productList = new sortedList<>();
    String compareName;
    double comparePrice = 0;
    String compareDescription;
    String getPromotion;
    double getDiscount = 0;
    /**
     * Creates new form setMonth
     */
    public setMonth() {
        initComponents();
        initializeList();
        for(int i =0;i<productList.size();i++){
            if(productList.get(i).getmonth().equals(getMonth())){
                productList.get(i).setDiscount(productList.get(i).getPrice() - 5);
            }else{
                productList.get(i).setDiscount(0);
            }
                                   //delete File
        File f = new File("ProductCatalog.dat");
        if(f.exists()){
	f.delete();}
        //add to File
         try {
                  ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("ProductCatalog.dat"));
                  ooStream.writeObject(productList);
                  ooStream.close();
                } catch (FileNotFoundException ex) {
                  JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                  JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
        }
        fillTable();
    }
    

    private void initializeList() {
    try {
      ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("ProductCatalog.dat"));
      productList = (sortedList) (oiStream.readObject());
      oiStream.close();
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }
    private void fillTable(){
        DefaultTableModel model = (DefaultTableModel) jTablePromotion.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[6];
        for(int i = 0; i < productList.size(); i++)
        {
                rowData[0] = productList.get(i).getName();
                rowData[1] = productList.get(i).getType();
                rowData[2] = productList.get(i).getPrice();
                rowData[3] = productList.get(i).getQuantity();
                rowData[4] = productList.get(i).getDescription();
                rowData[5] = productList.get(i).getmonth();
                model.addRow(rowData);    
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
        jTablePromotion = new javax.swing.JTable();
        jComboMonth = new javax.swing.JComboBox<>();
        jbuttonConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTablePromotion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Original Price", "Quantity", "Description", "Promotion Month"
            }
        ));
        jScrollPane1.setViewportView(jTablePromotion);

        jComboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", " " }));

        jbuttonConfirm.setText("Confirm");
        jbuttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(651, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbuttonConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboMonth, 0, 94, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(169, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jComboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jbuttonConfirm)
                .addContainerGap(394, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonConfirmActionPerformed
        // TODO add your handling code here:
        String month = jComboMonth.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) jTablePromotion.getModel();
        //TableModel model1 = jTablePromotion.getModel();
        int index[] = jTablePromotion.getSelectedRows();
        Object[] row = new Object [6];
        for(int i =0;i<index.length;i++){
            String compareName = model.getValueAt(index[i], 0).toString(); 
            String compareType = model.getValueAt(index[i],1).toString();
            for(int u = 0; u<productList.size(); u ++)
            if(productList.get(u).getName().equals(compareName) && productList.get(u).getType().equals(compareType) ){
                   productList.get(index[i]).setmonth(month);

            }
        }
                        //delete File
        File f = new File("ProductCatalog.dat");
        if(f.exists()){
	f.delete();}
        //add to File
         try {
                  ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("ProductCatalog.dat"));
                  ooStream.writeObject(productList);
                  ooStream.close();
                } catch (FileNotFoundException ex) {
                  JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                  JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                 JOptionPane.showMessageDialog(null, "Change Succesful");
                 this.dispose();
                 new setMonth().setVisible(true);
    }//GEN-LAST:event_jbuttonConfirmActionPerformed

          public String getMonth(){
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];
        return month;
    }
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
            java.util.logging.Logger.getLogger(setMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new setMonth().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboMonth;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePromotion;
    private javax.swing.JButton jbuttonConfirm;
    // End of variables declaration//GEN-END:variables
}
