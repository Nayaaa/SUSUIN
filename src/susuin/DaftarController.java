    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susuin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Naya
 */
public class DaftarController implements Initializable {
    public String user, pass, nam, telp; 
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton daftar;
    @FXML
    private JFXButton log_in;
    @FXML
    private JFXTextField nama;

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;
    @FXML
    private JFXTextField telepon;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = koneksi.kon.Konek();
        // TODO
    }    

    @FXML
    private void daftar(ActionEvent event) throws SQLException {
        conn = koneksi.kon.Konek();
        user = username.getText();
        pass = password.getText();
        nam = nama.getText();
        telp = telepon.getText();
        String sql = "INSERT INTO `user`(`nama`,`telepon`,`username`,`password`) VALUES (?,?,?,?)";   
        
        try {
            stmt= conn.prepareStatement(sql);
            stmt.setString(1, nam);
            stmt.setString(3, user);
            stmt.setString(4, pass);
            stmt.setString(2, telp);
            int i = stmt.executeUpdate();
            if(nama.getText().equals("")||telepon.getText().equals("")||username.getText().equals("")||password.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Lengkapi Data Anda!!!");
            }
            else if (i == 1){
                JOptionPane.showMessageDialog(null,"Daftar Berhasil");
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
            else{
                JOptionPane.showMessageDialog(null,"Maaf anda gagal mendaftar");
            }
            stmt.close();
            conn.close();           
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se);
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                if (stmt != null){
                    stmt.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    @FXML
    void log_in(ActionEvent event) {
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
