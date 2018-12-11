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
import javax.swing.table.TableModel;
public class userTableModel extends AbstractTableModel {
    public String [] columnNames = {"ID","Nim","Nama","Prodi","Jumlah Peminjaman"};
    public Object[][] data = {{"1","1741720212","Fauzan","Teknologi Informasi","0"}};
    
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
    

    public String getColumName(int column){
        return columnNames[column];
    }
    
    public Class getColumnClas(int c){
        return getValueAt(0,c).getClass();
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
