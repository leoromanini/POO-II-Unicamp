/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_servico.view;

import ordem_servico.controller.OsController;
import ordem_servico.model.Item;

/**
 *
 * @author matheus
 */
public class OsView extends javax.swing.JFrame {
    OsController osController;
    
    public javax.swing.JComboBox<Item<String>> getListResponsavel() {
        return listResponsavel;
    }

    public void setListResponsavel(javax.swing.JComboBox<Item<String>> listResponsavel) {
        this.listResponsavel = listResponsavel;
    }

        
    public javax.swing.JButton getBtnFinalizar() {
        return btnFinalizar;
    }

    public void setBtnFinalizar(javax.swing.JButton btnFinalizar) {
        this.btnFinalizar = btnFinalizar;
    }

    public javax.swing.JButton getBtnHistorico() {
        return btnHistorico;
    }

    public void setBtnHistorico(javax.swing.JButton btnHistorico) {
        this.btnHistorico = btnHistorico;
    }

    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public javax.swing.JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(javax.swing.JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public javax.swing.JLabel getLabelMaoObra() {
        return labelMaoObra;
    }

    public void setLabelMaoObra(javax.swing.JLabel labelMaoObra) {
        this.labelMaoObra = labelMaoObra;
    }

    public javax.swing.JLabel getLabelReclamacao() {
        return labelReclamacao;
    }

    public void setLabelReclamacao(javax.swing.JLabel labelReclamacao) {
        this.labelReclamacao = labelReclamacao;
    }

    public javax.swing.JLabel getLbAbertura() {
        return lbAbertura;
    }

    public void setLbAbertura(javax.swing.JLabel lbAbertura) {
        this.lbAbertura = lbAbertura;
    }

    public javax.swing.JLabel getLbCliente() {
        return lbCliente;
    }

    public void setLbCliente(javax.swing.JLabel lbCliente) {
        this.lbCliente = lbCliente;
    }

    public javax.swing.JLabel getLbFinalizado() {
        return lbFinalizado;
    }

    public void setLbFinalizado(javax.swing.JLabel lbFinalizado) {
        this.lbFinalizado = lbFinalizado;
    }

    public javax.swing.JLabel getLbGit() {
        return lbGit;
    }

    public void setLbGit(javax.swing.JLabel lbGit) {
        this.lbGit = lbGit;
    }

    public javax.swing.JLabel getLbMaoObra() {
        return lbMaoObra;
    }

    public void setLbMaoObra(javax.swing.JLabel lbMaoObra) {
        this.lbMaoObra = lbMaoObra;
    }

    public javax.swing.JLabel getLbPrazo() {
        return lbPrazo;
    }

    public void setLbPrazo(javax.swing.JLabel lbPrazo) {
        this.lbPrazo = lbPrazo;
    }

    public javax.swing.JLabel getLbReclamacao() {
        return lbReclamacao;
    }

    public void setLbReclamacao(javax.swing.JLabel lbReclamacao) {
        this.lbReclamacao = lbReclamacao;
    }

    public javax.swing.JLabel getLbResponsavel() {
        return lbResponsavel;
    }

    public void setLbResponsavel(javax.swing.JLabel lbResponsavel) {
        this.lbResponsavel = lbResponsavel;
    }

    public javax.swing.JLabel getLbServico() {
        return lbServico;
    }

    public void setLbServico(javax.swing.JLabel lbServico) {
        this.lbServico = lbServico;
    }

    public javax.swing.JLabel getLbTipo() {
        return lbTipo;
    }

    public void setLbTipo(javax.swing.JLabel lbTipo) {
        this.lbTipo = lbTipo;
    }

    public javax.swing.JLabel getLbTitulo() {
        return lbTitulo;
    }

    public void setLbTitulo(javax.swing.JLabel lbTitulo) {
        this.lbTitulo = lbTitulo;
    }

    public javax.swing.JLabel getLbTotal() {
        return lbTotal;
    }

    public void setLbTotal(javax.swing.JLabel lbTotal) {
        this.lbTotal = lbTotal;
    }

    public javax.swing.JPanel getPanelDetalhes() {
        return panelDetalhes;
    }

    public void setPanelDetalhes(javax.swing.JPanel panelDetalhes) {
        this.panelDetalhes = panelDetalhes;
    }

    public javax.swing.JTable getTabelaOs() {
        return tabelaOs;
    }

    public void setTabelaOs(javax.swing.JTable tabelaOs) {
        this.tabelaOs = tabelaOs;
    }

    /**
     * Creates new form OsView
     */
    public OsView() {
        initComponents();
        osController = new OsController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDetalhes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbAbertura = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbPrazo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbFinalizado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbServico = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        lbResponsavel = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        labelReclamacao = new javax.swing.JLabel();
        lbReclamacao = new javax.swing.JLabel();
        labelMaoObra = new javax.swing.JLabel();
        lbMaoObra = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbGit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        listResponsavel = new javax.swing.JComboBox<>();
        btnHistorico = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaOs = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Titulo: ");

        jLabel4.setText("Abertura:");

        jLabel6.setText("Prazo:");

        jLabel8.setText("Finalizado:");

        jLabel10.setText("Serviço:");

        jLabel12.setText("Total:");

        jLabel25.setText("Tipo:");

        jLabel26.setText("Responsavel:");

        jLabel27.setText("Cliente:");

        labelReclamacao.setText("Reclamação:");

        labelMaoObra.setText("Mão de Obra:");

        jLabel17.setText("Git:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atualizar"));

        jLabel2.setText("Responsavel:");

        btnFinalizar.setBackground(new java.awt.Color(51, 204, 0));
        btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listResponsavel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(listResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(jButton1))
                .addGap(26, 26, 26))
        );

        btnHistorico.setText("Histórico");
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetalhesLayout = new javax.swing.GroupLayout(panelDetalhes);
        panelDetalhes.setLayout(panelDetalhesLayout);
        panelDetalhesLayout.setHorizontalGroup(
            panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(lbResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(lbCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(lbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(lbServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lbFinalizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lbPrazo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lbAbertura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                                        .addComponent(labelReclamacao)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbReclamacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                                        .addComponent(labelMaoObra)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbMaoObra, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbGit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDetalhesLayout.setVerticalGroup(
            panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelReclamacao)
                                        .addComponent(lbReclamacao, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lbAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelMaoObra)
                                .addComponent(lbMaoObra, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(lbGit, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbFinalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(lbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(lbResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(lbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHistorico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaOs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Responsavel", "Finalizado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaOsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaOs);
        if (tabelaOs.getColumnModel().getColumnCount() > 0) {
            tabelaOs.getColumnModel().getColumn(0).setMinWidth(80);
            tabelaOs.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabelaOs.getColumnModel().getColumn(0).setMaxWidth(80);
            tabelaOs.getColumnModel().getColumn(1).setMinWidth(320);
            tabelaOs.getColumnModel().getColumn(1).setPreferredWidth(320);
            tabelaOs.getColumnModel().getColumn(1).setMaxWidth(320);
            tabelaOs.getColumnModel().getColumn(2).setMinWidth(250);
            tabelaOs.getColumnModel().getColumn(2).setPreferredWidth(250);
            tabelaOs.getColumnModel().getColumn(2).setMaxWidth(250);
        }

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ordem_servico/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(panelDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        osController.btnAtualizar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaOsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaOsMouseClicked
        osController.tableClienteClick(evt);
    }//GEN-LAST:event_tabelaOsMouseClicked

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        osController.btnFinalizar();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        osController.btnHistoricoClick();
    }//GEN-LAST:event_btnHistoricoActionPerformed

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
            java.util.logging.Logger.getLogger(OsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelMaoObra;
    private javax.swing.JLabel labelReclamacao;
    private javax.swing.JLabel lbAbertura;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbFinalizado;
    private javax.swing.JLabel lbGit;
    private javax.swing.JLabel lbMaoObra;
    private javax.swing.JLabel lbPrazo;
    private javax.swing.JLabel lbReclamacao;
    private javax.swing.JLabel lbResponsavel;
    private javax.swing.JLabel lbServico;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JComboBox<Item<String>> listResponsavel;
    private javax.swing.JPanel panelDetalhes;
    private javax.swing.JTable tabelaOs;
    // End of variables declaration//GEN-END:variables
}
