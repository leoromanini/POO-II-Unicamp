/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_servico;

import java.math.BigDecimal;

/**
 *
 * @author Leonardo
 */
public class Produto {
    
    private String descricao;
    private int quantidade;
    private String tipo;
    private BigDecimal valor_compra;
    private float margem;
    private BigDecimal valor_venda;

    public Produto(String descricao, int quantidade, String tipo, BigDecimal valor_compra, float margem, BigDecimal valor_venda) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.valor_compra = valor_compra;
        this.margem = margem;
        this.valor_venda = valor_venda;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(BigDecimal valor_compra) {
        this.valor_compra = valor_compra;
    }

    public float getMargem() {
        return margem;
    }

    public void setMargem(float margem) {
        this.margem = margem;
    }

    public BigDecimal getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(BigDecimal valor_venda) {
        this.valor_venda = valor_venda;
    }
    
}
