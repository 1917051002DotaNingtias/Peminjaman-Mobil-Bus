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
public class Individu extends Peminjaman{
    private StringProperty Pekerjaan;

    public Individu(Integer IdPeminjaman, String tanggal, String NomorKendaraan, String NamaPenyewa, Integer LamaPeminjaman, Integer BiayaPeminjaman , String Pekerjaan) {
        super(IdPeminjaman, tanggal, NomorKendaraan, NamaPenyewa, LamaPeminjaman, BiayaPeminjaman);
        this.Pekerjaan= new SimpleStringProperty(Pekerjaan);
    }
    
    public void setPekerjaan(String Pekerjaan){
        this.Pekerjaan.set(Pekerjaan);
    }
    
    public String getPekerjaan() {
        return Pekerjaan.get();
    }
}
