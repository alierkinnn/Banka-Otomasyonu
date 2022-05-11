
package prolab3_banking_project.service;

import java.util.List;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.model.Transaction;


public interface CustomerService {
    
    ResponseModel<List<Transaction>> ozetGoruntule(Customer customer); //bakılacak
    
    ResponseModel<Customer> bilgiGuncelle(String email,String phone,String adress);
    
    ResponseModel<Customer> musteriEkle(Long id,String name,String surname,String phone,String adress,String email,String password);
    
}
