/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

/**
 *
 * @author fauzan
 */
public class userClass {
    private String user, password;
    private int ID;
    connectionClass koneksi = new connectionClass();
    
    
    public userClass(){
        
    }
    
    public userClass(String user){
        this.user = user;
    }
    
    public userClass(String user, String password){
        this.user = user;
        this.password = password;
    }
    
    public void addUser (String user, String password){
        
    }
}
