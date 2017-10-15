package ordem_servico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Compra {

    private Integer id;
    private Integer qtd;
    private Float total;
    private Integer idProduto;
    private Dados dados = new Dados();

    public Compra() {

    }

    public Compra(Integer id) throws SQLException {
        ResultSet rs = dados.busca("SELECT * FROM compra WHERE id= " + id.toString());
        if (rs.next()) {
            this.id = rs.getInt(1);
            this.qtd = rs.getInt(2);
            this.total = rs.getFloat(3);
            this.idProduto = rs.getInt(4);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setId_produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public boolean insertCompra() {
        return (dados.executa("INSERT INTO compra(qtd,total,id_produto) VALUES(" + qtd + "," + total + "," + idProduto + ")"));
    }

    public boolean updateCompra() {
        return (dados.executa("UPDATE compra SET qtd=" + qtd + ", total=" + total + ", id_produto=" + idProduto + " WHERE id=" + id));
    }

    public boolean deleteCompra() {
        return (dados.executa("DELETE FROM compra WHERE id=" + id));
    }

    private ArrayList<Compra> buscaGeral(String sql) throws SQLException {
        ArrayList<Compra> listCompra = new ArrayList();
        ResultSet rsCompra;
        Compra compra;
        rsCompra = dados.busca(sql);
        while (rsCompra.next()) {
            compra = new Compra(rsCompra.getInt(1));
            listCompra.add(compra);
        }
        return listCompra;
    }

    public ArrayList<Compra> selectAll() throws SQLException {
        String sql = "SELECT id FROM compra ORDER BY id DESC";
        return buscaGeral(sql);
    }

}
