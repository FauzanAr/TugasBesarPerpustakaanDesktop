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
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class userTableModel extends AbstractTableModel {

    private String [] columnNames = {"ID","Nim","Nama","Prodi","Jumlah Peminjaman"};
    private ArrayList <User> userList; 
    
    public userTableModel(UserJavaToDatabase list){
        userList = list.getAllUser();
    }
    
            
    
    @Override
    public int getRowCount() {
        int size;
        if (userList == null)
            size = 0;
        else
            size = userList.size();
        return size;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    

    @Override
    public Object getValueAt(int row, int col) {//"ID","Nim","Nama","Prodi","Jumlah Peminjaman"
        Object tmp = null;
        if (col == 0){
            tmp = userList.get(row).getID();
        }else if (col == 1){
            tmp = userList.get(row).getNim();
        }else if (col == 2){
            tmp = userList.get(row).getNama();
        }else if (col == 3){
            tmp = userList.get(row).getProdi();
        }else if (col == 4){
            tmp = userList.get(row).getUserPinjam();
        }
        return tmp;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }
}
