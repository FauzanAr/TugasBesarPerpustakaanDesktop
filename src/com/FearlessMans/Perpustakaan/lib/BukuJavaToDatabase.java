/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM buku WHERE id_buku="+id);
            
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
    
    public ArrayList getAllBuku() {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM buku");
            
            ArrayList bukuBuku = new ArrayList();
            
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
    
    public boolean insertBuku(Buku buku) {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            PreparedStatement ps = koneksi.prepareStatement("INSERT INTO buku(judul_buku, pengarang_buku, id_category_buku, jumlah_buku) VALUES (?,?,?,?)");
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPengarang());
            ps.setInt(3, buku.getIdKategory());
            ps.setInt(4, buku.getJumlahBuku());
            
            int i = ps.executeUpdate();
            
            if (i == 1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBuku(Buku buku) {
        Connection koneksi = Koneksi.buka_koneksi();
        
        try {
            PreparedStatement ps = koneksi.prepareStatement("UPDATE buku SET judul_buku=?, pengarang_buku=?, id_category_buku=?, jumlah_buku=? WHERE id_buku=?");
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPengarang());
            ps.setInt(3, buku.getIdKategory());
            ps.setInt(4, buku.getJumlahBuku());
            ps.setInt(5, buku.getId());
            
            int i = ps.executeUpdate();
            
            if (i == 1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteBuku(int id) {
        Connection koneksi = Koneksi.buka_koneksi();
        
        try {
            Statement stmt = koneksi.createStatement();
            int i = stmt.executeUpdate("DELETE FROM buku WHERE id_buku="+id);
            if(i == 1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
