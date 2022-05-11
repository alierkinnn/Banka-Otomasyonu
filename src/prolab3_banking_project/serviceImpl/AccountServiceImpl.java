/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import prolab3_banking_project.model.Account;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.repository.AccountRepository;
import prolab3_banking_project.service.AccountService;
import prolab3_banking_project.session.CustomerSession;


/**
 *
 * @author erene
 */
public class AccountServiceImpl implements AccountService{
    
    private AccountRepository accountrepository = new AccountRepository();

    @Override
    public ResponseModel<Account> paraCekme(Account account, String amount) {
        ResponseModel responsemodel = new ResponseModel();
        if(account.getBalance()-Double.valueOf(amount)>=0){
            account.setBalance(account.getBalance()- Double.valueOf(amount));
            if(accountrepository.updateBalance(account)<0){
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem başarısız!");
       
            }else{
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(account);
            responsemodel.setMessage("Ödemeniz gerçekleştirildi!");
            }                        
        
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem başarısız oldu , geçersiz miktar girildi!");
            return responsemodel;        
        }
        return responsemodel;
    }

    @Override
    public ResponseModel<Account> paraYatırma(Account account, String amount) {
        ResponseModel responsemodel = new ResponseModel();
        account.setBalance(account.getBalance()+Double.valueOf(amount));
        if(accountrepository.updateBalance(account)<0){
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem başarısız!");
       
        }else{
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(account);
            responsemodel.setMessage("İşlem başarılı!");
        }                        
        return responsemodel;
        
    }

    @Override
    public ResponseModel<Account> hesapAcma(Account account) {
        ResponseModel responsemodel = new ResponseModel();
        
        return responsemodel;
    }

    @Override
    public ResponseModel<Boolean> hesapSilme(Account account) {
        ResponseModel responsemodel = new ResponseModel();
        if(account.getBalance()==0){
            if(accountrepository.deleteAccount(account.getId())<0){
                responsemodel.setSuccess(false);
                responsemodel.setResponseObject(null);
                responsemodel.setMessage("İşlem başarısız!");   
            }else{               
                responsemodel.setSuccess(true);
                responsemodel.setResponseObject(null);
                responsemodel.setMessage("İşlem başarılı!");  
            }
        }else{
                responsemodel.setSuccess(false);
                responsemodel.setResponseObject(account);
                responsemodel.setMessage("İşlem başarısız , hesapta bakiye bulunmamalıdır!");   
        }        
        return responsemodel;
}

    @Override
    public ResponseModel<Account> ozetGoruntule(Account account) {
        ResponseModel responsemodel = new ResponseModel();
        
        return responsemodel;
    }

    @Override
    public ResponseModel<List<Account>> paraGonder(Account account, String amount, long iban) {   
        List<Account> list=new ArrayList<>();        
        ResponseModel<List<Account>> responsemodel=new ResponseModel<>();
        Account targetAccount=new Account();
        targetAccount=accountrepository.findByIban(iban);
        list.add(account);
        list.add(targetAccount);
        if(targetAccount==null){
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("Yazılan IBAN'a ait hesap bulunamadı!");                
        }else{
            if(account.getBalance()-Double.valueOf(amount)>=0){
                account.setBalance(account.getBalance()- Double.valueOf(amount));
                targetAccount.setBalance(targetAccount.getBalance()+ Double.valueOf(amount));
                accountrepository.updateBalance(account);
                accountrepository.updateBalance(targetAccount);
                responsemodel.setSuccess(true);                
                responsemodel.setMessage("Para transfer işlemi başarılı ve hesap bakiyesi sekmeyi yeniden açınca geçerli olacaktır!");
                responsemodel.setResponseObject(list);
                return responsemodel;
            }else{                
                return null;        
            }
        }            
        return null;
    }
    
    public ResponseModel<List<Account>> kayitliHesaplar(){
        List<Account> list=new ArrayList<>();        
        ResponseModel<List<Account>> responsemodel=new ResponseModel<>();
        Customer customer = CustomerSession.getCustomer();
        list.addAll(accountrepository.findByCustomerId(customer.getCustomerNumber()));
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
    
    
}

    

