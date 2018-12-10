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
public class User {
    private String nim, nama, prodi, password;
    private int ID,userPinjam;

    
    
    public User(){
        
    }
    
    public User(String nim){
        this.nim = nim;
    }
    
    public User(String nim, String password){
        this.nim = nim;
        this.password = password;
    }
    
    public User(String nim, String nama, String prodi){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.password = nim;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }

    public int getUserPinjam() {
        return userPinjam;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserPinjam(int userPinjam) {
        this.userPinjam = userPinjam;
    }
    
    
}
