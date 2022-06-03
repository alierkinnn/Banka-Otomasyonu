/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prolab3_banking_project.service;

import prolab3_banking_project.model.Manager;
import prolab3_banking_project.model.ResponseModel;

/**
 *
 * @author Ali Erkin
 */
public interface ManagerLoginService {
    
    ResponseModel<Manager> login(Long id,String password);
    
}
