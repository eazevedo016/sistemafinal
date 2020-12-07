/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import Entidades.Cliente;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduar
 */
public class ClienteCON 
{
    ClienteDAO ClienteD;
    
    public ClienteCON(){
        ClienteD = new ClienteDAO();
    }

    public boolean verificador(Cliente cliente_aux){
        if(cliente_aux.getNome().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(cliente_aux.getRua().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Rua","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
     
        if(cliente_aux.getTelefone().equals("(  )     -    ")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Telefone","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(cliente_aux.getBairro().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Bairro","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        ClienteD.cadastrarCliente(cliente_aux);
        return true;
    }
    
              
    public String controleCodigo(){
        return ClienteD.proxCliente();
    }
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo){
       ClienteD.buscarCliente(Pesquisa, Modelo);
    }
    
    public void controlePesquisa(String Pesquisa, List<String> Lista){
       ClienteD.buscarCliente(Pesquisa, Lista);
    }
    
    public Cliente controlePreencher(int Codigo){
        return ClienteD.preencherCampos(Codigo);
    }

    public boolean verificaDadosEditar(Cliente cliente_aux){
        if(cliente_aux.getNome().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(cliente_aux.getRua().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Rua","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
     
        if(cliente_aux.getTelefone().equals("(  )     -    ")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Telefone","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(cliente_aux.getBairro().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Bairro","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        ClienteD.editarCliente(cliente_aux);
        return true;
    }    
}
