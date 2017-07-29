package pos.transaksi;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import pos.modul.koneksi;
import java.io.*;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import pos.transaksi.getcart;
import pos.menu;

/**
 *
 * @author rohmat
 */
public class penjualan extends javax.swing.JFrame {
    PreparedStatement stm;
    Statement st;
    ResultSet rs;
    String getnamabarang,getkodebarang,getnomor_faktur;
    int x,y,getjumlah;
    Double getTotal,getharga,getBayar,total,belanja;
    //Map<String ,Object> parameters = new HashMap<>();
    modelpenjualan getpenjualan = new modelpenjualan();
    private Object getkoneksi;
    private Object JDBCTutorialUtilities;
    JasperPrint jp;
    JasperReport Report;
    JasperDesign jd;
    
    public penjualan() {
        initComponents();
        load_data();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nama_barang = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        daftarbarang = new javax.swing.JTable();
        cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        kode_barang = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        subtotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        hapus_cart = new javax.swing.JButton();
        checkout = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        kembalian = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1234, 750));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("PENJUALAN");

        jLabel2.setText("NAMA BARANG");

        jLabel3.setText("HARGA");

        jLabel4.setText("JUMLAH");

        jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jumlahKeyPressed(evt);
            }
        });

        daftarbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        daftarbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daftarbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(daftarbarang);

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });

        jLabel1.setText("CARI BARANG");

        tambah.setText("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        batal.setText("BATAL");

        jLabel5.setText("KODE BARANG");

        cart.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(cart);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("CART");

        jLabel6.setText("TOTAL");

        hapus_cart.setText("DELETE");
        hapus_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_cartActionPerformed(evt);
            }
        });

        checkout.setText("CHECK OUT");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        checkout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                checkoutKeyPressed(evt);
            }
        });

        jLabel8.setText("BAYAR");

        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bayarKeyPressed(evt);
            }
        });

        jLabel9.setText("KEMBALI");

        back.setText("BACK MENU");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back)
                .addGap(286, 286, 286)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(258, 258, 258))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_barang)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tambah)
                                .addGap(18, 18, 18)
                                .addComponent(batal))
                            .addComponent(kode_barang, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(hapus_cart)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkout)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(kembalian)
                                        .addComponent(subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                        .addComponent(bayar)))
                                .addGap(10, 10, 10)))))
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(kode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(batal)
                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(hapus_cart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkout)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(307, 307, 307))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void clear()
    {
        kode_barang.setText("");
        nama_barang.setText("");
        harga.setText("");
        jumlah.setText("");
        kode_barang.requestFocusInWindow();
    }
    public void save() throws JRException
    {
        int baris=0;
        baris = getpenjualan.count();
        int cols=4;
        String [][] data =new String [baris][cols];
        for(int x=0;x<data.length;x++){
            for(int y=0;y<cols;y++){
                data[x][y]=cart.getValueAt(x,y).toString();
            }
        }
        Date dateNow = new Date();
        SimpleDateFormat ft = 
        new SimpleDateFormat ("yyyy.MM.dd-hh.mm.ss");        
        String formatfaktur=ft.format(dateNow);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        //System.out.println(dateFormat.format(date));

        getnomor_faktur="PJ"+formatfaktur;
        getTotal=Double.parseDouble(this.subtotal.getText());
        getBayar=Double.parseDouble(this.bayar.getText());
            try {
                koneksi conn = new koneksi();
                Connection getkoneksi = conn.konek();
                getkoneksi.setAutoCommit(false);
                String str ="INSERT INTO penjualan (nomor_faktur,date,total,bayar)VALUES (?,?,?,?)";
                stm=getkoneksi.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
                stm.setString(1,getnomor_faktur);
                stm.setString(2,dateFormat.format(date));
                stm.setDouble(3,getTotal);
                stm.setDouble(4,getBayar);
                stm.executeUpdate();
                ResultSet rs = stm.getGeneratedKeys();
                    int Key = 0;
                    if (rs.next()) {
                        Key = rs.getInt(1);
                    }
                    //System.out.println(Key);
                    for(int x=0;x<data.length;x++){
                        String qry ="INSERT INTO detail_penjualan (nomor_faktur_id,kode_barang,nama_barang,qty,harga)VALUES(?,?,?,?,?)";    
                        stm =getkoneksi.prepareStatement(qry);
                        stm.setInt(1,Key);
                        stm.setString(2,data[x][0]);
                        stm.setString(3,data[x][1]);
                        stm.setString(4,data[x][2]);
                        stm.setString(5,data[x][3]);
                        stm.executeUpdate();
//                        System.out.print(data[x][0] + " "); //output get kode barang
//                        System.out.print(data[x][1] + " "); //output get nama barang
//                        System.out.print(data[x][2] + " "); //output get qty
//                        System.out.print(data[x][3] + " "); //output get harga
                        getkoneksi.commit();
                    }
                     //JOptionPane.showMessageDialog(null,"Transaksi Berhasil");
                    
                    
                    Map<String, Object> parameters = new HashMap<>();
                 
                       parameters.put("id",Key);
                        jd= JRXmlLoader.load("src/pos/report/kwitansi.jrxml");
                        Report = JasperCompileManager.compileReport(jd);
                        jp = JasperFillManager.fillReport(Report,parameters,getkoneksi);
                        JasperViewer.viewReport(jp);
                   
                } catch (SQLException ex) {                   
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }//end catch
            
        getpenjualan.getTabel().setRowCount(0);
        bayar.setText("");
        subtotal.setText("");
        kembalian.setText("");
    }
    private void daftarbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarbarangMouseClicked
        
        int Index = daftarbarang.getSelectedRow();
        getkodebarang=daftarbarang.getValueAt(Index,0).toString();
        getnamabarang=daftarbarang.getValueAt(Index,1).toString();
        getharga =Double.parseDouble(daftarbarang.getValueAt(Index,2).toString());
        kode_barang.setText(getkodebarang);
        nama_barang.setText(getnamabarang);
        harga.setText(Double.toString(getharga));        
        jumlah.requestFocusInWindow();
    }//GEN-LAST:event_daftarbarangMouseClicked

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cari();
        }
    }//GEN-LAST:event_cariKeyPressed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        if(kode_barang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Kode barang is required ..");
            kode_barang.requestFocusInWindow();
        }else if(jumlah.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Qty is required ..");
            jumlah.requestFocusInWindow();
        }
        viewcart();
        clear();
    }//GEN-LAST:event_tambahActionPerformed

    private void hapus_cartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_cartActionPerformed
        int id =cart.getSelectedRow();
        if(id > 0 ){
            getpenjualan.getTabel().removeRow(cart.getSelectedRow());
            DecimalFormat formatter = new DecimalFormat("");
            subtotal.setText(formatter.format(getpenjualan.countSubtotal()));
        }else{
            JOptionPane.showMessageDialog(null,"Pilih data cart yang akan di Hapus");
        }
        
    }//GEN-LAST:event_hapus_cartActionPerformed

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        try {
            save();
        } catch (JRException ex) {
            Logger.getLogger(penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_checkoutActionPerformed

    private void bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyPressed
        char getChar = evt.getKeyChar();
        if(getChar == evt.VK_ENTER){
            Double getKembali;
            getBayar= Double.parseDouble(bayar.getText());
            getTotal = Double.parseDouble(subtotal.getText()); 
            getKembali =getBayar - getTotal;
            DecimalFormat ft = new DecimalFormat();
            kembalian.setText(ft.format(getKembali));
            checkout.requestFocusInWindow();
        }
       
    }//GEN-LAST:event_bayarKeyPressed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void jumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahKeyPressed
       int key = evt.getKeyChar();
       if(key==evt.VK_ENTER){
           if(kode_barang.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Kode barang is required ..");
                kode_barang.requestFocusInWindow();
            }else if(jumlah.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Qty is required ..");
                jumlah.requestFocusInWindow();
            }
            viewcart();
            clear();
       }
        
    }//GEN-LAST:event_jumlahKeyPressed

    private void checkoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_checkoutKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                save();
            } catch (JRException ex) {
                Logger.getLogger(penjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_checkoutKeyPressed
   
    public void cari()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("KODE BARANG");
        model.addColumn("NAMA BARANG");
        model.addColumn("HARGA");
        model.addColumn("STOK");
        model.addColumn("KETERANGAN");
        try{
            String sql = "SELECT * FROM barang WHERE nama_barang LIKE ? ";               
            koneksi conn = new koneksi();
            Connection getkoneksi = conn.konek();
            stm = getkoneksi.prepareStatement(sql);
            stm.setString(1, cari.getText()+"%");           
            rs = stm.executeQuery();
            //menampilkan ke table
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            daftarbarang.setModel(model);
            //System.out.println(rs);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
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
            if(getkoneksi==null){
                JOptionPane.showMessageDialog(null, "KOneksi gagal ! periksa server");
            }
            st = getkoneksi.createStatement();
            rs = st.executeQuery(sql);
            //menampilkan ke table
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            daftarbarang.setModel(model);
        }catch(Exception e){
            
        }
    }
    public void viewcart()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("KODE BARANG");
        model.addColumn("NAMA BARANG");
        model.addColumn("HARGA");
        model.addColumn("JUMLAH");
        model.addColumn("TOtal");
        
        NumberFormat formatter = NumberFormat.getInstance();
        getjumlah=Integer.parseInt(this.jumlah.getText());
        getharga = Double.parseDouble(harga.getText());
        String [] arr = new String[10];
        arr[0]=getkodebarang;
        arr[1]=getnamabarang;
        arr[2]=jumlah.getText();
        arr[3]=harga.getText();
        total =getjumlah * getharga;
        arr[4]=Double.toString(total);
        //arr[4]=formatter.format(total);
        getpenjualan.getTabel().addRow(arr);
        cart.setModel(getpenjualan.getTabel());
        //subtotal.setText(formatter.format(getpenjualan.countSubtotal()));
        String t = Double.toString(getpenjualan.countSubtotal());
        
        subtotal.setText(t);
        
        Double belanja =getpenjualan.countSubtotal();
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
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton batal;
    private javax.swing.JTextField bayar;
    private javax.swing.JTextField cari;
    private javax.swing.JTable cart;
    private javax.swing.JButton checkout;
    private javax.swing.JTable daftarbarang;
    private javax.swing.JButton hapus_cart;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField kode_barang;
    private java.awt.Label label1;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JTextField subtotal;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
