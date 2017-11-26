/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_servico.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ordem_servico.model.Cliente;
import ordem_servico.model.OsResponsavel;
import ordem_servico.model.Usuario;
import ordem_servico.view.OsResponsavelView;

/**
 *
 * @author matheus
 */
public class OsResponsavelController {
    private OsResponsavel osResponsavel;
    private OsResponsavelView osResponsavelView;    
        
    public OsResponsavelController(OsResponsavelView v){
        osResponsavel = new OsResponsavel();
        osResponsavelView = v;       
        osResponsavelView.setVisible(true);
        osResponsavelView.setLocationRelativeTo(null);
    }
    
    private void listToTableOsResponsavel(ArrayList<OsResponsavel> lista) {
        DefaultTableModel model = (DefaultTableModel) osResponsavelView.getTableOsResponsavel().getModel();
        model.setNumRows(0);
        lista.forEach((c) -> {
            Usuario usuario = new Usuario(c.getIdUsuario());
            model.addRow(new Object[]{usuario.getNome(),c.getData()});
        });
    }
    
    public void listarOsResponsavel(Integer id){
        listToTableOsResponsavel(osResponsavel.selectByOs(id));
    }
}
