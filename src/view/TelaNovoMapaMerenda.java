
package view;

import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugo
 */
public class TelaNovoMapaMerenda extends javax.swing.JDialog {

    public TelaNovoMapaMerenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpaTexto();
    }

    private void limpaTexto() {
        jTextFieldCardapio.setText("");
        jTextFieldNumeroAlunos.setText("");
        jTextFieldTurno.setText("");
        jFormattedTextFieldData.setText("");
        limpaTabela();
    }
    
    private void limpaTabela() {
        DefaultTableModel model = (DefaultTableModel) jTableGasto.getModel();
        model.addRow(new String[] {
                "1", "", ""
            });
        
    }
    
    private void carregaTabela() {
        DefaultTableModel model = (DefaultTableModel) jTableGasto.getModel();
        model.setRowCount(0);
        model.addRow(new String[] {
                "", "", ""
            });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCardapio = new javax.swing.JLabel();
        jTextFieldCardapio = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabelNumeroAlunos = new javax.swing.JLabel();
        jTextFieldNumeroAlunos = new javax.swing.JTextField();
        jLabelTurno = new javax.swing.JLabel();
        jTextFieldTurno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGasto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCardapio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelCardapio.setText("Cardapio:");

        jTextFieldCardapio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabelData.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabelData.setText("Data:");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextFieldDataMouseClicked(evt);
            }
        });

        jLabelNumeroAlunos.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabelNumeroAlunos.setText("Nº de Alunos:");

        jTextFieldNumeroAlunos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabelTurno.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabelTurno.setText("Turno:");

        jTextFieldTurno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jTableGasto.setModel(new javax.swing.table.DefaultTableModel
            (
                null,
                new String [] {
                    "", "Alimento", "Valor"
                }
            )
            {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    if(mColIndex > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            jTableGasto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            jTableGasto.setRowSelectionAllowed(false);
            jTableGasto.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTableGastoKeyReleased(evt);
                }
            });
            jScrollPane1.setViewportView(jTableGasto);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCardapio)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldCardapio))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelData)
                            .addGap(18, 18, 18)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelNumeroAlunos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldNumeroAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelTurno)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldTurno))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 5, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCardapio)
                        .addComponent(jTextFieldCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelData)
                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNumeroAlunos)
                        .addComponent(jTextFieldNumeroAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTurno)
                        .addComponent(jTextFieldTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(86, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataMouseClicked
        jFormattedTextFieldData.setText("");
    }//GEN-LAST:event_jFormattedTextFieldDataMouseClicked

    private void jTableGastoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableGastoKeyReleased
        if(jTableGasto.getSelectedColumn() == 0 
                && evt.getKeyChar() == KeyEvent.VK_ENTER 
                && jTableGasto.getValueAt(0, 1) != "") {
            //jTableGasto.setEditingColumn(2);
            System.out.println(jTableGasto.getValueAt(0, 1));
            System.out.println(jTableGasto.getSelectedColumn());
        }
    }//GEN-LAST:event_jTableGastoKeyReleased

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
            java.util.logging.Logger.getLogger(TelaNovoMapaMerenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoMapaMerenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoMapaMerenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoMapaMerenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaNovoMapaMerenda dialog = new TelaNovoMapaMerenda(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabelCardapio;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelNumeroAlunos;
    private javax.swing.JLabel jLabelTurno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGasto;
    private javax.swing.JTextField jTextFieldCardapio;
    private javax.swing.JTextField jTextFieldNumeroAlunos;
    private javax.swing.JTextField jTextFieldTurno;
    // End of variables declaration//GEN-END:variables
}
