/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ojan
 */
public class connectionClass {
    private static Connection koneksi;
    public static void buka_koneksi(){
        if (koneksi == null){
            try {
                String url = "jdbc:mysql://localhost:100/perpustakaan_tubes";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = (Connection) DriverManager.getConnection(url,user,password);  
                //Selesai
            } catch (SQLException t){
                System.out.println("Error Membuat Koneksi");
                //Selesai
            }
        }
    }
}
