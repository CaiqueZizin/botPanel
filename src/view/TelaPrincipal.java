/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import controller.TelaPrincipalController;
import java.awt.Toolkit;
import personalizado.meuDefaultTableModel;

/**
 *
 * @author Caique
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        TelaPrincipalController.buscarDados();
        TelaPrincipalController.mostrarVersaoPrograma();
        setIconeTela();
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtFuncoes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btAdicionar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btPlay = new javax.swing.JButton();
        lblVersaoDoPrograma = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        TelaPrincipalController.dados = new meuDefaultTableModel(TelaPrincipalController.colunas, 0);
        jtFuncoes.setModel(TelaPrincipalController.dados);
        jtFuncoes.getTableHeader().setReorderingAllowed(false);
        jtFuncoes.getTableHeader().setResizingAllowed(false);
        jtFuncoes.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtFuncoes.getColumnModel().getColumn(1).setPreferredWidth(250);
        jScrollPane2.setViewportView(jtFuncoes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacoteicones2/add(1).png"))); // NOI18N
        btAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAdicionarMouseExited(evt);
            }
        });
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pacoteicones2/delete.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btPlay.setText("PLAY");
        btPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btPlayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPlayMouseExited(evt);
            }
        });
        btPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlayActionPerformed(evt);
            }
        });

        lblVersaoDoPrograma.setFont(new java.awt.Font("Book Antiqua", 1, 10)); // NOI18N
        lblVersaoDoPrograma.setForeground(java.awt.Color.white);
        lblVersaoDoPrograma.setText("lbl Versao do Programa");
        lblVersaoDoPrograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVersaoDoProgramaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVersaoDoProgramaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVersaoDoProgramaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btPlay)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblVersaoDoPrograma))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(lblVersaoDoPrograma))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAdicionarMouseEntered
        TelaPrincipalController.mostrarPopUp("Adicionar Função", evt, btAdicionar);
    }//GEN-LAST:event_btAdicionarMouseEntered

    private void btAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAdicionarMouseExited
        TelaPrincipalController.ocultarPopUp();
    }//GEN-LAST:event_btAdicionarMouseExited

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
       TelaPrincipalController.pegarArquivo();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        TelaPrincipalController.mostrarPopUp("Remover função", evt, jButton2);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
       TelaPrincipalController.ocultarPopUp();
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaPrincipalController.deletarFuncao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlayActionPerformed
        TelaPrincipalController.executarFuncao();
    }//GEN-LAST:event_btPlayActionPerformed

    private void btPlayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPlayMouseEntered
        TelaPrincipalController.mostrarPopUp("Executar Função", evt, btPlay);
    }//GEN-LAST:event_btPlayMouseEntered

    private void btPlayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPlayMouseExited
        TelaPrincipalController.ocultarPopUp();
    }//GEN-LAST:event_btPlayMouseExited

    private void lblVersaoDoProgramaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVersaoDoProgramaMouseEntered
        lblVersaoDoPrograma.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblVersaoDoProgramaMouseEntered

    private void lblVersaoDoProgramaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVersaoDoProgramaMouseExited
        lblVersaoDoPrograma.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblVersaoDoProgramaMouseExited

    private void lblVersaoDoProgramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVersaoDoProgramaMouseClicked
        TelaPrincipalController.mostrarMsgVersao();
    }//GEN-LAST:event_lblVersaoDoProgramaMouseClicked

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }            
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btPlay;
    private javax.swing.JButton jButton2;
    public static javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jtFuncoes;
    public static javax.swing.JLabel lblVersaoDoPrograma;
    // End of variables declaration//GEN-END:variables

    
    private void setIconeTela() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Pacoteicones2/bot.png")));
    }
    
}