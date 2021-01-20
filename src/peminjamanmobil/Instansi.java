/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanmobil;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author SDP
 */
public class Instansi extends Peminjaman{
    private StringProperty BidangInstansi;
    
    public Instansi(Integer IdPeminjaman, String tanggal, String NomorKendaraan, String NamaPenyewa, Integer LamaPeminjaman, Integer BiayaPeminjaman , String BidangInstansi) {
        super(IdPeminjaman, tanggal, NomorKendaraan, NamaPenyewa, LamaPeminjaman, BiayaPeminjaman);
        this.BidangInstansi = new SimpleStringProperty(BidangInstansi);
    }
    
    public void setBidangInstansi(String BidangInstansi){
        this.BidangInstansi.set(BidangInstansi);
    }
     public String getBidangInstansi() {
        return BidangInstansi.get();
    }
}
