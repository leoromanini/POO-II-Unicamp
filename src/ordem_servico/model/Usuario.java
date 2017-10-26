package ordem_servico.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario extends Pessoa implements Serializable{
    private Integer id;
    private String email;
    private String senha;
    private transient Dados dados = new Dados();
    
    public Usuario(){
                
    }
    
    public Usuario(Integer id) throws SQLException{
            ResultSet rs = dados.busca("SELECT * FROM usuario WHERE id= " + id.toString());
            if (rs != null){
                rs.next();
                this.id = rs.getInt(1);
                this.email = rs.getString(2);
                this.senha = rs.getString(3);
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
        return (dados.executa("INSERT INTO usuario(email,senha) VALUES('"+email+"','"+senha+"')"));
    }

    public boolean updateUsuario() {
        return (dados.executa("UPDATE usuario SET email='"+email+"', senha='"+senha+"' WHERE id="+id));
    }

    public boolean deleteUsuario() {
        return (dados.executa("DELETE FROM usuario WHERE id=" + id));
    }
        
    private ArrayList<Usuario> buscaGeral(String sql) throws SQLException{
        ArrayList<Usuario> listUsuario = new ArrayList();
        ResultSet rsUsuario;
        Usuario usuario;
        rsUsuario = dados.busca(sql);
            while (rsUsuario.next()) {
                usuario = new Usuario(rsUsuario.getInt(1));
                listUsuario.add(usuario);
            }
        return listUsuario;
    }
    
    public ArrayList<Usuario> selectAll() throws SQLException {
        String sql = "SELECT id FROM usuario ORDER BY id DESC";
        return buscaGeral(sql);
    }
    
    public boolean logar() throws SQLException{
        String sql = "SELECT id FROM usuario WHERE email='" + email + "' AND senha='" + senha + "'";
        ResultSet rsUsuario = dados.busca(sql);
        if (rsUsuario.last() && rsUsuario.getRow() == 1){
            return true;
        }else{
            return false;
        }
    }
    
}
