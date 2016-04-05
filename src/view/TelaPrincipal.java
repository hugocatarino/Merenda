/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AlimentoDAO;
import dao.EscolaDAO;
import dao.EstoqueDAO;
import dao.Remessa_has_AlimentoDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Alimento;
import model.Escola;
import model.Estoque;
import model.Remessa_has_Alimento;

/**
 *
 * @author Hugo
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private ArrayList<Escola> listaEscola;
    private ArrayList<Estoque> listaEstoque;
    private ArrayList<Alimento> listaAlimento;
    private Escola escola;
    private Estoque estoque;
    
    private void disableButton() {
        jButtonRemover.setEnabled(false);
    }
    
    public TelaPrincipal() {
        initComponents();
        carregaEscolaDAO();
        disableButton();
    }
    
    public Escola getEscola() {
        escola = listaEscola.get(jComboBoxEscola.getSelectedIndex());
        return escola;
    }
    
    public Estoque getEstoque() {
        estoque = listaEstoque.get(jComboBoxEstoque.getSelectedIndex());
        return estoque;
    }
    
    public void carregaEscolaDAO() {
        EscolaDAO dao = new EscolaDAO();
        listaEscola = dao.getAllEscola();
        for(int i = 0; i < listaEscola.size(); i++) {
            jComboBoxEscola.addItem(listaEscola.get(i).getNome());
        }
    }
    
    public void carregaEstoqueDAO(int idEscola) {
        EstoqueDAO dao = new EstoqueDAO();
        listaEstoque = dao.getAllEstoque(idEscola);
        jComboBoxEstoque.removeAllItems();
        if(jComboBoxEstoque.getSelectedIndex() != 1)
        for(int i = 0; i < listaEstoque.size(); i++) {
            jComboBoxEstoque.addItem(listaEstoque.get(i).getNome());
        }
    }
    
    public void carregaAlimentoDAO(int idEstoque) {
        DefaultTableModel model = (DefaultTableModel) jTableListaAlimento.getModel();
        AlimentoDAO dao = new AlimentoDAO();
        Remessa_has_AlimentoDAO daoRemessaAlimento = new Remessa_has_AlimentoDAO();
        listaAlimento = dao.getAllAlimentoEstoque(idEstoque);
        model.setRowCount(0);
        float recebido = 0,antigo = 0;
        for (int i = 0; i < listaAlimento.size(); i++) {
            ArrayList<Remessa_has_Alimento> lista =
                    daoRemessaAlimento.getListaRemessaAlimento(listaAlimento.get(i).getNome());
            if(lista.size() > 0) {
                recebido = lista.get(lista.size() - 1).getRecebido();
                if(lista.size() > 1) {
                    antigo = lista.get(lista.size() - 2).getRecebido();
                }
            } else {
                System.err.println("RemessaALimento = 0");
            }
            model.addRow(new String[]{listaAlimento.get(i).getNome(),
                Float.toString(antigo), Float.toString(recebido), "0", Float.toString(listaAlimento.get(i).getTotal())});
        }
    }
    
    public void limpaTableAlimento() {
        DefaultTableModel model = (DefaultTableModel) jTableListaAlimento.getModel();
        model.setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEscola = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelEstoque = new javax.swing.JPanel();
        jLabelEstoque = new javax.swing.JLabel();
        jComboBoxEstoque = new javax.swing.JComboBox<>();
        jScrollPaneListaAlimento = new javax.swing.JScrollPane();
        jTableListaAlimento = new javax.swing.JTable();
        jButtonAdicionarAlimento = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jComboBoxEscola = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelEscola.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelEscola.setText("Escola:");

        jButtonBuscar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabelEstoque.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelEstoque.setText("Estoque:");

        jComboBoxEstoque.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEstoqueItemStateChanged(evt);
            }
        });
        jComboBoxEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstoqueActionPerformed(evt);
            }
        });

        jTableListaAlimento.setModel(new javax.swing.table.DefaultTableModel 
            (
                null,
                new String [] {
                    "Alimento", "Antigo", "Entrada", "Saida", "Novo"
                }
            )
            {
                @Override    
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            jTableListaAlimento.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableListaAlimentoMouseClicked(evt);
                }
            });
            jScrollPaneListaAlimento.setViewportView(jTableListaAlimento);

            jButtonAdicionarAlimento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
            jButtonAdicionarAlimento.setText("Adicionar Alimento");
            jButtonAdicionarAlimento.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonAdicionarAlimentoActionPerformed(evt);
                }
            });

            jButtonRemover.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
            jButtonRemover.setText("Remover Alimento");
            jButtonRemover.setMaximumSize(new java.awt.Dimension(141, 25));
            jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonRemoverActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanelEstoqueLayout = new javax.swing.GroupLayout(jPanelEstoque);
            jPanelEstoque.setLayout(jPanelEstoqueLayout);
            jPanelEstoqueLayout.setHorizontalGroup(
                jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelEstoqueLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelEstoqueLayout.createSequentialGroup()
                            .addComponent(jLabelEstoque)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxEstoque, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEstoqueLayout.createSequentialGroup()
                            .addGap(0, 18, Short.MAX_VALUE)
                            .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPaneListaAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEstoqueLayout.createSequentialGroup()
                                    .addComponent(jButtonAdicionarAlimento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap())
            );
            jPanelEstoqueLayout.setVerticalGroup(
                jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelEstoqueLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEstoque)
                        .addComponent(jComboBoxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneListaAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAdicionarAlimento)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21))
            );

            jTabbedPane1.addTab("Estoque", jPanelEstoque);

            jComboBoxEscola.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            jComboBoxEscola.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    jComboBoxEscolaItemStateChanged(evt);
                }
            });
            jComboBoxEscola.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBoxEscolaActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonBuscar)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxEscola, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jButtonBuscar)
                    .addGap(18, 18, 18)
                    .addComponent(jTabbedPane1))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBoxEscolaActionPerformed

    private void jComboBoxEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstoqueActionPerformed

    private void jComboBoxEscolaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEscolaItemStateChanged
        // TODO add your handling code here:
        if(listaEscola.get(jComboBoxEscola.getSelectedIndex()) != null)
        carregaEstoqueDAO(listaEscola.get(jComboBoxEscola.getSelectedIndex()).getIdEscola());
    
    }//GEN-LAST:event_jComboBoxEscolaItemStateChanged

    private void jButtonAdicionarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarAlimentoActionPerformed
        
        TelaNovoAlimento novoAlimento = new TelaNovoAlimento(this,true);
        novoAlimento.setVisible(true);
        
    }//GEN-LAST:event_jButtonAdicionarAlimentoActionPerformed

    private void jComboBoxEstoqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEstoqueItemStateChanged
        if(jComboBoxEstoque.getSelectedIndex() != -1)
            carregaAlimentoDAO(listaEstoque.get(jComboBoxEstoque.getSelectedIndex()).getIdEstoque());
        else {
            limpaTableAlimento();
        }
    }//GEN-LAST:event_jComboBoxEstoqueItemStateChanged

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        AlimentoDAO dao = new AlimentoDAO();
        int linhaSelecionada = jTableListaAlimento.getSelectedRow();
        String alimento = listaAlimento.get(linhaSelecionada).getNome();
        System.out.println(alimento);        
        dao.removeAlimento(alimento);
        carregaAlimentoDAO(listaEstoque.get(jComboBoxEstoque.getSelectedIndex()).getIdEstoque());
        System.out.println(jTableListaAlimento.getRowCount());
        if(jTableListaAlimento.getRowCount() == 0) {
            disableButton();
        } else {
            jTableListaAlimento.setRowSelectionInterval(linhaSelecionada - 1, linhaSelecionada - 1);
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jTableListaAlimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaAlimentoMouseClicked
        jButtonRemover.setEnabled(true);
    }//GEN-LAST:event_jTableListaAlimentoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarAlimento;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JComboBox<String> jComboBoxEscola;
    private javax.swing.JComboBox<String> jComboBoxEstoque;
    private javax.swing.JLabel jLabelEscola;
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JPanel jPanelEstoque;
    private javax.swing.JScrollPane jScrollPaneListaAlimento;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableListaAlimento;
    // End of variables declaration//GEN-END:variables

    
}
