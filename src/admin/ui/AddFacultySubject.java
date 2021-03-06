/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.FacultyInfoDAO;
import model.dao.FacultySubjectDAO;
import model.dao.SubjectInfoDAO;
import model.to.FacultyInfoTO;
import model.to.FacultySubjectTO;
import model.to.SubjectInfoTO;

/**
 *
 * @author vijay
 */
public class AddFacultySubject extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddFacultySubject
     */
    public AddFacultySubject() {
        initComponents();
        setSize(730, 537);
        getRootPane().setDefaultButton(btnAddFacultySubject);
        getContentPane().setBackground(Color.ORANGE);

        jcbFacultyID.removeAllItems();
        jcbFacultyID.addItem("Select Any Faculty");
        ArrayList<FacultyInfoTO> allFacultydata = new FacultyInfoDAO().getAllRecord();
        if (allFacultydata != null) {
            for (FacultyInfoTO fit : allFacultydata) {
                jcbFacultyID.addItem(fit);
            }
        }

        jcbSubjectID.removeAllItems();
        jcbSubjectID.addItem("Select Any Subject");
        ArrayList<SubjectInfoTO> allSubjectdata = new SubjectInfoDAO().getAllRecord();
        if (allSubjectdata != null) {
            for (SubjectInfoTO sit : allSubjectdata) {
                jcbSubjectID.addItem(sit);
            }
        }
    }

    FacultySubjectTO updateData;

    public AddFacultySubject(FacultySubjectTO updata) {
        this();
        updateData = updata;
        if (updateData != null) {
            btnAddFacultySubject.setText("Update Faculty Subject Information");
            for (int i = 1; i < jcbFacultyID.getItemCount(); i++) {
                FacultyInfoTO fit = (FacultyInfoTO) jcbFacultyID.getItemAt(i);
                if (fit.getFacultyID().equals(updateData.getFacultyID())) {
                    jcbFacultyID.setSelectedIndex(i);
                    break;

                }
            }
            for (int i = 1; i < jcbSubjectID.getItemCount(); i++) {
                SubjectInfoTO sit = (SubjectInfoTO) jcbSubjectID.getItemAt(i);
                if (sit.getSubjectID().equals(updateData.getSubjectID())) {
                    jcbSubjectID.setSelectedIndex(i);
                    break;

                }
            }
            if (updateData.getIsCurrent().equalsIgnoreCase("yes")) {
                jrbYes1.setSelected(true);
            } else if (updateData.getIsCurrent().equalsIgnoreCase("no")) {
                jrbNo.setSelected(true);
            }

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbFacultyID = new javax.swing.JComboBox();
        jcbSubjectID = new javax.swing.JComboBox();
        jrbNo = new javax.swing.JRadioButton();
        jrbYes1 = new javax.swing.JRadioButton();
        btnAddFacultySubject = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 153, 0));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Add Faculty Subject");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Choose IsCurrent:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 240, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Choose Faculty Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 42, 190, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Choose Subject Name:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 140, 190, 30);

        jcbFacultyID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbFacultyID);
        jcbFacultyID.setBounds(300, 40, 380, 30);

        jcbSubjectID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbSubjectID);
        jcbSubjectID.setBounds(300, 140, 380, 30);

        buttonGroup1.add(jrbNo);
        jrbNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jrbNo.setText("No");
        getContentPane().add(jrbNo);
        jrbNo.setBounds(413, 239, 60, 31);

        buttonGroup1.add(jrbYes1);
        jrbYes1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jrbYes1.setText("Yes");
        getContentPane().add(jrbYes1);
        jrbYes1.setBounds(300, 233, 53, 40);

        btnAddFacultySubject.setBackground(new java.awt.Color(255, 204, 102));
        btnAddFacultySubject.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAddFacultySubject.setText("Add Faculty Subject");
        btnAddFacultySubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFacultySubjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddFacultySubject);
        btnAddFacultySubject.setBounds(190, 320, 380, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFacultySubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFacultySubjectActionPerformed
        String message = "";
        try {

            if (jcbFacultyID.getSelectedItem() instanceof FacultyInfoTO) {
                if (jcbSubjectID.getSelectedItem() instanceof SubjectInfoTO) {
                    if (!isRadioSelected()) {
                        message = "Please Choose Radio Values...";
                    } else {
                        FacultyInfoTO fit = (FacultyInfoTO) jcbFacultyID.getSelectedItem();

                        SubjectInfoTO sit = (SubjectInfoTO) jcbSubjectID.getSelectedItem();

                        FacultySubjectTO data = new FacultySubjectTO();
                        data.setFacultyID(fit.getFacultyID());
                        data.setSubjectID(sit.getSubjectID());

                        if (jrbNo.isSelected()) {
                            data.setIsCurrent("no");
                        } else if (jrbYes1.isSelected()) {
                            data.setIsCurrent("yes");
                        }

                        FacultySubjectDAO action = new FacultySubjectDAO();
                        if (btnAddFacultySubject.getText().contains("Add")) {

                            if (data.getIsCurrent().equalsIgnoreCase("yes")) {
                                if (action.isTeach(data.getFacultyID(), data.getSubjectID())) {
                                    message = "Hey User Faculty Alloted Already Teaches That Subject.So Kindly Allot Some Other Subject Or Change the Faculty";
                                } else {
                                    if (action.insertRecord(data)) {
                                        message = "Record Is Successfully Inserted";
                                    } else {
                                        message = action.getErrorMessage();

                                    }
                                }
                            } else {
                                if (action.insertRecord(data)) {
                                    message = "Record Is Successfully Inserted";
                                } else {
                                    message = action.getErrorMessage();

                                }
                            }
                        } else {
                            if (btnAddFacultySubject.getText().contains("Update")) {
                                data.setSrNo(updateData.getSrNo());
                                if (action.updateRecord(data)) {
                                    message = "Record Is Now Successfully Updated";

                                    JOptionPane.showMessageDialog(this, message);
                                    ViewFacultySubject obj = new ViewFacultySubject();
                                    obj.setVisible(true);
                                    JDesktopPane jdp = getDesktopPane();
                                    jdp.add(obj);
                                    try {
                                        obj.setSelected(true);
                                    } catch (PropertyVetoException ex) {
                                    }
                                    dispose();
                                } else {
                                    message = action.getErrorMessage();

                                }
                            }
                        }
                    }
                } else {
                    message = "Please Choose A Subject Name";
                }
            } else {
                message = "Please Choose A Faculty Name";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, message);

    }//GEN-LAST:event_btnAddFacultySubjectActionPerformed

    private boolean isRadioSelected() {
        boolean isSelected = false;
        if (jrbYes1.isSelected() || jrbNo.isSelected()) {
            isSelected = true;
        }

        return isSelected;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFacultySubject;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox jcbFacultyID;
    private javax.swing.JComboBox jcbSubjectID;
    private javax.swing.JRadioButton jrbNo;
    private javax.swing.JRadioButton jrbYes1;
    // End of variables declaration//GEN-END:variables
}
