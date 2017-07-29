/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.pembelian;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pos.modul.koneksi;
//import net.sourceforge.jdatepicker.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import pos.menu;
/**
 *
 * @author rohmat
 */
public class pembelian extends javax.swing.JFrame {

    PreparedStatement stm;
    Statement st;
    ResultSet rs;
    String getnamabarang,getkodebarang,getnomorfaktur,getsatuan;
    int getqty;
    String faktur; 
    Double getharga;
    
    public pembelian() {
        initComponents();
        this.awal(); 
        loadData();
    }
    public void getfaktur()
    {
        modal_faktur mdf = new modal_faktur();
        mdf.beli=this;
        nomor_faktur.setText(faktur);
    }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buat = new javax.swing.JButton();
        nomor_faktur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        kode_barang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama_barang = new javax.swing.JTextField();
        satuan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        error_faktur = new javax.swing.JLabel();
        error_kodebarang = new javax.swing.JLabel();
        error_namabarang = new javax.swing.JLabel();
        error_satuan = new javax.swing.JLabel();
        error_qty = new javax.swing.JLabel();
        error_harga = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpembelian = new javax.swing.JTable();
        datafaktur = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NO FAKTUR");

        buat.setText("BUAT");
        buat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buatActionPerformed(evt);
            }
        });

        nomor_faktur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomor_fakturKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomor_fakturKeyTyped(evt);
            }
        });

        jLabel2.setText("KODE BARANG");

        kode_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kode_barangKeyPressed(evt);
            }
        });

        jLabel3.setText("NAMA BARANG");

        nama_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nama_barangKeyPressed(evt);
            }
        });

        satuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                satuanKeyPressed(evt);
            }
        });

        jLabel4.setText("SATUAN");

        jLabel5.setText("QTY");

        jLabel6.setText("HARGA");

        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtyKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PEMBELIAN");

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        edit.setText("EDIT");

        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        tabelpembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelpembelian.setMinimumSize(new java.awt.Dimension(40, 30));
        tabelpembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpembelianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpembelian);

        datafaktur.setText("Data Faktur");
        datafaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datafakturActionPerformed(evt);
            }
        });

        kembali.setText("KEMBALI");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(error_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(error_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(error_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(error_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(error_kodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(error_faktur, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nomor_faktur)
                                            .addComponent(kode_barang, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
                                .addGap(42, 42, 42)
                                .addComponent(datafaktur))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buat)
                                .addGap(18, 18, 18)
                                .addComponent(save)
                                .addGap(18, 18, 18)
                                .addComponent(edit)
                                .addGap(18, 18, 18)
                                .addComponent(hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kembali)))))
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomor_faktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datafaktur))
                .addGap(23, 23, 23)
                .addComponent(error_faktur, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_kodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(error_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buat)
                    .addComponent(save)
                    .addComponent(edit)
                    .addComponent(hapus)
                    .addComponent(kembali))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void active()
    {
        //nomor_faktur.setEnabled(true);
        kode_barang.setEnabled(true);
        nama_barang.setEnabled(true);
        satuan.setEnabled(true);
        qty.setEnabled(true);
        harga.setEnabled(true);
        kode_barang.requestFocusInWindow();
        //button
        edit.setEnabled(false);
        save.setEnabled(true);
        buat.setEnabled(false);
        hapus.setEnabled(false);
        //this.getfaktur();        
    }
    public void awal(){
        nomor_faktur.setEnabled(false);
        kode_barang.setEnabled(false);
        nama_barang.setEnabled(false);
        satuan.setEnabled(false);
        qty.setEnabled(false);
        harga.setEnabled(false);
        //button
        edit.setEnabled(false);
        save.setEnabled(false);
        hapus.setEnabled(false);
        buat.requestFocusInWindow();
        //nomor_faktur.setText(new modal_faktur().getfaktur(faktur));
    }
    public void clear()
    {
        kode_barang.setText("");
        nama_barang.setText("");
        satuan.setText("");
        qty.setText("");
        harga.setText("");
        id.setText("");
        //save.setEnabled(false);
    }
    public void validasi()
    {
        boolean validate=true;
        if(nomor_faktur.getText().isEmpty()){
            validate =false;
            error_faktur.setText("nomor faktur required ..");
            nomor_faktur.requestFocusInWindow();
        }else if(kode_barang.getText().isEmpty()){
            validate =false;
            error_kodebarang.setText("Kode barang required ..");
            kode_barang.requestFocusInWindow();
        }else if(nama_barang.getText().isEmpty()){
            validate =false;
            error_namabarang.setText("Nama Baragn required ..");
            nama_barang.requestFocusInWindow();
        }else if(satuan.getText().isEmpty()){
            validate =false;
            error_satuan.setText("Satuan required ..");
            satuan.requestFocusInWindow();
        }else if(qty.getText().isEmpty()){
            validate =false;
            error_qty.setText("Qty required ..");
             qty.requestFocusInWindow();
        }else if(harga.getText().isEmpty()){
            validate =false;
            error_harga.setText("Harga required ..");
            harga.requestFocusInWindow();
        }
    }
    public void getData()
    {
       
        
    }
    public void loadData()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOMOR FAKTUR");
        model.addColumn("KODE BARANG");
        model.addColumn("NAMA BARANG");
        model.addColumn("SATUAN");
        model.addColumn("QTY");
        model.addColumn("HARGA");
        try{
            String sql = "SELECT * FROM detail_pembelian";            
            koneksi conn = new koneksi();
            Connection getkoneksi = conn.konek();
            if(getkoneksi==null){
                JOptionPane.showMessageDialog(null, "KOneksi gagal ! periksa server");
            }
            st = getkoneksi.createStatement();
            rs = st.executeQuery(sql);
            //menampilkan ke table
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }
            tabelpembelian.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void buatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buatActionPerformed
        active();
       // setfaktur();
    }//GEN-LAST:event_buatActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        //String getfaktur = null;
        //nomor_faktur.setText(getfaktur);
        validasi();
        getnomorfaktur=nomor_faktur.getText();
        getkodebarang=kode_barang.getText();
        getnamabarang=nama_barang.getText();
        getsatuan = satuan.getText();
        getqty=Integer.parseInt(qty.getText());
        getharga=Double.parseDouble(harga.getText());
         try{
            String str ="INSERT INTO detail_pembelian "
                    +"(nomor_faktur,kode_barang,nama_barang,satuan,qty,harga)VALUES"
                    +"(?,?,?,?,?,?)";
            koneksi conn = new koneksi();
                try (Connection getkoneksi = conn.konek()) {
                    if(getkoneksi == null){
                        JOptionPane.showMessageDialog(null,"Koneksi gagal ! check server");                       
                    }         
                    //getData();
                    stm =getkoneksi.prepareStatement(str);
                    stm.setString(1,getnomorfaktur);
                    stm.setString(2,getkodebarang);
                    stm.setString(3,getnamabarang);
                    stm.setString(4,getsatuan);
                    stm.setInt(5,getqty);
                    stm.setDouble(6,getharga);                    
                    stm.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Berhasil");
                    loadData();
                    clear();
                    
                }
            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null,"gagal "+e.getMessage());
            }
        
    }//GEN-LAST:event_saveActionPerformed

    private void nomor_fakturKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomor_fakturKeyTyped
        
    }//GEN-LAST:event_nomor_fakturKeyTyped

    private void nomor_fakturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomor_fakturKeyPressed
        
    }//GEN-LAST:event_nomor_fakturKeyPressed

    private void datafakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datafakturActionPerformed
        modal_faktur mdf = new modal_faktur();
        mdf.beli=this;
        mdf.setVisible(true);
             
    }//GEN-LAST:event_datafakturActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
       new menu().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void kode_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kode_barangKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            nama_barang.requestFocusInWindow();
        }
    }//GEN-LAST:event_kode_barangKeyPressed

    private void nama_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nama_barangKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            satuan.requestFocusInWindow();
        }
    }//GEN-LAST:event_nama_barangKeyPressed

    private void satuanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_satuanKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            qty.requestFocusInWindow();
        }
    }//GEN-LAST:event_satuanKeyPressed

    private void qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            harga.requestFocusInWindow();
        }
    }//GEN-LAST:event_qtyKeyPressed

    private void tabelpembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpembelianMouseClicked
        int Index = tabelpembelian.getSelectedRow();
        getnomorfaktur= tabelpembelian.getValueAt(Index,1).toString();
        getkodebarang=tabelpembelian.getValueAt(Index,2).toString();
        getnamabarang=tabelpembelian.getValueAt(Index,3).toString();
        getsatuan= tabelpembelian.getValueAt(Index,4).toString();
        getharga= Double.parseDouble(tabelpembelian.getValueAt(Index,5).toString());
        getqty= Integer.parseInt(tabelpembelian.getValueAt(Index,6).toString());
        //ambil ID barang
        int getid =Integer.parseInt(tabelpembelian.getValueAt(Index,0).toString());
        nomor_faktur.setText(getnomorfaktur);
        kode_barang.setText(getkodebarang);
        nama_barang.setText(getnamabarang);
        satuan.setText(getsatuan);
        harga.setText(Double.toString(getharga));
        qty.setText(Integer.toString(getqty));
        hapus.setEnabled(true);
        id.setText(Integer.toString(getid));
        
    }//GEN-LAST:event_tabelpembelianMouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        //getID tabel pembelian
        getkodebarang = kode_barang.getText();
        String getid = id.getText();
        String str;
        try{
            str = "DELETE FROM detail_pembelian where id= ?";
            koneksi conn = new koneksi();
            Connection getkoneksi = conn.konek();
            
            stm =getkoneksi.prepareStatement(str);
            stm.setString(1,getid);
            stm.execute();
            //System.out.println(stm);
            JOptionPane.showMessageDialog(null,getkodebarang +"Di hapus");
            clear();
            awal();
        }catch(SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_hapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buat;
    private javax.swing.JButton datafaktur;
    private javax.swing.JButton edit;
    private javax.swing.JLabel error_faktur;
    private javax.swing.JLabel error_harga;
    private javax.swing.JLabel error_kodebarang;
    private javax.swing.JLabel error_namabarang;
    private javax.swing.JLabel error_qty;
    private javax.swing.JLabel error_satuan;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField kode_barang;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JTextField nomor_faktur;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField satuan;
    private javax.swing.JButton save;
    private javax.swing.JTable tabelpembelian;
    // End of variables declaration//GEN-END:variables

    
}
