/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.session;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import prolab3_banking_project.model.Customer;
import prolab3_banking_project.model.CustomerRepresenter;

/**
 *
 * @author Ali Erkin
 */
public class CustomerRepresenterSession {
    
    private static CustomerRepresenter representer;
    private static List<Customer> customerList;
    private static List<JFrame> parentFrame = new ArrayList<>();

    
    
    public static CustomerRepresenter getRepresenter() {
        return representer;
    }

    public static void setRepresenter(CustomerRepresenter representer) {
        CustomerRepresenterSession.representer = representer;
    }
    
    public static List<JFrame> getParentFrame() {
        return parentFrame;
    }

    public static void setParentFrame(List<JFrame> parentFrame) {
        CustomerRepresenterSession.parentFrame = parentFrame;
    }
    
    public static void clear(){
        representer = null;
        customerList = null;
        parentFrame = null;
        
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(List<Customer> customerList) {
        CustomerRepresenterSession.customerList = customerList;
    }

        
    



    
}
