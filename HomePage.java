/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Med_System;

/**
 *
 * @author ASUS
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form NewHomepage
     */
    public HomePage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GETSTARTED = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GETSTARTED.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GETSTARTED.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Med_System/login.png"))); // NOI18N
        GETSTARTED.setText("GET STARTED");
        GETSTARTED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GETSTARTEDActionPerformed(evt);
            }
        });
        getContentPane().add(GETSTARTED, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 170, 40));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, -1, -1));

        jLabel1.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("START ORDER NOW!!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("• Step 1: Fill up the form of medicine");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("• Step 2: Fill up the form of quantity ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("• Step 5: Select payment method ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, -1, -1));

        jLabel6.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("• Step 6: Place order");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, -1));

        jLabel7.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("• Step 3: Input the price of medicine order");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("• Step 4: Input the delivery date ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, -1, -1));

        jLabel9.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("• Step 8: Sign-Out");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, -1, -1));

        jLabel10.setFont(new java.awt.Font("Onyx", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("• Step 7: Generate reciept ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Med_System/bg.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GETSTARTEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GETSTARTEDActionPerformed
        MedicineOrderSystem RP = new MedicineOrderSystem();

        RP.setVisible(true);
    RP.setLocationRelativeTo(null); // Center the window
    dispose(); // Close the current window

    }//GEN-LAST:event_GETSTARTEDActionPerformed
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicineOrderSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GETSTARTED;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
