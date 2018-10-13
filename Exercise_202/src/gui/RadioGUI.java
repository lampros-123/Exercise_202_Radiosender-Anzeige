package gui;

import bl.Sender;
import bl.SenderTableModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthias
 */
public class RadioGUI extends javax.swing.JFrame {

    private SenderTableModel model = new SenderTableModel();

    public RadioGUI() {
        initComponents();
        tableRadioStations.setModel(model);
        tableRadioStations.setDefaultRenderer(Object.class, new SenderTableRenderer());

        JFileChooser chooser = new JFileChooser(".");
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                model.loadSenders(chooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Unable to load from selected file");
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        miAdd = new javax.swing.JMenuItem();
        miHideBand = new javax.swing.JMenuItem();
        miShowBand = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRadioStations = new javax.swing.JTable();

        miAdd.setText("hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miAdd);

        miHideBand.setText("Band verstecken");
        miHideBand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHideBandActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miHideBand);

        miShowBand.setText("Band anzeigen");
        miShowBand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miShowBandActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miShowBand);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        tableRadioStations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRadioStations.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tableRadioStations);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        SenderDlg dlg = new SenderDlg(this, true);
        dlg.setVisible(true);
        if (dlg.s != null) {
            model.add(dlg.s);
        }
    }//GEN-LAST:event_miAddActionPerformed

    private void miHideBandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHideBandActionPerformed
        model.hideBand();
    }//GEN-LAST:event_miHideBandActionPerformed

    private void miShowBandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miShowBandActionPerformed
        model.showBand();
    }//GEN-LAST:event_miShowBandActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JFileChooser chooser = new JFileChooser(".");
        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                model.saveSenders(chooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Unable to save to selected file");
            }
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RadioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miHideBand;
    private javax.swing.JMenuItem miShowBand;
    private javax.swing.JTable tableRadioStations;
    // End of variables declaration//GEN-END:variables
}
