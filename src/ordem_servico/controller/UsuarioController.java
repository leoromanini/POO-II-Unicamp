package ordem_servico.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ordem_servico.model.Usuario;
import ordem_servico.view.UsuarioView;

public class UsuarioController {
    private UsuarioView usuarioView;
    private Usuario usuario;

    public UsuarioController() {
        usuarioView = new UsuarioView();
        usuarioView.setVisible(true);
    }
    
    public UsuarioController(UsuarioView v){
        usuario = new Usuario();
        usuarioView = v;
        
        usuarioView.setLocationRelativeTo(null);
        usuarioView.getPanelDetalhes().setVisible(false);
        usuarioView.getPanelNovo().setVisible(false);
        listarUsuarios();
    }
    
    private boolean validarCampos(){
        if(usuario.getEmail() != null && usuario.getSenha() != null && usuario.getEmail().length() > 5 && usuario.getSenha().length() > 3){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean listarUsuarios(){
        limparCampos();
        ArrayList<Usuario> listUsuarios;
        try {
            listUsuarios = usuario.selectAll();
            DefaultTableModel model = (DefaultTableModel) usuarioView.getTableUsuario().getModel();
        model.setRowCount(0);
        for(Usuario u : listUsuarios){
            model.addRow(new Object[]{u.getId(),u.getEmail(),u.getNome(),"*****"});
        }
        return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Houve um problema geral na busca. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    private boolean atualizarUsuario(){
        if(validarCampos()){
            return usuario.updateUsuario();
        }else{
            return false;
        }
    }
    
    private boolean excluirUsuario(){
        return usuario.deleteUsuario();
    }
    
    private boolean cadastarUsuario(){
        if(validarCampos()){
            return usuario.insertUsuario();
        }else{
            return false;
        }
    }
    
    private void limparCampos(){
        usuarioView.getTxtDetalhesEmail().setText("");
        usuarioView.getTxtDetalhesNovaSenha().setText("");
        usuarioView.getTxtDetalhesSenhaAtual().setText("");
        usuarioView.getTxtNovoEmail().setText("");
        usuarioView.getTxtNovoSenha().setText("");
        usuarioView.getTxtNovoNome().setText("");
        usuarioView.getTxtDetalhesNome().setText("");
    }
    
    private void detalharUsuario(Integer id){
        try {
            usuario = new Usuario(id);
            usuarioView.getTxtDetalhesEmail().setText(usuario.getEmail());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um problema geral na busca. Para nerds: " + e, "Ops", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void btnNovoClick(){
        usuarioView.getPanelDetalhes().setVisible(false);
        usuarioView.getPanelNovo().setVisible(true);
    }
    
    public void btnCadastrarClick(){
        usuario.setEmail(usuarioView.getTxtNovoEmail().getText());
        usuario.setSenha(usuarioView.getTxtNovoSenha().getText());
        usuario.setNome(usuarioView.getTxtNovoNome().getText());
        if(cadastarUsuario()){
            JOptionPane.showMessageDialog(null, "Usuario cadastrado", "Feito!", JOptionPane.INFORMATION_MESSAGE);
            usuarioView.getPanelDetalhes().setVisible(false);
            listarUsuarios();
        }else{
            JOptionPane.showMessageDialog(null, "Houve um problema ao cadastrar cliente", "Ops", JOptionPane.ERROR_MESSAGE);
        }
        limparCampos();
    }
    
    public void btnAtualizarClick(){
        if(usuarioView.getTxtDetalhesSenhaAtual().getText().equals(usuario.getSenha())){
            if(usuarioView.getTxtDetalhesNovaSenha().getText() != null){
                usuario.setSenha(usuarioView.getTxtDetalhesNovaSenha().getText());
                usuario.setNome(usuarioView.getTxtDetalhesNome().getText());
                if(atualizarUsuario()){
                    JOptionPane.showMessageDialog(null, "Usuario atualizado", "Feito!", JOptionPane.INFORMATION_MESSAGE);
                    usuarioView.getPanelDetalhes().setVisible(false);
                    listarUsuarios();
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possivel atualizar usuario. Verifique os campos preenchidos", "Ops", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Nova senha não pode ser nula", "Ops", JOptionPane.ERROR_MESSAGE);
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Senha atual não confere", "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnExcluirClick(){
        if (usuarioView.getTxtDetalhesSenhaAtual().getText().equals(usuario.getSenha())) {
            if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este usuario?") == 0 && excluirUsuario()){
                JOptionPane.showMessageDialog(null, "Usuario exluido", "Feito", JOptionPane.INFORMATION_MESSAGE);
                usuarioView.getPanelDetalhes().setVisible(false);
                listarUsuarios();
            }else{
                JOptionPane.showMessageDialog(null, "Houve um problema ao excluir usuario", "Ops", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha atual não confere", "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tableUsuarioClick(java.awt.event.MouseEvent evt){
        if (evt.getClickCount() == 2) {
                Integer row = usuarioView.getTableUsuario().rowAtPoint(evt.getPoint());
                Integer id = (Integer) usuarioView.getTableUsuario().getValueAt(row, 0);
                detalharUsuario(id);
                usuarioView.getPanelDetalhes().setVisible(true);
                usuarioView.getPanelNovo().setVisible(false);
        }
    }
    
    
}
