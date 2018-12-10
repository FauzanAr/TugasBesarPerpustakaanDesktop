/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

/**
 *
 * @author Ojan
 */
public class Admin {
    private String nik, password;
    private int id;

    public Admin(String nik, String password, int id) {
        this.nik = nik;
        this.password = password;
        this.id = id;
    }
    
    public Admin(){
        
    }

    public String getNik() {
        return nik;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
