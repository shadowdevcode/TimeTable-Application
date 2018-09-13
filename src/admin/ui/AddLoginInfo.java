/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import Operational.Checks;
import javax.swing.JOptionPane;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTO;

/**
 *
 * @author vijay
 */
public class AddLoginInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddLoginInfo
     */
    public AddLoginInfo() {
        initComponents();
        setSize(651, 445);
        getRootPane().setDefaultButton(jbtnAddloginInfo);
        jcbRoleName.removeAllItems();
        jcbRoleName.addItem("Select A Role Name");
        jcbRoleName.addItem("User");
        jcbRoleName.addItem("Admin");

    }
    
    public AddLoginInfo(LoginInfoTO data){
        this();
        if(data!=null){
            jtfUserName.setText(data.getUserName());
            jtfPassword.setText(data.getPassword());
            jcbRoleName.setSelectedItem(data.getRoleName());
            jtfUserName.setEditable(false);
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

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfUserName = new javax.swing.JTextField();
        jtfPassword = new javax.swing.JPasswordField();
        jcbRoleName = new javax.swing.JComboBox();
        jbtnAddloginInfo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Login Information");
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Choose RoleName:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 180, 150, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter User Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 22, 150, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 100, 150, 40);

        jtfUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfUserNameKeyTyped(evt);
            }
        });
        getContentPane().add(jtfUserName);
        jtfUserName.setBounds(270, 30, 320, 30);
        getContentPane().add(jtfPassword);
        jtfPassword.setBounds(270, 110, 320, 30);

        jcbRoleName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbRoleName);
        jcbRoleName.setBounds(270, 180, 320, 40);

        jbtnAddloginInfo.setBackground(new java.awt.Color(0, 204, 153));
        jbtnAddloginInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddloginInfo.setText("Add Login Info");
        jbtnAddloginInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddloginInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddloginInfo);
        jbtnAddloginInfo.setBounds(170, 260, 300, 110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddloginInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddloginInfoActionPerformed
        String message = "";
        try {
            String username = jtfUserName.getText().trim();
            String password = new String(jtfPassword.getPassword());
            String rolename = jcbRoleName.getSelectedItem().toString();
            if (Checks.isEmpty(username) || Checks.isEmpty(password)) {

                message = "Please Enter Some Value In User Name And Password";
            }
            else if (!jcbRoleName.getSelectedItem().toString().contains("Select")) {
                
                LoginInfoTO data = new LoginInfoTO();
                data.setUserName(username);
                data.setPassword(password);
                data.setRoleName(rolename);
               
                LoginInfoDAO action = new LoginInfoDAO();
                if (action.insertRecord(data)) {
                    message = "Login Information Is Successfully Added";
                } else {
                    message = action.getErrorMessage();
                    if(message.contains("Duplicate")){
                        message = "HEY USER PLEASE ENTER SOME OTHER VALUE AS THE VALUE YOU ENTERED IS ALREADY IN USE...!";
                    }
                    if(message.contains("PRIMARY")){
                        message = "THIS USER NAME IS ALREADY IN USE.";
                    }
                }

            } else {
                message = "Please Choose A Role Name";

            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddloginInfoActionPerformed

    private void jtfUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUserNameKeyTyped
        if(Character.isLetter(evt.getKeyChar())|| evt.getKeyChar()==' '){
            
        }else{
            evt.consume();
            try{
                
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_jtfUserNameKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtnAddloginInfo;
    private javax.swing.JComboBox jcbRoleName;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfUserName;
    // End of variables declaration//GEN-END:variables
}