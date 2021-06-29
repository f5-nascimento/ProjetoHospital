
package factory;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class conexao {
    
    public Connection getConnection(){
        
        try{
         
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useTimezone=true&serverTimezone=UTC","root","kernel255");

    
} catch(SQLException excecao){
    
    throw new RuntimeException(excecao);
    
}
    }
}
    
   
     
                
    
    
    
    