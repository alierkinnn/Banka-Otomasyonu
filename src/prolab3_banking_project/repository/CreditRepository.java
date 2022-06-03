/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.repository;

import prolab3_banking_project.databaseconnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import prolab3_banking_project.model.Account;
import prolab3_banking_project.model.Credit;
import prolab3_banking_project.model.CustomerRepresenter;
/**
 *
 * @author erene
 */
public class CreditRepository {
    
    private Connection con=DatabaseConnection.getCon();
    private CustomerRepository customerRepository = new CustomerRepository();
    
    public Credit krediEkle(Credit credit){
        String sql = "INSERT INTO CREDIT(MAINAMOUNT,TOTALAMOUNT,CURRENTAMOUNT,INTERESTRATE,EXPIRY,APPROVAL,CUSTOMERNUMBER)"+
                "VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setDouble(1,credit.getMainAmount());
            ps.setDouble(2,credit.getTotalAmount());
            ps.setDouble(3,credit.getCurrentAmount());
            ps.setDouble(4,credit.getInterestRate());
            ps.setDate(5,null);
            ps.setInt(6,0);
            ps.setLong(7,credit.getCustomerNumber());
            ps.executeUpdate();
            
        }catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return credit;
    }
    
    public List<Credit> basvuruGoruntule(CustomerRepresenter representer){
        String sql = "SELECT * FROM CUSTOMER INNER JOIN CREDIT ON CREDIT.CUSTOMERNUMBER=CUSTOMER.CUSTOMERNUMBER WHERE REPRESENTERID = ?";
        PreparedStatement ps=null;
        List<Credit> list= new ArrayList<>();
        ResultSet rs=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setLong(1,representer.getId());
            rs=ps.executeQuery();
            while(rs.next()){
                Credit credit=new Credit();
                credit.setCurrentAmount(rs.getDouble("CURRENTAMOUNT"));
                credit.setInterestRate(rs.getDouble("INTERESTRATE"));
                credit.setTotalAmount(rs.getDouble("TOTALAMOUNT"));
                credit.setMainAmount(rs.getDouble("MAINAMOUNT"));
                credit.setApproval(rs.getInt("APPROVAL"));
                credit.setCustomer(customerRepository.findByCustomerId(rs.getLong("CUSTOMERNUMBER")));
                credit.setCustomerNumber(rs.getLong("ACCOUNTID"));
                credit.setId(rs.getLong("ID"));

                list.add(credit);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    }

