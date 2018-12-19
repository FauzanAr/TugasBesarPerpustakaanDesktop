/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

import java.util.Date;
/**
 *
 * @author Ojan
 */
public class PeminjamanLib {
    private int idPeminjaman, idUserPerpus, idBuku;
    private Date tanggalPinjam, tanggalKembali;
    
    public PeminjamanLib(){
        
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public int getIdUserPerpus() {
        return idUserPerpus;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public void setIdUserPerpus(int idUserPerpus) {
        this.idUserPerpus = idUserPerpus;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }
    
}
