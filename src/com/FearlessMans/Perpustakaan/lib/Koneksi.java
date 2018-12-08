/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ojan
 */
public class Koneksi {
    
    public Koneksi(){}
    private static Connection koneksi;
    public static Connection buka_koneksi(){
        
            try {
                String url = "jdbc:mysql://localhost:100/perpustakaan_tubes";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                return koneksi = (Connection) DriverManager.getConnection(url,user,password);  
                //Selesai
            } catch (SQLException t){
                throw new RuntimeException("Error Membuat Koneksi",t);
                //Selesai
            }
    }
}
