/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prolab3_banking_project.service;

import prolab3_banking_project.model.Currency;
import prolab3_banking_project.model.ResponseModel;

/**
 *
 * @author Ali Erkin
 */
public interface CurrencyService {
    
    ResponseModel<Boolean> newCurrency(String name,Double price);
    ResponseModel<Currency> bilgiGuncelle(String name,Double price);
    
}
