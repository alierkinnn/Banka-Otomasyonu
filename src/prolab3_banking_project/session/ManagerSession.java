/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.session;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import prolab3_banking_project.model.Currency;
import prolab3_banking_project.model.Manager;

/**
 *
 * @author erene
 */
public class ManagerSession {
    
    private static Currency currency;
    private static Manager manager;
    private static List<JFrame> parentFrame = new ArrayList<>();

    public static Manager getManager() {
        return manager;
    }

    public static void setManager(Manager manager) {
        ManagerSession.manager = manager;
    }

    public static List<JFrame> getParentFrame() {
        return parentFrame;
    }

    public static void setParentFrame(List<JFrame> parentFrame) {
        ManagerSession.parentFrame = parentFrame;
    }

    public static Currency getCurrency() {
        return currency;
    }

    public static void setCurrency(Currency currency) {
        ManagerSession.currency = currency;
    }
    
    
    public static void clear(){
        manager = null;
        parentFrame=null;
        currency=null;
        
    }
    
}
