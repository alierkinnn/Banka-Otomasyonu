/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.service;

import prolab3_banking_project.model.ResponseModel;


public interface ManagerService {
    
    ResponseModel<Boolean> faizAyarla();
    
    ResponseModel<Boolean> gecikmeFaiziAyarla();
    
    ResponseModel<Boolean> paraBirimiEkle();
    
    ResponseModel<Boolean> kurGuncelle();
    
    ResponseModel<Boolean> maasBelirle();
    
    ResponseModel<Boolean> musteriEkle(String name,String surname,String identityNumber,
            Long id,String phone,String address,String password);
    
    ResponseModel<Boolean> sistemiIlerlet(); //burası çok önemli
    
    ResponseModel<Boolean> islemGoruntule();//bakıcaz hocam
    
    ResponseModel<Boolean> genelDurumGoruntule();//bakıcaz hocam
    
    
    
}
