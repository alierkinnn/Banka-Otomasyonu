/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import prolab3_banking_project.model.Account;
import prolab3_banking_project.model.Currency;
import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.repository.CurrencyRepository;
import prolab3_banking_project.service.CurrencyService;

/**
 *
 * @author Ali Erkin
 */
public class CurrencyServiceImpl implements CurrencyService{
    
    private CurrencyRepository c = new CurrencyRepository();

    @Override
    public ResponseModel<Boolean> newCurrency(String name, Double price) {
        ResponseModel responseModel = new ResponseModel();
        
        if(c.newCurrency(name, price)==false){
            responseModel.setSuccess(false);
            responseModel.setMessage("İşlem Başarısız");
        }
        else{
            responseModel.setSuccess(true);
            responseModel.setMessage("İşlem Başarılı");
            
        }
        
        return responseModel;
    }
    
    public ResponseModel<List<Currency>> kayıtlıCurrency(){
        List<Currency> list=new ArrayList<>();        
        ResponseModel<List<Currency>> responsemodel=new ResponseModel<>();
        //Customer customer = CustomerSession.getCustomer();
        list.addAll(c.allCurrencies());
        if(list.isEmpty()){
            responsemodel.setSuccess(false);
            responsemodel.setMessage("kayıtlı döviz bulunamadı.");
            responsemodel.setResponseObject(null);
        }
        else{
            responsemodel.setSuccess(true);
            responsemodel.setResponseObject(list);
        }
        return responsemodel;
    }

    @Override
    public ResponseModel<Currency> bilgiGuncelle(String name,Double price) {
        Currency currency = new Currency();
        ResponseModel responseModel = new ResponseModel();
        currency = null;
        currency = c.bilgiGuncelle(name,price);
        if(currency==null){
            responseModel.setSuccess(false);
            responseModel.setMessage("İşlem Başarısız");
        }
        else{
            responseModel.setSuccess(true);
            responseModel.setMessage("İşlem Başarılı");
        }
        
        return responseModel;
    }
    
    
    
}
