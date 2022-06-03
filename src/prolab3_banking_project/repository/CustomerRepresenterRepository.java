package prolab3_banking_project.repository;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import prolab3_banking_project.databaseconnection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import prolab3_banking_project.model.Customer;



/**
 *
 * @author Ali Erkin
 */
public class CustomerRepresenterRepository {
    
    private Connection con=(Connection) DatabaseConnection.getCon();
    
    public int musteriSil(Customer customer){
        String sql ="DELETE FROM EMREKAYA.CUSTOMER WHERE ID=? AND REPRESENTERID=?";
        PreparedStatement ps=null;
        
        try{
            ps = con.prepareStatement(sql);
            ps.setLong(1,customer.getCustomerNumber());
            ps.setLong(2,customer.getRepresenterId());           
            return ps.executeUpdate();
           
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
   
    }
    
        public List<Customer> findByRepresenterId(Long representerId){
        String sql="SELECT * FROM CUSTOMER WHERE REPRESENTERID=?";
        List<Customer> list= new ArrayList<>(); 

        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, representerId);
            rs=ps.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setCustomerNumber(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                list.add(customer);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    
}
