
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sergiosayago
 */
public class QueryHandler {
    
    private static Statement stmt = null;
    private static ResultSet rs = null;
    
    public ResultSet executeQuery (Connection con, String query) throws SQLException{
        stmt = con.createStatement();            
        rs = stmt.executeQuery(query);           
        return rs;
    }
    
}
