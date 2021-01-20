/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanmobil;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author SDP
 */
public abstract class Peminjaman {
    private IntegerProperty IdPeminjaman;
    private StringProperty tanggal;
    private StringProperty NomorKendaraan;
    private StringProperty NamaPenyewa;
    private IntegerProperty LamaPeminjaman;
    private IntegerProperty BiayaPeminjaman;

    public Peminjaman(Integer IdPeminjaman, String tanggal, String NomorKendaraan, String NamaPenyewa, Integer LamaPeminjaman, Integer BiayaPeminjaman) {
        this.IdPeminjaman= new SimpleIntegerProperty(IdPeminjaman);
        this.tanggal= new SimpleStringProperty( tanggal);
        this.NomorKendaraan= new SimpleStringProperty(NomorKendaraan);
        this.NamaPenyewa= new SimpleStringProperty(NamaPenyewa);
        this.LamaPeminjaman= new SimpleIntegerProperty(LamaPeminjaman);
        this.BiayaPeminjaman= new SimpleIntegerProperty(BiayaPeminjaman);
    }
 

    public String getTanggal() {
        return tanggal.get();
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }

    public String getNomorKendaraan() {
        return NomorKendaraan.get();
    }

    public void setNomorKendaraan(String NomorKendaraan) {
        this.NomorKendaraan.set(NomorKendaraan);
    }

    public String getNamaPenyewa() {
        return NamaPenyewa.get();
    }

    public void setNamaPenyewa(String NamaPenyewa) {
        this.NamaPenyewa.set(NamaPenyewa);
    }

    public Integer getIdPeminjaman() {
        return IdPeminjaman.get();
    }

    public void setIdPeminjaman(Integer IdPeminjaman) {
        this.IdPeminjaman.set(IdPeminjaman);
    }
    public Integer getLamaPeminjaman() {
        return LamaPeminjaman.get();
    }
    public void setLamaPeminjaman(Integer LamaPeminjaman) {
        this.LamaPeminjaman.set(LamaPeminjaman);
    }
    public Integer getBiayaPeminjaman() {
        return BiayaPeminjaman.get();
    }
    public void setBiayaPeminjaman(Integer BiayaPeminjaman) {
        this.LamaPeminjaman.set(BiayaPeminjaman);
    }
    
    
}
