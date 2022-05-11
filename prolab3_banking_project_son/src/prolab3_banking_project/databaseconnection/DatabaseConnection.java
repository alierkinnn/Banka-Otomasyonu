/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab3_banking_project.databaseconnection;


import java.sql.*;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection con = null;

    public Connection connectDb() {

        String url = "jdbc:derby://localhost:1527/prolab3";

        try {
            con =DriverManager.getConnection(url, "emrekaya", "admin");
            System.out.println("İşlem Başarılı.");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DatabaseConnection.con = con;
    }

}
