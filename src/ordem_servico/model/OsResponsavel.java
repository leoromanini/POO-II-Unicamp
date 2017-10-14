package ordem_servico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OsResponsavel {
    private Integer id;
    private Integer idUsuario;
    private Integer idOs;
    private String data;
    private Dados dados = new Dados();
    
    public OsResponsavel(){
                
    }
    
    public OsResponsavel(Integer id){
        try{
            ResultSet rs = dados.busca("SELECT * FROM os_responsavel WHERE id= " + id.toString());
            if (rs.next()){
                this.id = rs.getInt(1);
                this.idUsuario = rs.getInt(2);
                this.idOs = rs.getInt(3);
                this.data = rs.getString(4);
            }
        }catch(SQLException ex){
            System.err.println("Erro SQL: " + ex);
        }catch(Exception e){
            System.err.println("Erro geral na criação de OsResponsavel: " + e);
        }        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdOs() {
        return idOs;
    }

    public void setIdOs(Integer idOs) {
        this.idOs = idOs;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public boolean insertOsResponsavel() {
        return (dados.executa("INSERT INTO os_responsavel(id_usuario,id_os,data) VALUES("+idUsuario+","+idOs+",'"+data+"')"));
    }
        
    private ArrayList<OsResponsavel> buscaGeral(String sql){
        ArrayList<OsResponsavel> listOsResponsavel = new ArrayList();
        ResultSet rsOsResponsavel;
        OsResponsavel osResponsavel;
        rsOsResponsavel = dados.busca(sql);
        try {
            while (rsOsResponsavel.next()) {
                osResponsavel = new OsResponsavel(rsOsResponsavel.getInt(1));
                listOsResponsavel.add(osResponsavel);
            }
        } catch (SQLException ex) {
            System.err.println("Erro SQL busca osResponsavels: " + ex);
        } catch (Exception e) {
            System.err.println("Erro geral busca osResponsavels: " + e);
        }
        return listOsResponsavel;
    }
    
    public ArrayList<OsResponsavel> selectAll() {
        String sql = "SELECT id FROM os_responsavel ORDER BY id DESC";
        return buscaGeral(sql);
    }
    
}
