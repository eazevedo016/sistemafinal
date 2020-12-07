
package Entidades;

import java.util.ArrayList;
import java.util.List;


public class Pedido {
    
    private int CodigoPedido;
    private int CodigoCliente;
    private int CodigoEntregador;
    private int CodigoFuncionario;
    private String Hora;
    private String Data;
    private String Status;
    private Double Valor;
    private List<Integer>CodCardapio;
    private List<Integer>Quantidade;
    
    
    
    public Pedido(){
        CodCardapio = new ArrayList<>();
        Quantidade = new ArrayList<>();
    
    }

    public int getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(int CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    public int getCodigoEntregador() {
        return CodigoEntregador;
    }

    public void setCodigoEntregador(int CodigoEntregador) {
        this.CodigoEntregador = CodigoEntregador;
    }

    public int getCodigoFuncionario() {
        return CodigoFuncionario;
    }

    public void setCodigoFuncionario(int CodigoFuncionario) {
        this.CodigoFuncionario = CodigoFuncionario;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public int getCodCardapio(int Pos) {
        return CodCardapio.get(Pos);
    }

    public void setCodCardapio(int CodCardapio) {
        this.CodCardapio.add(CodCardapio);
    }

    public int getQuantidade(int Pos) {
        return Quantidade.get(Pos);
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade.add(Quantidade);
    }
    
    
}
