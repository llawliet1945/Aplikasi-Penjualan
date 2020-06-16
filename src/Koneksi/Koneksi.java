package Koneksi;
/**
 *
 * @author Muhammad YusuF Alpian - 201743501031
 */
import java.sql.*;
public class Koneksi {
    private static Connection config;
    public static Connection configDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException yusuf) {
            System.err.println("koneksi gagal "+yusuf); //perintah menampilkan error pada koneksi
        }            
        String link="jdbc:mysql://127.0.0.1:3306/penjualan"; //url database
        try{
            config = DriverManager.getConnection(link,"root","");
        }catch(SQLException yusuf){
            System.out.printf("Gagal KONEK DB"+yusuf);
        }
        return config;
    }    
}