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
import java.util.ArrayList;
import java.util.List;
import prolab3_banking_project.model.Currency;

/**
 *
 * @author Ali Erkin
 */
public class CurrencyRepository {
    
    private Connection con=DatabaseConnection.getCon();
    
    public boolean newCurrency(String name,Double price){
        Currency currency = new Currency();
        String sql = "INSERT INTO CURRENCY(NAME,PRICE) VALUES (?,?)";
        
        PreparedStatement ps = null;
        
            try{
            ps=con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setDouble(2, price);
          
            ps.executeUpdate();
             
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;        
        }                  
        
        
        return true;
    }
    
    public List<Currency> allCurrencies(){
        String sql = "SELECT* FROM CURRENCY";
        List<Currency> list= new ArrayList<>(); 
        
        PreparedStatement ps=null;
        ResultSet rs=null;
            try{
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Currency currency = new Currency();
                currency.setName(rs.getString("NAME"));
                currency.setPrice(rs.getDouble("PRICE"));
                
                list.add(currency);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
  
    }
    
        public Currency bilgiGuncelle(String name,Double price){
        Currency currency = new Currency();
        String sql = "UPDATE CURRENCY SET PRICE=? WHERE NAME=?";
        
        PreparedStatement ps=null;
        currency.setPrice(price);
         try{
            ps=con.prepareStatement(sql);
            
            ps.setDouble(1, price);
            ps.setString(2, name);            
            ps.executeUpdate();
               
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;        
        }                  
        
    return currency;
    }
    
}
