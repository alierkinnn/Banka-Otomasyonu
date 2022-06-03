/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import prolab3_banking_project.databaseconnection.DatabaseConnection;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.CustomerRepresenter;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.serviceImpl.CustomerRepresenterServiceImpl;
import prolab3_banking_project.session.CustomerRepresenterSession;





/**
 *
 * @author Ali Erkin
 */
public class CustomerRepresenterLoginRepository {
    
    private final Connection con=DatabaseConnection.getCon();
    private CustomerRepresenterSession customerRepresenterSession = new CustomerRepresenterSession();
    private CustomerRepresenterServiceImpl customerRepresenterService = new CustomerRepresenterServiceImpl();
    
    public CustomerRepresenter login(Long id,String password){
        String sql= "SELECT * FROM EMREKAYA.REPRESENTER WHERE ID=? AND PASSWORD=?";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,id);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                CustomerRepresenter customerRepresenter = new CustomerRepresenter();
           
                customerRepresenter.setId(rs.getLong("id"));
                customerRepresenter.setName(rs.getString("name"));
                customerRepresenter.setSurname(rs.getString("surname"));
                customerRepresenter.setPhone(rs.getString("phone"));
                customerRepresenter.setPassword(rs.getString("password"));
                
                
                return customerRepresenter;
            }
            else{
                return null;
            }
            
        }catch(SQLException ex){
            return null;
        }
    }
    
    
}
