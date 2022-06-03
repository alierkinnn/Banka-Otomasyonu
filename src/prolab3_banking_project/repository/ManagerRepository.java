/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.repository;

import java.sql.Connection;
import prolab3_banking_project.databaseconnection.DatabaseConnection;
import prolab3_banking_project.model.CustomerRepresenter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author erene
 */
public class ManagerRepository {
    
    private Connection con=DatabaseConnection.getCon();
    
    public boolean maasBelirle(Long salary){
        CustomerRepresenter representer = new CustomerRepresenter();
        String sql = "UPDATE REPRESENTER SET SALARY=?";
        
        PreparedStatement ps=null;
         try{
            ps=con.prepareStatement(sql);
            
            ps.setLong(1, salary);
            ps.executeUpdate();
               
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;        
        }                  
        
        
        return true;
    }
    
}
