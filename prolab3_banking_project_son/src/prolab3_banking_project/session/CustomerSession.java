/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.session;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import prolab3_banking_project.model.Account;
import prolab3_banking_project.model.Credit;
import prolab3_banking_project.model.Customer;

/**
 *
 * @author erene
 */
public class CustomerSession {
    
   private static Customer customer;
   private static List<Credit> credit;
   private static List<Account> account;
   private static List<JFrame> parentFrame = new ArrayList<>(); 

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        CustomerSession.customer = customer;
    }

    public static List<Credit> getCredit() {
        return credit;
    }

    public static void setCredit(List<Credit> credit) {
        CustomerSession.credit = credit;
    }

    public static List<Account> getAccount() {
        return account;
    }

    public static void setAccount(List<Account> account) {
        CustomerSession.account = account;
    }

    public static List<JFrame> getParentFrame() {
        return parentFrame;
    }

    public static void setParentFrame(List<JFrame> parentFrame) {
        CustomerSession.parentFrame = parentFrame;
    }
    
    public static void clear(){
        customer = null;
        account = null;
        credit = null;
    }
   
   
    
}
