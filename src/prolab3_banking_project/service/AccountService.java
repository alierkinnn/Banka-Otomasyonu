


package prolab3_banking_project.service;

import java.util.List;
import prolab3_banking_project.model.Account;
import prolab3_banking_project.model.ResponseModel;


public interface AccountService {
    
    ResponseModel<Account> paraCekme(Account account,String amount);
    
    ResponseModel<Account> paraYatırma(Account account,String amount);
    
    ResponseModel<Account> hesapAcma(Account account); //bakılacak
    
    ResponseModel<Boolean> hesapSilme(Account account); 
    
    ResponseModel<Account> ozetGoruntule(Account account); //bakılacak
    
    ResponseModel<List<Account>> paraGonder(Account account,String amount,long iban);
    
}
