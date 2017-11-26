package ordem_servico.controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import ordem_servico.model.Usuario;
import ordem_servico.view.PrincipalView;
import ordem_servico.view.UsuarioLoginView;

public class UsuarioLoginController {
    private UsuarioLoginView usuarioLoginView;
    private Usuario usuario;    
    
    public UsuarioLoginController(UsuarioLoginView v){
        usuarioLoginView = v;
        usuario = new Usuario();
        usuarioLoginView.setVisible(true);
        usuarioLoginView.setLocationRelativeTo(null);
    }
    
    private boolean logar(String email, String senha){
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario.logar();
    }
    
    public void btnEntrarClick(){
        String email = usuarioLoginView.getTxtEmail().getText();
        String senha = usuarioLoginView.getTxtSenha().getText();
        if(!email.isEmpty() && !senha.isEmpty()){
            try{
                if(logar(email,senha)){                    
                    System.setProperty("idUsuario", usuario.getId().toString());
                    PrincipalView principalView = new PrincipalView();
                    principalView.setVisible(true);
                    principalView.setLocationRelativeTo(null);
                    usuarioLoginView.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario ou senha inválidos", "Ops", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Houve um problema geral com Usuario :( para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Preencha email e senha antes de enviar", "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
