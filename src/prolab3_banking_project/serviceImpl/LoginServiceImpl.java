/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;

import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.repository.LoginRepository;
import prolab3_banking_project.service.LoginService;
import prolab3_banking_project.session.CustomerSession;


public class LoginServiceImpl implements LoginService{
    
    private LoginRepository loginRepository = new LoginRepository();
    
    public ResponseModel<Customer> login(Long customerNumber,String password){
            ResponseModel responsemodel = new ResponseModel();
            Customer customer = loginRepository.login(customerNumber,password);
            
            if(customer==null){
                responsemodel.setSuccess(false);
                responsemodel.setMessage("Giriş işlemi başarısız.");
                responsemodel.setResponseObject(customer);
            }
            else{
                responsemodel.setSuccess(true);
                responsemodel.setMessage("Giriş işlemi başarılı.");
                responsemodel.setResponseObject(customer);
            }
            CustomerSession.setCustomer(customer);
            return responsemodel;
    
    }    
    
    public void logout(){
        
        CustomerSession.clear();
        
    }
}
