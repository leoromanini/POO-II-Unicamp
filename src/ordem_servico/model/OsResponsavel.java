package ordem_servico.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OsResponsavel implements Serializable{

    private Integer id;
    private Integer idUsuario;
    private Integer idOs;
    private String data;
    private transient Dados dados = new Dados();

    public OsResponsavel() {

    }

    public OsResponsavel(Integer id) throws SQLException {
        ResultSet rs = dados.busca("SELECT * FROM os_responsavel WHERE id= " + id.toString());
        if (rs.next()) {
            this.id = rs.getInt(1);
            this.idUsuario = rs.getInt(2);
            this.idOs = rs.getInt(3);
            this.data = rs.getString(4);
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
        return (dados.executa("INSERT INTO os_responsavel(id_usuario,id_os,data) VALUES(" + idUsuario + "," + idOs + ",'" + data + "')"));
    }

    private ArrayList<OsResponsavel> buscaGeral(String sql) throws SQLException {
        ArrayList<OsResponsavel> listOsResponsavel = new ArrayList();
        ResultSet rsOsResponsavel;
        OsResponsavel osResponsavel;
        rsOsResponsavel = dados.busca(sql);
        while (rsOsResponsavel.next()) {
            osResponsavel = new OsResponsavel(rsOsResponsavel.getInt(1));
            listOsResponsavel.add(osResponsavel);
        }
        return listOsResponsavel;
    }

    public ArrayList<OsResponsavel> selectAll() throws SQLException {
        String sql = "SELECT id FROM os_responsavel ORDER BY id DESC";
        return buscaGeral(sql);
    }

}
