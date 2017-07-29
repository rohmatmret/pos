/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.transaksi;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rohmat
 */
public class modelpenjualan {
    private double subTotal=0;
    private double ppn=0;
    private double total=0;
    private DefaultTableModel tabel = new DefaultTableModel();
    public modelpenjualan()
    {
        getTabel().addColumn("Barang");
        getTabel().addColumn("Nama Barang");
        getTabel().addColumn("Qty");
        getTabel().addColumn("Harga");
        getTabel().addColumn("Total");
    }
    public final DefaultTableModel getTabel()
    {
        return tabel;   
    }
    public void setTabel(DefaultTableModel tabel) {
        this.tabel = tabel;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
     public double countSubtotal(){
        subTotal=0;
        for (int i=0;i<tabel.getRowCount();i++){
            subTotal=subTotal+Double.parseDouble(tabel.getValueAt(i, 4).toString());
        }
        return subTotal;
    }
    public int count()
    {
        int count=0;
        for (int i=0;i<tabel.getRowCount();i++){
            count +=1;
        }
        return count;
    }
   
    
    
}
