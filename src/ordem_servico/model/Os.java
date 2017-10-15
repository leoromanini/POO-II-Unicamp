package ordem_servico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Os {

    private Integer id;
    private String titulo;
    private String dataAbertura;
    private String prazo;
    private String dataFinalizado;
    private String servico;
    private Float total;
    private Integer idTipo;
    private Integer idUsuario;
    private Integer idCliente;
    protected Dados dados = new Dados();

    public Os() {

    }

    public Os(Integer id) throws SQLException {
        ResultSet rs = dados.busca("SELECT * FROM os WHERE id= " + id.toString());
        if (rs.next()) {
            this.id = rs.getInt(1);
            this.titulo = rs.getString(2);
            this.dataAbertura = rs.getString(3);
            this.prazo = rs.getString(4);
            this.dataFinalizado = rs.getString(5);
            this.servico = rs.getString(6);
            this.total = rs.getFloat(7);
            this.idTipo = rs.getInt(8);
            this.idUsuario = rs.getInt(9);
            this.idCliente = rs.getInt(10);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(String dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    protected void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    protected boolean insertOs() {
        boolean retorno = (dados.executa("INSERT INTO os(titulo,data_abertura,prazo,data_finalizado,servico,total,id_tipo,id_usuario,id_cliente) "
                + "VALUES('" + titulo + "','" + dataAbertura + "','" + prazo + "','" + dataFinalizado + "','" + servico + "'," + total + "," + idTipo + "," + idUsuario + "," + idCliente + ")"));
        if (retorno) {
            setId(getIdInserido());
        }
        return retorno;
    }

    protected boolean updateOs() {
        return (dados.executa("UPDATE os SET titulo='" + titulo + "', data_abertura='" + dataAbertura + "', prazo='" + prazo + "', data_finalizado='" + dataFinalizado + "', "
                + "servico='" + servico + "', total=" + total + ", id_tipo=" + idTipo + ", id_usuario=" + idUsuario + ", id_cliente=" + idCliente + " WHERE id=" + id + ""));
    }

    protected boolean deleteOs() {
        return (dados.executa("DELETE FROM os WHERE id=" + id));
    }

    private int getIdInserido() {
        ResultSet rs;
        try {
            rs = dados.busca("SELECT id FROM os ORDER BY id DESC LIMIT 1");
            if (rs.next()) {
                return (rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.err.println("Erro SQL inserido os: " + ex);
        } catch (Exception e) {
            System.err.println("Erro SQL inserido os: " + e);
        }
        return 0;
    }

    private ArrayList<Os> buscaGeral(String sql) throws SQLException {
        ArrayList<Os> listOs = new ArrayList();
        ResultSet rsOs;
        Os os;
        rsOs = dados.busca(sql);
        while (rsOs.next()) {
            os = new Os(rsOs.getInt(1));
            listOs.add(os);
        }
        return listOs;
    }

    public ArrayList<Os> selectAll() throws SQLException {
        String sql = "SELECT id FROM os ORDER BY id DESC";
        return buscaGeral(sql);
    }

}
