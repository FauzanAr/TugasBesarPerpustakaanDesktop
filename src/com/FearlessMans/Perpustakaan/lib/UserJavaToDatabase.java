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
import java.util.HashSet;
import java.util.Set;
import java.util.*;
/**
 *
 * @author fauzan
 **/
public class UserJavaToDatabase {
    
    public User getUser(int id) {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id ="+id);
            
            if (rs.next()){
                User user = new User();
                
                return extractUserFromResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null; 
    }
    
    private User extractUserFromResultSet(ResultSet rs) throws SQLException{
        User user = new User();
        
        user.setID(rs.getInt("id_user_perpus"));
        user.setNim(rs.getString("nim_user_perpus"));
        user.setNama(rs.getString("nama_user_perpus"));
        user.setProdi(rs.getString("prodi_user_perpus"));
        user.setUserPinjam(rs.getInt("user_pinjam"));
        user.setPassword(rs.getString("password_user_perpus"));
        
        return user;
    }
    
    private Admin extractAdminFromResultSet(ResultSet rs) throws SQLException{
        Admin admin = new Admin();
        admin.setId(rs.getInt("id_admin"));
        admin.setNik(rs.getString("nik_admin"));
        admin.setPassword(rs.getString("password_admin"));
        return admin;
    }


    public ArrayList getAllUser() {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            
            ArrayList users = new ArrayList();
            
            while (rs.next()){
                User user = extractUserFromResultSet(rs);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public User getUserByUserNameAndPassword(String nim) {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
                PreparedStatement ps = koneksi.prepareStatement("SELECT * FROM user WHERE nim_user_perpus=? AND password_user_perpus=?");
                ps.setString(1, nim);
                ps.setString(2, nim);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()){
                    return extractUserFromResultSet(rs);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return null;
    }
    
    public Admin getAdminByUserNameAndPassword(String nik, String password){
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            PreparedStatement ps = koneksi.prepareStatement("SELECT * FROM admin WHERE nik_admin=? AND password_admin=?");
            ps.setString(1, nik);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                return extractAdminFromResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public boolean insertUser(User user) {
        Connection koneksi = Koneksi.buka_koneksi();
        try {
            PreparedStatement ps = koneksi.prepareStatement("INSERT INTO user(nim_user_perpus, nama_user_perpus, prodi_user_perpus, password_user_perpus) VALUES (?,?,?,?)");
            ps.setString(1, user.getNim());
            ps.setString(2, user.getNama());
            ps.setString(3, user.getProdi());
            ps.setString(4, user.getPassword());
            
            int i = ps.executeUpdate();
            
            if (i == 1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User user) {
        Connection koneksi = Koneksi.buka_koneksi();
        
        try {
            PreparedStatement ps = koneksi.prepareStatement("UPDATE user SET nim_user_perpus=?, nama_user_perpus=?, prodi_user_perpus=?, user_pinjam=? WHERE id=?");
            ps.setString(1, user.getNim());
            ps.setString(2, user.getNama());
            ps.setString(3, user.getProdi());
            ps.setInt(4, user.getUserPinjam());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getID());
            
            int i = ps.executeUpdate();
            
            if (i == 1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteUser(int id) {
        Connection koneksi = Koneksi.buka_koneksi();
        
        try {
            Statement stmt = koneksi.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id="+id);
            if(i == 1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
