package ordem_servico.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OsHardware extends Os{
    private String reclamacao;
    private Float maoObra;
    
    public OsHardware(){
        setIdTipo(1);
    }
    
    public OsHardware(Integer id){
        super(id);
        try{
            ResultSet rs = dados.busca("SELECT * FROM os_hardware WHERE id_os= " + id.toString());
            if (rs.next()){
                this.reclamacao = rs.getString(2);
                this.maoObra = rs.getFloat(3);
            }
        }catch(SQLException ex){
            System.err.println("Erro SQL: " + ex);
        }catch(Exception e){
            System.err.println("Erro geral na criação de OsHardware: " + e);
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
        return (insertOs() && dados.executa("INSERT INTO os_hardware(id_os,reclamacao,mao_obra) VALUES("+getId()+",'"+reclamacao+"',"+maoObra+")"));
    }

    public boolean updateOsHardware() {
        return (updateOs() && dados.executa("UPDATE os_hardware SET reclamacao='"+reclamacao+"', mao_obra="+maoObra+" WHERE id_os="+getId()));
    }

    public boolean deleteOsHardware() {
        return (deleteOs() && dados.executa("DELETE FROM os_hardware WHERE id_os=" + getId()));
    }
      
    private ArrayList<Os> buscaGeral(String sql){
        ArrayList<Os> listOsHardware = new ArrayList();
        ResultSet rsOsHardware;
        OsHardware osHardware;
        rsOsHardware = dados.busca(sql);
        try {
            while (rsOsHardware.next()) {
                osHardware = new OsHardware(rsOsHardware.getInt(1));
                listOsHardware.add(osHardware);
            }
        } catch (SQLException ex) {
            System.err.println("Erro SQL busca osHardwares: " + ex);
        } catch (Exception e) {
            System.err.println("Erro geral busca osHardwares: " + e);
        }
        return listOsHardware;
    }
    
    @Override
    public ArrayList<Os> selectAll() {
        String sql = "SELECT id_os FROM osHardware ORDER BY id_os DESC";
        return buscaGeral(sql);
    }
    
}
