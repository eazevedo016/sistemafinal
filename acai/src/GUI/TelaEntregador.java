
package GUI;


import Controller.ClienteCON;
import Controller.EntregadorCON;
import Controller.FuncionarioCON;
import Entidades.Cliente;
import Entidades.Entregador;
import Entidades.Funcionario;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author eduar
 */
public class TelaEntregador extends javax.swing.JInternalFrame {
    
    MaskFormatter formato_personalizado;
    SimpleDateFormat FormatoData;
    Date data;
    Entregador entid_entregador;
    EntregadorCON con_entregador;
    DefaultTableModel Modelo;
    
   
    public TelaEntregador() {
        initComponents();
        txt_cod.setEnabled(false);
        habilitarCampos(false);
        
        
        FormatoData = new SimpleDateFormat("dd/MM/yyyy");
        
        
        con_entregador = new EntregadorCON();
        entid_entregador = new Entregador();
        Modelo = (DefaultTableModel)table_cli.getModel();
        Modelo.addRow(new Object[]{"Nome",1,"Rua Y","Bairro X","16464"});
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jlabel_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        Jlabel_cod = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        Jlabel_data = new javax.swing.JLabel();
        txt_data = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Jlabel_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_cli = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        btn_novo = new javax.swing.JButton();
        btn_cadastrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Entregadores");

        Jlabel_nome.setText("Nome");

        Jlabel_cod.setText("Código");

        txt_cod.setEditable(false);
        txt_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codActionPerformed(evt);
            }
        });

        Jlabel_data.setText("Data");

        txt_data.setEditable(false);

        Jlabel_buscar.setText("Buscar");

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        table_cli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Código", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_cli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cliMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_cliMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_cli);

        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.setMaximumSize(new java.awt.Dimension(50, 23));
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(Jlabel_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_novo)
                    .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 393, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jlabel_cod)
                            .addComponent(Jlabel_nome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jlabel_data)
                        .addGap(18, 18, 18)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlabel_nome)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlabel_cod)
                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jlabel_data))
                .addGap(59, 59, 59)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlabel_buscar)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_novo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        setBounds(0, 0, 500, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        data = new Date();
        txt_data.setText(FormatoData.format(data));
        habilitarCampos(true);
        con_entregador.controleCodigo();
        txt_cod.setText(con_entregador.controleCodigo());
        
    }//GEN-LAST:event_btn_novoActionPerformed

    private void txt_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        valores_funcionario();
        con_entregador.verificador(entid_entregador);
        LimpaCampos();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        Modelo.setNumRows(0);
        con_entregador.controlePesquisa(txt_buscar.getText(), Modelo);
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void table_cliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cliMouseClicked
        
    }//GEN-LAST:event_table_cliMouseClicked

    private void table_cliMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cliMousePressed
        habilitarCampos(true);
        entid_entregador = con_entregador.controlePreencher(Integer.parseInt(Modelo.getValueAt(table_cli.getSelectedRow(),0).toString()));
        
        txt_nome.setText(entid_entregador.getNome());
        txt_cod.setText(entid_entregador.getCodigo() + "");
       
        txt_data.setText(entid_entregador.getData());
    }//GEN-LAST:event_table_cliMousePressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel_buscar;
    private javax.swing.JLabel Jlabel_cod;
    private javax.swing.JLabel Jlabel_data;
    private javax.swing.JLabel Jlabel_nome;
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable table_cli;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables

    
    
final void habilitarCampos(boolean valor){
   txt_data.setEnabled(valor);
   txt_nome.setEnabled(valor);
   
}

final void valores_funcionario(){
    
    
    entid_entregador.setNome(txt_nome.getText());
    entid_entregador.setData(txt_data.getText());
   
}

final void LimpaCampos(){
    txt_cod.setText("");
    txt_data.setText("");
    txt_nome.setText("");
    ;
    
  
    
    
}
}






