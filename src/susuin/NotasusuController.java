/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susuin;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Naya
 */
public class NotasusuController implements Initializable {
    
    String nam,nm ,t,ap,almt;
    int tb;

    @FXML
    private AnchorPane pemesan;
    @FXML
    private JFXTextField telepon;
    @FXML
    private JFXTextField alamat;
    @FXML
    private JFXTextField biaya;
    @FXML
    private Button submit;
    @FXML
    private Button out;
    
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextArea hasil;
    private JFXTextArea hasil1;
    @FXML
    private JFXTextField pes1;
    @FXML
    private JFXTextField pes2;
    @FXML
    private JFXTextField pes3;
    @FXML
    private JFXTextField pes4;
    @FXML
    private JFXTextField pes5;
    
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn = koneksi.kon.Konek();
    }       
    
    public void total(int total){
        biaya.setText(""+total);
    }   
    
    
    @FXML
    private void submit(ActionEvent event) throws SQLException {
         conn = koneksi.kon.Konek();
        nm = nama.getText();
        t = telepon.getText();
        almt = alamat.getText();
        String sql = "INSERT INTO `nota`(`nama`,`telepon`,`alamat`) VALUES (?,?,?)";  
        stmt= conn.prepareStatement(sql);
        stmt.setString(1, nm);
        stmt.setString(2,t );
        stmt.setString(3, almt);
        int i = stmt.executeUpdate();
        if(i==1){
            nam=nama.getText();
            t=telepon.getText();
            ap=alamat.getText();
            String tt=biaya.getText();
            hasil.setText("Pemesan : "+nam+"\n"+"Nomor Telepon : "+t+"\n"+"Alamat : "+ap+"\n"+"Total Harga : "+tt);
        }
        
    }
    public void pilihan1 (String pilihan1){
        pes1.setText(""+pilihan1);
    }   
    public void pilihan2 (String pilihan2){
        pes2.setText(""+pilihan2);
    }   
    public void pilihan3 (String pilihan3){
        pes3.setText(""+pilihan3);
    }   
    public void pilihan4 (String pilihan4){
        pes4.setText(""+pilihan4);
    }   
    public void pilihan5 (String pilihan5){
        pes5.setText(""+pilihan5);
    }   
    

    @FXML
    private void out(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("SUSU'in");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
}
