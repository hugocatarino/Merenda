/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AlimentoDAO;
import dao.RemessaDAO;
import dao.Remessa_has_AlimentoDAO;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import model.Alimento;
import model.Remessa;
import model.Remessa_has_Alimento;

/**
 *
 * @author Hugo
 */
public class TelaNovoAlimento extends javax.swing.JDialog {
    private Remessa_has_Alimento remessaAlimento;
    private Alimento alimento;
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
        jButtonGasto.setVisible(false);
        iniciaCampos();
    }
    
    private void calculaSaldo() {
        float novo = 0;
        novo = Float.parseFloat(jTextFieldAntigo.getText()) + Float.parseFloat(jTextFieldEntrada.getText()) 
                - Float.parseFloat(jTextFieldSaida.getText());
        jTextFieldNovo.setText(Float.toString(novo));
    }
    
    private void iniciaCampos() {
        limpaCampos();
        if(principal.getAlimento() != null) {
            enableButtonsGasto(principal.getAlimento());
        }else {
            enableButtonsAdiciona();
        }
    }
    
    private void disableButtons() {
        jTextFieldNomeAlimento.setEditable(false);
        jTextFieldEntrada.setEditable(false);
        jFormattedTextFieldData.setEditable(false);
        jTextFieldAntigo.setEditable(false);
        jTextFieldSaida.setEditable(false);
        jTextFieldNovo.setEditable(false);
        jButtonAdicionar.setEnabled(false);
        jButtonGasto.setEnabled(false);
    }
    
    private void enableButtonsAdiciona() {
        jTextFieldNomeAlimento.setEditable(true);
        jButtonBuscarAlimento.setEnabled(true);
    }
    
    private void enableCampos() {
        jTextFieldEntrada.setEditable(true);
        jFormattedTextFieldData.setEditable(true);
        jTextFieldAntigo.setEditable(true);
        jTextFieldAntigo.setEditable(true);
        jTextFieldSaida.setEditable(false);
        jButtonAdicionar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
    }
    
    private void enableButtonsGasto(Alimento alimento) {
        jTextFieldEntrada.setEditable(true);
        jTextFieldAntigo.setEditable(false);
        jButtonBuscarAlimento.setEnabled(false);
        jTextFieldNomeAlimento.setText(alimento.getNome());
        jTextFieldAntigo.setText(Float.toString(alimento.getTotal()));
        jFormattedTextFieldData.setEditable(true);
        calculaSaldo();
        jTextFieldNomeAlimento.setEditable(false);
        jTextFieldSaida.setEditable(false);
        jButtonAdicionar.setEnabled(true);
        jButtonGasto.setEnabled(false);
    }
    
    private void limpaCampos() {
        jTextFieldNomeAlimento.setText("");
        jFormattedTextFieldData.setText("");
        jTextFieldAntigo.setText("0");
        jTextFieldNovo.setText("0");
        jTextFieldEntrada.setText("0");
        jTextFieldSaida.setText("0");
        disableButtons();
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
    
   private boolean validaNomeAlimento() {
        if(jTextFieldNomeAlimento.getText().trim().length() == 0){
            this.exibirInformacao("O valor do campo 'Nome' não foi informado.");
            jTextFieldNomeAlimento.requestFocus();
            return false;
        } else {
            return true;
        }
    }
    
    private boolean validarCampos() {
        System.out.println(jTextFieldNomeAlimento.getText());
        if(!validaNomeAlimento()) {
            return false;
        } 
        if("  /  /    ".equals(jFormattedTextFieldData.getText())) {
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
        alimento.setNome(jTextFieldNomeAlimento.getText());
        alimento.setTotal(0);
        alimento.setIdEstoque(principal.getEstoque().getIdEstoque());
        System.out.println("Alimento: " + alimento.getNome());
        dao.adicionaAlimento(alimento);
        System.out.println("Alimento: " + alimento.getNome());
    }
    
    private void adicionaRemessa(float valor) {
        RemessaDAO dao = new RemessaDAO();
        Remessa remessa = new Remessa();
        remessa.setDate(jFormattedTextFieldData.getText());
        remessa.setIdEstoque(principal.getEstoque().getIdEstoque());
        remessa.setNome(principal.getEstoque().getNome());
        dao.adicionaRemessa(remessa);
        adicionaRemessaAlimento(remessa, valor);
    }
    
    private void adicionaRemessaAlimento(Remessa remessa, float valor) {
        Remessa_has_AlimentoDAO dao = new Remessa_has_AlimentoDAO();
        remessaAlimento = new Remessa_has_Alimento();
        remessaAlimento.setIdAlimento(alimento.getNome());
        remessaAlimento.setIdRemessa(remessa.getIdRemessa());
        remessaAlimento.setRecebido(valor);
        dao.adicionaRemessa_has_Alimento(remessaAlimento);
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
        jButtonBuscarAlimento = new javax.swing.JButton();
        jButtonGasto = new javax.swing.JButton();

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
        jTextFieldAntigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAntigoFocusLost(evt);
            }
        });
        jTextFieldAntigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldAntigoMouseClicked(evt);
            }
        });
        jTextFieldAntigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAntigoActionPerformed(evt);
            }
        });
        jTextFieldAntigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAntigoKeyReleased(evt);
            }
        });

        jTextFieldEntrada.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEntradaFocusLost(evt);
            }
        });
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
        jTextFieldSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSaidaFocusLost(evt);
            }
        });
        jTextFieldSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSaidaMouseClicked(evt);
            }
        });
        jTextFieldSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaActionPerformed(evt);
            }
        });
        jTextFieldSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSaidaKeyReleased(evt);
            }
        });

        jTextFieldNovo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextFieldNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNovoActionPerformed(evt);
            }
        });

        jTextFieldNomeAlimento.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButtonAdicionar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonAdicionar.setText("Adicionar Alimento");
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
        jFormattedTextFieldData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextFieldDataMouseClicked(evt);
            }
        });
        jFormattedTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataActionPerformed(evt);
            }
        });

        jButtonBuscarAlimento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonBuscarAlimento.setText("Buscar Alimento");
        jButtonBuscarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAlimentoActionPerformed(evt);
            }
        });

        jButtonGasto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonGasto.setText("Adicionar Gasto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNomeAlimento)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNomeAlimento))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelSaida)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(jButtonBuscarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelEntrada)
                                        .addComponent(jLabelData))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(jTextFieldEntrada)))
                                .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabelNovo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
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
                    .addComponent(jButtonBuscarAlimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonGasto))
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
        if(validarCampos()) {
            
            adicionaAlimento();
            
            if(jTextFieldAntigo.isEditable()) {
                if(!jTextFieldAntigo.getText().equals("0")) {
                    adicionaRemessa(Float.parseFloat(jTextFieldAntigo.getText()));
                }
            }
            adicionaRemessa(Float.parseFloat(jTextFieldEntrada.getText()));
            
            principal.carregaAlimentoDAO(principal.getEstoque().getIdEstoque());
            
       }
           iniciaCampos();
       
    }//GEN-LAST:event_jButtonAdicionarActionPerformed
    
    private void jTextFieldEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEntradaKeyReleased
        keyReleased(jTextFieldEntrada, evt);
    }//GEN-LAST:event_jTextFieldEntradaKeyReleased
    
    private void mouseClicked(javax.swing.JTextField jTextField) {
        if(jTextField.isEditable()) {
            jTextField.setText("0");
            calculaSaldo();
            jTextField.setText("");
        }
    }
    
    private void jTextFieldEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEntradaMouseClicked
        mouseClicked(jTextFieldEntrada);
    }//GEN-LAST:event_jTextFieldEntradaMouseClicked

    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataActionPerformed

    private void jButtonBuscarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAlimentoActionPerformed
        if(validaNomeAlimento()) {
            String nome = jTextFieldNomeAlimento.getText();
            AlimentoDAO dao = new AlimentoDAO();
            alimento = dao.buscaAlimento(nome);
            System.out.println(alimento.getNome());
            if(alimento.getNome() == null) {
                enableCampos();
                alimento.setNome(nome);
            } else {
                enableButtonsGasto(alimento);
            }
        }
    }//GEN-LAST:event_jButtonBuscarAlimentoActionPerformed

    private void jTextFieldNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNovoActionPerformed

    private void jTextFieldAntigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAntigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAntigoActionPerformed

    private void keyReleased(javax.swing.JTextField jTextField, java.awt.event.KeyEvent evt) {
        if(validaNumero(evt)) {
            calculaSaldo();
        } else {
            jTextField.setText("0");
            calculaSaldo();
            jTextField.setText("");
        }
    }
    
    private void jTextFieldAntigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAntigoKeyReleased
        keyReleased(jTextFieldAntigo, evt);
    }//GEN-LAST:event_jTextFieldAntigoKeyReleased

    private void jTextFieldAntigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldAntigoMouseClicked
        mouseClicked(jTextFieldAntigo);
    }//GEN-LAST:event_jTextFieldAntigoMouseClicked

    private void focusLost(javax.swing.JTextField jTextField) {
        if(jTextField.getText().equals("")) {
            jTextField.setText("0");
        }
    }
    
    private void jTextFieldEntradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEntradaFocusLost
        focusLost(jTextFieldEntrada);
    }//GEN-LAST:event_jTextFieldEntradaFocusLost

    private void jTextFieldAntigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAntigoFocusLost
        focusLost(jTextFieldAntigo);
    }//GEN-LAST:event_jTextFieldAntigoFocusLost

    private void jTextFieldSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSaidaFocusLost
        focusLost(jTextFieldSaida);
    }//GEN-LAST:event_jTextFieldSaidaFocusLost

    private void jTextFieldSaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSaidaMouseClicked
        mouseClicked(jTextFieldSaida);
    }//GEN-LAST:event_jTextFieldSaidaMouseClicked

    private void jTextFieldSaidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSaidaKeyReleased
        keyReleased(jTextFieldSaida, evt);
    }//GEN-LAST:event_jTextFieldSaidaKeyReleased

    private void jFormattedTextFieldDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataMouseClicked
        jFormattedTextFieldData.setText("");
    }//GEN-LAST:event_jFormattedTextFieldDataMouseClicked

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
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonBuscarAlimento;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGasto;
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
