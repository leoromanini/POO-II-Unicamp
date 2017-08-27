package ordem_servico;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class ConectorSqlServer {
    Connection con;
    CallableStatement cst;
    String nombre_BD;
    String usuario="sa";
    String pass="roma@2016";
    public ConectorSqlServer() {
        nombre_BD="os";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-R2GFFSM:1433;databasename="+nombre_BD+";"+"user="+usuario+";password="+pass);
            System.out.println("Conexão ao banco de dados existente");
        }catch (ClassNotFoundException | SQLException e){
                  System.out.println("Erro ao efetuar a conexão com o banco de daods");
            JOptionPane.showMessageDialog(null,"Erro na conexão com o banco de dados");
        }
    }
    public Connection getCon() {
        return con;
    }
    public CallableStatement getCst() {
        return cst;
    }
    public boolean Conectar(){   // retorna -1 si hubo un error
        boolean retorno=false;
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-R2GFFSM:1433;databasename="+nombre_BD+";"+"user="+usuario+";password="+pass);
            retorno = true;
        }catch (ClassNotFoundException | SQLException e){
            retorno = false;
        }
        return retorno;
    }
    public int Desconectar(){   // retorna -1 si hubo un error
        try {
            con.close();
            return 0;
        } catch (SQLException ex) {
            return -1;
        }
    }
    
    /// EJECUTORES /////
    public int Insert(String Tabla,String argumentos[]){  //devuelve -1 si hubo error y si un argumento es char o varchar debe ir entre comilla simple ej: "'hola'"
    //en caso de entero se debe mandar v[n]=String.valueOf(entero);
    // si es un String el que se va a guardar v[n]="String";
    // si es fecha el formato es "'año/dia/mes'" ej: v[n]="'2013/27/2'";
        String sql="insert into "+Tabla+" values(";
        if(argumentos!=null){
           if(argumentos.length>0){ 
            sql=sql+argumentos[0];   
            for (int i = 1; i < argumentos.length; i++) {
                sql=sql+","+argumentos[i];
                
            }
            sql=sql+")";
            if(Conectar()==0){
                    try {
                       Statement stm = con.createStatement();
                       stm.execute(sql);
                       if(Desconectar()==0){
                           return 0;
                       }
                    } catch (Exception e) {
                        return -1;
                    }
            }
           }
        }
           return -1;
    }
    public int Modify(String Tabla,String Campo[],String valores[],String condicion){//devuelve -1 si hubo error y si un argumento es char o varchar debe ir entre comilla simple ej: "'hola'"
        String sql="update "+Tabla+" set ";
        if(condicion==null){
            condicion="";
        }else{
            if(!"".equals(condicion)){
                condicion=" where "+condicion;
            }
        }
        if(Campo!=null&&valores!=null){
           if(Campo.length>0&&valores.length==Campo.length){ 
            sql=sql+Campo[0]+"="+valores[0];   
            for (int i = 1; i <Campo.length; i++) {
                sql=sql+","+Campo[i]+"="+valores[i]; 
            }
            sql=sql+condicion;
            if(Conectar()==0){
                    try {
                       Statement stm = con.createStatement();
                       stm.execute(sql);
                       if(Desconectar()==0){
                           return 0;
                       }
                    } catch (Exception e) {
                        return -1;
                    }
            }
           }
        }
           return -1;
    }
   
    public int  Ejecutar_Sentencia(String sql){
      if(Conectar()==0){
        try {
             Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = null;
            stm.execute(sql);
            return 0;
         } catch (Exception e) {
             System.out.println("Error al Ejecutar Sentencia: "+sql);
             return -1;
         }
      }
      return -1;
    }
    public Object[] Consulta_simple(String sql){
        Object v[]=new Object[0];
      if(Conectar()==0){
        try {
             Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = null;
            rs = stm.executeQuery(sql);
            String a="";
            while(rs.next()){
                   v= agrandar_vec_object(v,rs.getObject(1));
            }
            if(Desconectar()==0){
                if(v.length!=0){
                    return v;
                }else{
                    return null;
                }
            }
        } catch (Exception e) {
            return null;
        }
      }
        return null;
    }
    public Object[] Consulta_Ayuda(String Tabla,String Campo,String condicion){
        if(condicion==null){
            condicion="";
        }else{
            if(!"".equals(condicion)){
                condicion=" where "+condicion;
            }
        }
        String sql="select "+Campo+" from "+Tabla+condicion;
        Object v[]=new Object[0];
      if(Conectar()==0){
        try {
             Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = null;
            rs = stm.executeQuery(sql);
            String a="";
            while(rs.next()){
                   v= agrandar_vec_object(v,rs.getObject(1));
            }
            if(Desconectar()==0){
                  return v;
            }
        } catch (Exception e) {
            return null;
        }
      }
        return null;
    }
    public DefaultTableModel Consulta_Tabla_Ayuda(String Tabla,String Campo[],String condicion){
        String sql="select ";
        if(condicion==null){
            condicion="";
        }else{
            if(!"".equals(condicion)){
                condicion=" where "+condicion;
            }
        }
        if(Campo!=null){    
            if(Campo.length>0){
                sql=sql+Campo[0];
                for (int i = 1; i < Campo.length; i++) {
                    sql=sql+","+Campo[i];
                }
                sql=sql+" from "+Tabla+condicion;
                if(Conectar()==0){
                    try {
                        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                        ResultSet rs = null;
                        rs = stm.executeQuery(sql);
                        DefaultTableModel modelo=new DefaultTableModel();
                        modelo=Imprimir(rs,modelo);
                        if(Desconectar()==0){
                            return modelo;
                        }
                    } catch (Exception e) {
                        return null;
                    }
                }
            }
        }
        return null;
    }
     public DefaultTableModel Consulta_Tabla_Simple(String sql){
                if(Conectar()==0){
                    try {
                        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                        ResultSet rs = null;
                        rs = stm.executeQuery(sql);
                        DefaultTableModel modelo=new DefaultTableModel();
                        modelo=Imprimir(rs,modelo);
                        if(Desconectar()==0){
                            return modelo;
                        }
                    } catch (Exception e) {
                        return null;
                    }
                }
        return null;
    }
    
    private Object[] agrandar_vec_object(Object v[],Object ele){
        Object m[]=new Object[v.length+1];
        System.arraycopy(v, 0, m, 0, v.length);
        m[v.length]=ele;
        return m;
    }
    private DefaultTableModel Imprimir(ResultSet res,DefaultTableModel modelo){

        int i;
        try {
        ResultSetMetaData rmeta = res.getMetaData();
        int numColumnas= rmeta.getColumnCount();
            for(i=1;i<=numColumnas;i++)
            {
            modelo.addColumn(rmeta.getColumnName(i));
            }
            while (res.next())
            {
            Object [] fila = new Object[numColumnas];
                for (i=0;i<numColumnas;i++)
                fila[i] = res.getObject(i+1);
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            return null;
        }
        return modelo;
    }
}
