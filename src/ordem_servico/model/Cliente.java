package ordem_servico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente {

    private Integer id;
    private String nome;
    private String nascimento;
    private String cpf;
    private String telefone;
    private String celular;
    private String endereco;
    private Dados dados = new Dados();

    public Cliente() {

    }

    public Cliente(Integer id) {
        try {
            ResultSet rs = dados.busca("SELECT * FROM cliente WHERE id= " + id.toString());
            if (rs.next()) {
                this.id = rs.getInt(1);
                this.nome = rs.getString(2);
                this.nascimento = rs.getString(3);
                this.cpf = rs.getString(4);
                this.telefone = rs.getString(5);
                this.celular = rs.getString(6);
                this.endereco = rs.getString(7);
            }
        } catch (SQLException ex) {
            System.err.println("Erro SQL: " + ex);
        } catch (Exception e) {
            System.err.println("Erro geral na criação de Cliente: " + e);
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNascimento() {
        return this.nascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }    

    public boolean insertCliente() {
        return (dados.executa("INSERT INTO cliente(nome,nascimento,cpf,telefone,celular,endereco) VALUES"
                + "('" + nome + "','" + nascimento + "','" + cpf + "','" + telefone + "','" + celular + "','" + endereco + "')"));
    }

    public boolean updateCliente() {
        return (dados.executa("UPDATE cliente SET nome='" + nome + "', nascimento='" + nascimento + "',"
                + " cpf='" + cpf + "', telefone='" + telefone + "', celular='" + celular + "',"
                + " endereco='" + endereco + "' WHERE id=" + id));
    }

    public boolean deleteCliente() {
        return (dados.executa("DELETE FROM cliente WHERE id=" + id));
    }
        
    private ArrayList<Cliente> buscaGeral(String sql){
        ArrayList<Cliente> listCliente = new ArrayList();
        ResultSet rsCliente;
        Cliente cliente;
        rsCliente = dados.busca(sql);
        try {
            while (rsCliente.next()) {
                cliente = new Cliente(rsCliente.getInt(1));
                listCliente.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro SQL busca clientes: " + ex);
        } catch (Exception e) {
            System.err.println("Erro geral busca clientes: " + e);
        }
        return listCliente;
    }
    
    public ArrayList<Cliente> selectAll() {
        String sql = "SELECT id FROM cliente ORDER BY id DESC";
        return buscaGeral(sql);
    }
    
    public ArrayList<Cliente> selectByNome(String nome){
        String sql = "SELECT id FROM cliente WHERE nome LIKE '%"+nome+"%' ORDER BY id DESC";
        return buscaGeral(sql);
    }
    
    
}
