/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FuncionarioDAO;
import Entidades.Cliente;
import Entidades.Funcionario;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduar
 */
public class FuncionarioCON 
{
    FuncionarioDAO FuncionarioD;
    
    public FuncionarioCON(){
        FuncionarioD = new FuncionarioDAO();
    }

    public boolean verificador(Funcionario funcionario_aux){
        if(funcionario_aux.getNome().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
      
        if(funcionario_aux.getFuncao().equals("")){
            JOptionPane.showMessageDialog(null,"Selecione a função","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        
        
        FuncionarioD.cadastrarFuncionario(funcionario_aux);
        return true;
    }
    
              
    public String controleCodigo(){
        return FuncionarioD.proxFuncionario();
    }
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo){
       FuncionarioD.buscarFuncionario(Pesquisa, Modelo);
    }
    
    public Funcionario controlePreencher(int Codigo){
        return FuncionarioD.preencherCampos(Codigo);
    }

    public boolean verificaDadosEditar(Funcionario funcionario_aux){
         if(funcionario_aux.getNome().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
      
        if(funcionario_aux.getFuncao().equals("")){
            JOptionPane.showMessageDialog(null,"Selecione a função","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        return true;
    }    
}
