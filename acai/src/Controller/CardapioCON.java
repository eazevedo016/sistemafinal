/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CardapioDAO;
import Entidades.Cardapio;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduar
 */
public class CardapioCON 
{
    CardapioDAO CardapioD;
    
    public CardapioCON(){
        CardapioD = new CardapioDAO();
    }

    public boolean verificador(Cardapio cardapio_aux){
        if(cardapio_aux.getDescricao().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Descrição","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
      
        if(cardapio_aux.getTipo().equals("Selecione um item")){
            JOptionPane.showMessageDialog(null,"Selecione um item","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(cardapio_aux.getValor() == 0){
            JOptionPane.showMessageDialog(null,"Preencha o campo Valor","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
         
        if(cardapio_aux.getAcompanhamento().equals("Selecione um grupo de acompanhamentos")){
            JOptionPane.showMessageDialog(null,"Selecione um grupo de acompanhamentos","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(cardapio_aux.getTamanho().equals("Selecione o tamanho")){
            JOptionPane.showMessageDialog(null,"Selecione o tamanho","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        
        
        CardapioD.cadastrarCardapio(cardapio_aux);
        return true;
    }
    
              
    public String controleCodigo(){
        return CardapioD.proxCardapio();
    }
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo){
       CardapioD.buscarCardapio(Pesquisa, Modelo);
    }
    
    public Cardapio controlePreencher(int Codigo){
        return CardapioD.preencherCampos(Codigo);
    }

    public boolean verificaDadosEditar(Cardapio cardapio_aux){
        if(cardapio_aux.getDescricao().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Descrição","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
      
        if(cardapio_aux.getTipo().equals("Selecione um item")){
            JOptionPane.showMessageDialog(null,"Selecione um item","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(cardapio_aux.getValor().equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Valor","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
         
        if(cardapio_aux.getAcompanhamento().equals("Selecione um grupo de acompanhamentos")){
            JOptionPane.showMessageDialog(null,"Selecione um grupo de acompanhamentos","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(cardapio_aux.getTamanho().equals("Selecione o tamanho")){
            JOptionPane.showMessageDialog(null,"Selecione o tamanho","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        CardapioD.editarCardapio(cardapio_aux);
        return true;
    }    
}
