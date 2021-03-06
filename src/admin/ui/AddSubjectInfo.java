/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.ui;

import Operational.Checks;
import java.awt.Color;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.SubjectInfoDAO;
import model.to.SubjectInfoTO;

/**
 *
 * @author vijay
 */
public class AddSubjectInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddSubjectInfo
     */
    public AddSubjectInfo() {
        initComponents();
        setSize(698, 458);
        getRootPane().setDefaultButton(jbtnAddSubjectInfo);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }
    
    public AddSubjectInfo(SubjectInfoTO data){
        this();
        if(data!=null){
            jtfSubjectID.setText(data.getSubjectID());
            jtfDescription.setText(data.getDescription());
            jtfSubjectName.setText(data.getSubjectName());
            
            jtfSubjectID.setEditable(false);
            jbtnAddSubjectInfo.setText("Update Subject Information");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfDescription = new javax.swing.JTextField();
        jtfSubjectID = new javax.swing.JTextField();
        jtfSubjectName = new javax.swing.JTextField();
        jbtnAddSubjectInfo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Subject Info");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Enter Description");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 220, 170, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Subject ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 50, 150, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Subject Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 140, 170, 40);
        getContentPane().add(jtfDescription);
        jtfDescription.setBounds(330, 220, 260, 40);
        getContentPane().add(jtfSubjectID);
        jtfSubjectID.setBounds(330, 50, 260, 40);

        jtfSubjectName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSubjectNameKeyTyped(evt);
            }
        });
        getContentPane().add(jtfSubjectName);
        jtfSubjectName.setBounds(330, 140, 260, 40);

        jbtnAddSubjectInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddSubjectInfo.setText("Add Subject Info");
        jbtnAddSubjectInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddSubjectInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddSubjectInfo);
        jbtnAddSubjectInfo.setBounds(190, 310, 300, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddSubjectInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddSubjectInfoActionPerformed
      String message = "";
        try {
            String subjectid = jtfSubjectID.getText().trim();
            String description = jtfDescription.getText().trim();
            String subjectname = jtfSubjectName.getText().trim();
            if (Checks.isEmpty(subjectid)) {
                message = "Please Enter Some Value in Subject Id before Add button...";
            }else if( Checks.isEmpty(subjectname)){
               message = "Please Enter Some Value in Subject Name before Add button..." ;
            }else if( Checks.isEmpty(description)){
               message = "Please Enter Some Value in Description before Add button..." ;
            }
            else {
                SubjectInfoTO data = new SubjectInfoTO();
                data.setSubjectID(subjectid);
                data.setDescription(description);
                data.setSubjectName(subjectname);
                SubjectInfoDAO action = new SubjectInfoDAO();
                if (jbtnAddSubjectInfo.getText().contains("Add")) {
                    if (action.insertRecord(data)) {
                        message = "Record Is Successfully Inserted";
                    } else {
                        message = action.geterrorMessage();
                        if(message.contains("PRIMARY")){
                            message = "This SubjectID is already in use";
                        }
                        if(message.contains("Duplicate")){
                          message = "The Subject Id has already been taken so please enter some other subject id along with the suitable subject regarding the id.";
                        }
                    }
                }else if(jbtnAddSubjectInfo.getText().contains("Update")) {
                     if (action.updateRecord(data)) {
                        message = "Record Is Successfully Updated";
                    } else {
                        message = action.geterrorMessage();
                        if(message.contains("FOREIGN"))
                        {
                            message = "Please delete the information from the Faculty Subject Page as it is the subject alloted to the faculty...!";
                        }
                    }
                     
                     JOptionPane.showMessageDialog(this, message);
                     ViewSubjectInfo obj = new ViewSubjectInfo();
                     obj.setVisible(true);
                     JDesktopPane jdp = getDesktopPane();
                     jdp.add(obj);
                     try {
                         obj.setSelected(true);
                     }catch (PropertyVetoException ex) {       
                     }
                     dispose();
                   }    
                }
           } catch (Exception ex) {
            message = ex.getMessage();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddSubjectInfoActionPerformed

    private void jtfSubjectNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSubjectNameKeyTyped
        if(Character.isLetter(evt.getKeyChar())|| evt.getKeyChar()==' '){
            
        }else{
            evt.consume();
            try{
                
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_jtfSubjectNameKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnAddSubjectInfo;
    private javax.swing.JTextField jtfDescription;
    private javax.swing.JTextField jtfSubjectID;
    private javax.swing.JTextField jtfSubjectName;
    // End of variables declaration//GEN-END:variables

}