package ordem_servico.model;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
    protected String nome;
    
    protected abstract String getNome();
    protected abstract void setNome(String nome);
}
