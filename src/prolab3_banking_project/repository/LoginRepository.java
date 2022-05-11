/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.repository;

import java.sql.Connection;
import prolab3_banking_project.databaseconnection.DatabaseConnection;
import prolab3_banking_project.model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author erene
 */
public class LoginRepository {
    
    private final Connection con=DatabaseConnection.getCon();
    
    public Customer login(Long customerNumber,String password){
        String sql= "SELECT * FROM EMREKAYA.CUSTOMER WHERE ID=? AND PASSWORD=?";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,customerNumber);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                Customer customer = new Customer();
                customer.setCustomerNumber(rs.getLong("ID"));
                customer.setPassword(rs.getString("PASSWORD"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setAddress(rs.getString("ADRESS"));
                customer.setBirthDate(rs.getDate("BIRTHDATE"));
                customer.setGender(rs.getBoolean("GENDER"));
                customer.setIdentityNumber(rs.getString("IDENTITYNUMBER"));
                customer.setPhone(rs.getString("PHONE"));
                customer.setEmail(rs.getString("EMAIL"));
                
                return customer;
            }
            else{
                return null;
            }
            
        }catch(SQLException ex){
            return null;
        }
    }
    
    
}
