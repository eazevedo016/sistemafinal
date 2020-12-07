/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import Entidades.Funcionario;
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
public class FuncionarioDAO 
{
    
    public FuncionarioDAO()
    {
        
    }
    
    public void cadastrarFuncionario(Funcionario funcionario_aux)
    {
        try {
            String SQLInsertion = "insert into funcionarios(nome_funcionario, funcao_funcionario, data_funcionario) values(?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, funcionario_aux.getNome());
            st.setString(2, funcionario_aux.getFuncao());
            st.setString(3, Atualizador.Converte(funcionario_aux.getData()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro concluído","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }        
    public String proxFuncionario(){
        String SQLSelection = "select * from funcionarios order by codigo_funcionario desc limit 1";
        try {
            
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return (Integer.parseInt(rs.getString("codigo_funcionario")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar registro","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return "0";
        }
    }
    public void buscarFuncionario(String Pesquisa, DefaultTableModel Modelo){
        
        try {
            String SQLSelection = "select * from funcionarios where nome_funcionario like '%" + Pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object [] {rs.getString("nome_funcionario"), rs.getString("codigo_funcionario"),rs.getString("funcao_funcionario"),Atualizador.ConverteJ(rs.getString("data_funcionario"))});
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar funcionario","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }   
    }
    
    public Funcionario preencherCampos(int Codigo)
    {
        Funcionario funcionario_aux = new Funcionario();
        try {
            String SQLSelection = "select * from funcionarios where codigo_funcionario = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1,Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               funcionario_aux.setCodigo(rs.getInt("codigo_funcionario"));
               funcionario_aux.setNome(rs.getString("nome_funcionario"));
               funcionario_aux.setFuncao(rs.getString("funcao_funcionario"));
               funcionario_aux.setData(Atualizador.ConverteJ(rs.getString("data_funcionario")));
               
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar funcionario","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
        
        return funcionario_aux;
    }
    
    public void editarFuncionario(Funcionario funcionario_aux){
        try {
            String SQLInsertion = "update  funcionarios set nome_funcionario = ?, data_funcionario = ? where codigo_funcionario = ? ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, funcionario_aux.getNome());
            st.setInt(2, funcionario_aux.getCodigo());
            
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro editado com sucesso","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            JOptionPane.showMessageDialog(null,"Erro ao editar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }     
}    
