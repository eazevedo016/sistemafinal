/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EntregadorDAO;
import DAO.FuncionarioDAO;
import Entidades.Entregador;
import Entidades.Funcionario;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduar
 */
public class EntregadorCON 
{
    EntregadorDAO EntregadorD;
    
    public EntregadorCON(){
        EntregadorD = new EntregadorDAO();
    }

    public boolean verificador(Entregador entregador_aux){
        if(entregador_aux.getNome().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
      
   
        
        EntregadorD.cadastrarEntregador(entregador_aux);
        return true;
    }
    
              
    public String controleCodigo(){
        return EntregadorD.proxEntregador();
    }
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo){
       EntregadorD.buscarEntregador(Pesquisa, Modelo);
    }
    
    public Entregador controlePreencher(int Codigo){
        return EntregadorD.preencherCampos(Codigo);
    }

    public boolean verificaDadosEditar(Entregador entregador_aux){
         if(entregador_aux.getNome().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
      
       
        return true;
    }    
}
