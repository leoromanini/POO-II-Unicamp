package ordem_servico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class OsResponsavel implements Serializable{

    private Integer id;
    private Integer idUsuario;
    private Integer idOs;
    private String data;
    private transient Dados dados = new Dados();
    private transient final String arquivo = "osResponsavel.txt";

    public OsResponsavel() {

    }

    public OsResponsavel(Integer id){
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        OsResponsavel os;
        for(Object objeto:listaObj){
            os = (OsResponsavel) objeto;
            if(Objects.equals(os.getId(), id)){
                this.id = os.id;
                this.idUsuario = os.idUsuario;
                this.idOs = os.idOs;
                this.data = os.data;
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdOs() {
        return idOs;
    }

    public void setIdOs(Integer idOs) {
        this.idOs = idOs;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean insertOsResponsavel() {
        ArrayList<Object> listaAtual = dados.lerTodos(arquivo);
        this.setId(listaAtual.size()+1);
        listaAtual.add(this);
        return dados.escrever(arquivo, listaAtual);
    }

    public ArrayList<OsResponsavel> selectAll(){
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<OsResponsavel> listaOsResponsavel = new ArrayList();
        for(Object objeto:listaObj){
            listaOsResponsavel.add((OsResponsavel) objeto);
        }
        return listaOsResponsavel;
    }
    
    public ArrayList<OsResponsavel> selectByOs(Integer idOs){
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<OsResponsavel> listaOsResponsavel = new ArrayList();
        for(Object objeto:listaObj){
            OsResponsavel osResponsavel = (OsResponsavel) objeto;
            if(osResponsavel.getIdOs().equals(idOs)){
                listaOsResponsavel.add(osResponsavel);
            }
        }
        return listaOsResponsavel;
    }

}
