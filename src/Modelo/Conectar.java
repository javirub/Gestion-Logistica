/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author GUSTAVO
 */
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.filechooser.FileSystemView;

public class Conectar {

    Connection con;

    public Connection getConnection() {  // metodo conexión utilizado para conectar o base de datos o qsl
        try {
            String url = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            File salida = new File(url + File.separator+ "sis_java.accdb");// le damos acceso a base acces por pruebas
            String access = "jdbc:ucanaccess://" + salida; //modulo controldor base datos windows
            con = DriverManager.getConnection(access);
            return con;
        } catch (SQLException e) {    //creamos la excpción si no hay conexión a access
            System.out.println(e.toString());
        }
        return null;
    }

}
