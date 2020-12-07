/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.ClienteCON;
import Controller.PedidoCON;
import Entidades.Cliente;
import Entidades.Pedido;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author eduar
 */
public class TelaPedido extends javax.swing.JInternalFrame {

    Cliente entid_cliente;
    Pedido entid_pedido;
    ClienteCON con_cliente;
    PedidoCON con_pedido;
    
    List<String>Lista;
    List<String>ListadeItens;
    DefaultTableModel Modelo;
    DecimalFormat formato_decimal;
    int CodigoFuncionario;
    Date DataAtual;
    SimpleDateFormat formatoData,formatoHora;
    
    MaskFormatter formato_personalizado;
    
    
    public TelaPedido(int CodigoFuncionario) {
        initComponents();
        habilitarCampos(false);
        
        Lista = new ArrayList<>();
        ListadeItens = new ArrayList<>();
        
        entid_cliente = new Cliente();
        con_cliente = new ClienteCON();
        entid_pedido = new Pedido();
        con_pedido = new PedidoCON();
        
        painel_cliente.setEnabledAt(1, false);
        Modelo = (DefaultTableModel)tabela.getModel();
    
        formato_decimal = new DecimalFormat("0.00");
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
        this.CodigoFuncionario = CodigoFuncionario;
    
        formatoData = new SimpleDateFormat("yyyy-MM-dd");
        formatoHora = new SimpleDateFormat("HH:mm:ss");
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_cliente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        painel_p1 = new javax.swing.JPanel();
        btn_pesquisar1 = new javax.swing.JButton();
        cb_clientes1 = new javax.swing.JComboBox<>();
        Jlabel_nome1 = new javax.swing.JLabel();
        txt_nome1 = new javax.swing.JTextField();
        Jlabel_cod1 = new javax.swing.JLabel();
        txt_cod1 = new javax.swing.JTextField();
        Jlabel_rua1 = new javax.swing.JLabel();
        txt_rua1 = new javax.swing.JTextField();
        Jlabel_bairro1 = new javax.swing.JLabel();
        txt_bai1 = new javax.swing.JTextField();
        Jlabel_tel1 = new javax.swing.JLabel();
        try 
        {
            formato_personalizado = new MaskFormatter("(##) #####-####");

        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Error ao criar máscara","Error",0);

        }
        txt_tel1 = new JFormattedTextField(formato_personalizado);
        Jlabel_data1 = new javax.swing.JLabel();
        txt_data1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        painel_p = new javax.swing.JPanel();
        txt_nomecliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_item = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cb_itens = new javax.swing.JComboBox<>();
        btn_valor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_codigopedido = new javax.swing.JTextField();
        btn_remove = new javax.swing.JButton();
        btn_add1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_calcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btn_finalizar = new javax.swing.JButton();
        btn_fecharpedido = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pedidos");

        btn_pesquisar1.setText("Pesquisar");
        btn_pesquisar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisar1ActionPerformed(evt);
            }
        });

        cb_clientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clientes1ActionPerformed(evt);
            }
        });

        Jlabel_nome1.setText("Nome");

        Jlabel_cod1.setText("Código");

        txt_cod1.setEditable(false);
        txt_cod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod1ActionPerformed(evt);
            }
        });

        Jlabel_rua1.setText("Rua");

        Jlabel_bairro1.setText("Bairro");

        Jlabel_tel1.setText("Telefone");

        txt_tel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tel1ActionPerformed(evt);
            }
        });

        Jlabel_data1.setText("Data");

        txt_data1.setEditable(false);

        jButton3.setText("Pedido");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Fechar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_p1Layout = new javax.swing.GroupLayout(painel_p1);
        painel_p1.setLayout(painel_p1Layout);
        painel_p1Layout.setHorizontalGroup(
            painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_p1Layout.createSequentialGroup()
                .addComponent(btn_pesquisar1)
                .addGap(18, 18, 18)
                .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_p1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addComponent(cb_clientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painel_p1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painel_p1Layout.createSequentialGroup()
                            .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Jlabel_cod1)
                                .addComponent(Jlabel_nome1)
                                .addComponent(Jlabel_rua1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(painel_p1Layout.createSequentialGroup()
                                    .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painel_p1Layout.createSequentialGroup()
                                            .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_rua1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_tel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Jlabel_data1)
                                                .addComponent(Jlabel_bairro1)))
                                        .addComponent(txt_cod1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_data1)
                                        .addComponent(txt_bai1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))))
                        .addGroup(painel_p1Layout.createSequentialGroup()
                            .addComponent(Jlabel_tel1)
                            .addGap(353, 353, 353)))
                    .addContainerGap()))
        );
        painel_p1Layout.setVerticalGroup(
            painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_p1Layout.createSequentialGroup()
                .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pesquisar1)
                    .addComponent(cb_clientes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
            .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painel_p1Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jlabel_nome1)
                        .addComponent(txt_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jlabel_cod1)
                        .addComponent(txt_cod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jlabel_rua1)
                        .addComponent(txt_rua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Jlabel_bairro1)
                        .addComponent(txt_bai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(painel_p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jlabel_tel1)
                        .addComponent(Jlabel_data1)
                        .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_data1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(74, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(painel_p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        painel_cliente.addTab("Cliente", jPanel1);

        txt_nomecliente.setEditable(false);
        txt_nomecliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("Item");

        txt_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_itemActionPerformed(evt);
            }
        });
        txt_item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_itemKeyReleased(evt);
            }
        });

        jLabel2.setText("Selecionar");

        cb_itens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_itens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_itensActionPerformed(evt);
            }
        });

        btn_valor.setText("Valor");
        btn_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_valorActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor");

        txt_valor.setEditable(false);

        jLabel4.setText("Quantidade");

        txt_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantidadeFocusLost(evt);
            }
        });

        jLabel5.setText("Código");

        txt_codigopedido.setEditable(false);

        btn_remove.setText("-");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_add1.setText("+");
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Total");

        btn_calcular.setText("Calcular");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Valor", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        btn_finalizar.setText("Finalizar");
        btn_finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarActionPerformed(evt);
            }
        });

        btn_fecharpedido.setText("Fechar");
        btn_fecharpedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_fecharpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fecharpedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_pLayout = new javax.swing.GroupLayout(painel_p);
        painel_p.setLayout(painel_pLayout);
        painel_pLayout.setHorizontalGroup(
            painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_pLayout.createSequentialGroup()
                .addGroup(painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nomecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_pLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_item, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cb_itens, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_pLayout.createSequentialGroup()
                        .addComponent(btn_valor)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigopedido, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(painel_pLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_pLayout.createSequentialGroup()
                        .addComponent(btn_add1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_remove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_calcular)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_pLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_pLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_finalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_fecharpedido)
                .addGap(72, 72, 72))
        );
        painel_pLayout.setVerticalGroup(
            painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_pLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nomecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cb_itens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_valor)
                    .addComponent(jLabel3)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigopedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_remove)
                        .addComponent(jLabel8)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_add1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(painel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_finalizar)
                    .addComponent(btn_fecharpedido))
                .addContainerGap())
        );

        painel_cliente.addTab("Pedidos", painel_p);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_cliente)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel_cliente)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod1ActionPerformed

    private void txt_tel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_pesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisar1ActionPerformed
        cb_clientes1.removeAllItems();
        Lista.clear();
        String Pesquisa = JOptionPane.showInputDialog(null,"Digite o nome do cliente","Pesquisar",3);
        con_cliente.controlePesquisa(Pesquisa, Lista);
        
        for(String i: Lista){
            cb_clientes1.addItem(i);
        }
    }//GEN-LAST:event_btn_pesquisar1ActionPerformed

    private void cb_clientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clientes1ActionPerformed
        if(!(cb_clientes1.getSelectedItem() == null)){
            String cod = cb_clientes1.getSelectedItem().toString();
            cod = cod.substring(0,cod.indexOf(" "));
            entid_cliente = con_cliente.controlePreencher(Integer.parseInt(cod));
            txt_cod1.setText(entid_cliente.getCodigo() + "");
            txt_data1.setText(entid_cliente.getData());
            txt_tel1.setText(entid_cliente.getTelefone());
            txt_rua1.setText(entid_cliente.getRua());
            txt_bai1.setText(entid_cliente.getBairro());
            txt_nome1.setText(entid_cliente.getNome());
            txt_cod1.setText(entid_cliente.getCodigo() + "");
        }
    }//GEN-LAST:event_cb_clientes1ActionPerformed

    private void btn_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarActionPerformed
        addEntidade();
        con_pedido.controlePedido(txt_cod1.getText(), CodigoFuncionario + "", txt_total.getText(),tabela.getRowCount(),entid_pedido);
        limparFinalizar();
    }//GEN-LAST:event_btn_finalizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        painel_cliente.setEnabledAt(1, true);
        painel_cliente.setEnabledAt(0, false);
        painel_cliente.setSelectedIndex(1);
        txt_nomecliente.setText(txt_nome1.getText());
        btn_finalizar.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_itemActionPerformed
        
    }//GEN-LAST:event_txt_itemActionPerformed

    private void btn_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_valorActionPerformed
        txt_valor.setText(con_pedido.controleValor(cb_itens.getSelectedItem().toString()) + "");
        txt_codigopedido.setText(con_pedido.controleCodigo(cb_itens.getSelectedItem().toString()) + "");
    }//GEN-LAST:event_btn_valorActionPerformed

    private void txt_itemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemKeyReleased
        txt_valor.setText("");
        cb_itens.removeAllItems();
        ListadeItens.clear();
        con_pedido.controledeItens(txt_item.getText(), ListadeItens);
        for(String i: ListadeItens){
            cb_itens.addItem(i);
        }
    }//GEN-LAST:event_txt_itemKeyReleased

    private void cb_itensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_itensActionPerformed
        txt_valor.setText("");
        txt_quantidade.setText("1");
    }//GEN-LAST:event_cb_itensActionPerformed

    private void txt_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusLost
        
    }//GEN-LAST:event_txt_quantidadeFocusLost

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        if(con_pedido.verificaItens(txt_valor.getText(),txt_quantidade.getText(), txt_codigopedido.getText(),cb_itens.getSelectedItem().toString())){
            double Total = Double.parseDouble(txt_valor.getText()) * Integer.parseInt(txt_quantidade.getText());
            Modelo.addRow(new Object []{txt_codigopedido.getText(),cb_itens.getSelectedItem(),txt_valor.getText(),txt_quantidade.getText(),Total});
            limparItens();
            calcularTotal();
        }
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void btn_fecharpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fecharpedidoActionPerformed
        dispose();
    }//GEN-LAST:event_btn_fecharpedidoActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        Modelo.removeRow(tabela.getSelectedRow());
        calcularTotal();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        
        calcularTotal();
        
    }//GEN-LAST:event_btn_calcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel_bairro1;
    private javax.swing.JLabel Jlabel_cod1;
    private javax.swing.JLabel Jlabel_data1;
    private javax.swing.JLabel Jlabel_nome1;
    private javax.swing.JLabel Jlabel_rua1;
    private javax.swing.JLabel Jlabel_tel1;
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_fecharpedido;
    private javax.swing.JButton btn_finalizar;
    private javax.swing.JButton btn_pesquisar1;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_valor;
    private javax.swing.JComboBox<String> cb_clientes1;
    private javax.swing.JComboBox<String> cb_itens;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane painel_cliente;
    private javax.swing.JPanel painel_p;
    private javax.swing.JPanel painel_p1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_bai1;
    private javax.swing.JTextField txt_cod1;
    private javax.swing.JTextField txt_codigopedido;
    private javax.swing.JTextField txt_data1;
    private javax.swing.JTextField txt_item;
    private javax.swing.JTextField txt_nome1;
    private javax.swing.JTextField txt_nomecliente;
    public static javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_rua1;
    private javax.swing.JTextField txt_tel1;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables


 final void habilitarCampos(boolean valor) {
    txt_rua1.setEnabled(valor);
    txt_bai1.setEnabled(valor);
    txt_tel1.setEnabled(valor);
    txt_data1.setEnabled(valor);
    txt_nome1.setEnabled(valor);

    }
 
 final void limparItens(){
     txt_item.setText("");
     txt_quantidade.setText("1");
     txt_valor.setText("0");
     cb_itens.removeAllItems();
     
 }  
 
 final void calcularTotal(){
     double PedidoTotal = 0;
         for(int i = 0; i < tabela.getRowCount(); i++){
             PedidoTotal += Double.parseDouble(Modelo.getValueAt(i,4).toString());
             
         }
         if(PedidoTotal > 0){
             btn_finalizar.setEnabled(true);
         }
         txt_total.setText(formato_decimal.format(PedidoTotal).replace('.',','));
     
 }

 
 final void addEntidade(){
     DataAtual = new Date();
     entid_pedido.setCodigoCliente(Integer.parseInt(txt_cod1.getText()));
     entid_pedido.setCodigoFuncionario(CodigoFuncionario);
     entid_pedido.setCodigoEntregador(1);
     entid_pedido.setData(formatoData.format(DataAtual));
     entid_pedido.setData(formatoHora.format(DataAtual));
     entid_pedido.setStatus("Pedido Aberto");
     entid_pedido.setValor(Double.parseDouble(txt_total.getText().replace(',','.')));
     
     for(int  i = 0; i < tabela.getRowCount(); i++){
         entid_pedido.setCodCardapio(Integer.parseInt(Modelo.getValueAt(i, 0).toString()));
         entid_pedido.setQuantidade(Integer.parseInt(Modelo.getValueAt(i, 3).toString()));
    }
 }
 
 final void limparFinalizar(){
    txt_total.setText("");
    txt_codigopedido.setText("");
    btn_finalizar.setEnabled(false);
    Modelo.setNumRows(0);
 }





}
