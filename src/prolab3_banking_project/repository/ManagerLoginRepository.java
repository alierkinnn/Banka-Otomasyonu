/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import prolab3_banking_project.databaseconnection.DatabaseConnection;
import prolab3_banking_project.model.Manager;


/**
 *
 * @author Ali Erkin
 */
public class ManagerLoginRepository {
    
    private final Connection con=DatabaseConnection.getCon();
    
    public Manager login(Long id,String password){
        String sql= "SELECT * FROM EMREKAYA.MANAGER WHERE ID=? AND PASSWORD=?";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
            try {
            ps=con.prepareStatement(sql);
            ps.setLong(1,id);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                Manager manager = new Manager();
                manager.setId(rs.getLong("id"));
                manager.setName(rs.getString("name"));
                manager.setSurname(rs.getString("surname"));
                manager.setPhone(rs.getString("phone"));
                manager.setPassword(rs.getString("password"));
    
                return manager;
            }
            else{
                return null;
            }
            
        }catch(SQLException ex){
            return null;
        }
        
    }
    
}
