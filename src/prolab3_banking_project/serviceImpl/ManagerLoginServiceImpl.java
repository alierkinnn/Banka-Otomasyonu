/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;

import prolab3_banking_project.model.Manager;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.repository.ManagerLoginRepository;
import prolab3_banking_project.service.ManagerLoginService;
import prolab3_banking_project.session.ManagerSession;

/**
 *
 * @author Ali Erkin
 */
public class ManagerLoginServiceImpl implements ManagerLoginService{
    
    private ManagerLoginRepository m = new ManagerLoginRepository();

    @Override
    public ResponseModel<Manager> login(Long id, String password) {
            ResponseModel responsemodel = new ResponseModel();
            Manager manager = m.login(id, password);
            
            if(manager==null){
                responsemodel.setSuccess(false);
                responsemodel.setMessage("Giriş işlemi başarısız.");
                responsemodel.setResponseObject(manager);
            }
            else{
                responsemodel.setSuccess(true);
                responsemodel.setMessage("Giriş işlemi başarılı.");
                responsemodel.setResponseObject(manager);
            }
            return responsemodel;
    }
    
    public void logout(){
        
        ManagerSession.clear();
        
    }
    
}
