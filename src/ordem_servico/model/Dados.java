package ordem_servico.model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Dados{

    public Dados() {
       
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
