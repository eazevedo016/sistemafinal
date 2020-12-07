
package Controller;

import DAO.PedidoDAO;
import Entidades.Pedido;
import GUI.TelaPedido;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class PedidoCON {
    
    PedidoDAO PedidoD;
    
    public PedidoCON(){
        PedidoD = new PedidoDAO();
    }
    
    public void controledeItens(String Pesquisa, List<String>ListadeItens){
        PedidoD.pesquisaItens(Pesquisa, ListadeItens);
    }
    
    public double controleValor(String Pesquisa){
        return PedidoD.valorItem(Pesquisa);
    }
    
    public int controleCodigo(String Pesquisa){
        return PedidoD.valorCodigo(Pesquisa);
    }
    
    public boolean verificaItens(String Valor, String Quantidade, String Codigo, String Item){
        
        try{
            int x = Integer.parseInt(Quantidade);
            if(x == 0){
                JOptionPane.showMessageDialog(null,"Quantidade inválida","Error",0,new ImageIcon("imagensdosistema/error.png"));
                TelaPedido.txt_quantidade.setText("1");
                TelaPedido.txt_quantidade.grabFocus();
            }
        }catch(NumberFormatException Ex){
            JOptionPane.showMessageDialog(null,"Insira um numero inteiro","Error",0,new ImageIcon("imagensdosistema/error.png"));
            TelaPedido.txt_quantidade.setText("1");
            TelaPedido.txt_quantidade.grabFocus();
        }       
        
        
        if(Quantidade.equals("")){
            //JOptionPane.showMessageDialog(null,"Preencha o campo Quantidade","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        
        if(Valor.equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Valor","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
            
        if(Codigo.equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Código","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        if(Item.equals("")){
            JOptionPane.showMessageDialog(null,"Preencha o campo Item","Error",0,new ImageIcon("imagensdosistema/error.png"));
            return false;
        }
        
        return true;


    }
    
    public void controlePedido(String CodigoCliente, String CodigoFuncionario, String Total,int  TamanhoTabela, Pedido entid_pedido){
        PedidoD.cadastrarPedido(CodigoCliente, CodigoFuncionario, Total, TamanhoTabela, entid_pedido);
    }     
    
}
