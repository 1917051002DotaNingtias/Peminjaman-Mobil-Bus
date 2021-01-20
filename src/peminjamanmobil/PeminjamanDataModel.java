/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanmobil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import peminjamanmobil.db.DBHelper;

/**
 *
 * @author SDP
 */
public class PeminjamanDataModel {
    public final  Connection conn;

    public PeminjamanDataModel(String Driver) throws SQLException {
        this.conn = DBHelper.getConnection(Driver);
    }
    
    public void addPeminjaman(Individu peminjaman) throws SQLException{
        String insertpeminjaman = "INSERT INTO peminajaman( IdPeminjaman , Tanggal , NomorKendaraan,NamaPeminjam,LamaPeminjaman,BiayaPeminjaman)"+
                "VALUES (?,?,?,?,?,?)";
        String insertIndividu = "INSERT INTO individu (IdPeminjaman, Pekerjaan )"+
                "VALUES (?,?)";
        PreparedStatement stmtpeminjaman = conn.prepareStatement(insertpeminjaman);
        stmtpeminjaman.setInt(1 ,peminjaman.getIdPeminjaman());
        stmtpeminjaman.setString(2 ,peminjaman.getTanggal());
        stmtpeminjaman.setString(3 ,peminjaman.getNomorKendaraan());
        stmtpeminjaman.setString(4 ,peminjaman.getNamaPenyewa());
        stmtpeminjaman.setInt(5 ,peminjaman.getLamaPeminjaman());
        stmtpeminjaman.setInt(6 ,peminjaman.getBiayaPeminjaman());
        stmtpeminjaman.execute();
        
        PreparedStatement stmtIndividu = conn.prepareStatement(insertIndividu);
        stmtIndividu.setInt(1 ,peminjaman.getIdPeminjaman());
        stmtIndividu.setString(2 ,peminjaman.getPekerjaan());
        stmtIndividu.execute();
        
    }
    
    public void addPeminjaman(Instansi peminjaman) throws SQLException{
        String insertpeminjaman =  "INSERT INTO peminajaman( IdPeminjaman , Tanggal , NomorKendaraan,NamaPeminjam,LamaPeminjaman,BiayaPeminjaman)"+
                "VALUES (?,?,?,?,?,?)";
        String insertInstansi = "INSERT INTO instansi (IdPeminjaman, BidangInstansi )"+
                "VALUES (?,?)";
        PreparedStatement stmtpeminjaman = conn.prepareStatement(insertpeminjaman);
        stmtpeminjaman.setInt(1 ,peminjaman.getIdPeminjaman());
        stmtpeminjaman.setString(2 ,peminjaman.getTanggal());
        stmtpeminjaman.setString(3 ,peminjaman.getNomorKendaraan());
        stmtpeminjaman.setString(4 ,peminjaman.getNamaPenyewa());
        stmtpeminjaman.setInt(5 ,peminjaman.getLamaPeminjaman());
        stmtpeminjaman.setInt(6 ,peminjaman.getBiayaPeminjaman());
        stmtpeminjaman.execute();
        
       
        PreparedStatement stmtInstansi = conn.prepareStatement(insertInstansi);
        stmtInstansi.setInt(1 ,peminjaman.getIdPeminjaman());
        stmtInstansi.setString(2 ,peminjaman.getBidangInstansi());
        stmtInstansi.execute();
        
        
    }
    
    public ObservableList<Individu>getIndividu() {
        ObservableList<Individu> data = FXCollections.observableArrayList();
        String sql = "SELECT `IdPeminjaman`,`Tanggal`,`NomorKendaraan`,`NamaPeminjam`,`LamaPeminjaman`,"
                + "`BiayaPeminjaman` , `Pekerjaan` FROM `peminajaman`NATURAL JOIN `individu`";
       
        try {
                           
            
                ResultSet rs = conn.createStatement().executeQuery(sql);    
                while (rs.next()){
                    data.add(new Individu (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7)));
                }
                
         } catch (SQLException ex) {
                            
                Logger.getLogger(PeminjamanDataModel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        
        return data;
    }
    
    public ObservableList<Instansi>getInstansi() {
        ObservableList<Instansi> data = FXCollections.observableArrayList();
        String sql = "SELECT `IdPeminjaman`,`Tanggal`,`NomorKendaraan`,`NamaPeminjam`,`LamaPeminjaman`,"
                + "`BiayaPeminjaman` , `BidangInstansi` FROM `peminajaman`NATURAL JOIN `instansi`";
       
        try {
                           
            
                ResultSet rs = conn.createStatement().executeQuery(sql);    
                while (rs.next()){
                    data.add(new Instansi (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7)));
                }
                
         } catch (SQLException ex) {
                            
                Logger.getLogger(PeminjamanDataModel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        
        
        return data;
    }
    
    public int NextIDPeminjaman() throws SQLException{
        String sql ="SELECT MAX(IdPeminjaman) from peminajaman";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
            return rs.getInt(1)==0?10000001:rs.getInt(1)+1;
        }
        return 1000001;
    }
}

