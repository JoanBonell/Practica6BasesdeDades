/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sergiosayago
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertHandler {
    
    public static Statement stmt = null;
    
    public String getDataNewBranch(String id, String street, String city, String postcode){
        String sql = "INSERT INTO branch (branch_id, street, city, postcode) "
        
                + "VALUES (" + 
                
                "'" + id + "'"
                
                + "," + 
                
                "'" + street + "'"
                
                + "," +
                
                "'" + city + "'"
                
                + "," +
                
                "'" + postcode + "'" +
                
                ");";
        
        System.out.println(sql);
        
        return sql;
    }
    
    public void executeUpdate(String sql, Connection c) throws SQLException{
        stmt = c.createStatement();
        stmt.executeUpdate(sql);        
    }
    
}
