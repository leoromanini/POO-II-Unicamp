package ordem_servico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class OsSoftware extends Os implements Serializable{

    private String gitLink;
    private transient final String arquivo = "osSoftware.txt";
    
    public OsSoftware() {
        setIdTipo(2);
    }

    public OsSoftware(Integer id) {
        super(id);
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        OsSoftware os;
        for(Object objeto:listaObj){
            os = (OsSoftware) objeto;
            if(Objects.equals(os.getId(), id)){
                this.gitLink = os.gitLink;
            }
        }
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    public boolean insertOsSoftware() {
        ArrayList<Object> listaAtual = dados.lerTodos(arquivo);
        this.setId(listaAtual.size()+1);
        listaAtual.add(this);
        return dados.escrever(arquivo, listaAtual);
    }

    public boolean updateOsSoftware() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        OsSoftware os;
        for(Object objeto:listaObj){
            os = (OsSoftware) objeto;
            if(os.getId().equals(this.getId())){
                listaObj.remove(objeto);
                listaObj.add(this);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    public boolean deleteOsSoftware() {
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        OsSoftware os;
        for(Object objeto:listaObj){
            os = (OsSoftware) objeto;
            if(os.getId().equals(this.getId())){
                listaObj.remove(objeto);
                return dados.escrever(arquivo, listaObj);
            }
        }
        return false;
    }

    @Override
    public ArrayList<Os> selectAll(){
        ArrayList<Object> listaObj = dados.lerTodos(arquivo);
        ArrayList<Os> listaOsSoftware = new ArrayList();
        for(Object objeto:listaObj){
            listaOsSoftware.add((Os) objeto);
        }
        return listaOsSoftware;
    }

}
