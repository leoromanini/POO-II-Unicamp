package ordem_servico;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

//se o titular quiser alocar, limpar antigos dependentes no focus off, id livro n nome

public class dados{
    Connection con;
    public boolean conecta(){
        boolean retorno=false;
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                ("jdbc:mysql://"+"172.245.248.177:3306"+"/"+"faculdade_01",
                "faculdade_01","_facul01_");
            retorno = true;
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Erro de conexão:\n"+e);
        }
        catch(SQLException e)
        {
            System.err.println("Erro de conexão:\n"+e);
        }
        return retorno;
    } 
       
    
    public boolean insere(String tabela, String  cpf, String rg, String nome, String endereco, String cidade,
            String telefone, String celular, String nascimento, String email, String observacao){
        boolean retorno = false;
        try{
            PreparedStatement stmt = (PreparedStatement) this.con
                    .prepareStatement("insert into " + tabela + " (cpf,rg,nome,endereco,cidade,telefone,celular,nascimento,email,observacao) "
                            + "values ('" +cpf+ "','" +rg+ "','" +nome+ "','" +endereco+ "','" +cidade+ "','" +telefone+ "','" +celular+ "','" +nascimento+ "','" +email+ "','" +observacao+ "');");
         
            stmt.execute();
            stmt.close();
            retorno = true;
            JOptionPane.showMessageDialog(null,"CADASTRADO COM SUCESSO","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException ex){
            retorno = false;
            System.err.println("Erro INSERT:" +ex);
            JOptionPane.showMessageDialog(null,"ERRO AO CADASTRAR","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        return retorno;        
    }    
    
    public boolean insere_estoque(String tabela, String  cod_produto, String cor, int quantidade, String tamanho){
        boolean retorno = false;
        try{
            PreparedStatement stmt = (PreparedStatement) this.con
                    .prepareStatement("insert into " + tabela + " (cod_produto,cor,quantidade,tamanho) "
                            + "values ('" +cod_produto+ "','" +cor+ "'," +quantidade+ ",'" +tamanho+ "');");
         
            stmt.execute();
            stmt.close();
            retorno = true;
            //JOptionPane.showMessageDialog(null,"CADASTRADO COM SUCESSO","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException ex){
            retorno = false;
            System.err.println("Erro INSERT:" +ex);
            JOptionPane.showMessageDialog(null,"ERRO AO CADASTRAR","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        return retorno;        
    }  
    
        public boolean insere_produto(String tabela, String  categoria, String referencia, String descricao, String valorc,String margem,String valorv){
        boolean retorno = false;
        try{
            PreparedStatement stmt = (PreparedStatement) this.con
                    .prepareStatement("insert into " + tabela + " (categoria,referencia,descricao,valor_compra,margem,valor_venda) "
                            + "values ('" +categoria+ "','" +referencia+ "','" +descricao+ "','" +valorc+ "','" +margem+ "','" +valorv+ "');");
         
            stmt.execute();
            stmt.close();
            retorno = true;
            JOptionPane.showMessageDialog(null,"CADASTRADO COM SUCESSO","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException ex){
            retorno = false;
            System.err.println("Erro INSERT:" +ex);
            JOptionPane.showMessageDialog(null,"ERRO AO CADASTRAR","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        return retorno;        
    } 
    
      
    public ResultSet consulta(String consulta){
        ResultSet rs = null;
        try{
            PreparedStatement stmt=(PreparedStatement)
            this.con.prepareStatement(consulta);
            rs=stmt.executeQuery();
        }catch(Exception e){
            System.err.println("Erro CONSULTA:" +e);
            //JOptionPane.showMessageDialog(null,"NENHUM REGISTRO ENCONTRADO","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        return rs;
    }    
    public boolean atualiza(String tabela, String campos, String condicao){
        boolean retorno = false;
        try{
            PreparedStatement stmt = (PreparedStatement) this
                    .con
                    .prepareStatement("update " + tabela + " set " + campos + 
                                      " where " + condicao);
            stmt.execute();
            stmt.close();
            retorno = true;
            
            JOptionPane.showMessageDialog(null,"ATUALIZADO COM SUCESSO","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            retorno = false;
            System.out.println("Erro UPDATE: " +ex);
            
        }
        return retorno;
    }    
    public boolean exclui(String tabela,String condicao){
        boolean retorno = false;
        try{
            PreparedStatement stmt = (PreparedStatement) this
                    .con
                    .prepareStatement("delete from " + tabela +
                                      " where " + condicao);
            stmt.execute();
            stmt.close();
            retorno = true;
            //JOptionPane.showMessageDialog(null,"REGISTRO EXCLUIDO","Aviso", JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch (SQLException ex){
            retorno = false;
            //JOptionPane.showMessageDialog(null,"FALHA AO EXCLUIR","Aviso", JOptionPane.INFORMATION_MESSAGE);
            System.err.println("Erro DELETE:" +ex);
        }
        return retorno;
            }
}
