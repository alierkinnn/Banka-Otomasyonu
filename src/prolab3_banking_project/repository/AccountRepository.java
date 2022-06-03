/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.repository;


import java.sql.Connection;
import prolab3_banking_project.databaseconnection.DatabaseConnection;
import prolab3_banking_project.model.Account;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.ResponseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class AccountRepository {
    
    private Connection con=DatabaseConnection.getCon(); 
    CustomerRepository customerrepository = new CustomerRepository();
    
    public int updateBalance(Account account){
        String sql="UPDATE ACCOUNT SET NAME = ?, IBAN= ?, BALANCE = ? WHERE ID = ?" ;  
        
        PreparedStatement ps;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,account.getName());
            ps.setString(2,account.getIban());
            ps.setDouble(3,account.getBalance());
            ps.setLong(4,account.getId());
            return ps.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }        
    }
    
    public int deleteAccount(Long id){
        
        String sql = "DELETE FROM ACCOUNT WHERE ID=?";
        
        PreparedStatement ps;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, id);
            return ps.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }  
        
    }
    
    public Account findByIban(String iban){
        String sql="SELECT * FROM ACCOUNT WHERE IBAN=?";
        Account account=new Account();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,iban);
            rs=ps.executeQuery();
            if(rs.next()){
                account.setId(rs.getLong("ID"));
                account.setBalance(rs.getDouble("BALANCE"));
                account.setName(rs.getString("NAME"));
                account.setIban(rs.getString("IBAN"));
                return account;
            }else{
                return null;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null; 
        }                        
       
    }
    public Account findById(Long id){
        String sql="SELECT * FROM ACCOUNT WHERE ID=?";
        Account account = new Account();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, id);            
            rs=ps.executeQuery();
            if(rs.next()){
                account.setId(rs.getLong("ID"));
                account.setBalance(rs.getDouble("BALANCE"));
                account.setName(rs.getString("NAME"));
                account.setIban(rs.getString("IBAN"));
                account.setCustomer(customerrepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER")));
                
                return account;
            }else{
                return null;
            }              
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;        
        }                               
    }
    public List<Account> findByCustomerId(Long customerNumber){
        String sql="SELECT * FROM ACCOUNT WHERE CUSTOMERNUMBER=?";
        List<Account> list= new ArrayList<>(); 

        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1, customerNumber);
            rs=ps.executeQuery();
            while(rs.next()){
                Account account = new Account();
                account.setId(rs.getLong("ID"));
                account.setBalance(rs.getDouble("BALANCE"));
                account.setName(rs.getString("NAME"));
                account.setIban(rs.getString("IBAN"));
                list.add(account);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
