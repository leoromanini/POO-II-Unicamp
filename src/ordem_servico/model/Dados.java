package ordem_servico.model;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

public class Dados{
    private Connection con;

    public Dados() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + "172.245.248.177:3306" + "/" + "faculdade_01",
                    "faculdade_01", "_facul01_");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro de Dados nas dependencias da conexão. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de Dados na criação da conexão. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro de Dados geral de conexão. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean executa(String query) {
        boolean retorno;
        try {
            PreparedStatement stmt = (PreparedStatement) this.con
                    .prepareStatement(query);
            stmt.execute();
            stmt.close();
            retorno = true;
        } catch (SQLException ex) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro de Dados ao executar comando. Para nerds: "+ex, "Ops", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro de Dados geral ao executar o comando. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }

    public ResultSet busca(String consulta) {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(consulta);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de Dados ao tentar executar busca. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de Dados geral na busca. Para nerds: "+e, "Ops", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
}
