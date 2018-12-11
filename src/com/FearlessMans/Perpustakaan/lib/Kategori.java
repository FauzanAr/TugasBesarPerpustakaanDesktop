/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

/**
 *
 * @author khosy
 */
public class Kategori {
    private int id;
    private String namaKategori;

    public Kategori(int id, String namaKategori) {
        this.id = id;
        this.namaKategori = namaKategori;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public int getId() {
        return id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }
    
    
}
