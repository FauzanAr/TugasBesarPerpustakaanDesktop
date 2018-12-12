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
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
public class userTableModel extends AbstractTableModel {
    private String [] columnNames = {"ID","Nim","Nama","Prodi","Jumlah Peminjaman"};
    private Object[][] data = {{"11","1741720212","Fauzann","Teknologi Informasi","0"}};
    //HashSet allDataUser  = (HashSet) new UserJavaToDatabase().getAllUser();
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    @Override
    public boolean isCellEditable(int row, int column)
    {
        if (column == 1 || column == 2){
            return false;
        }else
            return true;
    }
}
