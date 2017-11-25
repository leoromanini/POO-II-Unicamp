package ordem_servico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Os implements Serializable{

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
    protected transient Dados dados = new Dados();
    private transient final String arquivo = "os.txt";

    public Os() {

    }

    public Os(Integer id) {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Os os;
        for(Object objeto:listaObj){
            os = (Os) objeto;
            if(Objects.equals(os.getId(), id)){
                this.id = os.id;
                this.titulo = os.titulo;
                this.dataAbertura = os.dataAbertura;
                this.prazo = os.prazo;
                this.dataFinalizado = os.dataFinalizado;
                this.servico = os.servico;
                this.total = os.total;
                this.idTipo = os.idTipo;
                this.idUsuario = os.idUsuario;
                this.idCliente = os.idCliente;
            }
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

    public void setIdTipo(Integer idTipo) {
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

    public boolean insertOs() {
        ArrayList<Object> listaAtual = dados.lerTodos(arquivo);
        this.setId(listaAtual.size()+1);
        listaAtual.add(this);
        return dados.escrever(arquivo, listaAtual);
    }

    public boolean updateOs() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Os os;
        for(Object objeto:listaObj){
            os = (Os) objeto;
            if(os.getId().equals(this.id)){
                listaObj.remove(objeto);
                listaObj.add(this);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    public boolean deleteOs() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        Os os;
        for(Object objeto:listaObj){
            os = (Os) objeto;
            if(os.getId().equals(this.id)){
                listaObj.remove(objeto);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    public ArrayList<Os> selectAll(){
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<Os> listaOs = new ArrayList();
        for(Object objeto:listaObj){
            listaOs.add((Os) objeto);
        }
        return listaOs;
    }

}
