package ordem_servico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
public class Cliente extends Pessoa implements Serializable{

    private Integer id;
    private String nascimento;
    private String cpf;
    private String telefone;
    private String celular;
    private String endereco;
    private transient final Dados dados = new Dados();
    private transient final String arquivo = "clientes.txt";

    public Cliente() {

    }

    public Cliente(Integer id) {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Cliente cliente;
        for(Object objeto:listaObj){
            cliente = (Cliente) objeto;
            if(Objects.equals(cliente.getId(), id)){
                this.id = cliente.id;
                this.nascimento = cliente.nascimento;
                this.cpf = cliente.cpf;
                this.telefone = cliente.telefone;
                this.celular = cliente.celular;
                this.endereco = cliente.endereco;
                this.nome = cliente.nome;
            }
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
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
        ArrayList<Object> listaAtual = dados.lerTodos(arquivo);
        this.setId(listaAtual.size()+1);
        listaAtual.add(this);
        return dados.escrever(arquivo, listaAtual);
    }

    public boolean updateCliente() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Cliente cliente;
        for(Object objeto:listaObj){
            cliente = (Cliente) objeto;
            if(cliente.getId().equals(this.id)){
                listaObj.remove(objeto);
                listaObj.add(this);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    public boolean deleteCliente() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Cliente cliente;
        for(Object objeto:listaObj){
            cliente = (Cliente) objeto;
            if(cliente.getId().equals(this.id)){
                listaObj.remove(objeto);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }
    
    public ArrayList<Cliente> selectAll()  {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<Cliente> listaCliente = new ArrayList();
        for(Object objeto:listaObj){
            listaCliente.add((Cliente) objeto);
        }
        return listaCliente;
    }
    
    public ArrayList<Cliente> selectByNome(String nome) {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<Cliente> listaCliente = new ArrayList();
        Cliente cliente;
        for(Object objeto:listaObj){
            cliente = (Cliente) objeto;
            if(cliente.getNome().equals(nome)){
                listaCliente.add((Cliente) objeto);                
            }
        }
        return listaCliente;
    }
    
    
}
