package ordem_servico.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Produto implements Serializable{

    private Integer id;
    private String nome;
    private Integer qtd;
    private Float precoSugerido;
    private transient Dados dados = new Dados();
    private transient final String arquivo = "produtos.txt";
    
    public Produto() {

    }

    public Produto(Integer id) {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Produto produto;
        for(Object objeto:listaObj){
            produto = (Produto) objeto;
            if(Objects.equals(produto.getId(), id)){
                this.id = produto.id;
                this.nome = produto.nome;
                this.qtd = produto.qtd;
                this.precoSugerido = produto.precoSugerido;
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Float getPrecoSugerido() {
        return precoSugerido;
    }

    public void setPrecoSugerido(Float precoSugerido) {
        this.precoSugerido = precoSugerido;
    }

    public boolean insertProduto() {
        ArrayList<Object> listaAtual = dados.lerTodos(arquivo);
        this.setId(listaAtual.size()+1);
        listaAtual.add(this);
        return dados.escrever(arquivo, listaAtual);
    }

    public boolean updateProduto() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Produto produto;
        for(Object objeto:listaObj){
            produto = (Produto) objeto;
            if(produto.getId().equals(this.id)){
                listaObj.remove(objeto);
                listaObj.add(this);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    public boolean deleteProduto() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Produto produto;
        for(Object objeto:listaObj){
            produto = (Produto) objeto;
            if(produto.getId().equals(this.id)){
                listaObj.remove(objeto);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    public ArrayList<Produto> selectAll() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<Produto> listaProduto = new ArrayList();
        for(Object objeto:listaObj){
            listaProduto.add((Produto) objeto);
        }
        return listaProduto;
    }

}
