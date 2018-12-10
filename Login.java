
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    String na = null;
    String pass = null;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserL = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        passL = new javax.swing.JLabel();
        OkB = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserL.setText("Username");

        passL.setText("Password");

        OkB.setText("OK");
        OkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passL)
                            .addComponent(UserL))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(password)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(OkB)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserL)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passL)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(OkB)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBActionPerformed
        na = userName.getText();
        pass = password.getText();
        String s = "";
        String s1 = "";
        //System.out.print(s);
        //System.out.print(pass);
        Connection con = null;
        PreparedStatement st = null;
        ResultSet res = null;
        String c = "Select l.username, l.password from BURHAN.LOGIN l";
        boolean lo = false;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/login", "Burhan", "burhan14");
            st = con.prepareStatement(c);
            res = st.executeQuery();
            //System.out.println(na+"\t"+pass);
            while (res.next()) {
                String un = res.getString(1);
                
                for (int i = 0; i < un.length(); i++) {
                    if (un.charAt(i) == ' ') {
                        break;
                    } else {
                        s = s + Character.toString(un.charAt(i));
                    }
                }
                System.out.print(s);
                String pa = res.getString(2);
                
                for (int i = 0; i < pa.length(); i++) {
                    if (pa.charAt(i) == ' ') {
                        break;
                    } else {
                        s1 = s1 + Character.toString(pa.charAt(i));
                    }
                }
                System.out.println(s1);
                if (na.equals(s) && pass.equals(s1)) {
                    lo = true;
                    
                    break;
                }
                s="";
                s1="";
            }
            if (lo == true) {
                //System.out.println("welcome");
                second se=new second();
                se.setVisible(true);
                this.setVisible(false);
            } else {
                System.out.println("wrong");
            }
        } catch (SQLException e) {
            System.out.println("The Username or password is not unique reset again");
            JOptionPane.showMessageDialog(new JFrame(), "Wrong Username or Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OkBActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OkB;
    private javax.swing.JLabel UserL;
    private javax.swing.JLabel passL;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
