/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.view;

import prolab3_banking_project.databaseconnection.DatabaseConnection;

/**
 *
 * @author erene
 */
public class Main {
    
    public static void main(String[] args) {
        DatabaseConnection con = new DatabaseConnection();
        con.connectDb();
        new LoginGui().setVisible(true);
        /*java.awt.EventQueue.invokeLater(new Runnable()){
            public void run(){
            
        }
        });*/
    }
    
}
