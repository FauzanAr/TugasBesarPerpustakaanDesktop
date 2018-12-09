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
import java.util.Set;

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


    public Set<User> getAllUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    
    public boolean insertUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean updateUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public boolean deleteUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public static void main (String []args){
//        User user;
//        UserJavaToDatabase userJ = new 
//        
//    }
}
