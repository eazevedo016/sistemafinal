/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import Util.Atualizador;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduar
 */
public class ClienteDAO 
{
    
    public ClienteDAO()
    {
        
    }
    
    public void cadastrarCliente(Cliente cliente_aux)
    {
        try {
            String SQLInsertion = "insert into clientes(nome_cliente,rua_cliente, bairro_cliente,telefone_cliente ,data_cliente) values(?,?,?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cliente_aux.getNome());
            st.setString(2, cliente_aux.getRua());
            st.setString(3, cliente_aux.getBairro());
            st.setString(4, cliente_aux.getTelefone());
            st.setString(5, Atualizador.Converte(cliente_aux.getData()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro concluído","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }        
    public String proxCliente(){
        String SQLSelection = "select * from clientes order by codigo_cliente desc limit 1";
        try {
            
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return (Integer.parseInt(rs.getString("codigo_cliente")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar registro","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return "0";
        }
    }
    public void buscarCliente(String Pesquisa, DefaultTableModel Modelo){
        
        try {
            String SQLSelection = "select * from clientes where nome_cliente like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object [] {rs.getString("nome_cliente"), rs.getString("codigo_cliente"), rs.getString("rua_cliente"), rs.getString("bairro_cliente"), rs.getString("telefone_cliente"),rs.getString("data_cliente")});
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar cliente","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }   
    }
    
    
    
     public void buscarCliente(String Pesquisa, List<String> Lista){
        
        try {
            String SQLSelection = "select * from clientes where nome_cliente like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Lista.add(rs.getString("codigo_cliente") + " - " + rs.getString("nome_cliente"));
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar cliente","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }   
    }
    
    public Cliente preencherCampos(int Codigo)
    {
        Cliente cliente_aux = new Cliente();
        try {
            String SQLSelection = "select * from clientes where codigo_cliente = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1,Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               cliente_aux.setCodigo(rs.getInt("codigo_cliente"));
               cliente_aux.setNome(rs.getString("nome_cliente"));
               cliente_aux.setBairro(rs.getString("bairro_cliente"));
               cliente_aux.setTelefone(rs.getString("telefone_cliente"));
               cliente_aux.setData(Atualizador.ConverteJ(rs.getString("data_cliente")));
               cliente_aux.setRua(rs.getString("rua_cliente"));
               
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar cliente","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
        
        return cliente_aux;
    }
    
    public void editarCliente(Cliente cliente_aux){
        try {
            String SQLInsertion = "update  clientes set nome_cliente = ?, rua_cliente = ?, bairro_cliente = ?, telefone_cliente = ? where codigo_cliente = ? ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cliente_aux.getNome());
            st.setString(2, cliente_aux.getRua());
            st.setString(3, cliente_aux.getBairro());
            st.setString(4, cliente_aux.getTelefone());
            st.setInt(5, cliente_aux.getCodigo());
            
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro editado com sucesso","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }     
}    
