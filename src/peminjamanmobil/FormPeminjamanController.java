/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanmobil;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author SDP
 */
public class FormPeminjamanController implements Initializable {
    
    
    @FXML
    private TextField tfidpeminjaman;

    @FXML
    private TextField tfnoplat;

    @FXML
    private TextField tfnama;

    @FXML
    private TextField tflama;

    @FXML
    private TextField tfbiaya;

    @FXML
    private TextField tfpekerjaan;

    @FXML
    private DatePicker tftanggal;
    

    @FXML
    private Button btnSimpanData;

    @FXML
    private Button btnReloadData;

    @FXML
    private Button btnClearForm;

    @FXML
    private TableView<Individu> tblPeminjaman;

    @FXML
    private TableColumn<Individu, Integer> colidpeminjaman;

    @FXML
    private TableColumn<Individu, String> coltanggal;

    @FXML
    private TableColumn<Individu, String> colnoplat;

    @FXML
    private TableColumn<Individu, String> colnama;

    @FXML
    private TableColumn<Individu, Integer> collama;

    @FXML
    private TableColumn<Individu, Integer> colbiaya;

    @FXML
    private TableColumn<Individu, String> colpekerjaan;

    @FXML
    private Label lblDBStatus;
    
      @FXML
    private Label lblstatussimpan;
      
    private PeminjamanDataModel pdm;

    @FXML
    void handleAddAction(ActionEvent event)  {
        LocalDate ld = tftanggal.getValue();
        String tgl = String.format("%d-%02d-%02d", ld.getYear() ,ld.getMonthValue(),ld.getDayOfMonth());
        Individu ind = new Individu(Integer.parseInt(tfidpeminjaman.getText()),tgl ,tfnoplat.getText() ,tfnama.getText() , Integer.parseInt(tflama.getText()), Integer.parseInt(tfbiaya.getText()), tfpekerjaan.getText());
        
        try {
            pdm.addPeminjaman(ind);
            lblstatussimpan.setText("Berhasil Simpan");
            btnReloadData.fire();
            btnClearForm.fire();
            btnReloadData1.fire();
            btnClearForm1.fire();
        } catch (SQLException ex) {
            lblstatussimpan.setText("Gagal Simpan");
            Logger.getLogger(FormPeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void handleClearAction(ActionEvent event) {
    try {
        tfidpeminjaman.setText(""+pdm.NextIDPeminjaman());
        tftanggal.setValue(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        tfnoplat.setText("");
        tfnama.setText("");
        tflama.setText("");
        tfbiaya.setText("");
        tfpekerjaan.setText("");
        
       
    } catch (SQLException ex) {
        Logger.getLogger(FormPeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    void handleReloadAction(ActionEvent event)  {
        ObservableList<Individu> data = pdm.getIndividu();
        colidpeminjaman.setCellValueFactory(new PropertyValueFactory("IdPeminjaman"));
        coltanggal.setCellValueFactory(new PropertyValueFactory("tanggal"));
        colnoplat.setCellValueFactory(new PropertyValueFactory("NomorKendaraan"));
        colnama.setCellValueFactory(new PropertyValueFactory("NamaPenyewa"));
        collama.setCellValueFactory(new PropertyValueFactory("LamaPeminjaman"));
        colbiaya.setCellValueFactory(new PropertyValueFactory("BiayaPeminjaman"));
        colpekerjaan.setCellValueFactory(new PropertyValueFactory("Pekerjaan"));
        tblPeminjaman.setItems(data);
        btnClearForm.fire();
        
        
    }
    
    @FXML
    private TextField tfidpeminjaman1;

    @FXML
    private TextField tfnoplat1;

    @FXML
    private TextField tfnama1;

    @FXML
    private TextField tflama1;

    @FXML
    private TextField tfbiaya1;

    @FXML
    private TextField tfbidanginstansi;

    @FXML
    private DatePicker tftanggal1;
    

    @FXML
    private Button btnSimpanData1;

    @FXML
    private Button btnReloadData1;

    @FXML
    private Button btnClearForm1;

    @FXML
    private TableView<Instansi> tblPeminjaman1;

    @FXML
    private TableColumn<Instansi, Integer> colidpeminjaman1;

    @FXML
    private TableColumn<Instansi, String> coltanggal1;

    @FXML
    private TableColumn<Instansi, String> colnoplat1;

    @FXML
    private TableColumn<Instansi, String> colnama1;

    @FXML
    private TableColumn<Instansi, Integer> collama1;

    @FXML
    private TableColumn<Instansi, Integer> colbiaya1;

    @FXML
    private TableColumn<Instansi, String> colbidanginstansi;

    
    
      @FXML
    private Label lblstatussimpan1;
      
    

    @FXML
    void handleAdd1Action(ActionEvent event)  {
        LocalDate ld = tftanggal1.getValue();
        String tgl = String.format("%d-%02d-%02d", ld.getYear() ,ld.getMonthValue(),ld.getDayOfMonth());
        Instansi ins = new Instansi(Integer.parseInt(tfidpeminjaman1.getText()),tgl ,tfnoplat1.getText() ,tfnama1.getText() , Integer.parseInt(tflama1.getText()), Integer.parseInt(tfbiaya1.getText()), tfbidanginstansi.getText());
        
        try {
            pdm.addPeminjaman(ins);
            lblstatussimpan1.setText("Berhasil Simpan");
            btnReloadData1.fire();
            btnClearForm1.fire();
            btnReloadData.fire();
            btnClearForm.fire();
        } catch (SQLException ex) {
            lblstatussimpan1.setText("Gagal Simpan");
            Logger.getLogger(FormPeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void handleClear1Action(ActionEvent event) {
    try {
        tfidpeminjaman1.setText(""+pdm.NextIDPeminjaman());
        tftanggal1.setValue(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        tfnoplat1.setText("");
        tfnama1.setText("");
        tflama1.setText("");
        tfbiaya1.setText("");
        tfbidanginstansi.setText("");
       
       
    } catch (SQLException ex) {
        Logger.getLogger(FormPeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    void handleReload1Action(ActionEvent event)  {
        ObservableList<Instansi> data1 = pdm.getInstansi();
        colidpeminjaman1.setCellValueFactory(new PropertyValueFactory("IdPeminjaman"));
        coltanggal1.setCellValueFactory(new PropertyValueFactory("tanggal"));
        colnoplat1.setCellValueFactory(new PropertyValueFactory("NomorKendaraan"));
        colnama1.setCellValueFactory(new PropertyValueFactory("NamaPenyewa"));
        collama1.setCellValueFactory(new PropertyValueFactory("LamaPeminjaman"));
        colbiaya1.setCellValueFactory(new PropertyValueFactory("BiayaPeminjaman"));
        colbidanginstansi.setCellValueFactory(new PropertyValueFactory("BidangInstansi"));
        tblPeminjaman1.setItems(null);
        tblPeminjaman1.setItems(data1);
        btnClearForm1.fire();
        
    }
    
    @FXML

    
    
    public void initialize(URL url, ResourceBundle rb) {
    try {
        // TODO
        pdm = new PeminjamanDataModel("SQLITE");
        lblDBStatus.setText(pdm.conn==null?"Not Connected":"Connected");
        btnClearForm.fire();
        btnReloadData.fire();
        btnClearForm1.fire();
        btnReloadData1.fire();
    } catch (SQLException ex) {
        Logger.getLogger(FormPeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    

    
        
}
