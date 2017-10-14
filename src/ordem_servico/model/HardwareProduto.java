
package ordem_servico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HardwareProduto {
    private Integer id;
    private Integer idHardware;
    private Integer idProduto;
    private Integer qtd;
    private Float preco;
    private Float total;
    private Dados dados = new Dados();
    
    public HardwareProduto(){
                
    }
    
    public HardwareProduto(Integer id){
        try{
            ResultSet rs = dados.busca("SELECT * FROM hardware_produto WHERE id= " + id.toString());
            if (rs.next()){
                this.id = rs.getInt(1);
                this.idHardware = rs.getInt(2);
                this.idProduto = rs.getInt(3);
                this.qtd = rs.getInt(4);
                this.preco = rs.getFloat(5);
                this.total = rs.getFloat(6);
            }
        }catch(SQLException ex){
            System.err.println("Erro SQL: " + ex);
        }catch(Exception e){
            System.err.println("Erro geral na criação de HardwareProduto: " + e);
        }        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdHardware() {
        return idHardware;
    }

    public void setIdHardware(Integer idHardware) {
        this.idHardware = idHardware;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
    public boolean insertHardwareProduto() {
        return (dados.executa("INSERT INTO hardware_produto(id_hardware,id_produto,qtd,preco,total) VALUES("
                + idHardware+","+idProduto+","+qtd+","+preco+","+total+")"));
    }

    public boolean updateHardwareProduto() {
        return (dados.executa("UPDATE hardware_produto SET id_hardware="+idHardware+", id_produto="+idProduto+","
                + " qtd="+qtd+", preco="+preco+", total="+total+" WHERE id="+id));
    }

    public boolean deleteHardwareProduto() {
        return (dados.executa("DELETE FROM hardware_produto WHERE id=" + id));
    }
        
    private ArrayList<HardwareProduto> buscaGeral(String sql){
        ArrayList<HardwareProduto> listHardwareProduto = new ArrayList();
        ResultSet rsHardwareProduto;
        HardwareProduto hardwareProduto;
        rsHardwareProduto = dados.busca(sql);
        try {
            while (rsHardwareProduto.next()) {
                hardwareProduto = new HardwareProduto(rsHardwareProduto.getInt(1));
                listHardwareProduto.add(hardwareProduto);
            }
        } catch (SQLException ex) {
            System.err.println("Erro SQL busca hardwareProdutos: " + ex);
        } catch (Exception e) {
            System.err.println("Erro geral busca hardwareProdutos: " + e);
        }
        return listHardwareProduto;
    }
    
    public ArrayList<HardwareProduto> selectAll() {
        String sql = "SELECT id FROM hardware_produto ORDER BY id DESC";
        return buscaGeral(sql);
    }
}
