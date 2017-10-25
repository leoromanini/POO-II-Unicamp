package ordem_servico.model;
public abstract class Pessoa {
    protected String nome;
    
    protected abstract String getNome();
    protected abstract void setNome(String nome);
}
