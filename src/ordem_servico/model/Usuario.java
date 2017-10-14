package ordem_servico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
    private Integer id;
    private String email;
    private String senha;
    private Dados dados = new Dados();
    
    public Usuario(){
                
    }
    
    public Usuario(Integer id){
        try{
            ResultSet rs = dados.busca("SELECT * FROM usuario WHERE id= " + id.toString());
            if (rs != null){
                rs.next();
                this.id = rs.getInt(1);
                this.email = rs.getString(2);
                this.senha = rs.getString(3);
            }
        }catch(SQLException ex){
            System.err.println("Erro SQL: " + ex);
        }catch(Exception e){
            System.err.println("Erro geral na criação de Usuario: " + e);
        }        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        
    private ArrayList<Usuario> buscaGeral(String sql){
        ArrayList<Usuario> listUsuario = new ArrayList();
        ResultSet rsUsuario;
        Usuario usuario;
        rsUsuario = dados.busca(sql);
        try {
            while (rsUsuario.next()) {
                usuario = new Usuario(rsUsuario.getInt(1));
                listUsuario.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro SQL busca usuarios: " + ex);
        } catch (Exception e) {
            System.err.println("Erro geral busca usuarios: " + e);
        }
        return listUsuario;
    }
    
    public ArrayList<Usuario> selectAll() {
        String sql = "SELECT id FROM usuario ORDER BY id DESC";
        return buscaGeral(sql);
    }
    
}
