/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Funcionario;
import Entidades.Cardapio;
import Util.Atualizador;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduar
 */
public class CardapioDAO 
{
    
    public CardapioDAO()
    {
        
    }
    
    public void cadastrarCardapio(Cardapio cardapio_aux)
    {
        try {
            String SQLInsertion = "insert into cardapio(descricao_cardapio, valor_cardapio, tipo_cardapio,acompanhamento_cardapio,tamanho_cardapio) values(?,?,?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cardapio_aux.getDescricao());
            st.setDouble(2, cardapio_aux.getValor());
            st.setString(3, cardapio_aux.getTipo());
            st.setString(4, cardapio_aux.getAcompanhamento());
            st.setString(5, cardapio_aux.getTamanho());
                
            
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro concluído","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }        
    public String proxCardapio(){
        String SQLSelection = "select * from cardapio order by codigo_cardapio desc limit 1";
        try {
            
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return (Integer.parseInt(rs.getString("codigo_cardapio")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar registro","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return "0";
        }
    }
    public void buscarCardapio(String Pesquisa, DefaultTableModel Modelo){
        
        try {
            String SQLSelection = "select * from cardapio where descricao_cardapio like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object [] {rs.getString("codigo_cardapio"), rs.getString("descricao_cardapio"),rs.getString("valor_cardapio"),rs.getString("tipo_cardapio"),rs.getString("acompanhamento_cardapio"),rs.getString("tamanho_cardapio")});
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }   
    }
    
    public Cardapio preencherCampos(int Codigo)
    {
        Cardapio cardapio_aux = new Cardapio();
        try {
            String SQLSelection = "select * from cardapio where codigo_cardapio = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1,Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               cardapio_aux.setCodigo(rs.getInt("codigo_cardapio"));
               cardapio_aux.setDescricao(rs.getString("descricao_cardapio"));
               cardapio_aux.setValor(rs.getDouble("valor_cardapio"));
               cardapio_aux.setTipo(rs.getString("tipo_cardapio"));
               cardapio_aux.setAcompanhamento(rs.getString("acompanhamento_cardapio"));
               cardapio_aux.setTamanho(rs.getString("tamanho_cardapio"));
               
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
        
        return cardapio_aux;
    }
    
    public void editarCardapio(Cardapio cardapio_aux){
        try {
            String SQLInsertion = "update  cardapio set descricao_cardapio = ?, valor_cardapio = ?, tipo_cardapio = ?, acompanhamento_cardapio = ?, tamanho_cardapio = ?, where codigo_cardapio = ? ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1,cardapio_aux.getDescricao());
            st.setDouble(2,cardapio_aux.getValor());
            st.setString(3,cardapio_aux.getTipo());
            st.setString(4,cardapio_aux.getAcompanhamento());
            st.setString(5,cardapio_aux.getTamanho());
            
           
            
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro editado com sucesso","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            JOptionPane.showMessageDialog(null,"Erro ao editar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }     
}    
