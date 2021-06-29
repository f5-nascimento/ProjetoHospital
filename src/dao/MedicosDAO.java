package dao;

import factory.conexao;
import model.Medicos;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class MedicosDAO {
    
    private Connection connection;
    int id_medicos;
    String nome_medicos;
    String crm_medicos;
    String especialidade_medicos;
    double salario_medicos;
    
    public MedicosDAO(){
       
        this.connection = new conexao().getConnection();
        
    }
    
    public void inserir(Medicos medicos){
    
        String sql = "INSERT INTO medicos(nome_medicos, crm_medicos, especialidade_medicos, salario_medicos) "
                + "VALUES(?,?,?,?)";
        
       try{
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, medicos.getNome_medicos());
           stmt.setString(2, medicos.getCrm_medicos());
           stmt.setString(3, medicos.getEspecialidade_medicos());
           stmt.setDouble(4, medicos.getSalario_medicos());
           stmt.execute();
           stmt.close();
           
           
           
       }
       catch(SQLException u){
           throw  new RuntimeException(u);
       } 
          
    }
    
    
    public Medicos consultar(Medicos medicos){
        
        Medicos consulta = new Medicos();
        String sql = "select nome_medicos, crm_medicos, especialidade_medicos,"
                + "salario_medicos from medicos where id_medicos = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,String.valueOf(medicos.getId_medicos()));
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                consulta.setNome_medicos(rs.getString(1));
                consulta.setCrm_medicos(rs.getString(2));
                consulta.setEspecialidade_medicos(rs.getString(3));
                consulta.setSalario_medicos(rs.getDouble(4));
            }
            else{
                consulta = null;
            }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return(consulta);
    }
        
    
    } 

    
    
        
    

    

