
package Controller;

import DAO.TelaProducaoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class TelaProducaoCON {
    
    TelaProducaoDAO TelaProducaoD;
    
    public TelaProducaoCON(){
        TelaProducaoD = new TelaProducaoDAO();
        
    }    
    
     public void controlePesquisa( DefaultTableModel Modelo){
        TelaProducaoD.showPedidos(Modelo);
    }
    
}
