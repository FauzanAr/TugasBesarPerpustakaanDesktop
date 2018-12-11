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
public class Buku {
        private int id;
    private String judul;
    private String pengarang;
    private int idKategory;
    private int jumlahBuku;

    public Buku() {
    }

    public Buku(int id, String judul, String pengarang, int idKategory, int jumlahBuku) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.idKategory = idKategory;
        this.jumlahBuku = jumlahBuku;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public int getIdKategory() {
        return idKategory;
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setIdKategory(int idKategory) {
        this.idKategory = idKategory;
    }

    public void setJumlahBuku(int jumlahBuku) {
        this.jumlahBuku = jumlahBuku;
    }
    
    
}
