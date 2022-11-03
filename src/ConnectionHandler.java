/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sergiosayago
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {
    
    public Connection getConnected() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");            
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/dreamhouse", "postgres", "");
        return c;        
    }
    
}
