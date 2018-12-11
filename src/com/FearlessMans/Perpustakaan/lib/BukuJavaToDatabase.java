/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author khosy
 */
public class BukuJavaToDatabase {

    public Buku getBuku(int id) {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM buku WHERE id ="+id);
            
            if (rs.next()){
                Buku buku = new Buku();
                
                return extractUserFromResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null; 
    }
    
    private Buku extractUserFromResultSet(ResultSet rs) throws SQLException{
        Buku buku = new Buku();
        
        buku.setId(rs.getInt("id_buku"));
        buku.setJudul(rs.getString("judul_buku"));
        buku.setPengarang(rs.getString("pengarang_buku"));
        buku.setIdKategory(rs.getInt("id_category_buku"));
        buku.setJumlahBuku(rs.getInt("jumlah_buku"));
        return buku;
    }
    
    public Set getAllBuku() {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM buku");
            
            Set bukuBuku = new HashSet();
            
            while (rs.next()){
                Buku buku = extractUserFromResultSet(rs);
                bukuBuku.add(buku);
            }
            return bukuBuku;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
