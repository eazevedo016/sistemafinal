/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import Entidades.Entregador;
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
public class EntregadorDAO 
{
    
    public EntregadorDAO()
    {
        
    }
    
    public void cadastrarEntregador(Entregador entregador_aux)
    {
        try {
            String SQLInsertion = "insert into entregador(nome_entregador,status_entregador, data_entregador) values(?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, entregador_aux.getNome());
            st.setString(2, "Disponível");
            st.setString(3, Atualizador.Converte(entregador_aux.getData()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro concluído","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }        
    public String proxEntregador(){
        String SQLSelection = "select * from entregador order by codigo_entregador desc limit 1";
        try {
            
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return (Integer.parseInt(rs.getString("codigo_entregador")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar registro","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return "0";
        }
    }
    public void buscarEntregador(String Pesquisa, DefaultTableModel Modelo){
        
        try {
            String SQLSelection = "select * from entregador where nome_entregador like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object [] {rs.getString("nome_entregador"), rs.getString("codigo_entregador"),Atualizador.ConverteJ(rs.getString("data_entregador"))});
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar entregador","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }   
    }
    
    public Entregador preencherCampos(int Codigo)
    {
        Entregador entregador_aux = new Entregador();
        try {
            String SQLSelection = "select * from entregador where codigo_entregador = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1,Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               entregador_aux.setCodigo(rs.getInt("nome_funcionario"));
               entregador_aux.setNome(rs.getString("codigo_funcionario"));
               entregador_aux.setData(Atualizador.ConverteJ(rs.getString("data_funcionario")));
               
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar entregador","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
        
        return entregador_aux;
    }
    
    public void editarEntregador(Entregador entregador_aux){
        try {
            String SQLInsertion = "update  entregador set nome_entregador = ?,status_entregador,data_entregador = ? where codigo_entregador = ? ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, entregador_aux.getNome());
            st.setInt(2, entregador_aux.getCodigo());
            
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro editado com sucesso","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            JOptionPane.showMessageDialog(null,"Erro ao editar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }     
}    
