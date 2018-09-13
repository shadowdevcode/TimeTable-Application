/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTO;

/**
 *
 * @author vijay
 */
public class ViewLoginInfo extends javax.swing.JInternalFrame {

    ArrayList<LoginInfoTO> allLoginData;
    int row;
    JPopupMenu jpopup;
    
    
    public ViewLoginInfo() {
        initComponents();
        setSize(700,400);
        bindTableData();
        row=-1;
        jpopup = new JPopupMenu();
         JMenuItem jmiUpdate = new JMenuItem("Update This Record");
         jpopup.add(jmiUpdate);
         JMenuItem jmiDelete = new JMenuItem("Delete This Record");
         jpopup.add(jmiDelete);
         
         jmiDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
         jmiUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });
         
    }
    
    private void updateRecord(){
         if (row != -1) {
            LoginInfoTO lit = allLoginData.get(row);
            if (lit != null) {
                AddLoginInfo obj = new AddLoginInfo(lit);
                obj.setVisible(true);
                obj.setTitle("Update Login Info");
                JDesktopPane jdp = getDesktopPane();
                jdp.add(obj);
                try {
                    obj.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                dispose();
            }
        }
    }
    
    private void deleteRecord(){
         if (row != -1) {
            LoginInfoTO lit = allLoginData.get(row);
            if (lit != null) {
                int result = JOptionPane.showConfirmDialog(this, "Are You Sure To Delete This Subject Information?", "Message From Admin", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    LoginInfoDAO action = new LoginInfoDAO();
                    if (action.deleteRecord(lit.getUserName())) {
                        JOptionPane.showMessageDialog(this, "Record is Deleted");
                        bindTableData();
                        row = -1;
                    } else {
                        JOptionPane.showMessageDialog(this, action.getErrorMessage());
                    }
                }
            }
        }
    }
    
      private void bindTableData() {
          allLoginData = new LoginInfoDAO().getAllRecord();
          if (allLoginData != null && allLoginData.size() != 0) {
            int totalRows = allLoginData.size();
            String[] columnNames = {" UserName ", " Password ", " RoleName "};
            Object allData[][] = new Object[totalRows][columnNames.length];
            for (int i = 0; i < totalRows; i++) {
                LoginInfoTO cit = allLoginData.get(i);
                allData[i] = new Object[columnNames.length];
                allData[i][0] = cit.getUserName();
                allData[i][1] = cit.getPassword();
                allData[i][2] = cit.getRoleName();
            }
            DefaultTableModel dtm = new DefaultTableModel(allData, columnNames);
            jtViewLoginInfo.setModel(dtm);
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
        jtViewLoginInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("View Login Information");

        jtViewLoginInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jtViewLoginInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtViewLoginInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtViewLoginInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtViewLoginInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtViewLoginInfoMouseClicked
         //if(evt.getButton()== MouseEvent.BUTTON3){
        if (SwingUtilities.isRightMouseButton(evt)) {
            //System.out.println(" Right Button is Clicked ");
            int idx = jtViewLoginInfo.rowAtPoint(evt.getPoint());
            jtViewLoginInfo.getSelectionModel().setSelectionInterval(idx, idx);
            row = jtViewLoginInfo.getSelectedRow();
            //System.out.println(row);
            jpopup.show(jtViewLoginInfo, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jtViewLoginInfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtViewLoginInfo;
    // End of variables declaration//GEN-END:variables
}
