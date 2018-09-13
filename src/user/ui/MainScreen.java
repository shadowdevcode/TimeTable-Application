/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.ui;

import admin.ui.SearchFacultySubject;
import admin.ui.SearchRoomAllocation;
import admin.ui.ViewFacultyInfo;
import admin.ui.ViewFacultySubject;
import admin.ui.ViewRoomAllocation;
import admin.ui.ViewRoomInfo;
import admin.ui.ViewSubjectInfo;
import java.beans.PropertyVetoException;

/**
 *
 * @author vijay
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        setSize(700, 700);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myDesktopPane = new admin.ui.MyDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenu1 = new javax.swing.JMenu();
        jmiViewSubjectInfo = new javax.swing.JMenuItem();
        jmenu2 = new javax.swing.JMenu();
        jmiViewFacultyInfo = new javax.swing.JMenuItem();
        jmenu3 = new javax.swing.JMenu();
        jmiViewRoomInfo = new javax.swing.JMenuItem();
        jmenu4 = new javax.swing.JMenu();
        jmiViewFacultySubject = new javax.swing.JMenuItem();
        jmiSearchFacultySubjectInfo = new javax.swing.JMenuItem();
        jmenu5 = new javax.swing.JMenu();
        jmiViewRoomAllocation = new javax.swing.JMenuItem();
        jmiSearchRoomAllocationInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(myDesktopPane, java.awt.BorderLayout.CENTER);

        jmenu1.setText(" Subject Info");

        jmiViewSubjectInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/SubjectView.png"))); // NOI18N
        jmiViewSubjectInfo.setText("View Subject Info");
        jmiViewSubjectInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewSubjectInfoActionPerformed(evt);
            }
        });
        jmenu1.add(jmiViewSubjectInfo);

        jMenuBar1.add(jmenu1);

        jmenu2.setText("Faculty Info");

        jmiViewFacultyInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/facultyview.png"))); // NOI18N
        jmiViewFacultyInfo.setText("View Faculty Info");
        jmiViewFacultyInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewFacultyInfoActionPerformed(evt);
            }
        });
        jmenu2.add(jmiViewFacultyInfo);

        jMenuBar1.add(jmenu2);

        jmenu3.setText(" Room Info");

        jmiViewRoomInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/roomview.png"))); // NOI18N
        jmiViewRoomInfo.setText("View Room Info");
        jmiViewRoomInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewRoomInfoActionPerformed(evt);
            }
        });
        jmenu3.add(jmiViewRoomInfo);

        jMenuBar1.add(jmenu3);

        jmenu4.setText(" Faculty Subject");

        jmiViewFacultySubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/facultysubjectview.png"))); // NOI18N
        jmiViewFacultySubject.setText("View Faculty Subject");
        jmiViewFacultySubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewFacultySubjectActionPerformed(evt);
            }
        });
        jmenu4.add(jmiViewFacultySubject);

        jmiSearchFacultySubjectInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/facultysubjectsearch.png"))); // NOI18N
        jmiSearchFacultySubjectInfo.setText("Search Faculty Subject Info");
        jmiSearchFacultySubjectInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSearchFacultySubjectInfoActionPerformed(evt);
            }
        });
        jmenu4.add(jmiSearchFacultySubjectInfo);

        jMenuBar1.add(jmenu4);

        jmenu5.setText(" Room Allocation");

        jmiViewRoomAllocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/roomallocationview.PNG"))); // NOI18N
        jmiViewRoomAllocation.setText("View Room Allocation");
        jmiViewRoomAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewRoomAllocationActionPerformed(evt);
            }
        });
        jmenu5.add(jmiViewRoomAllocation);

        jmiSearchRoomAllocationInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/facultysubjectsearch.png"))); // NOI18N
        jmiSearchRoomAllocationInfo.setText("Search Room Allocation Info");
        jmiSearchRoomAllocationInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSearchRoomAllocationInfoActionPerformed(evt);
            }
        });
        jmenu5.add(jmiSearchRoomAllocationInfo);

        jMenuBar1.add(jmenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiViewSubjectInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewSubjectInfoActionPerformed
         ViewSubjectInfo obj = new ViewSubjectInfo();
        obj.setVisible(true);
        myDesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch(PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewSubjectInfoActionPerformed

    private void jmiViewFacultyInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewFacultyInfoActionPerformed
         ViewFacultyInfo obj = new ViewFacultyInfo();
        obj.setVisible(true);
        myDesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch(PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewFacultyInfoActionPerformed

    private void jmiViewRoomInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewRoomInfoActionPerformed
           ViewRoomInfo obj = new ViewRoomInfo();
        obj.setVisible(true);
        myDesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch(PropertyVetoException ex) {
        } 
    }//GEN-LAST:event_jmiViewRoomInfoActionPerformed

    private void jmiViewFacultySubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewFacultySubjectActionPerformed
         ViewFacultySubject obj = new ViewFacultySubject();
        obj.setVisible(true);
        myDesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch(PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewFacultySubjectActionPerformed

    private void jmiViewRoomAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewRoomAllocationActionPerformed
          ViewRoomAllocation obj = new ViewRoomAllocation();
        obj.setVisible(true);
        myDesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch(PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewRoomAllocationActionPerformed

    private void jmiSearchFacultySubjectInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSearchFacultySubjectInfoActionPerformed
           SearchFacultySubject obj = new SearchFacultySubject();
        obj.setVisible(true);
        myDesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch(PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiSearchFacultySubjectInfoActionPerformed

    private void jmiSearchRoomAllocationInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSearchRoomAllocationInfoActionPerformed
         SearchRoomAllocation obj = new SearchRoomAllocation();
        obj.setVisible(true);
        myDesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch(PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiSearchRoomAllocationInfoActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmenu1;
    private javax.swing.JMenu jmenu2;
    private javax.swing.JMenu jmenu3;
    private javax.swing.JMenu jmenu4;
    private javax.swing.JMenu jmenu5;
    private javax.swing.JMenuItem jmiSearchFacultySubjectInfo;
    private javax.swing.JMenuItem jmiSearchRoomAllocationInfo;
    private javax.swing.JMenuItem jmiViewFacultyInfo;
    private javax.swing.JMenuItem jmiViewFacultySubject;
    private javax.swing.JMenuItem jmiViewRoomAllocation;
    private javax.swing.JMenuItem jmiViewRoomInfo;
    private javax.swing.JMenuItem jmiViewSubjectInfo;
    private admin.ui.MyDesktopPane myDesktopPane;
    // End of variables declaration//GEN-END:variables
}
