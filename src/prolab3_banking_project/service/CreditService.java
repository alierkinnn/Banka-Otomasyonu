/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.service;

import prolab3_banking_project.model.Credit;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.ResponseModel;

/**
 *
 * @author erene
 */
public interface CreditService {
    
    ResponseModel<Credit> krediTalep(Customer customer,Double amount,int expiry);
    
    ResponseModel<Boolean> krediOnay(Credit credit);
    
    ResponseModel<Boolean> krediRed(Credit credit);
    
    ResponseModel<Credit> krediBorcuOde(Credit account,String amount);
    
}
