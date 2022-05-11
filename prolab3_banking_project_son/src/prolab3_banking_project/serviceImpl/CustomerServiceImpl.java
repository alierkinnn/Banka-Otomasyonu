/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;

import java.util.List;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.model.Transaction;
import prolab3_banking_project.repository.CustomerRepository;
import prolab3_banking_project.service.CustomerService;
import prolab3_banking_project.session.CustomerSession;

/**
 *
 * @author erene
 */
public class CustomerServiceImpl implements CustomerService{
    
    private CustomerRepository customerrepository = new CustomerRepository();

    @Override
    public ResponseModel<List<Transaction>> ozetGoruntule(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseModel<Customer> bilgiGuncelle(String email, String phone, String adress) {
        Customer customer = new Customer();
        ResponseModel responseModel = new ResponseModel();
        customer = null;
        customer = customerrepository.bilgiGuncelle(CustomerSession.getCustomer().getCustomerNumber(), email, phone, adress);
        if(customer==null){
            responseModel.setSuccess(false);
            responseModel.setMessage("İşlem Başarısız");
        }
        else{
            responseModel.setSuccess(true);
            responseModel.setMessage("İşlem Başarılı");
            CustomerSession.setCustomer(customer);
        }
        
        return responseModel;
    }

    @Override
    public ResponseModel<Customer> musteriEkle(Long id, String name, String surname, String phone, String adress, String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
