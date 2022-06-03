/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.repository;

import java.sql.Connection;
import prolab3_banking_project.databaseconnection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.session.CustomerSession;

public class CustomerRepository {
    
    private Connection con=DatabaseConnection.getCon();
     
    public Customer findByCustomerId(Long customerNumber){
        String sql="SELECT * FROM CUSTOMER WHERE CUSTOMERNUMBER=?";
        Customer customer = new Customer(); 
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, customerNumber);            
            rs=ps.executeQuery();
            if(rs.next()){
                customer.setCustomerNumber(rs.getLong("CUSTOMERNUMBER"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setAddress(rs.getString("ADRESS"));
                customer.setGender(rs.getBoolean("GENDER"));
                customer.setPhone(rs.getString("PHONE"));
                customer.setEmail(rs.getString("EMAIL"));
                return customer;
            }else{
                return null;
            }                
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;        
        }                               
    }
    
    public Customer bilgiGuncelle(Long customerNumber,String email,String phone,String adress){
        Customer customer = new Customer();
        String sql = "UPDATE CUSTOMER SET EMAIL=?,PHONE=?,ADRESS=? WHERE ID=?";
        
        PreparedStatement ps=null;
        customer = CustomerSession.getCustomer();
        customer.setEmail(email);
        customer.setAddress(adress);
        customer.setPhone(phone);
         try{
            ps=con.prepareStatement(sql);
            
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, adress);
            ps.setLong(4, customerNumber);
            ps.executeUpdate();

               
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;        
        }                  
        
    return customer;
    }
    
    public boolean musteriEkle(Long id, String name, String surname, String phone, String adress, String email, String password){
        Customer customer = new Customer();
        String sql = "INSERT INTO CUSTOMER(IDENTITYNUMBER,NAME,SURNAME,PHONE,ADRESS,EMAIL,PASSWORD,ID) VALUES (?,?,?,?,?,?,?,(SELECT MAX(ID)+1 FROM CUSTOMER))";
        
        PreparedStatement ps = null;
        try{
            ps=con.prepareStatement(sql);
            
            ps.setLong(1, id);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, phone);
            ps.setString(5,adress);
            ps.setString(6,email);
            ps.setString(7, password);
          
            ps.executeUpdate();
             
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;        
        }                  
        
    return true;
        
        
    }
    
}
