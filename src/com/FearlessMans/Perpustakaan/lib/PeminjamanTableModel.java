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
public class PeminjamanTableModel extends AbstractTableModel {
    private String [] columnNames = {"Kode Peminjaman","ID User","ID Buku","Tanggal Pinjam","Tanggal Kembali"};
    private ArrayList <PeminjamanLib> pinjamanList; 

    public PeminjamanTableModel(PinjamJavaToDatabase list, int id) {
        pinjamanList = list.getAllPinjamUser(id);
    }
    
    
    @Override
    public int getRowCount() {
        int size;
        if (pinjamanList == null)
            size = 0;
        else
            size = pinjamanList.size();
        return size;
    }

    @Override 
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object tmp = null;
        if (col == 0){
            tmp = pinjamanList.get(row).getIdPeminjaman();
        }else if (col == 1){
            tmp = pinjamanList.get(row).getIdUserPerpus();
        }else if (col == 2){
            tmp = pinjamanList.get(row).getIdBuku();
        }else if (col == 3){
            tmp = pinjamanList.get(row).getTanggalPinjam();
        }else if (col == 4){
            tmp = pinjamanList.get(row).getTanggalKembali();
        }
        return tmp;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }
}
