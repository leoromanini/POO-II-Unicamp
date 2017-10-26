package ordem_servico.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OsHardware extends Os implements Serializable{

    private String reclamacao;
    private Float maoObra;

    public OsHardware() {
        setIdTipo(1);
    }

    public OsHardware(Integer id) throws SQLException {
        super(id);
        ResultSet rs = dados.busca("SELECT * FROM os_hardware WHERE id_os= " + id.toString());
        if (rs.next()) {
            this.reclamacao = rs.getString(2);
            this.maoObra = rs.getFloat(3);
        }
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public Float getMaoObra() {
        return maoObra;
    }

    public void setMaoObra(Float maoObra) {
        this.maoObra = maoObra;
    }

    public boolean insertOsHardware() {
        return (insertOs() && dados.executa("INSERT INTO os_hardware(id_os,reclamacao,mao_obra) VALUES(" + getId() + ",'" + reclamacao + "'," + maoObra + ")"));
    }

    public boolean updateOsHardware() {
        return (updateOs() && dados.executa("UPDATE os_hardware SET reclamacao='" + reclamacao + "', mao_obra=" + maoObra + " WHERE id_os=" + getId()));
    }

    public boolean deleteOsHardware() {
        return (deleteOs() && dados.executa("DELETE FROM os_hardware WHERE id_os=" + getId()));
    }

    private ArrayList<Os> buscaGeral(String sql) throws SQLException {
        ArrayList<Os> listOsHardware = new ArrayList();
        ResultSet rsOsHardware;
        OsHardware osHardware;
        rsOsHardware = dados.busca(sql);
        while (rsOsHardware.next()) {
            osHardware = new OsHardware(rsOsHardware.getInt(1));
            listOsHardware.add(osHardware);
        }
        return listOsHardware;
    }

    @Override
    public ArrayList<Os> selectAll() throws SQLException {
        String sql = "SELECT id FROM os WHERE id_tipo = 1 ORDER BY id DESC";
        return buscaGeral(sql);
    }

}
