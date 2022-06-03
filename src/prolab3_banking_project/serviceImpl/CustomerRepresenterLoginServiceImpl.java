/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;

import prolab3_banking_project.model.CustomerRepresenter;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.repository.CustomerRepresenterLoginRepository;
import prolab3_banking_project.service.CustomerRepresenterLoginService;
import prolab3_banking_project.session.CustomerRepresenterSession;
import prolab3_banking_project.session.CustomerSession;

/**
 *
 * @author Ali Erkin
 */
public class CustomerRepresenterLoginServiceImpl implements CustomerRepresenterLoginService{
    
    private CustomerRepresenterLoginRepository c = new CustomerRepresenterLoginRepository();

    @Override
    public ResponseModel<CustomerRepresenter> login(Long id, String password) {
            ResponseModel responsemodel = new ResponseModel();
            CustomerRepresenter customerRepresenter = c.login(id, password);
            
            if(customerRepresenter==null){
                responsemodel.setSuccess(false);
                responsemodel.setMessage("Giriş işlemi başarısız.");
                responsemodel.setResponseObject(customerRepresenter);
            }
            else{
                responsemodel.setSuccess(true);
                responsemodel.setMessage("Giriş işlemi başarılı.");
                responsemodel.setResponseObject(customerRepresenter);
            }
            CustomerRepresenterSession.setRepresenter(customerRepresenter);
            return responsemodel;
    }
    
    public void logout(){
        
        CustomerRepresenterSession.clear();
        
    }
    
    
}
