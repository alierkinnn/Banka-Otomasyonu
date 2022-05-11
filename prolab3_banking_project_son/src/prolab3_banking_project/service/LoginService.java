/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prolab3_banking_project.service;

import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.ResponseModel;

/**
 *
 * @author erene
 */
public interface LoginService {
    
    ResponseModel<Customer> login(Long customerNumber,String password);
    
    
    
    
    
}
