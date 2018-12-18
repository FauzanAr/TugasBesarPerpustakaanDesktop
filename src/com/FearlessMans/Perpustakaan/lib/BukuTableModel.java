/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FearlessMans.Perpustakaan.lib;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author khosy
 */
public class BukuTableModel extends AbstractTableModel{
 
     private String [] columnNames = {"Judul Buku","Pengarang","Id Kategori","Jumlah Peminjaman"};
    private ArrayList <Buku> bukuList; 
    
    public BukuTableModel(BukuJavaToDatabase list){
        bukuList = list.getAllBuku();
    }
    
            
    
    @Override
    public int getRowCount() {
        int size;
        if (bukuList == null)
            size = 0;
        else
            size = bukuList.size();
        return size;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    

    @Override
    public Object getValueAt(int row, int col) {//"Judul Buku","Pengarang","Id Kategori","Jumlah Peminjaman"
        Object tmp = null;
        if (col == 0){
            tmp = bukuList.get(row).getJudul();
        }else if (col == 1){
            tmp = bukuList.get(row).getPengarang();
        }else if (col == 2){
            tmp = bukuList.get(row).getIdKategory();
        }else if (col == 3){
            tmp = bukuList.get(row).getJudul();
        }else if (col == 4){
            tmp = bukuList.get(row).getJumlahBuku();
        }
        return tmp;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }
}
