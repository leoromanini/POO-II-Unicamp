package ordem_servico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class OsHardware extends Os implements Serializable{

    private String reclamacao;
    private Float maoObra;
    private transient final String arquivo = "osHardware.txt";

    public OsHardware() {
        setIdTipo(1);
    }

    public OsHardware(Integer id){
        super(id);
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        OsHardware os;
        for(Object objeto:listaObj){
            os = (OsHardware) objeto;
            if(Objects.equals(os.getId(), id)){
                this.reclamacao = os.reclamacao;
                this.maoObra = os.maoObra;
            }
        }
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public Float getMaoObra() {
        return maoObra;
    }

    public void setMaoObra(Float maoObra) {
        this.maoObra = maoObra;
    }

    public boolean insertOsHardware() {
        ArrayList<Object> listaAtual = dados.lerTodos(arquivo);
        listaAtual.add(this);
        return dados.escrever(arquivo, listaAtual);
    }

    public boolean updateOsHardware() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        OsHardware os;
        for(Object objeto:listaObj){
            os = (OsHardware) objeto;
            if(os.getId().equals(this.getId())){
                listaObj.remove(objeto);
                listaObj.add(this);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    public boolean deleteOsHardware() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        OsHardware os;
        for(Object objeto:listaObj){
            os = (OsHardware) objeto;
            if(os.getId().equals(this.getId())){
                listaObj.remove(objeto);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Os> selectAll() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<Os> listaOsHardware = new ArrayList();
        for(Object objeto:listaObj){
            listaOsHardware.add((Os) objeto);
        }
        return listaOsHardware;
    }

}
