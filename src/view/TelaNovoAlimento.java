/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AlimentoDAO;
import dao.RemessaDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Alimento;
import model.Remessa;

/**
 *
 * @author Hugo
 */
public class TelaNovoAlimento extends javax.swing.JDialog {

    private Alimento alimento;
    private Remessa remessa;
    public static TelaPrincipal principal;
    public TelaNovoAlimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public TelaNovoAlimento(TelaPrincipal parent, boolean modal) {
        //super(parent, modal);
        this.principal = parent;
        this.setModal(modal);
        setLocationRelativeTo(this);
        initComponents();
        limpaCampos();
        disableButtons();
    }
    
    private void disableButtons() {
        jTextFieldNovo.setEditable(false);
        jTextFieldEntrada.setEditable(false);
        jFormattedTextFieldData.setEditable(false);
        jTextFieldAntigo.setEditable(false);
        jTextFieldSaida.setEditable(false);
        jTextFieldNovo.setEditable(false);
        jButtonAdicionar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
    }
    
    private void enableButtons() {
        jTextFieldNovo.setEditable(true);
        jTextFieldEntrada.setEditable(true);
        jFormattedTextFieldData.setEditable(true);
        jTextFieldAntigo.setEditable(true);
        jTextFieldSaida.setEditable(true);
        jTextFieldNovo.setEditable(true);
        jButtonAdicionar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
    }
    
    private void limpaCampos() {
        jTextFieldAntigo.setText("0");
        jTextFieldNovo.setText("0");
        jTextFieldEntrada.setText("0");
        jTextFieldSaida.setText("0");
    }
    
    private boolean validaNumero(KeyEvent evt) {
        if ((evt.getKeyChar() >= KeyEvent.VK_0 && 
               evt.getKeyChar() <= KeyEvent.VK_9)) {
            evt.consume();
            return true;
        }
        return false;
    }
    
    private void exibirInformacao(String info) {
        JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private boolean validarCampos() {
        if(jTextFieldNomeAlimento.getText().trim().length() == 0){
            this.exibirInformacao("O valor do campo 'Nome' não foi informado.");
            jTextFieldNomeAlimento.requestFocus();
            return false;
        } if("  /  /    ".equals(jFormattedTextFieldData.getText())) {
            this.exibirInformacao("O campo 'Data' não foi informado.");
            jFormattedTextFieldData.requestFocus();
            return false;
            
        } if(jTextFieldEntrada.getText().trim().length() == 0 ||
                "0".equals(jTextFieldEntrada.getText())) {
            this.exibirInformacao("O campo 'Entrada' não foi informado.");
            jTextFieldEntrada.requestFocus();
            return false;
        } else
            return true;
    }
    
    public Alimento getAlimento() {
        return this.alimento;
    }
    
    private void adicionaAlimento() {
        AlimentoDAO dao = new AlimentoDAO();
        alimento = new Alimento();
        alimento.setNome(jTextFieldNomeAlimento.getText());
        alimento.setTotal(Float.parseFloat(jTextFieldNovo.getText()));
        System.out.println("Total = " + alimento.getTotal());
        alimento.setIdEstoque(principal.getEstoque().getIdEstoque());
        dao.adicionaAlimento(alimento);
    }
    
    private void adicionaRemessa() {
        RemessaDAO dao = new RemessaDAO();
        remessa = new Remessa();
        remessa.setDate(jFormattedTextFieldData.getText());
        remessa.setIdEstoque(principal.getEstoque().getIdEstoque());
        remessa.setNome(jTextFieldNomeAlimento.getText());
        dao.adicionaRemessa(remessa);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeAlimento = new javax.swing.JLabel();
        jLabelAntigo = new javax.swing.JLabel();
        jLabelEntrada = new javax.swing.JLabel();
        jLabelSaida = new javax.swing.JLabel();
        jLabelNovo = new javax.swing.JLabel();
        jTextFieldAntigo = new javax.swing.JTextField();
        jTextFieldEntrada = new javax.swing.JTextField();
        jTextFieldSaida = new javax.swing.JTextField();
        jTextFieldNovo = new javax.swing.JTextField();
        jTextFieldNomeAlimento = new javax.swing.JTextField();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelData = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNomeAlimento.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelNomeAlimento.setText("Nome do Alimento");

        jLabelAntigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelAntigo.setText("Saldo Anterior");

        jLabelEntrada.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelEntrada.setText("Entrada");

        jLabelSaida.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelSaida.setText("Saida");

        jLabelNovo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelNovo.setText("Saldo");

        jTextFieldAntigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextFieldEntrada.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldEntradaMouseClicked(evt);
            }
        });
        jTextFieldEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEntradaActionPerformed(evt);
            }
        });
        jTextFieldEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEntradaKeyReleased(evt);
            }
        });

        jTextFieldSaida.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaActionPerformed(evt);
            }
        });

        jTextFieldNovo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextFieldNomeAlimento.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButtonAdicionar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelData.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelData.setText("Data");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldData.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jFormattedTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Buscar Alimento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNomeAlimento)
                        .addGap(27, 27, 27)
                        .addComponent(jTextFieldNomeAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jLabelSaida)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSaida))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEntrada)
                                    .addComponent(jLabelData))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEntrada))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNovo)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeAlimento)
                    .addComponent(jTextFieldNomeAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSaida)
                    .addComponent(jTextFieldSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEntrada)
                    .addComponent(jTextFieldEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAntigo)
                    .addComponent(jLabelNovo)
                    .addComponent(jTextFieldNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonCancelar))
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaActionPerformed

    private void jTextFieldEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEntradaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
       System.out.println(jTextFieldEntrada.getText());
        if(validarCampos()) {
           adicionaAlimento();
           adicionaRemessa();
           principal.carregaAlimentoDAO(principal.getEstoque().getIdEstoque());
           this.dispose();
       }
           
       
    }//GEN-LAST:event_jButtonAdicionarActionPerformed
    
    private void jTextFieldEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEntradaKeyReleased
        int novo;
        if(validaNumero(evt)) {
            novo = (Integer.parseInt(jTextFieldEntrada.getText()) + Integer.parseInt(jTextFieldAntigo.getText()));
            jTextFieldNovo.setText(Integer.toString(novo));
        }else {
            jTextFieldNovo.setText("0");
            System.out.println(jFormattedTextFieldData.getText());
            jTextFieldEntrada.setText("");
        }
    }//GEN-LAST:event_jTextFieldEntradaKeyReleased

    private void jTextFieldEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEntradaMouseClicked
        jTextFieldEntrada.setText("");
    }//GEN-LAST:event_jTextFieldEntradaMouseClicked

    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaNovoAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaNovoAlimento dialog = new TelaNovoAlimento(principal, true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabelAntigo;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEntrada;
    private javax.swing.JLabel jLabelNomeAlimento;
    private javax.swing.JLabel jLabelNovo;
    private javax.swing.JLabel jLabelSaida;
    private javax.swing.JTextField jTextFieldAntigo;
    private javax.swing.JTextField jTextFieldEntrada;
    private javax.swing.JTextField jTextFieldNomeAlimento;
    private javax.swing.JTextField jTextFieldNovo;
    private javax.swing.JTextField jTextFieldSaida;
    // End of variables declaration//GEN-END:variables
}
