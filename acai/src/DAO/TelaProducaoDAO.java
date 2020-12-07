/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.Atualizador;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduar
 */
public class TelaProducaoDAO {
    
    public  TelaProducaoDAO(){
    
    }
    
    public void showPedidos(DefaultTableModel Modelo){
        try {
            String SQLPesquisa = "select * from pedidos order by codigo_pedido desc limit 10 ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLPesquisa);
           
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object [] {rs.getString("codigo_pedido"),Atualizador.ConverteJ(rs.getString("data_pedido")), rs.getString("hora_pedido"), rs.getString("pedido_status")});
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao pesquisar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    
    }
}
