/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;

import prolab3_banking_project.repository.CreditRepository;

import prolab3_banking_project.model.Account;
import prolab3_banking_project.model.Credit;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.repository.AccountRepository;
import prolab3_banking_project.repository.CreditRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CreditServiceImpl {
    
    private CreditRepository creditRepository=new CreditRepository();
    private AccountServiceImpl accountService=new AccountServiceImpl();
    private AccountRepository accountRepository=new AccountRepository();
    
    /*public ResponseModel<Credit> krediBasvurusu(Account account ,Double amount){
        ResponseModel<Credit> responsemodel=new ResponseModel();
        Credit credit=new Credit();
        //credit.setCustomer(account.getCustomer());
        //credit.setExpiry();
        credit.setCurrentAmount(amount);
        credit.setMainAmount(amount);
        credit.setTotalAmount(amount+amount*14/1000*24);
        credit.setInterestRate(Double.valueOf(14/1000));
        credit.setAccountId(account.getId());
        Calendar calender = Calendar.getInstance();
        Date date=new Date();
        calender.setTime(date);
        calender.add(Calendar.YEAR, 2);
        date = calender.getTime();
        //credit.setExpiry();
        if(creditRepository.insertCredit(credit)!=null){
            
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(credit);
            responsemodel.setMessage("Krediniz onaylandıktan sonra hesabınıza aktarılacaktır!");
        
            return responsemodel;
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("İşlem gerçekleştirilemedi!");
            
            return responsemodel;
        }

    }
    
    public ResponseModel<List<Credit>> kayıtlıBasvurular(){
        List<Credit> list=new ArrayList<>();
        ResponseModel<List<Credit>> responsemodel=new ResponseModel<>();
        list=creditRepository.findCreditAppeals();
        if(!list.isEmpty()){
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(list);
            responsemodel.setMessage("İşlem başarılı!");
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setResponseObject(null);
            responsemodel.setMessage("Kayıtlı başvuru bulunamadı!");
        }                
        return responsemodel;                
    }
    
    public ResponseModel<Boolean> basvuruOnayla(Long id){
        ResponseModel<Boolean> responsemodel= new ResponseModel();
        if(creditRepository.setApproval(id)>=0){
            Credit credit=creditRepository.findById(id);
            accountService.paraYatirma(accountRepository.findById(credit.getAccountId()),String.valueOf(credit.getMainAmount()));
            responsemodel.setSuccess(true);
            responsemodel.setMessage("Onaylama başarılı");
            responsemodel.setResponseObject(true);
            return responsemodel;
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setMessage("Onaylama başarısız");
            responsemodel.setResponseObject(false);
            return responsemodel;
        }
    
    }
    public ResponseModel<Boolean> basvuruReddi(Long id){
        ResponseModel<Boolean> responsemodel= new ResponseModel();
        if(creditRepository.deleteAppeal(id)>=0){
            responsemodel.setSuccess(true);
            responsemodel.setMessage("Başvuru reddedildi!");
            responsemodel.setResponseObject(true);
            return responsemodel;
        }else{
            responsemodel.setSuccess(false);
            responsemodel.setMessage("Reddetme başarısız!");
            responsemodel.setResponseObject(false);
            return responsemodel;
        }
    }*/
}
