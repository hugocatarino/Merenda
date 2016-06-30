/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AlimentoDAO;
import dao.EscolaDAO;
import dao.EstoqueDAO;
import dao.GastoDAO;
import dao.RemessaDAO;
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
    private Alimento alimento = new Alimento();
    
    private void disableButton() {
        jButtonRemover.setEnabled(false);
        jButtonAdicionarRemessa.setEnabled(false);
    }
    
    public TelaPrincipal() {
        initComponents();
        carregaEscolaDAO();
        disableButton();
    }
    
    public Escola getEscola() {
        escola = listaEscola.get(jComboBoxEscola.getSelectedIndex());
        return this.escola;
    }
    
    public Alimento getAlimento() {
        return this.alimento;
    }
    
    public Estoque getEstoque() {
        estoque = listaEstoque.get(jComboBoxEstoque.getSelectedIndex());
        return this.estoque;
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
    
    public void carregaAlimentoComboBox(int idEstoque) {
        AlimentoDAO dao = new AlimentoDAO();
        listaAlimento = dao.getAllAlimentoEstoque(idEstoque);
        jComboBoxAlimentoRemessa.removeAllItems();
        for(int i = 0; i < listaAlimento.size(); i++) {
            jComboBoxAlimentoRemessa.addItem(listaAlimento.get(i).getNome());
        }
        
    }
    
    public void carregaAlimentoDAO(int idEstoque) {
        DefaultTableModel model = (DefaultTableModel) jTableListaAlimento.getModel();
        AlimentoDAO dao = new AlimentoDAO();
        Remessa_has_AlimentoDAO daoRemessaAlimento = new Remessa_has_AlimentoDAO();
        listaAlimento = dao.getAllAlimentoEstoque(idEstoque);
        model.setRowCount(0);
        float recebido = 0,anterior = 0;
        for (int i = 0; i < listaAlimento.size(); i++) {
            ArrayList<Remessa_has_Alimento> lista =
                    daoRemessaAlimento.getListaRemessaAlimento(listaAlimento.get(i).getNome());
          /*  for (int j = 0; j < lista.size(); j++) {
                System.out.println("Lista: " + lista.get(j).getIdAlimento());
            }
            System.out.println(lista.size());
          */
            if(lista.size() > 0) {
                anterior = 0;
                for( int j = 0; j < lista.size() - 1; j++) {
                    anterior = anterior + lista.get(j).getRecebido();
                }
                recebido = lista.get(lista.size() - 1).getRecebido();
            } else {
                System.err.println("RemessaALimento = 0");
                recebido = 0;
            }
            model.addRow(new String[] {
                listaAlimento.get(i).getNome(),
                Float.toString(anterior), 
                Float.toString(recebido), 
                "0", 
                Float.toString(listaAlimento.get(i).getTotal())
            });
        }
    }
    
    public void tableRemessa(DefaultTableModel model, ArrayList<Remessa_has_Alimento> lista) {
        model.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new String[] {
                Integer.toString(i + 1),
                lista.get(i).getIdAlimento(),
                lista.get(i).getDateRemessa(),
                Float.toString(lista.get(i).getRecebido())
            });
        }
    }
    
    public void carregaRemessaTable(String idAlimento) {
        DefaultTableModel model = (DefaultTableModel) jTableRemessa.getModel();
        Remessa_has_AlimentoDAO dao = new Remessa_has_AlimentoDAO();
        ArrayList<Remessa_has_Alimento> lista = new ArrayList<Remessa_has_Alimento>();
        lista = dao.getListaRemessaAlimento(idAlimento);
        tableRemessa(model, lista);
        
        
    }
    
    public void limpaTableAlimento() {
        DefaultTableModel model = (DefaultTableModel) jTableListaAlimento.getModel();
        model.setRowCount(0);
    }
    
    public void limpaTableRemessa() {
        DefaultTableModel model = (DefaultTableModel) jTableRemessa.getModel();
        model.setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEscola = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jTabbedPaneAlimento = new javax.swing.JTabbedPane();
        jPanelEstoque = new javax.swing.JPanel();
        jLabelEstoque = new javax.swing.JLabel();
        jComboBoxEstoque = new javax.swing.JComboBox<>();
        jScrollPaneListaAlimento = new javax.swing.JScrollPane();
        jTableListaAlimento = new javax.swing.JTable();
        jButtonAdicionarAlimento = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonAdicionarRemessa = new javax.swing.JButton();
        jPanelRemessa = new javax.swing.JPanel();
        jComboBoxAlimentoRemessa = new javax.swing.JComboBox<>();
        jLabelAlimento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRemessa = new javax.swing.JTable();
        jPanelMapaMerenda = new javax.swing.JPanel();
        jButtonAdicionar = new javax.swing.JButton();
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
                    "Alimento", "Anterior", "Entrada", "Saida", "Saldo"
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

            jButtonAdicionarRemessa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
            jButtonAdicionarRemessa.setText("Adicionar Remessa");
            jButtonAdicionarRemessa.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonAdicionarRemessaActionPerformed(evt);
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
                            .addComponent(jButtonAdicionarAlimento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                            .addComponent(jButtonAdicionarRemessa)
                            .addGap(33, 33, 33)
                            .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPaneListaAlimento))
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
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAdicionarRemessa))
                    .addContainerGap())
            );

            jTabbedPaneAlimento.addTab("Estoque", jPanelEstoque);

            jComboBoxAlimentoRemessa.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    jComboBoxAlimentoRemessaItemStateChanged(evt);
                }
            });
            jComboBoxAlimentoRemessa.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBoxAlimentoRemessaActionPerformed(evt);
                }
            });

            jLabelAlimento.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
            jLabelAlimento.setText("Alimento:");

            jTableRemessa.setModel(new javax.swing.table.DefaultTableModel
                (
                    null,
                    new String [] {
                        "", "Alimento", "Data", "Valor"
                    }
                )
                {
                    @Override
                    public boolean isCellEditable(int rowIndex, int mColIndex) {
                        return false;
                    }
                });
                jScrollPane1.setViewportView(jTableRemessa);

                javax.swing.GroupLayout jPanelRemessaLayout = new javax.swing.GroupLayout(jPanelRemessa);
                jPanelRemessa.setLayout(jPanelRemessaLayout);
                jPanelRemessaLayout.setHorizontalGroup(
                    jPanelRemessaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRemessaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelRemessaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanelRemessaLayout.createSequentialGroup()
                                .addComponent(jLabelAlimento)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxAlimentoRemessa, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                );
                jPanelRemessaLayout.setVerticalGroup(
                    jPanelRemessaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRemessaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelRemessaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxAlimentoRemessa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAlimento))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addContainerGap())
                );

                jTabbedPaneAlimento.addTab("Remessa", jPanelRemessa);

                jButtonAdicionar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
                jButtonAdicionar.setText("Adicionar");
                jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButtonAdicionarActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanelMapaMerendaLayout = new javax.swing.GroupLayout(jPanelMapaMerenda);
                jPanelMapaMerenda.setLayout(jPanelMapaMerendaLayout);
                jPanelMapaMerendaLayout.setHorizontalGroup(
                    jPanelMapaMerendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMapaMerendaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAdicionar)
                        .addContainerGap(411, Short.MAX_VALUE))
                );
                jPanelMapaMerendaLayout.setVerticalGroup(
                    jPanelMapaMerendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMapaMerendaLayout.createSequentialGroup()
                        .addContainerGap(236, Short.MAX_VALUE)
                        .addComponent(jButtonAdicionar)
                        .addContainerGap())
                );

                jTabbedPaneAlimento.addTab("Mapa da Merenda", jPanelMapaMerenda);

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
                            .addComponent(jTabbedPaneAlimento)
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
                        .addGap(30, 30, 30)
                        .addComponent(jButtonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPaneAlimento)
                        .addContainerGap())
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBoxEscolaActionPerformed

    private void jComboBoxEscolaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEscolaItemStateChanged
        // TODO add your handling code here:
        if(listaEscola.get(jComboBoxEscola.getSelectedIndex()) != null)
        carregaEstoqueDAO(listaEscola.get(jComboBoxEscola.getSelectedIndex()).getIdEscola());
    
    }//GEN-LAST:event_jComboBoxEscolaItemStateChanged

    private void jButtonAdicionarRemessaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarRemessaActionPerformed
        TelaNovoAlimento novoAlimento = new TelaNovoAlimento(this,true);
        novoAlimento.setVisible(true);
    }//GEN-LAST:event_jButtonAdicionarRemessaActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        AlimentoDAO daoAlimento = new AlimentoDAO();
        RemessaDAO daoRemessa = new RemessaDAO();
        int linhaSelecionada = jTableListaAlimento.getSelectedRow();
        String nomeAlimento = listaAlimento.get(linhaSelecionada).getNome();
        alimento = null;
        daoAlimento.removeAlimento(nomeAlimento);
        carregaAlimentoDAO(listaEstoque.get(jComboBoxEstoque.getSelectedIndex()).getIdEstoque());

        if(jTableListaAlimento.getRowCount() == 0) {
            disableButton();
        } else {
            System.out.println(linhaSelecionada);
            if(linhaSelecionada > 0) {
                jTableListaAlimento.setRowSelectionInterval(linhaSelecionada - 1, linhaSelecionada - 1);
                alimento = listaAlimento.get(linhaSelecionada - 1);
            } else {
                jTableListaAlimento.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);
                alimento = listaAlimento.get(linhaSelecionada);
            }
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonAdicionarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarAlimentoActionPerformed
        alimento = null;
        disableButton();
        if(jTableListaAlimento.getRowCount() != 0) {
            jTableListaAlimento.removeRowSelectionInterval(0, jTableListaAlimento.getRowCount() - 1);
        }
        TelaNovoAlimento novoAlimento = new TelaNovoAlimento(this,true);
        novoAlimento.setVisible(true);
    }//GEN-LAST:event_jButtonAdicionarAlimentoActionPerformed

    private void jTableListaAlimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaAlimentoMouseClicked
        int selectedIndex = jTableListaAlimento.getSelectedRow();
        jButtonRemover.setEnabled(true);
        jButtonAdicionarRemessa.setEnabled(true);
        alimento = listaAlimento.get(selectedIndex);
        System.out.println("Alimento = " + alimento.getNome());
        jComboBoxAlimentoRemessa.setSelectedIndex(selectedIndex);
    }//GEN-LAST:event_jTableListaAlimentoMouseClicked

    private void jComboBoxEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstoqueActionPerformed

    private void jComboBoxEstoqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEstoqueItemStateChanged
        if(jComboBoxEstoque.getSelectedIndex() != -1) {
            int idEstoque = listaEstoque.get(jComboBoxEstoque.getSelectedIndex()).getIdEstoque();
            carregaAlimentoDAO(idEstoque);
            carregaAlimentoComboBox(idEstoque);
        } else {
            limpaTableAlimento();
        }
    }//GEN-LAST:event_jComboBoxEstoqueItemStateChanged

    private void jComboBoxAlimentoRemessaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlimentoRemessaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAlimentoRemessaActionPerformed

    private void jComboBoxAlimentoRemessaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAlimentoRemessaItemStateChanged
        int linhaSelecionada = jComboBoxAlimentoRemessa.getSelectedIndex();
        if(linhaSelecionada >= 0) {
            String idAlimento = jComboBoxAlimentoRemessa.getSelectedItem().toString();
            carregaRemessaTable(idAlimento);
            if(linhaSelecionada >= 0) {
                jTableListaAlimento.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);
            }
        } else {
            limpaTableRemessa();
        }
    }//GEN-LAST:event_jComboBoxAlimentoRemessaItemStateChanged

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        TelaNovoMapaMerenda novoMapaMerenda = new TelaNovoMapaMerenda(this, rootPaneCheckingEnabled);
        novoMapaMerenda.setVisible(true);
                
    }//GEN-LAST:event_jButtonAdicionarActionPerformed
    
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
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAdicionarAlimento;
    private javax.swing.JButton jButtonAdicionarRemessa;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JComboBox<String> jComboBoxAlimentoRemessa;
    private javax.swing.JComboBox<String> jComboBoxEscola;
    private javax.swing.JComboBox<String> jComboBoxEstoque;
    private javax.swing.JLabel jLabelAlimento;
    private javax.swing.JLabel jLabelEscola;
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JPanel jPanelEstoque;
    private javax.swing.JPanel jPanelMapaMerenda;
    private javax.swing.JPanel jPanelRemessa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneListaAlimento;
    private javax.swing.JTabbedPane jTabbedPaneAlimento;
    private javax.swing.JTable jTableListaAlimento;
    private javax.swing.JTable jTableRemessa;
    // End of variables declaration//GEN-END:variables

    
}
