/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.RoomAllocationDAO;
import model.dao.RoomInfoDAO;
import model.to.RoomAllocationTO;
import model.to.RoomInfoTO;

/**
 *
 * @author vijay
 */
public class SearchRoomAllocation extends javax.swing.JInternalFrame {

    /**
     * Creates new form SearchRoomAllocation
     */
    public SearchRoomAllocation() {
        initComponents();
        setSize(917,557);
        jcbRoomID.removeAllItems();
        jcbRoomID.addItem("Select A Room");
        ArrayList<RoomInfoTO> allfacultyData = new RoomInfoDAO().getAllRecord();
        if (allfacultyData != null) {
            for (RoomInfoTO rit : allfacultyData) {
                jcbRoomID.addItem(rit);
            }
        }
        
        jcbYesOrNo.removeAllItems();
        jcbYesOrNo.addItem("Select Yes/No");
        jcbYesOrNo.addItem("Yes");
        jcbYesOrNo.addItem("No");
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
        jtRoomAllocation = new javax.swing.JTable();
        jcbRoomID = new javax.swing.JComboBox();
        btnShowRoomInfo = new javax.swing.JButton();
        jcbYesOrNo = new javax.swing.JComboBox();

        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Search Room Allocation");
        getContentPane().setLayout(null);

        jtRoomAllocation.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtRoomAllocation);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 182, 900, 340);

        jcbRoomID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbRoomID);
        jcbRoomID.setBounds(30, 20, 290, 40);

        btnShowRoomInfo.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        btnShowRoomInfo.setText("Show Room Info");
        btnShowRoomInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRoomInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnShowRoomInfo);
        btnShowRoomInfo.setBounds(410, 10, 330, 120);

        jcbYesOrNo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbYesOrNo);
        jcbYesOrNo.setBounds(30, 90, 290, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowRoomInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRoomInfoActionPerformed
       String message = "";
        try{
             if (jcbRoomID.getSelectedItem() instanceof RoomInfoTO){
                 
                 if(jcbYesOrNo.getSelectedItem().toString().contains("Select")){
             
                 JOptionPane.showMessageDialog(this, "Please Select Either Yes Or No");
             
             }else{
                  String value=jcbYesOrNo.getSelectedItem().toString();
                    
                RoomInfoTO rit = (RoomInfoTO) jcbRoomID.getSelectedItem();
                
                ArrayList<RoomAllocationTO>  allRoomAllocationdata = new RoomAllocationDAO().getAllRecord(rit.getRoomID(),value);
                if (allRoomAllocationdata != null && allRoomAllocationdata.size() != 0) {
                int totalRows = allRoomAllocationdata.size();
                String[] columnNames = {" Faculty Name ", " Subject Name ", " Room Name "," IsActive "};
                Object allData[][] = new Object[totalRows][columnNames.length];
                for (int i = 0; i < totalRows; i++) {
                   RoomAllocationTO rat = allRoomAllocationdata.get(i);
                   allData[i] = new Object[columnNames.length];
                   allData[i][0] = rat.getFacultyName();
                   allData[i][1] = rat.getSubjectName();
                   allData[i][2] = rat.getRoomName();
                   allData[i][3] = rat.getIsActive();
            }
            DefaultTableModel dtm = new DefaultTableModel(allData, columnNames);
            jtRoomAllocation.setModel(dtm);
        }else{
                    message = "There is no record. SO kindly Enter some record to view the data!";
                    String[] columnNames = {" Faculty Name ", " Subject Name ", " Room Name "," IsActive "};
                    Object allData[][] = new Object[1][columnNames.length];
                    allData[0] = new Object[columnNames.length];
                    allData[0][0] = "No Data";
                    allData[0][1] = "No Data";
                    allData[0][2] = "No Data";
                    allData[0][3] = "No Data";
                    DefaultTableModel dtm = new DefaultTableModel(allData, columnNames);
                    jtRoomAllocation.setModel(dtm);
                    JOptionPane.showMessageDialog(this, message);
                    
                }
          
          }
                  
             }else{
                  JOptionPane.showMessageDialog(this, "Please Select A Room");
             }
                     
                      
        }catch(Exception ex){
           message = ex.getMessage();
        }
         
    }//GEN-LAST:event_btnShowRoomInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowRoomInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbRoomID;
    private javax.swing.JComboBox jcbYesOrNo;
    private javax.swing.JTable jtRoomAllocation;
    // End of variables declaration//GEN-END:variables
}