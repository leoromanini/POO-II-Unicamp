
package ordem_servico.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ordem_servico.model.Cliente;
import ordem_servico.model.Item;
import ordem_servico.model.Os;
import ordem_servico.model.OsHardware;
import ordem_servico.model.OsSoftware;
import ordem_servico.model.Usuario;
import ordem_servico.view.OsView;

public class OsController {
    private Os os;
    private OsView osView;
    
    public OsController(){
        osView = new OsView();
        osView.setVisible(true);
    }
    
    public OsController(OsView v){
        os = new Os();
        osView = v;   
        
        osView.setLocationRelativeTo(null);
        osView.getPanelDetalhes().setVisible(false);
        buscarTodasOs();
    }
    
    private void listResponsaveis(){
        Usuario usuario = new Usuario();
        osView.getListResponsavel().removeAllItems();
        ArrayList<Usuario> usuariosList = usuario.selectAll();
        for(Usuario u:usuariosList){
            osView.getListResponsavel().addItem(new Item(u.getId().toString(),u.getNome()));
        }
    }
    
    private void listToTableOs(ArrayList<Os> lista) {
        DefaultTableModel model = (DefaultTableModel) osView.getTabelaOs().getModel();
        model.setNumRows(0);
        lista.forEach((c) -> {
            Usuario usuario = new Usuario(c.getIdUsuario());
            model.addRow(new Object[]{c.getId(), c.getTitulo(), usuario.getNome(), c.getDataFinalizado()});
        });
    }
    
    private void buscarTodasOs() {
        ArrayList<Os> listaOs;
        
        listaOs = os.selectAll();
        Collections.reverse(listaOs);
        listToTableOs(listaOs);
    }
    
    private void detalharOs(Integer id) {
        if (id > 0) {
            osView.getPanelDetalhes().setVisible(true);
            os = new Os(id);            
            Usuario usuario = new Usuario(os.getIdUsuario());
            Cliente cliente = new Cliente(os.getIdCliente());
            
            osView.getLbAbertura().setText(os.getDataAbertura());
            osView.getLbCliente().setText(cliente.getNome());
            osView.getLbFinalizado().setText(os.getDataFinalizado());
            osView.getLbPrazo().setText(os.getPrazo());
            osView.getLbResponsavel().setText(usuario.getNome());
            osView.getLbServico().setText(os.getServico());
            osView.getLbTitulo().setText(os.getTitulo());
            if(os.getTotal() != null){
                osView.getLbTotal().setText(os.getTotal().toString());
            }
            
            if(os.getIdTipo().equals(1)){
                osView.getLbGit().setText("");
                OsHardware osHardware = new OsHardware(id);
                osView.getLbTipo().setText("Hardware");
                if(osHardware.getMaoObra() != null){
                    osView.getLbMaoObra().setText(osHardware.getMaoObra().toString());
                }
                osView.getLbReclamacao().setText(osHardware.getReclamacao());
            }else if(os.getIdTipo().equals(2)){
                osView.getLbMaoObra().setText("");
                osView.getLbReclamacao().setText("");
                OsSoftware osSoftware = new OsSoftware(id);
                osView.getLbTipo().setText("Software");
                osView.getLbGit().setText(osSoftware.getGitLink());
            }
        }
    }
    
    private boolean atualizarOs(Integer id) {
        if (id > 0) {
            os = new Os();
            Item item = (Item) osView.getListResponsavel().getSelectedItem();
            os.setId(id);            
            os.setIdUsuario(Integer.parseInt((String) item.getValue()));
            buscarTodasOs();
            return os.updateOs();
        }
        return false;
    }
    
    private boolean finalizarOs(Integer id){
        if(id > 0){
            os = new Os(id);
            os.setDataFinalizado(new SimpleDateFormat( "dd/MM/yyyy" ).toString());
            buscarTodasOs();
            return os.updateOs();
        }
        return false;
    }
    
    public void btnAtualizar(){
        try{
            if(atualizarOs(os.getId())){
                JOptionPane.showMessageDialog(null, "OS Atualizada", "Feito", JOptionPane.INFORMATION_MESSAGE);                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel atualizar a OS, tente novamente mais tarde", "Ops", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar. Para nerds: "+ e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnFinalizar(){
        try{
            if(finalizarOs(os.getId())){
                JOptionPane.showMessageDialog(null, "OS Finalizada", "Feito", JOptionPane.INFORMATION_MESSAGE);                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel finalizar a OS, tente novamente mais tarde", "Ops", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao finalizar. Para nerds: "+ e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tableClienteClick(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            try {
                Integer row = osView.getTabelaOs().rowAtPoint(evt.getPoint());
                Integer id = (Integer) osView.getTabelaOs().getValueAt(row, 0);
                detalharOs(id);
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(null, "Houve um problema ao identificar o formato do codigo na seleção para detalhar. Para nerds: " + e, "Ops", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Houve um problema geral no detalhamento. Para nerds: " + e, "Ops", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
