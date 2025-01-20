/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony's PC
 */
public class ConnectDB {

    Connection con; //---> Interface penyedia method utk menghubungi database
    PreparedStatement pst;
    ResultSet rs; //---> untuk menyimpan hasil proses query kedalam database
    Statement st; //---> untuk mngeksekusi query

    public ConnectDB() {
        try {
            //konstruktor koneksi
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/kostaira", "root", "");
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDB0(String IdBooking, String KodeKamar, String id_cust, String TglMasuk, String LamaSewa, String TglKeluar, String kode_pembayaran, String TotalHarga) {
        try {
            String sql = "insert into pemesanan values (?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, IdBooking);
            pst.setString(2, KodeKamar);
            pst.setString(3, id_cust);
            pst.setString(4, TglMasuk);
            pst.setString(5, TglKeluar);
            pst.setString(6, LamaSewa);
            pst.setString(7, TotalHarga);
            pst.setString(8, kode_pembayaran);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDB(String id_cust, String noktp, String nama, String jeniskelamin, String alamat, String nohppribadi, String nohpdarurat) {
        try {
            String sql = "insert into pelanggan values (?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, id_cust);
            pst.setString(2, noktp);
            pst.setString(3, nama);
            pst.setString(4, jeniskelamin);
            pst.setString(5, alamat);
            pst.setString(6, nohppribadi);
            pst.setString(7, nohpdarurat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDB(String id_user, String username, String password, String akses) {
        try {
            String sql = "insert into login_user values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, id_user);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, akses);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDB1(String kode_kamar, String lokasi_kamar, String Kjenis_Kamar, String dsc_fasilitas, String status, byte[] gambar) {
        try {
            String sql = "insert into kamar values (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, kode_kamar);
            pst.setString(2, lokasi_kamar);
            pst.setString(3, Kjenis_Kamar);
            pst.setString(4, dsc_fasilitas);
            pst.setString(5, status);
            pst.setBytes(6, gambar);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDB(String id_cust, String noktp, String nama, String jeniskelamin, String alamat, String nohppribadi, String nohpdarurat) {
        try {
            String sql = "update pelanggan set NoKTP=?, NamaLengkap=?, JenisKelamin=?, Alamat=?, NoHpPribadi=?, NoHpDarurat=? where id_cust =?";
            pst = con.prepareStatement(sql);
            pst.setString(1, noktp);
            pst.setString(2, nama);
            pst.setString(3, jeniskelamin);
            pst.setString(4, alamat);
            pst.setString(5, nohppribadi);
            pst.setString(6, nohpdarurat);
            pst.setString(7, id_cust);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDB(String id_user, String username, String password, String akses) {
        try {
            String sql = "update login_user set username=?, password=?, akses=? where id_user =?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, akses);
            pst.setString(4, id_user);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDB(String kode_kamar, String lokasi_kamar, String Kjenis_Kamar, String dsc_fasilitas, String status) {
        try {
            String sql = "update kamar set lokasi_kamar=?, Kjenis_Kamar=?, dsc_fasilitas=?, status=? where kode_kamar =?";
            pst = con.prepareStatement(sql);
            pst.setString(1, lokasi_kamar);
            pst.setString(2, Kjenis_Kamar);
            pst.setString(3, dsc_fasilitas);
            pst.setString(4, status);
            pst.setString(5, kode_kamar);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateGbr(String kode_kamar, byte[] gambar) {
        try {
            String sql = "update kamar set gambar=? where kode_kamar =?";
            pst = con.prepareStatement(sql);
            pst.setBytes(1, gambar);
            pst.setString(2, kode_kamar);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDB(String kode_kamar, String status) {
        try {
            String sql = "update kamar set status=? where kode_kamar =?";
            pst = con.prepareStatement(sql);
            pst.setString(1, status);
            pst.setString(2, kode_kamar);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet selectDB() {
        try {
            String sql = "select * from login_user";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB(String id_user) {
        try {
            String sql = "select id_user from login_user";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB0(String idBooking) {
        try {
            String sql = "select * from pemesanan";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB1(String id_cust) {
        try {
            String sql = "select id_cust from pelanggan";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB2(String kode_kamar) {
        try {
            String sql = "select * from kamar";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB3(String Kjenis_Kamar) {
        try {
            String sql = "SELECT jenis_kamar, harga FROM jns_kamar WHERE KJenis_Kamar='" + Kjenis_Kamar + "'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB4() {
        try {
            String sql = "SELECT kode_kamar, lokasi_kamar, kamar.Kjenis_Kamar, jns_kamar.jenis_kamar, dsc_fasilitas, jns_kamar.harga, status "
                    + "FROM kamar, jns_kamar WHERE kamar.Kjenis_Kamar=jns_kamar.Kjenis_Kamar ORDER BY kode_kamar ASC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB5(String cari) {
        try {
            String sql = "SELECT id_cust, NoKTP,  NamaLengkap, Alamat, JenisKelamin, NoHpPribadi, NoHpDarurat, id_user, login_user.username, login_user.password, akses From pelanggan "
                    + "INNER JOIN login_user ON pelanggan.id_cust=login_user.id_user where id_cust LIKE '%" + cari
                    + "%' OR NamaLengkap LIKE '%" + cari + "%'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB6(String cari) {
        try {
            String sql = "SELECT kode_kamar, lokasi_kamar, kamar.Kjenis_Kamar, jns_kamar.jenis_kamar, dsc_fasilitas, jns_kamar.harga, status "
                    + "FROM kamar INNER JOIN jns_kamar ON kamar.Kjenis_Kamar=jns_kamar.Kjenis_Kamar WHERE kode_kamar LIKE '%" + cari
                    + "%' OR lokasi_kamar LIKE '%" + cari + "%'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB7(String kode_kamar) {
        try {
            String sql = "select * from kamar where kode_kamar='" + kode_kamar + "'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB8() {
        try {
            String sql = "SELECT kode_kamar, lokasi_kamar, jns_kamar.jenis_kamar, dsc_fasilitas, jns_kamar.harga, status "
                    + "FROM kamar, jns_kamar WHERE kamar.Kjenis_Kamar=jns_kamar.Kjenis_Kamar ORDER BY kode_kamar ASC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB9(String cari) {
        try {
            String sql = "SELECT kode_kamar, lokasi_kamar, jns_kamar.jenis_kamar, dsc_fasilitas, jns_kamar.harga, status "
                    + "FROM kamar INNER JOIN jns_kamar ON kamar.Kjenis_Kamar=jns_kamar.Kjenis_Kamar WHERE jns_kamar.jenis_kamar LIKE '" + cari
                    + "'";;
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB10() {
        try {
            String sql = "SELECT kode_kamar, lokasi_kamar, jns_kamar.jenis_kamar, dsc_fasilitas, jns_kamar.harga, status "
                    + "FROM kamar INNER JOIN jns_kamar ON kamar.Kjenis_Kamar=jns_kamar.Kjenis_Kamar WHERE jns_kamar.jenis_kamar LIKE 'Kamar 1'";;
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet selectDB11() {
        try {
            String sql = "SELECT kode_kamar, lokasi_kamar, jns_kamar.jenis_kamar, dsc_fasilitas, jns_kamar.harga, status "
                    + "FROM kamar INNER JOIN jns_kamar ON kamar.Kjenis_Kamar=jns_kamar.Kjenis_Kamar WHERE jns_kamar.jenis_kamar LIKE 'Kamar 2'";;
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet slctDB() {
        try {
            String sql = "SELECT id_cust, NoKTP,  NamaLengkap, Alamat, JenisKelamin, NoHpPribadi, NoHpDarurat, id_user, login_user.username, login_user.password, akses From pelanggan "
                    + "INNER JOIN login_user ON pelanggan.id_cust=login_user.id_user ORDER BY id_cust ASC";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet conLogin(String username, String password) {
        try {
            String sql = "select * from login_user where username='" + username + "' AND password='" + password + "'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet gabungDB(String username) {
        try {
            String sql = "SELECT * From pelanggan INNER JOIN login_user ON pelanggan.id_cust=login_user.id_user WHERE login_user.username='" + username + "'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
    }

    public void deleteDB(String id_cust) {
        try {
            String sql = "delete from pelanggan where id_cust =?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id_cust);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteDB(String id_cust, String id_user) {
        try {
            String sql = "delete from login_user where id_user =?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id_user);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletesDB(String kode_kamar) {
        try {
            String sql = "delete from kamar where kode_kamar=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, kode_kamar);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
