/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susuin;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Naya
 */
public class SususayaController implements Initializable {
  
    @FXML
    private Button Reset;
    @FXML
    private Button hitung;
    @FXML
    private JFXTextField biaya;
    @FXML
    private TextField jumlahsusu;
    @FXML
    private TextField jumlahyogurt;
    @FXML
    private TextField jumlahpudingsusu;
    @FXML
    private TextField jumlahicecream;
    @FXML
    private TextField jumlahmilkshake;
    @FXML
    private DatePicker tanggal;
    
    private Connection conn = null;
    private PreparedStatement stmt = null;
    @FXML
    private RadioButton buysusu;
    @FXML
    private RadioButton buyyogurt;
    @FXML
    private RadioButton buypudingsusu;
    @FXML
    private RadioButton buyicecream;
    @FXML
    private RadioButton buymilkshake;
    
    int jumlahmakan1 =0,jumlahmakan2=0,jumlahmakan3=0,jumlahmakan4=0,jumlahmakan5=0;
    int hagatotal1,hagatotal2,hagatotal3,hagatotal4,hagatotal5,hagatotal6,hagatotal7,hagatotal8;
    String menu="";
    String pilih1, pilih2, pilih3, pilih4, pilih5,tgl;
    int harga;
    public int totalbayar;
    private ResultSet rs = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = koneksi.kon.Konek();
        
    }    

    @FXML
    private void reset(ActionEvent event) {
        jumlahsusu.setText("");
        jumlahpudingsusu.setText("");
        jumlahicecream.setText("");
        jumlahmilkshake.setText("");
        jumlahyogurt.setText("");
        tanggal.setValue(LocalDate.now());
        buysusu.setSelected(false);
        buyyogurt.setSelected(false);
        buypudingsusu.setSelected(false);
        buymilkshake.setSelected(false);
        buyicecream.setSelected(false);
    }

    @FXML
    private void hitung(ActionEvent event) {
        if(buysusu.isSelected()){     
            pilih1 = "Fresh Milk : "+jumlahsusu.getText() +", " ;
            harga = 5000;
            menu +=buysusu.getText()+", ";
            jumlahmakan1+=Integer.parseInt(jumlahsusu.getText());
            hagatotal1=harga*jumlahmakan1;
            System.out.println(hagatotal1);
        }
        if(buyyogurt.isSelected()){     
            pilih2 = "Yogurt : "+jumlahyogurt.getText() +", " ;
            harga = 7000;
            menu += buyyogurt.getText()+", ";
            jumlahmakan2+=Integer.parseInt(jumlahyogurt.getText());
            hagatotal2=harga*jumlahmakan2;
            System.out.println(hagatotal2);
        }
        if(buypudingsusu.isSelected()){    
            pilih3 = "Puding Susu : "+jumlahpudingsusu.getText()+", ";
            harga = 6000;
            menu += buypudingsusu.getText()+", ";
            jumlahmakan3+=Integer.parseInt(jumlahpudingsusu.getText());
            hagatotal3=harga*jumlahmakan3;
            System.out.println(hagatotal3);
        }
        if(buyicecream.isSelected()){     
            pilih4 = "Ice Cream : "+jumlahicecream.getText()+",";
            harga = 9000;
            menu += buyicecream.getText()+", ";
            jumlahmakan4+=Integer.parseInt(jumlahicecream.getText());
            hagatotal4=harga*jumlahmakan4;
            System.out.println(hagatotal4);
        }
        if(buymilkshake.isSelected()){   
            pilih5 = "Milkshake : "+jumlahmilkshake.getText()+",";
            harga = 9000;
            menu += buymilkshake.getText()+", ";
            jumlahmakan5+=Integer.parseInt(jumlahmilkshake.getText());
            hagatotal5=harga*jumlahmakan5;
            System.out.println(hagatotal5);
        }
        totalbayar = hagatotal1+hagatotal2+hagatotal3+hagatotal4+hagatotal5+hagatotal6+hagatotal7+hagatotal8;
       
        
        conn = koneksi.kon.Konek();
        tgl = tanggal.getValue().toString();
        String ttl = String.valueOf(totalbayar);
        String js = String.valueOf(jumlahmakan1);
        String jy = String.valueOf(jumlahmakan2);
        String jp = String.valueOf(jumlahmakan3);
        String ji = String.valueOf(jumlahmakan4);
        String jm = String.valueOf(jumlahmakan5);
        
        String sql = "INSERT INTO `pesanan`(`tanggal`,`totalbiaya`,`jumlahsusu`,`jumlahyogurt`,`jumlahpuding`,`jumlahicecream`,`jumlahmilkshake`) VALUES (?,?,?,?,?,?,?)";
        try {
            stmt= conn.prepareStatement(sql);
            stmt.setString(1,tgl);
            stmt.setString(2, ttl);
            stmt.setString(3,js );
            stmt.setString(4, jy);
            stmt.setString(5, jp);
            stmt.setString(6, ji);
            stmt.setString(7, jm);
            int i = stmt.executeUpdate();  
            if(i==1){
           try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("notasusu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("SUSU'in");
            stage.show();
            
             NotasusuController kirim= new NotasusuController();
            kirim = fxmlLoader.getController();
            kirim.total(totalbayar);
            kirim.pilihan1(pilih1);
            kirim.pilihan2(pilih2);
            kirim.pilihan3(pilih3);
            kirim.pilihan4(pilih4);
            kirim.pilihan5(pilih5);
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
            
           
            
            }
        } 
        catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se);
        }
        
        
    }
    
}