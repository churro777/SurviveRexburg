/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.surviveRexburg.frames;

/**
 *
 * @author carissa888
 */
public class ChooseCharacterFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChooseCharacterFrame
     */
    public ChooseCharacterFrame() {
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

        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cancelChooseCharacterButton = new javax.swing.JButton();
        chooseYourCharacterHeading = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bingHeading = new javax.swing.JLabel();
        bingStrengthLabel = new javax.swing.JLabel();
        bingSpeedLabel = new javax.swing.JLabel();
        bingCharismaLabel = new javax.swing.JLabel();
        bingLuckLabel = new javax.swing.JLabel();
        bingPlayButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        benHeading = new javax.swing.JLabel();
        benStrengthLabel = new javax.swing.JLabel();
        benSpeedLabel = new javax.swing.JLabel();
        benCharismaLabel = new javax.swing.JLabel();
        benLuckLabel = new javax.swing.JLabel();
        benPlayButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        meganHeading = new javax.swing.JLabel();
        meganStrengthLabel = new javax.swing.JLabel();
        meganSpeedLabel = new javax.swing.JLabel();
        meganCharismaLabel = new javax.swing.JLabel();
        meganLuckLabel = new javax.swing.JLabel();
        meganPlayButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        hayleyHeading = new javax.swing.JLabel();
        hayleyStrengthLabel = new javax.swing.JLabel();
        hayleySpeedLabel = new javax.swing.JLabel();
        hayleyCharismaLabel = new javax.swing.JLabel();
        hayleyLuckLabel = new javax.swing.JLabel();
        hayleyPlayButton = new javax.swing.JButton();

        jLabel6.setText("Strength: -");

        jLabel10.setText("Strength: -");

        jLabel11.setText("Speed: - ");

        jLabel12.setText("Charisma: -");

        jLabel13.setText("Luck: -");

        jLabel14.setText("Strength: -");

        jLabel15.setText("Speed: - ");

        jLabel16.setText("Charisma: -");

        jLabel17.setText("Luck: -");

        jLabel21.setText("jLabel21");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cancelChooseCharacterButton.setText("  Cancel  ");
        cancelChooseCharacterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelChooseCharacterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelChooseCharacterButton)
                .addGap(150, 150, 150))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelChooseCharacterButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        chooseYourCharacterHeading.setBackground(new java.awt.Color(255, 255, 255));
        chooseYourCharacterHeading.setFont(new java.awt.Font("28 Days Later", 0, 48)); // NOI18N
        chooseYourCharacterHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseYourCharacterHeading.setText("Choose Your Character");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        bingHeading.setFont(new java.awt.Font("28 Days Later", 0, 24)); // NOI18N
        bingHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bingHeading.setText("BING");

        bingStrengthLabel.setText("Strength: 6");

        bingSpeedLabel.setText("Speed: 8 ");

        bingCharismaLabel.setText("Charisma: 3");

        bingLuckLabel.setText("Luck: 3");

        bingPlayButton.setText("  Play  ");
        bingPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bingPlayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bingHeading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bingPlayButton)
                    .addComponent(bingSpeedLabel)
                    .addComponent(bingStrengthLabel)
                    .addComponent(bingCharismaLabel)
                    .addComponent(bingLuckLabel))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bingHeading)
                .addGap(18, 18, 18)
                .addComponent(bingStrengthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bingSpeedLabel)
                .addGap(12, 12, 12)
                .addComponent(bingCharismaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bingLuckLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(bingPlayButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        benHeading.setFont(new java.awt.Font("28 Days Later", 0, 24)); // NOI18N
        benHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        benHeading.setText("BEN");

        benStrengthLabel.setText("Strength: 10");

        benSpeedLabel.setText("Speed: 5");

        benCharismaLabel.setText("Charisma: 1");

        benLuckLabel.setText("Luck: 5");

        benPlayButton.setText("  Play  ");
        benPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benPlayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(benHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(benPlayButton)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(benStrengthLabel)
                            .addComponent(benSpeedLabel)
                            .addComponent(benCharismaLabel)
                            .addComponent(benLuckLabel))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(benHeading)
                .addGap(18, 18, 18)
                .addComponent(benStrengthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(benSpeedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(benCharismaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(benLuckLabel)
                .addGap(30, 30, 30)
                .addComponent(benPlayButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        meganHeading.setFont(new java.awt.Font("28 Days Later", 0, 24)); // NOI18N
        meganHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meganHeading.setText("MEGAN");

        meganStrengthLabel.setText("Strength: 6");

        meganSpeedLabel.setText("Speed: 2");

        meganCharismaLabel.setText("Charisma: 8");

        meganLuckLabel.setText("Luck: 4");

        meganPlayButton.setText("  Play  ");
        meganPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meganPlayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meganHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meganPlayButton)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(meganSpeedLabel)
                            .addComponent(meganStrengthLabel)
                            .addComponent(meganCharismaLabel)
                            .addComponent(meganLuckLabel)))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(meganHeading)
                .addGap(18, 18, 18)
                .addComponent(meganStrengthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(meganSpeedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(meganCharismaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(meganLuckLabel)
                .addGap(30, 30, 30)
                .addComponent(meganPlayButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        hayleyHeading.setFont(new java.awt.Font("28 Days Later", 0, 24)); // NOI18N
        hayleyHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hayleyHeading.setText("HAYLEY");

        hayleyStrengthLabel.setText("Strength: 1");

        hayleySpeedLabel.setText("Speed: 5");

        hayleyCharismaLabel.setText("Charisma: 6");

        hayleyLuckLabel.setText("Luck: 8");

        hayleyPlayButton.setText("  Play  ");
        hayleyPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hayleyPlayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hayleyHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hayleyPlayButton)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hayleySpeedLabel)
                            .addComponent(hayleyStrengthLabel)
                            .addComponent(hayleyCharismaLabel)
                            .addComponent(hayleyLuckLabel))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(hayleyHeading)
                .addGap(18, 18, 18)
                .addComponent(hayleyStrengthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hayleySpeedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hayleyCharismaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hayleyLuckLabel)
                .addGap(29, 29, 29)
                .addComponent(hayleyPlayButton)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(491, 491, 491))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(701, 701, 701)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chooseYourCharacterHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(chooseYourCharacterHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bingPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bingPlayButtonActionPerformed
        // TODO add your handling code here:
        BingSelectedFrame bingFrame = new BingSelectedFrame();
        bingFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bingPlayButtonActionPerformed

    private void benPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benPlayButtonActionPerformed
        // TODO add your handling code here:
        BenSelectedFrame benFrame = new BenSelectedFrame();
        benFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_benPlayButtonActionPerformed

    private void meganPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meganPlayButtonActionPerformed
        // TODO add your handling code here:
        MeganSelectedFrame meganFrame = new MeganSelectedFrame();
        meganFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_meganPlayButtonActionPerformed

    private void hayleyPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hayleyPlayButtonActionPerformed
        // TODO add your handling code here:
        HayleySelectedFrame hayleyFrame = new HayleySelectedFrame();
        hayleyFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hayleyPlayButtonActionPerformed

    private void cancelChooseCharacterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelChooseCharacterButtonActionPerformed
        // TODO add your handling code here:
        StartProgramFrame1 startGame = new StartProgramFrame1();
        startGame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelChooseCharacterButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseCharacterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseCharacterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseCharacterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseCharacterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseCharacterFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel benCharismaLabel;
    private javax.swing.JLabel benHeading;
    private javax.swing.JLabel benLuckLabel;
    private javax.swing.JButton benPlayButton;
    private javax.swing.JLabel benSpeedLabel;
    private javax.swing.JLabel benStrengthLabel;
    private javax.swing.JLabel bingCharismaLabel;
    private javax.swing.JLabel bingHeading;
    private javax.swing.JLabel bingLuckLabel;
    private javax.swing.JButton bingPlayButton;
    private javax.swing.JLabel bingSpeedLabel;
    private javax.swing.JLabel bingStrengthLabel;
    private javax.swing.JButton cancelChooseCharacterButton;
    private javax.swing.JLabel chooseYourCharacterHeading;
    private javax.swing.JLabel hayleyCharismaLabel;
    private javax.swing.JLabel hayleyHeading;
    private javax.swing.JLabel hayleyLuckLabel;
    private javax.swing.JButton hayleyPlayButton;
    private javax.swing.JLabel hayleySpeedLabel;
    private javax.swing.JLabel hayleyStrengthLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel meganCharismaLabel;
    private javax.swing.JLabel meganHeading;
    private javax.swing.JLabel meganLuckLabel;
    private javax.swing.JButton meganPlayButton;
    private javax.swing.JLabel meganSpeedLabel;
    private javax.swing.JLabel meganStrengthLabel;
    // End of variables declaration//GEN-END:variables
}
