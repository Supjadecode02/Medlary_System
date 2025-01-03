

package Med_System;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class MEDLARY_LOGIN extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public MEDLARY_LOGIN() {
        initComponents();
        try {
            Connection();
        } catch (SQLException ex) {
            Logger.getLogger(MEDLARY_LOGIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Connection cn;
    Statement st;
    PreparedStatement ps;
    
    private static final String DbName = "usersignupform";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/" + DbName;
    private static final String DbUsername = "root";
    private static final String DbPassword = "";
    
    public void Connection() throws SQLException {
        try {
            Class.forName(DbDriver);
            cn = DriverManager.getConnection(DbUrl, DbUsername, DbPassword);
            st = cn.createStatement();
            
            if (cn != null) {
                System.out.println("Connection Successful");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MEDLARY_SIGNUP.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        CreateAccount = new javax.swing.JButton();
        LoginAccount = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ExistingUsername = new javax.swing.JTextField();
        ExistingPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CreateAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CreateAccount.setText("Create Account");
        CreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountActionPerformed(evt);
            }
        });
        jPanel2.add(CreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 130, 40));

        LoginAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginAccount.setText("Log In");
        LoginAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginAccountActionPerformed(evt);
            }
        });
        jPanel2.add(LoginAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 450, 110, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 62, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Username");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, -1, -1));

        ExistingUsername.setBackground(new java.awt.Color(255, 255, 255));
        ExistingUsername.setForeground(new java.awt.Color(0, 0, 0));
        ExistingUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ExistingUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExistingUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(ExistingUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 340, 260, 40));

        ExistingPassword.setBackground(new java.awt.Color(255, 255, 255));
        ExistingPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExistingPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(ExistingPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 260, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Log In");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\NETBEANS\\bg.png")); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginAccountActionPerformed
        // TODO add your handling code here:
        String username, password;

        username = ExistingUsername.getText();
        password = ExistingPassword.getText();

        String queryLogin = "SELECT * FROM accountdetails where userName = '"+username+"' AND passWord = '"+password+"'";

        try {
            ps = cn.prepareStatement(queryLogin);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()){
                JOptionPane.showMessageDialog(null, "Invalid Credentials", "Account Not Found", JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Welcome!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
               
                HomePage homepage = new HomePage();
        
                dispose();
                homepage.pack();
                homepage.setVisible(true);
                homepage.setLocationRelativeTo(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MEDLARY_LOGIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LoginAccountActionPerformed

    private void CreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountActionPerformed
        // TODO add your handling code here:
        dispose();
        MEDLARY_SIGNUP rg = new MEDLARY_SIGNUP();
        rg.pack();
        rg.setVisible(true);
        rg.setLocationRelativeTo(null);
    }//GEN-LAST:event_CreateAccountActionPerformed

    private void ExistingPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExistingPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExistingPasswordActionPerformed

    private void ExistingUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExistingUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExistingUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(MEDLARY_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MEDLARY_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MEDLARY_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MEDLARY_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MEDLARY_LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateAccount;
    private javax.swing.JPasswordField ExistingPassword;
    private javax.swing.JTextField ExistingUsername;
    private javax.swing.JButton LoginAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
