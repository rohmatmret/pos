/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.modul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author rohmat
 */
public class koneksi {
    Connection conn=null;
    private static final String user="root";
    private static final String password="";
    public String table,getkoneksi;
 
    public  Connection konek()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");            
        }catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos",user,password);
            if(conn !=null){
                //System.out.print("koneksi succes");
            }
            return conn;
        }catch(SQLException e){
            
        }
        return null;
    }
    
    public void insert(String data)
    {
        String sql = "INSERT INTO "+table+"";
    }
    public void check_koneksi(String getkoneksi)
    {
        if(getkoneksi==null){
             JOptionPane.showMessageDialog(null,"Koneksi gagal ! check server");
        }
       
    }
}
