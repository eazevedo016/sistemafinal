package DAO;

import Entidades.Pedido;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PedidoDAO {
    
    public void pesquisaItens(String Pesquisa, List<String>ListadeItens){
        
        try {
            String SQLPesquisa = "select * from cardapio where descricao_cardapio like '%" + Pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs  = st.executeQuery();
            
            while(rs.next()){
                ListadeItens.add(rs.getString("descricao_cardapio"));
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao pesquisar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
    }
    
    public double valorItem(String Pesquisa){
        try {
            String SQLPesquisa = "select * from cardapio where descricao_cardapio = ? ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            st.setString(1,Pesquisa);
            ResultSet rs  = st.executeQuery();
            
            if(rs.next()){
                return rs.getDouble("valor_cardapio");
                
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao pesquisar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
        
        
        return 0;
        
    }
    
    public int valorCodigo(String Pesquisa){
        try {
            String SQLPesquisa = "select * from cardapio where descricao_cardapio = ? ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            st.setString(1,Pesquisa);
            ResultSet rs  = st.executeQuery();
            
            if(rs.next()){
                return rs.getInt("codigo_cardapio");
                
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao pesquisar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
        
        
        return 0;
        
    }
    
    public void cadastrarPedido(String CodigoCliente, String CodigoFuncionario, String Total, int  TamanhoTabela, Pedido entid_pedido){
        Date Data = new Date();
        SimpleDateFormat FormatoData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat FormatoHora = new SimpleDateFormat("HH:mm:ss");
        try {
            String SQLInsert = "insert into pedidos(codigo_pedido_cliente, pedido_codigo_funcionario, pedido_codigo_entregador,  data_pedido,	hora_pedido, valor_pedido, pedido_status) values(?,?,?,?,?,?,?)";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLInsert);
            st.setString(1,CodigoCliente);
            st.setString(2,CodigoFuncionario);
            st.setString(3,"1");
            st.setString(4,FormatoData.format(Data));
            st.setString(5,FormatoHora.format(Data));
            st.setString(6,Total.replace(',','.'));
            st.setString(7,"Pedido Aberto");
            
            
            st.execute();
            cadastraItens(CodigoCliente, CodigoFuncionario, codigoPedido(),  TamanhoTabela, entid_pedido);
            codigoPedido();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro concluído","Salvo",1,new ImageIcon("imagensdosistema/sucesso.png"));
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            //JOptionPane.showMessageDialog(null,"Erro ao cadastrar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
        
    }
    
    public String codigoPedido(){
        String Cod = "0";
        
        try {
            String SQLSelection = "select codigo_pedido from pedidos order by codigo_pedido desc limit 1";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs  = st.executeQuery();
            if(rs.next()){
                Cod = rs.getString("codigo_pedido");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            //JOptionPane.showMessageDialog(null,"Erro ao cadastrar","Error",0,new ImageIcon("imagensdosistema/error.png"));
        }
        return Cod;
    }
    
    
    public void cadastraItens(String CodigoCliente, String CodigoFuncionario, String CodigoPedido, int TamanhoTabela, Pedido entid_pedido){
        for (int i = 0; i < TamanhoTabela; i++){
            String SQLInserir = "insert into item(item_entregador_codigo, item_funcionario_codigo, item_cliente_codigo, item_pedido_codigo, item_cardapio_codigo, item_quantidade) values(?,?,?,?,?,?)";
            try {
                PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInserir);
                
                st.setString(1, "1");
                st.setString(2, CodigoFuncionario);
                st.setString(3, CodigoCliente);
                st.setString(4, CodigoPedido);
                st.setInt(5, entid_pedido.getCodCardapio(i));
                st.setInt(6, entid_pedido.getQuantidade(i));
                
                st.execute();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex,"Error",0,new ImageIcon("imagensdosistema/error.png"));
            //JOptionPane.showMessageDialog(null,"Erro ao cadastrar","Error",0,new ImageIcon("imagensdosistema/error.png"));
            }
        }
    }
    
    
    
}
