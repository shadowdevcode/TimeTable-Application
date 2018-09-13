/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.FacultyInfoDAO;
import model.dao.RoomAllocationDAO;
import model.dao.RoomInfoDAO;
import model.dao.SubjectInfoDAO;
import model.to.FacultyInfoTO;
import model.to.RoomAllocationTO;
import model.to.RoomInfoTO;
import model.to.SubjectInfoTO;

/**
 *
 * @author vijay
 */
public class AddRoomAllocation extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddRoomAllocation
     */
    public AddRoomAllocation() {
        initComponents();
        setSize(894, 597);
        getRootPane().setDefaultButton(btnAddRoomAllocation);
        getContentPane().setBackground(Color.YELLOW);

        jcbFacultyID1.removeAllItems();
        jcbFacultyID1.addItem("Select Any Faculty");
        ArrayList<FacultyInfoTO> allfacultydata = new FacultyInfoDAO().getAllRecord();
        if (allfacultydata != null) {
            for (FacultyInfoTO fit : allfacultydata) {
                jcbFacultyID1.addItem(fit);
            }
        }

        jcbSubjectID1.removeAllItems();
        jcbSubjectID1.addItem("Select Any Subject");

        jcbRoomID1.removeAllItems();
        jcbRoomID1.addItem("Select Any Room");
        ArrayList<RoomInfoTO> allRoomdata = new RoomInfoDAO().getAllRecord();
        if (allRoomdata != null) {
            for (RoomInfoTO rit : allRoomdata) {
                jcbRoomID1.addItem(rit);
            }
        }

        jcbDayName.removeAllItems();
        jcbDayName.addItem("Select A Day Name");
        Daynames[] allDayNames = Daynames.values();
        for (Daynames daynames : allDayNames) {
            jcbDayName.addItem(daynames);
        }

        jcbHours.removeAllItems();
        jcbHours.addItem("Hours");
        Hours[] allHours = Hours.values();
        for (Hours hour : allHours) {
            jcbHours.addItem(hour);
        }

        jcbMinutes.removeAllItems();
        jcbMinutes.addItem("Minutes");

        for (int m = 0; m <= 55; m += 5) {
            jcbMinutes.addItem(String.valueOf(m));
        }

    }

    RoomAllocationTO updateData;

    public AddRoomAllocation(RoomAllocationTO updata) {
        this();
        updateData = updata;
        if (updateData != null) {
            btnAddRoomAllocation.setText("Update Room Allocation Info");
            for (int i = 1; i < jcbFacultyID1.getItemCount(); i++) {
                FacultyInfoTO fit = (FacultyInfoTO) jcbFacultyID1.getItemAt(i);
                if (fit.getFacultyID().equals(updateData.getFacultyID())) {
                    jcbFacultyID1.setSelectedIndex(i);
                    break;

                }
            }
            for (int i = 1; i < jcbSubjectID1.getItemCount(); i++) {
                SubjectInfoTO sit = (SubjectInfoTO) jcbSubjectID1.getItemAt(i);
                if (sit.getSubjectID().equals(updateData.getSubjectID())) {
                    jcbSubjectID1.setSelectedIndex(i);
                    break;

                }
            }
            for (int i = 1; i < jcbRoomID1.getItemCount(); i++) {
                RoomInfoTO rit = (RoomInfoTO) jcbRoomID1.getItemAt(i);
                if (rit.getRoomID().equals(updateData.getRoomID())) {
                    jcbRoomID1.setSelectedIndex(i);
                    break;

                }
            }

            String Lecturetime = updateData.getLectureTime().toString();
            System.out.println(Lecturetime);
            String[] alllecturetime = Lecturetime.split(":");
            int hours = Integer.parseInt(alllecturetime[0]);
            int minutes = Integer.parseInt(alllecturetime[1]);

            System.out.println(hours);
            System.out.println(minutes);
            Hours[] allHours = Hours.values();
            for (int i = 0; i < allHours.length; i++) {
                if (allHours[i].getHour() == hours) {
                    jcbHours.setSelectedIndex(i + 1);
                }
            }
            for (int i = 1; i < jcbMinutes.getItemCount(); i++) {
                int num = Integer.parseInt(jcbMinutes.getItemAt(i).toString());
                if (minutes == num) {
                    jcbMinutes.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbDayName.getItemCount(); i++) {
                Daynames dname = Daynames.valueOf(jcbDayName.getItemAt(i).toString());
                if (updateData.getDayName().equalsIgnoreCase(dname.toString())) {
                    jcbDayName.setSelectedIndex(i);
                    break;
                }
            }

            if (updateData.getIsActive().equalsIgnoreCase("yes")) {
                jrbYes.setSelected(true);
            } else if (updateData.getIsActive().equalsIgnoreCase("no")) {
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
        jLable6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfDayname = new javax.swing.JLabel();
        jcbDayName = new javax.swing.JComboBox();
        jcbFacultyID1 = new javax.swing.JComboBox();
        jcbSubjectID1 = new javax.swing.JComboBox();
        jcbMinutes = new javax.swing.JComboBox();
        jcbHours = new javax.swing.JComboBox();
        btnAddRoomAllocation = new javax.swing.JButton();
        jLable7 = new javax.swing.JLabel();
        jrbYes = new javax.swing.JRadioButton();
        jrbNo = new javax.swing.JRadioButton();
        jcbRoomID1 = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Room Allocation");
        getContentPane().setLayout(null);

        jLable6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLable6.setText("Choose IsActive:");
        getContentPane().add(jLable6);
        jLable6.setBounds(70, 390, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Choose Faculty Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 42, 190, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Choose Subject Name:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 110, 190, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Choose Room Name:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 180, 190, 30);

        jtfDayname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfDayname.setText("Enter Day Name:");
        getContentPane().add(jtfDayname);
        jtfDayname.setBounds(70, 250, 190, 30);

        jcbDayName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDayName);
        jcbDayName.setBounds(290, 250, 430, 40);

        jcbFacultyID1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFacultyID1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFacultyID1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbFacultyID1);
        jcbFacultyID1.setBounds(290, 40, 430, 40);

        jcbSubjectID1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbSubjectID1);
        jcbSubjectID1.setBounds(290, 110, 430, 40);

        jcbMinutes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbMinutes);
        jcbMinutes.setBounds(450, 320, 130, 40);

        jcbHours.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbHours);
        jcbHours.setBounds(290, 320, 130, 40);

        btnAddRoomAllocation.setBackground(new java.awt.Color(153, 153, 255));
        btnAddRoomAllocation.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAddRoomAllocation.setText("Add Room Allocation");
        btnAddRoomAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRoomAllocationActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddRoomAllocation);
        btnAddRoomAllocation.setBounds(250, 430, 430, 70);

        jLable7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLable7.setText("Choose Lecture Time:");
        getContentPane().add(jLable7);
        jLable7.setBounds(70, 320, 190, 30);

        buttonGroup1.add(jrbYes);
        jrbYes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jrbYes.setText("Yes");
        getContentPane().add(jrbYes);
        jrbYes.setBounds(290, 390, 93, 30);

        buttonGroup1.add(jrbNo);
        jrbNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jrbNo.setText("No");
        getContentPane().add(jrbNo);
        jrbNo.setBounds(440, 390, 47, 30);

        jcbRoomID1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbRoomID1);
        jcbRoomID1.setBounds(290, 180, 430, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRoomAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoomAllocationActionPerformed
        String message = "";
        try {
                       
                if (jcbFacultyID1.getSelectedItem() instanceof FacultyInfoTO) {

                if (jcbSubjectID1.getSelectedItem() instanceof SubjectInfoTO) {

                    if (jcbRoomID1.getSelectedItem() instanceof RoomInfoTO) {

                        Hours[] allHours = Hours.values();

                        String selectedhour = jcbHours.getSelectedItem().toString();
                        String LectureTime = "";
                        for (Hours h : allHours) {
                            if (h.getValue().equals(selectedhour)) {
                                LectureTime = h.getHour() + ":";
                                break;
                            }
                        }
                       
                        
                        Daynames selecteddaynames = Daynames.valueOf(jcbDayName.getSelectedItem().toString());
                        int selectedminutes = Integer.parseInt(jcbMinutes.getSelectedItem().toString());
                        LectureTime += String.valueOf(selectedminutes) + ":0";

                        FacultyInfoTO fit = (FacultyInfoTO) jcbFacultyID1.getSelectedItem();
                        SubjectInfoTO sit = (SubjectInfoTO) jcbSubjectID1.getSelectedItem();
                        RoomInfoTO rit = (RoomInfoTO) jcbRoomID1.getSelectedItem();

                        RoomAllocationTO data = new RoomAllocationTO();

                        data.setFacultyID(fit.getFacultyID());
                        data.setSubjectID(sit.getSubjectID());
                        data.setRoomID(rit.getRoomID());
                        data.setDayName(selecteddaynames.toString());
                        data.setLectureTime(Time.valueOf(LectureTime));
                         
                        if (jrbNo.isSelected()) {
                            data.setIsActive("no");
                        } else if (jrbYes.isSelected()) {
                            data.setIsActive("yes");
                        }

                        RoomAllocationDAO action = new RoomAllocationDAO();
                        if (btnAddRoomAllocation.getText().contains("Add")) {
                                if (!isRadioSelected()) {
                             message = "Please Choose Radio Values...";
                               }
                            else if (data.getIsActive().equalsIgnoreCase("yes")) {
                                if (action.isAvailable(data.getFacultyID(), data.getSubjectID(), data.getRoomID())) {
                                    message = "Room Is Already Available Please choose Some Other Room";
                                } else {
                                    if (action.insertRecord(data)) {
                                        message = "Record Is Successfully Added";
                                    } else {
                                       JOptionPane.showMessageDialog(this, "Please choose Day name and Time");
                                        message = action.getErrorMessage();
                                    }

                                }
                            } else {
                                if (action.insertRecord(data)) {
                                    message = "Record Is Successfully Added";
                                } else {
                                    JOptionPane.showMessageDialog(this, "Please choose Day name and Time");
                                    message = action.getErrorMessage();
                                }

                            }
                        } else {
                            if (btnAddRoomAllocation.getText().contains("Update")) {
                                data.setSrNO(updateData.getSrNO());
                                if (action.updateRecord(data)) {
                                    message = "Record Is Now Successfully Updated";

                                    JOptionPane.showMessageDialog(this, message);
                                    ViewRoomAllocation obj = new ViewRoomAllocation();
                                    obj.setVisible(true);
                                    JDesktopPane jdp = getDesktopPane();
                                    jdp.add(obj);
                                    try {
                                        obj.setSelected(true);
                                    } catch (PropertyVetoException ex) {
                                    }
                                    dispose();
                                } else {
                                    JOptionPane.showMessageDialog(this, "Please choose Day name and Time");
                                    message = action.getErrorMessage();
                                }
                            }
                        }
                    }
                    else {
                        message = "Please Choose a Room Name";
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
    }//GEN-LAST:event_btnAddRoomAllocationActionPerformed

    
    private boolean isDayNameSelected(){
        try{
            Daynames.valueOf(jcbDayName.getSelectedItem().toString());
            return true;
        }catch(Exception ex){
            return false;
        }
    }
     private boolean istimeselected(){
        try{
            String selectedhour = jcbHours.getSelectedItem().toString();
            return true;
        }catch(Exception ex){
            return false;
        }
    }
     private boolean isminselected(){
        try{
            int selectedminutes = Integer.parseInt(jcbMinutes.getSelectedItem().toString());
            return true;
        }catch(Exception ex){
            return false;
        }
    }
     
    private void jcbFacultyID1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFacultyID1ItemStateChanged
        jcbSubjectID1.removeAllItems();
        jcbSubjectID1.addItem("Select a Subject");
        try {
            FacultyInfoTO fit = (FacultyInfoTO) jcbFacultyID1.getSelectedItem();
            ArrayList<SubjectInfoTO> allSubjectdata = new SubjectInfoDAO().getAllRecordFacultyWise(fit.getFacultyID());
            if (allSubjectdata != null) {
                for (SubjectInfoTO sit : allSubjectdata) {
                    jcbSubjectID1.addItem(sit);
                }
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jcbFacultyID1ItemStateChanged

    private boolean isRadioSelected() {
        boolean isSelected = false;
        if (jrbYes.isSelected() || jrbNo.isSelected()) {
            isSelected = true;
        }

        return isSelected;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRoomAllocation;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLable6;
    private javax.swing.JLabel jLable7;
    private javax.swing.JComboBox jcbDayName;
    private javax.swing.JComboBox jcbFacultyID1;
    private javax.swing.JComboBox jcbHours;
    private javax.swing.JComboBox jcbMinutes;
    private javax.swing.JComboBox jcbRoomID1;
    private javax.swing.JComboBox jcbSubjectID1;
    private javax.swing.JRadioButton jrbNo;
    private javax.swing.JRadioButton jrbYes;
    private javax.swing.JLabel jtfDayname;
    // End of variables declaration//GEN-END:variables
}
