package ordem_servico.model;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void criarArquivo(String nome){
        File arquivo = new File(nome);
        if (arquivo.exists() == false){
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro de Dados IO ao criar arquivo. Para nerds: "+ex, "Ops", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private boolean vazio(String nome){
        File arquivo = new File(nome);
        if (arquivo.exists() == false) {
            return true;
        }else{
            if(arquivo.length() > 0){
                return false;
            }else{
                return true;
            }
        }
    }
    
    public boolean escrever(String nome, ArrayList<Object> objetos){
        criarArquivo(nome);
        try{
            FileOutputStream fileOut = new FileOutputStream(nome);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(objetos);
            objOut.close();
            fileOut.close();
            return true;
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Erro de Dados IO ao escrever arquivo. Para nerds: "+ex, "Ops", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<Object> lerTodos(String nome){
        criarArquivo(nome);
        ArrayList<Object> listRetorno = new ArrayList();
        if(!vazio(nome)){
            try{
            FileInputStream fileIn = new FileInputStream(nome);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            listRetorno = (ArrayList) objIn.readObject();
            objIn.close();
            fileIn.close();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Erro de Dados IO ao ler arquivo. Para nerds: "+ex, "Ops", JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Erro de Dados Class ao ler arquivo. Para nerds: "+ex, "Ops", JOptionPane.ERROR_MESSAGE);
        }
        }
        return listRetorno;
    }
}
