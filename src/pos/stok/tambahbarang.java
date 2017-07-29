package pos.stok;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pos.modul.koneksi;
import pos.menu;
/**
 *
 * @author rohmat
 */
public class tambahbarang extends javax.swing.JFrame {
    
    private String getkode_barang,getnama_barang,getketerangan;
    private Integer getstok;
    private Double getharga;
    boolean valid=true;
    PreparedStatement stm;
    Statement st;
    ResultSet rs;
    public tambahbarang() {
        initComponents();
        this.awal();
        load_data();
    }
    public void clear()
    {
        kode_barang.setText("");
        nama_barang.setText("");
        harga.setText("");
        stok.setText("");
        keterangan.setText("");
    }
    public final void awal()
    {
        kode_barang.disable();
        nama_barang.disable();
        stok.disable();
        harga.disable();
        keterangan.disable();
        tambah.requestFocusInWindow();
        edit.setEnabled(false);
        hapus.setEnabled(false);
        save.setEnabled(false);
        batal.setEnabled(false);
    }
    public void active()
    {
        kode_barang.setEnabled(true);
        nama_barang.setEnabled(true);
        stok.setEnabled(true);
        harga.setEnabled(true);
        keterangan.setEnabled(true);
        kode_barang.requestFocusInWindow();
        tambah.setEnabled(false);
    }        
    public void validasi()
    {
        boolean valid=true;
        if(kode_barang.getText().isEmpty()){
            errorlabel_kodebarang.setText("kode barang required ..");
            kode_barang.requestFocusInWindow();
            valid =false;
        }
        if(nama_barang.getText().isEmpty()){
            errorlabel_namabarang.setText("Nama barang required ..");
            valid =false;
        }
        if(harga.getText().isEmpty()){
            errorlabel_harga.setText("Harga Required ..");
            valid =false;
        }
        if(stok.getText().isEmpty()){
            errorlabel_stok.setText("Stok Required ..");
            valid =false;
        }
        if(keterangan.getText().isEmpty()){
            errorlabel_keterangan.setText("Keterangan Required ..");
            valid =false;
        }
    }
    public void getData()
    {
        getnama_barang = nama_barang.getText();
        getkode_barang=kode_barang.getText();
        getstok=Integer.parseInt(this.stok.getText());
        getharga=Double.parseDouble(this.harga.getText());
        getketerangan =keterangan.getText();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        kode_barang = new javax.swing.JTextField();
        nama_barang = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        stok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebarang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        keterangan = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        errorlabel_kodebarang = new javax.swing.JLabel();
        errorlabel_namabarang = new javax.swing.JLabel();
        errorlabel_harga = new javax.swing.JLabel();
        errorlabel_stok = new javax.swing.JLabel();
        errorlabel_keterangan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("KODE BARANG");

        jLabel2.setText("NAMA BARANG");

        jLabel3.setText("HARGA");

        jLabel4.setText("STOK");

        tambah.setText("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        batal.setText("BATAL");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        kode_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kode_barangKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kode_barangKeyTyped(evt);
            }
        });

        nama_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nama_barangKeyPressed(evt);
            }
        });

        harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hargaKeyPressed(evt);
            }
        });

        stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stokKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("FORM TAMBAH BARANG");

        tablebarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tablebarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablebarang);

        jLabel6.setText("KETERANGAN");

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        back.setText("BACK TO MENU");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        errorlabel_kodebarang.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        errorlabel_kodebarang.setForeground(java.awt.Color.red);

        errorlabel_namabarang.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        errorlabel_namabarang.setForeground(java.awt.Color.red);

        errorlabel_harga.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        errorlabel_harga.setForeground(java.awt.Color.red);

        errorlabel_stok.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        errorlabel_stok.setForeground(java.awt.Color.red);

        errorlabel_keterangan.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        errorlabel_keterangan.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(back)
                        .addGap(234, 234, 234)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorlabel_kodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tambah)
                                .addGap(27, 27, 27)
                                .addComponent(save)
                                .addGap(18, 18, 18)
                                .addComponent(batal)
                                .addGap(18, 18, 18)
                                .addComponent(hapus)
                                .addGap(18, 18, 18)
                                .addComponent(edit))
                            .addComponent(errorlabel_keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorlabel_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorlabel_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorlabel_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(kode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(errorlabel_kodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(errorlabel_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorlabel_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorlabel_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorlabel_keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(save)
                    .addComponent(batal)
                    .addComponent(hapus)
                    .addComponent(edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        clear();
        hapus.setEnabled(false);
        edit.setEnabled(false);
        active();
        save.setEnabled(true);
        batal.setEnabled(true);
    }//GEN-LAST:event_tambahActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
      
        // validasi data    
        validasi();
        if(valid == true){
            getData();
            try{
            String str ="INSERT INTO barang "
                    +"(kode_barang,nama_barang,harga,stok,keterangan)VALUES"
                    +"(?,?,?,?,?)";
            koneksi conn = new koneksi();
                try (Connection getkoneksi = conn.konek()) {
                    if(getkoneksi == null){
                        JOptionPane.showMessageDialog(null,"Koneksi gagal ! check server");
                        clear();
                        awal();
                    }                    
                    stm =getkoneksi.prepareStatement(str);
                    stm.setString(1,getkode_barang);
                    stm.setString(2,getnama_barang);
                    stm.setDouble(3,getharga);
                    stm.setInt(4,getstok);
                    stm.setString(5,getketerangan);
                    stm.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Berhasil");
                }
            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null,"gagal "+e.getMessage());
            }
            load_data();
            clear();
            awal();
            tambah.setEnabled(true);
        }
        
    }//GEN-LAST:event_saveActionPerformed

    private void kode_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kode_barangKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            nama_barang.requestFocusInWindow();
        }
    }//GEN-LAST:event_kode_barangKeyPressed

    private void nama_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nama_barangKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            harga.requestFocusInWindow();
        }
    }//GEN-LAST:event_nama_barangKeyPressed

    private void hargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           stok.requestFocusInWindow();
        }
    }//GEN-LAST:event_hargaKeyPressed

    private void stokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stokKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            keterangan.requestFocusInWindow();
        }
    }//GEN-LAST:event_stokKeyPressed

    private void tablebarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangMouseClicked
        active();
        edit.setEnabled(true);
        hapus.setEnabled(true);
        NumberFormat formatter = new DecimalFormat("");      
        kode_barang.setEnabled(false);
        int row = tablebarang.getSelectedRow();
        getkode_barang = tablebarang.getValueAt(row,0).toString();
        getnama_barang=tablebarang.getValueAt(row,1).toString();
        getharga=Double.parseDouble(tablebarang.getValueAt(row,2).toString());
        getstok=Integer.parseInt(tablebarang.getValueAt(row,3).toString());
        getketerangan =tablebarang.getValueAt(row,4).toString();
        
        // view to textfield
        kode_barang.setText(getkode_barang);
        nama_barang.setText(getnama_barang);
        stok.setText(Integer.toString(getstok));
        harga.setText(formatter.format(getharga));
        keterangan.setText(getketerangan);
        kode_barang.requestFocusInWindow();
    }//GEN-LAST:event_tablebarangMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        getnama_barang = nama_barang.getText();
        getkode_barang=kode_barang.getText();
        getstok=Integer.parseInt(this.stok.getText());
        getharga=Double.parseDouble(this.harga.getText());
        getketerangan =keterangan.getText();
        
        // validasi data
        if(getnama_barang == null){
            JOptionPane.showInternalMessageDialog(null,"nama barang harus di isi");
            nama_barang.requestFocusInWindow();
        }else if(getkode_barang == null){
            JOptionPane.showMessageDialog(null,"Kode barang tidak boleh kosong");
            kode_barang.requestFocusInWindow();
        }else if(getharga == null){
            JOptionPane.showMessageDialog(null,"Kode barang tidak boleh kosong");
            harga.requestFocusInWindow();
        }else if(getstok == null){
            JOptionPane.showMessageDialog(null,"Stok barang tidak boleh kosong");
            stok.requestFocusInWindow();
        }
        
        //JOptionPane.showMessageDialog(null,getstok);
        
        try{
            String str ="UPDATE barang SET nama_barang =?,harga = ?,stok = ?,keterangan = ? WHERE kode_barang = ? ";                    
            koneksi conn = new koneksi();
            try (Connection getkoneksi = conn.konek()) {
                if(getkoneksi == null){
                    JOptionPane.showMessageDialog(null,"Koneksi gagal ! check server");
                    nama_barang.requestFocusInWindow();
                }
                //conn.konek().prepareStatement(str);
                stm =getkoneksi.prepareStatement(str);
                
                stm.setString(1,getnama_barang);
                stm.setDouble(2,getharga);
                stm.setInt(3,getstok);
                stm.setString(4,getketerangan);
                stm.setString(5,getkode_barang);
                stm.execute();
                JOptionPane.showMessageDialog(null,"Berhasil");
            }
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"gagal "+e.getMessage());
        }
        
        load_data();
        clear();
        awal();
        tambah.setEnabled(true);
    }//GEN-LAST:event_editActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        getkode_barang=kode_barang.getText();
        int confirm = JOptionPane.showConfirmDialog(null,"Yakin akan di hapus","Confirm",JOptionPane.INFORMATION_MESSAGE,JOptionPane.YES_NO_OPTION);
        if(confirm ==JOptionPane.OK_OPTION){
            try{
            String str ="DELETE FROM barang  WHERE kode_barang = ? ";                    
            koneksi conn = new koneksi();
                try (Connection getkoneksi = conn.konek()) {
                    if(getkoneksi == null){
                        JOptionPane.showMessageDialog(null,"Koneksi gagal ! check server");
                        nama_barang.requestFocusInWindow();
                    }

                    stm =getkoneksi.prepareStatement(str);
                    stm.setString(1,getkode_barang);
                    stm.execute();
                    JOptionPane.showMessageDialog(null,getkode_barang +"Di hapus");
                }
            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null,"gagal "+e.getMessage());
            }
            load_data();
            clear();
            awal();
        }//endif
       
    }//GEN-LAST:event_hapusActionPerformed

    private void kode_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kode_barangKeyTyped
        
    }//GEN-LAST:event_kode_barangKeyTyped

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
       awal();
    }//GEN-LAST:event_batalActionPerformed
    public final void load_data()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("KODE BARANG");
        model.addColumn("NAMA BARANG");
        model.addColumn("HARGA");
        model.addColumn("STOK");
        model.addColumn("KETERANGAN");
        try{
            String sql = "SELECT * FROM barang";            
            koneksi conn = new koneksi();
            Connection getkoneksi = conn.konek();
            if(getkoneksi == null){
                JOptionPane.showMessageDialog(null,"KOneksi gagal ! periksa server");
            }
            st = getkoneksi.createStatement();
            rs = st.executeQuery(sql);
            //menampilkan ke table
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            tablebarang.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tambahbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambahbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambahbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambahbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambahbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton batal;
    private javax.swing.JButton edit;
    private javax.swing.JLabel errorlabel_harga;
    private javax.swing.JLabel errorlabel_keterangan;
    private javax.swing.JLabel errorlabel_kodebarang;
    private javax.swing.JLabel errorlabel_namabarang;
    private javax.swing.JLabel errorlabel_stok;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keterangan;
    private javax.swing.JTextField kode_barang;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JButton save;
    private javax.swing.JTextField stok;
    private javax.swing.JTable tablebarang;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
