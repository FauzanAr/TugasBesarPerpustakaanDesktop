/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author khosy
 */
public class PinjamJavaToDatabase {
     
    public Peminjaman getPinjam(int id) {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM peminjaman WHERE id_user_perpustakaan ="+id);
            
            if (rs.next()){
//                Buku buku = new Buku();
                
                return extractPinjamFromResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null; 
    }
    
    
    private Peminjaman extractPinjamFromResultSet(ResultSet rs) throws SQLException{
        Peminjaman pinjam = new Peminjaman();
        
        pinjam.setIdPeminjaman(rs.getInt("id_peminjaman"));
        pinjam.setIdUserPerpus(rs.getInt("id_user_perpustakaan"));
        pinjam.setIdBuku(rs.getInt("id_buku"));
        pinjam.setTanggalPinjam(rs.getDate("tanggal_pinjam"));
        pinjam.setTanggalKembali(rs.getDate("tanggal_kembali"));
        return pinjam;
    }
    
    public ArrayList getAllPinjamAdmin() {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM peminjaman");
            
            ArrayList pinjamList = new ArrayList();
            
            while (rs.next()){
                Peminjaman pinjam = extractPinjamFromResultSet(rs);
                pinjamList.add(pinjam);
            }
            return pinjamList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
        public ArrayList getAllPinjamUser(int user) {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM peminjaman WHERE id_user_perpustakaan="+user);
            
            ArrayList pinjamList = new ArrayList();
            
            while (rs.next()){
                Peminjaman pinjam = extractPinjamFromResultSet(rs);
                pinjamList.add(pinjam);
            }
            return pinjamList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
  
    public boolean insertPinjam(Peminjaman pinjam) {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            PreparedStatement ps = koneksi.prepareStatement("INSERT INTO peminjaman(id_user_perpustakaan, id_buku, tanggal_pinjam, tanggal_kembali) VALUES (?,?,?,?)");
            ps.setInt(1, pinjam.getIdUserPerpus());
            ps.setInt(2, pinjam.getIdBuku());
            ps.setDate(3, (Date) pinjam.getTanggalPinjam());
            ps.setDate(4, (Date) pinjam.getTanggalKembali());
            
            int i = ps.executeUpdate();
            
            if (i == 1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public boolean updateBuku(Buku buku) {
//        Connection koneksi = Koneksi.buka_koneksi();
//        
//        try {
//            PreparedStatement ps = koneksi.prepareStatement("UPDATE buku SET judul_buku=?, pengarang_buku=?, id_category_buku=?, jumlah_buku=? WHERE id=?");
//            ps.setString(1, buku.getJudul());
//            ps.setString(2, buku.getPengarang());
//            ps.setInt(3, buku.getIdKategory());
//            ps.setInt   (4, buku.getJumlahBuku());
//            ps.setInt   (5, buku.getId());
//            
//            int i = ps.executeUpdate();
//            
//            if (i == 1){
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }


    public boolean deletePinjam(int id) {
        Connection koneksi = Koneksi.buka_koneksi();
        
        try {
            Statement stmt = koneksi.createStatement();
            int i = stmt.executeUpdate("DELETE FROM buku WHERE id_peminjaman="+id);
            if(i == 1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
