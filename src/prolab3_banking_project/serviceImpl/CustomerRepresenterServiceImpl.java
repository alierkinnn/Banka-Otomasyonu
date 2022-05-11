/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;

import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.service.CustomerRepresenterService;
import prolab3_banking_project.session.CustomerSession;

/**
 *
 * @author Ali Erkin
 */
public class CustomerRepresenterServiceImpl implements CustomerRepresenterService{

    @Override
    public ResponseModel<Customer> musteriEkle(Long id, String name, String surname, String phone, String adress, String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


    

