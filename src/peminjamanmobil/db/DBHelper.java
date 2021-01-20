/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanmobil.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author SDP
 */
public class DBHelper {
    private static final String Username ="root";
    private static final String Password ="";
    private static final String DB ="peminjamanmobil";
    private static final String MYCONN ="jdbc:mysql://localhost/"+DB;
    private static final String SQCONN ="jdbc:sqlite:PeminjamanMobil.sqlite";
    
    public static Connection getConnection (String driver) throws SQLException{
        Connection conn =null;
        switch( driver ){
            case "SQLITE": {
                        try {
                            Class.forName("org.sqlite.JDBC");
                            conn = DriverManager.getConnection(SQCONN,Username,Password);
                            createTable(conn, driver);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("Tidak Ada Library");
                            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                        }                
                break;
            }
            case "MYSQL" : {
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            conn = DriverManager.getConnection(MYCONN,Username,Password);
                            createTable(conn, driver);

                        } catch (ClassNotFoundException ex) {
                            System.out.println("Tidak Ada Library");
                            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
            }
            
        }
        
        
        
        return conn;
    }
        
    public static void createTable (Connection conn ,String driver) throws SQLException{
        String sqlcreate =  "";
        switch(driver){
            case "MYSQL":{
                sqlcreate ="CREATE TABLE IF NOT EXISTS `peminajaman` (" +
                        "  `IdPeminjaman` int(10) NOT NULL," +
                        "  `Tanggal` date DEFAULT NULL," +
                        "  `NomorKendaraan` varchar(100) DEFAULT NULL," +
                        "  `NamaPeminjam` varchar(100) DEFAULT NULL," +
                        "  `LamaPeminjaman` int(100) DEFAULT NULL," +
                        "  `BiayaPeminjaman` int(100) DEFAULT NULL," +
                        "  PRIMARY KEY (`IdPeminjaman`)" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;" +
              
                        "CREATE TABLE IF NOT EXISTS `individu` (" +
                        "  `IdPeminjaman` int(10) NOT NULL," +
                        "  `Pekerjaan` varchar(100) DEFAULT NULL," +
                        "  PRIMARY KEY (`IdPeminjaman`)," +
                        "  FOREIGN KEY (`IdPeminjaman`) REFERENCES `peminajaman` (`IdPeminjaman`) ON DELETE CASCADE" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;" +
                        
                        "CREATE TABLE IF NOT EXISTS `instansi` (" +
                        "  `IdPeminjaman` int(10) NOT NULL," +
                        "  `BidangInstansi` varchar(100) DEFAULT NULL," +
                        "  PRIMARY KEY (`IdPeminjaman`)," +
                        "  FOREIGN KEY (`IdPeminjaman`) REFERENCES `peminajaman` (`IdPeminjaman`) ON DELETE CASCADE" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=latin1;" ;
                        
                break;
            }
            case "SQLITE":{
                sqlcreate = "CREATE TABLE IF NOT EXISTS peminajaman (" +
                        "    IdPeminjaman    INT (10)      PRIMARY KEY," +
                        "    Tanggal         DATE," +
                        "    NomorKendaraan  VARCHAR (100)," +
                        "    NamaPeminjam    VARCHAR (100)," +
                        "    LamaPeminjaman  INT (100)," +
                        "    BiayaPeminjaman INT (100) " +
                        ");" +
                        "CREATE TABLE IF NOT EXISTS individu (" +
                        "    IdPeminjaman INT (10)      PRIMARY KEY" +
                        "                               REFERENCES Peminajaman (IdPeminjaman) ON DELETE RESTRICT" +
                        "                                                                     ON UPDATE CASCADE," +
                        "    Pekerjaan    VARCHAR (100) " +
                        ");" +
                        "CREATE TABLE IF NOT EXISTS instansi (" +
                        "    IdPeminjaman   INT (10)      PRIMARY KEY" +
                        "                                 REFERENCES Peminajaman (IdPeminjaman) ON DELETE RESTRICT" +
                        "                                                                       ON UPDATE CASCADE," +
                        "    BidangInstansi VARCHAR (100) " +
                        ");" ;
                break;
            }
            
        }
        String sqls [] = sqlcreate.split(";");
        for(String sql : sqls){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        }
        
        
        
        
    }
    }

   
    



