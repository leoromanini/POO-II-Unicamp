package ordem_servico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OsSoftware extends Os{
    private String gitLink;
    
    public OsSoftware(){
        setIdTipo(2);
    }
    
    public OsSoftware(Integer id){
        super(id);
        try{
            ResultSet rs = dados.busca("SELECT * FROM os_software WHERE id_os= " + id.toString());
            if (rs.next()){
                this.gitLink = rs.getString(2);
            }
        }catch(SQLException ex){
            System.err.println("Erro SQL: " + ex);
        }catch(Exception e){
            System.err.println("Erro geral na criação de OsSoftware: " + e);
        }        
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }
    
    public boolean insertOsSoftware() {
        return (insertOs() && dados.executa("INSERT INTO os_software(id_os,git_link) VALUES("+getId()+",'"+gitLink+"')"));
    }

    public boolean updateOsSoftware() {
        return (updateOs() && dados.executa("UPDATE os_software SET git_link='"+gitLink+"' WHERE id_os="+getId()));
    }

    public boolean deleteOsSoftware() {
        return (deleteOs() && dados.executa("DELETE FROM os_software WHERE id_os=" + getId()));
    }
        
    private ArrayList<Os> buscaGeral(String sql){
        ArrayList<Os> listOsSoftware = new ArrayList();
        ResultSet rsOsSoftware;
        OsSoftware osSoftware;
        rsOsSoftware = dados.busca(sql);
        try {
            while (rsOsSoftware.next()) {
                osSoftware = new OsSoftware(rsOsSoftware.getInt(1));
                listOsSoftware.add(osSoftware);
            }
        } catch (SQLException ex) {
            System.err.println("Erro SQL busca osSoftwares: " + ex);
        } catch (Exception e) {
            System.err.println("Erro geral busca osSoftwares: " + e);
        }
        return listOsSoftware;
    }
    
    @Override
    public ArrayList<Os> selectAll() {
        String sql = "SELECT id_os FROM os_software ORDER BY id_os DESC";
        return buscaGeral(sql);
    }
    
}
