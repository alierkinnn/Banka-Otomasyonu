/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prolab3_banking_project.view;

import prolab3_banking_project.service.CustomerRepresenterLoginService;
import prolab3_banking_project.serviceImpl.CustomerRepresenterLoginServiceImpl;
import prolab3_banking_project.session.CustomerRepresenterSession;

/**
 *
 * @author Ali Erkin
 */
public class TemsilciAnaMenu extends javax.swing.JFrame {
    
    private CustomerRepresenterLoginServiceImpl loginService = new CustomerRepresenterLoginServiceImpl();

    /**
     * Creates new form TemsilciAnaMenu
     */
    public TemsilciAnaMenu() {
        initComponents();
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

        bilgiGuncelle = new javax.swing.JButton();
        musteriEkle = new javax.swing.JButton();
        musteriSil = new javax.swing.JButton();
        musteriIslemGoruntule = new javax.swing.JButton();
        musteriTalepGoruntule = new javax.swing.JButton();
        MusteriGenelDurumGoruntule = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bilgiGuncelle.setText("Bilgi Güncelle");
        bilgiGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgiGuncelleActionPerformed(evt);
            }
        });

        musteriEkle.setText("Müşteri Ekle");
        musteriEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriEkleActionPerformed(evt);
            }
        });

        musteriSil.setText("Müşteri Sil");
        musteriSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriSilActionPerformed(evt);
            }
        });

        musteriIslemGoruntule.setText("Müşteri İşlemlerini Görüntüle");
        musteriIslemGoruntule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriIslemGoruntuleActionPerformed(evt);
            }
        });

        musteriTalepGoruntule.setText("Müşteri Taleplerini Görüntüle");
        musteriTalepGoruntule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriTalepGoruntuleActionPerformed(evt);
            }
        });

        MusteriGenelDurumGoruntule.setText("Müşteri Genel Durum Görüntüle");
        MusteriGenelDurumGoruntule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MusteriGenelDurumGoruntuleActionPerformed(evt);
            }
        });

        logout.setText("Çıkış");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MusteriGenelDurumGoruntule)
                            .addComponent(musteriEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bilgiGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(musteriSil, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(musteriIslemGoruntule, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(musteriTalepGoruntule, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logout)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(bilgiGuncelle)
                .addGap(18, 18, 18)
                .addComponent(musteriEkle)
                .addGap(18, 18, 18)
                .addComponent(musteriSil)
                .addGap(18, 18, 18)
                .addComponent(musteriIslemGoruntule)
                .addGap(18, 18, 18)
                .addComponent(musteriTalepGoruntule)
                .addGap(18, 18, 18)
                .addComponent(MusteriGenelDurumGoruntule)
                .addGap(18, 18, 18)
                .addComponent(logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void musteriEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriEkleActionPerformed
        this.setVisible(false);
        new TemsilciMusteriEkle().setVisible(true);
        CustomerRepresenterSession.getParentFrame().add(this);
        
        
    }//GEN-LAST:event_musteriEkleActionPerformed

    private void bilgiGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgiGuncelleActionPerformed
        this.setVisible(false);
        new TemsilciBilgiGuncelle().setVisible(true);
        CustomerRepresenterSession.getParentFrame().add(this);
    }//GEN-LAST:event_bilgiGuncelleActionPerformed

    private void musteriSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriSilActionPerformed
        this.setVisible(false);
        new TemsilciMusteriSil().setVisible(true);
        CustomerRepresenterSession.getParentFrame().add(this);
    }//GEN-LAST:event_musteriSilActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        CustomerRepresenterSession.getParentFrame().get(CustomerRepresenterSession.getParentFrame().size()-1).setVisible(true);
        CustomerRepresenterSession.getParentFrame().remove(CustomerRepresenterSession.getParentFrame().size()-1);
        loginService.logout();
        dispose();
        //new LoginGui().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void musteriIslemGoruntuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriIslemGoruntuleActionPerformed
        this.setVisible(false);
        new TemsilciİşlemGörüntüle().setVisible(true);
        CustomerRepresenterSession.getParentFrame().add(this);
    }//GEN-LAST:event_musteriIslemGoruntuleActionPerformed

    private void musteriTalepGoruntuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriTalepGoruntuleActionPerformed
        this.setVisible(false);
        new TemsilciTalepGörüntüle().setVisible(true);
        CustomerRepresenterSession.getParentFrame().add(this);
    }//GEN-LAST:event_musteriTalepGoruntuleActionPerformed

    private void MusteriGenelDurumGoruntuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MusteriGenelDurumGoruntuleActionPerformed
        this.setVisible(false);
        new TemsilciGenelDurum().setVisible(true);
        CustomerRepresenterSession.getParentFrame().add(this);
    }//GEN-LAST:event_MusteriGenelDurumGoruntuleActionPerformed

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
            java.util.logging.Logger.getLogger(TemsilciAnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TemsilciAnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TemsilciAnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TemsilciAnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TemsilciAnaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MusteriGenelDurumGoruntule;
    private javax.swing.JButton bilgiGuncelle;
    private javax.swing.JButton logout;
    private javax.swing.JButton musteriEkle;
    private javax.swing.JButton musteriIslemGoruntule;
    private javax.swing.JButton musteriSil;
    private javax.swing.JButton musteriTalepGoruntule;
    // End of variables declaration//GEN-END:variables
}
