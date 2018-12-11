/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

import java.util.ArrayList;

/**
 *
 * @author khosy
 */
public class comboKategori {
    private ArrayList<Kategori> kat; // varaibel items untuk menyimpan item dari objek

    //kontruktor pada array list
    public comboKategori() {
      this.kat = new ArrayList<>();
    }
    
    public Kategori[] toArray(){
        Kategori[] a = new Kategori[this.kat.size()];
            for(int i = 0; i < a.length; i++){
                a [i] = this.kat.get(i);
            }
            return a;
    }
    
    //untuk mendambahkan item ke list dari Item
    public void tambahKategori(Kategori kategori){
        this.kat.add(kategori);
    }
}
