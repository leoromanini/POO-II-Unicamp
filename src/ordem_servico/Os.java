/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_servico;

/**
 *
 * @author Leonardo
 */
public class Os {
    
    private String objeto;
    private String descricao;
    private String avarias;
    private String desc_serv;
    private String observacao;
    private Servico[] servicos;
    private Produto[] produtos;

    public Os(String objeto, String descricao, String avarias, String desc_serv, String observacao, Servico[] servicos) {
        this.objeto = objeto;
        this.descricao = descricao;
        this.avarias = avarias;
        this.desc_serv = desc_serv;
        this.observacao = observacao;
        this.servicos = servicos;
        this.produtos = produtos;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAvarias() {
        return avarias;
    }

    public void setAvarias(String avarias) {
        this.avarias = avarias;
    }

    public String getDesc_serv() {
        return desc_serv;
    }

    public void setDesc_serv(String desc_serv) {
        this.desc_serv = desc_serv;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Servico[] getServicos() {
        return servicos;
    }

    public void setServicos(Servico[] servicos) {
        this.servicos = servicos;
    }
    
    public Produto[] getProduto() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }
    
    
    
    
}
