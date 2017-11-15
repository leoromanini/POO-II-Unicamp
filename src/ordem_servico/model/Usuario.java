package ordem_servico.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Usuario extends Pessoa implements Serializable{
    private Integer id;
    private String email;
    private String senha;
    private transient Dados dados = new Dados();
    private transient final String arquivo = "usuarios.txt";
    
    public Usuario(){
                
    }
    
    public Usuario(Integer id){
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Usuario usuario;
        for(Object objeto:listaObj){
            usuario = (Usuario) objeto;
            if(Objects.equals(usuario.getId(), id)){
                this.id = usuario.id;
                this.email = usuario.email;
                this.senha = usuario.senha;
            }
        }
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String getNome(){
        return nome;
    }
    
    @Override
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean insertUsuario() {
        ArrayList<Object> listaAtual = dados.lerTodos(arquivo);
        this.setId(listaAtual.size()+1);
        listaAtual.add(this);
        return dados.escrever(arquivo, listaAtual);
    }

    public boolean updateUsuario() {   
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Usuario usuario;
        for(Object objeto:listaObj){
            usuario = (Usuario) objeto;
            if(usuario.getId().equals(this.id)){
                listaObj.remove(objeto);
                listaObj.add(this);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    public boolean deleteUsuario() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Usuario usuario;
        for(Object objeto:listaObj){
            usuario = (Usuario) objeto;
            if(usuario.getId().equals(this.id)){
                listaObj.remove(objeto);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }
    
    public ArrayList<Usuario> selectAll() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<Usuario> listaUsuario = new ArrayList();
        for(Object objeto:listaObj){
            listaUsuario.add((Usuario) objeto);
        }
        return listaUsuario;
    }
    
    public boolean logar(){
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Usuario usuario;
        for(Object objeto:listaObj){
            usuario = (Usuario) objeto;
            if(usuario.getEmail().equals(this.getEmail()) && usuario.getSenha().equals(this.getSenha())){
                this.id = usuario.id;
                return true;
            }
        }
        return false;
    }
    
}
