/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import prolab3_banking_project.model.Account;
import prolab3_banking_project.model.Credit;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.CustomerRepresenter;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.repository.CreditRepository;
import prolab3_banking_project.repository.CustomerRepresenterRepository;
import prolab3_banking_project.service.CustomerRepresenterService;
import prolab3_banking_project.session.CustomerRepresenterSession;
import prolab3_banking_project.session.CustomerSession;

/**
 *
 * @author Ali Erkin
 */
public class CustomerRepresenterServiceImpl implements CustomerRepresenterService{
    
     private CustomerRepresenterRepository representerRepository = new CustomerRepresenterRepository();
     private CreditRepository creditRepository = new CreditRepository();
    
   

    @Override
    public ResponseModel<Customer> musteriEkle(Long id, String name, String surname, String phone, String adress, String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseModel<Boolean> musteriSil(Customer customer) {
        ResponseModel responseModel = new ResponseModel();
        
        if(representerRepository.musteriSil(customer)>0){
            responseModel.setSuccess(true);
            responseModel.setMessage("İşlem Başarılı");   
        }
        else{
            responseModel.setSuccess(false);
            responseModel.setMessage("İşlem Başarısız");        
        }
        
        return responseModel;
    }
    
        public ResponseModel<List<Customer>> kayitliMusteriler(){
        List<Customer> list=new ArrayList<>();        
        ResponseModel<List<Customer>> responsemodel=new ResponseModel<>();
        CustomerRepresenter representer = CustomerRepresenterSession.getRepresenter();
        list.addAll(representerRepository.findByRepresenterId(representer.getId()));
        CustomerRepresenterSession.setCustomerList(representerRepository.findByRepresenterId(representer.getId()));
        if(list.isEmpty()){
            responsemodel.setSuccess(false);
            responsemodel.setMessage("Adınıza kayıtlı hesap bulunamadı");
            responsemodel.setResponseObject(null);
        }
        else{
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(list);
        }
        return responsemodel;
    }

    @Override
    public ResponseModel<List<Credit>> basvuruGoruntule(CustomerRepresenter representer) {
        ResponseModel<List<Credit>> responsemodel=new ResponseModel<>();
        List<Credit> list=new ArrayList<>();
        list.addAll(creditRepository.basvuruGoruntule(representer));
        if(list.isEmpty()){
            responsemodel.setSuccess(false);
            responsemodel.setMessage("Başvuru Bulunamadı");
            responsemodel.setResponseObject(null);
        }
        else{
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(list);
        }
        return responsemodel;
    }
 }




    

