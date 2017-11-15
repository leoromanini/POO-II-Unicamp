
package ordem_servico.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ordem_servico.model.Cliente;
import ordem_servico.view.ClienteView;

public class ClienteController {
    private Cliente cliente;
    private ClienteView clienteView;
    
    public ClienteController(){
        clienteView = new ClienteView();
        clienteView.setVisible(true);
    }
    
    public ClienteController(ClienteView v){
        this.cliente = new Cliente();
        clienteView = v;
        buscarTodosClientes();
        
        clienteView.setLocationRelativeTo(null);
        clienteView.getPanelDetalhes().setVisible(false);
    }
    
    private void listToTableCliente(ArrayList<Cliente> lista){
        DefaultTableModel model = (DefaultTableModel) clienteView.getTableCliente().getModel();
        model.setNumRows(0);
        lista.forEach((c) -> {
            model.addRow(new Object[]{c.getId(),c.getNome(),c.getEndereco()});
        });
    }
    
    private void buscarTodosClientes(){
        ArrayList<Cliente> listaClientes;
        
            listaClientes = cliente.selectAll();
            listToTableCliente(listaClientes);   
            
    }
    
    private void buscarClientesByNome(String nome){
        try {
            if (nome != null && nome.length() > 0) {
                ArrayList<Cliente> listaClientes = cliente.selectByNome(nome);
                listToTableCliente(listaClientes);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro geral na busca de cliente por nome. Para nerds: " + e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void detalharCliente(Integer id){
        if(id > 0){
            cliente = new Cliente(id);
            
            clienteView.getLabelCelular().setText(cliente.getCelular());
            clienteView.getLabelCpf().setText(cliente.getCpf());
            clienteView.getLabelEndereco().setText(cliente.getEndereco());
            clienteView.getLabelNascimento().setText(cliente.getNascimento());
            clienteView.getLabelNome().setText(cliente.getNome());
            clienteView.getLabelTelefone().setText(cliente.getTelefone());
        }
    }
    
    private boolean excluirCliente(Integer id){
        if(id > 0){
            cliente.setId(id);
            return cliente.deleteCliente();
        }        
        return false;
    }
    
    private boolean validarCampos(){
        if(!cliente.getTelefone().isEmpty() && !cliente.getCpf().isEmpty() && !cliente.getEndereco().isEmpty() 
                && !cliente.getNascimento().isEmpty() && !cliente.getNome().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    private void limparCampos(){
        clienteView.getLabelCelular().setText("");
        clienteView.getLabelCpf().setText("");
        clienteView.getLabelEndereco().setText("");
        clienteView.getLabelNascimento().setText("");
        clienteView.getLabelNome().setText("");
        clienteView.getLabelTelefone().setText("");
    }
    
    private boolean atualizarCliente(Integer id){
        if(id > 0){
            cliente = new Cliente();
            cliente.setId(id);
            cliente.setCelular(clienteView.getLabelCelular().getText());
            cliente.setCpf(clienteView.getLabelCpf().getText());
            cliente.setEndereco(clienteView.getLabelEndereco().getText());
            cliente.setNascimento(clienteView.getLabelNascimento().getText());
            cliente.setNome(clienteView.getLabelNome().getText());
            cliente.setTelefone(clienteView.getLabelTelefone().getText());
            
            if(validarCampos()){
                return cliente.updateCliente();
            }
        }
        return false;
    }
    
    private boolean cadastrarCliente(){
        cliente = new Cliente();
        cliente.setCelular(clienteView.getLabelCelular().getText());
        cliente.setCpf(clienteView.getLabelCpf().getText());
        cliente.setEndereco(clienteView.getLabelEndereco().getText());
        cliente.setNascimento(clienteView.getLabelNascimento().getText());
        cliente.setNome(clienteView.getLabelNome().getText());
        cliente.setTelefone(clienteView.getLabelTelefone().getText());

        if (validarCampos()) {
            return cliente.insertCliente();
        } else {
            return false;
        }
    }
    
    public void btnCadastrarClick(){
        if(cadastrarCliente()){
            JOptionPane.showMessageDialog(null, "Cliente cadastrado", "Feito", JOptionPane.INFORMATION_MESSAGE);
            clienteView.getPanelDetalhes().setVisible(false);
            buscarTodosClientes();
        }else{
            JOptionPane.showMessageDialog(null, "Houve um problema ao cadastrar este cliente. Verifique se os campos estão corretos",
                        "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnNovoClick(){
        limparCampos();
        clienteView.getPanelDetalhes().setVisible(true);
        clienteView.getBtnAtualizar().setVisible(false);
        clienteView.getBtnExcluir().setVisible(false);
        clienteView.getBtnCadastrar().setVisible(true);
    }
    
    
    public void btnAtualizarClick(){
        try{
            Integer id = cliente.getId();
            if(atualizarCliente(id)){
                JOptionPane.showMessageDialog(null, "Cliente atualizado", "Feito", JOptionPane.INFORMATION_MESSAGE);
                clienteView.getPanelDetalhes().setVisible(false);
                buscarTodosClientes();
            }else{
                JOptionPane.showMessageDialog(null, "Houve um problema ao atualizar este cliente. Verifique se os campos estão corretos",
                        "Ops", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Houve um problema ao identificar o codigo do cliente. Para nerds:" +e, "Ops", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Houve um problema geral ao atualizar o cliente. Para nerds:" +e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnExcluirClick(){
        try{
            Integer id = cliente.getId();
            if(JOptionPane.showConfirmDialog(null, "Realmente deseja excluir esse cliente?") == 0){
                if(excluirCliente(id)){
                    clienteView.getPanelDetalhes().setVisible(false);
                    JOptionPane.showMessageDialog(null, "Cliente excluido", "Feito", JOptionPane.INFORMATION_MESSAGE);
                    buscarTodosClientes();
                }else{
                    JOptionPane.showMessageDialog(null, "Houve um problema ao excluir este cliente", "Ops", JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Houve um problema geral na exclusão. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnRedefinirClick(){
        buscarTodosClientes();
        clienteView.getTxtNome().setText("");
    }
    
    public void btnBuscarClick(){
        String nome = clienteView.getTxtNome().getText();
        buscarClientesByNome(nome);
    }
    
    public void tableClienteClick(java.awt.event.MouseEvent evt){
        if (evt.getClickCount() == 2) {
            try{
                Integer row = clienteView.getTableCliente().rowAtPoint(evt.getPoint());
                Integer id = (Integer) clienteView.getTableCliente().getValueAt(row, 0);
                detalharCliente(id);
                clienteView.getPanelDetalhes().setVisible(true);
                clienteView.getBtnCadastrar().setVisible(false);
                clienteView.getBtnAtualizar().setVisible(true);
                clienteView.getBtnExcluir().setVisible(true);
            }catch(ClassCastException e){
                JOptionPane.showMessageDialog(null, "Houve um problema ao identificar o formato do codigo na seleção para exclusão. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Houve um problema geral na exclusão. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
}
