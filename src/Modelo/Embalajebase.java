/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author GUSTAVO
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Embalajebase {
    Connection con;
    Conectar cn = new Conectar();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarEmbalaje(Embalaje emb){
        String sql = "INSERT INTO embalaje (codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, emb.getCodigo());
            ps.setString(2, emb.getNombre());
            ps.setInt(3, emb.getProveedor());
            ps.setInt(4, emb.getStock());
            ps.setDouble(5, emb.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List ListarEmbalaje(){
       List<Embalaje> Listaemb = new ArrayList();
       String sql = "SELECT pr.id AS id_proveedor, pr.nombre AS nombre_proveedor, p.* FROM proveedor pr INNER JOIN embalaje p ON pr.id = p.proveedor ORDER BY p.id DESC";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Embalaje emb = new Embalaje();
               emb.setId(rs.getInt("id"));
               emb.setCodigo(rs.getString("codigo"));
               emb.setNombre(rs.getString("nombre"));
               emb.setProveedor(rs.getInt("id_proveedor"));
               emb.setProveedorPro(rs.getString("nombre_proveedor"));
               emb.setStock(rs.getInt("stock"));
               emb.setPrecio(rs.getDouble("precio"));
               Listaemb.add(emb);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Listaemb;
   }
    
    public boolean EliminarEmbalaje(int id){
       String sql = "DELETE FROM embalaje WHERE id = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }
       }
   }
    
    public boolean ModificarEmbalaje(Embalaje emb){
       String sql = "UPDATE embalaje SET codigo=?, nombre=?, proveedor=?, stock=?, precio=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, emb.getCodigo());
           ps.setString(2, emb.getNombre());
           ps.setInt(3, emb.getProveedor());
           ps.setInt(4, emb.getStock());
           ps.setDouble(5, emb.getPrecio());
           ps.setInt(6, emb.getId());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
    
    public Embalaje BuscarEmb(String cod){
        Embalaje embalaje = new Embalaje();
        String sql = "SELECT * FROM embalaje WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                embalaje.setId(rs.getInt("id"));
                embalaje.setNombre(rs.getString("nombre"));
                embalaje.setPrecio(rs.getDouble("precio"));
                embalaje.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return embalaje;
    }
    public Embalaje BuscarId(int id){
        Embalaje emb = new Embalaje();
        String sql = "SELECT pr.id AS id_proveedor, pr.nombre AS nombre_proveedor, p.* FROM proveedor pr INNER JOIN embalajes p ON p.proveedor = pr.id WHERE p.id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                emb.setId(rs.getInt("id"));
                emb.setCodigo(rs.getString("codigo"));
                emb.setNombre(rs.getString("nombre"));
                emb.setProveedor(rs.getInt("proveedor"));
                emb.setProveedorPro(rs.getString("nombre_proveedor"));
                emb.setStock(rs.getInt("stock"));
                emb.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return emb;
    }
    public Proveedor BuscarProveedor(String nombre){
        Proveedor pr = new Proveedor();
        String sql = "SELECT * FROM proveedor WHERE nombre = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                pr.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pr;
    }
    public Config BuscarDatos(){
        Config conf = new Config();
        String sql = "SELECT * FROM config";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conf.setId(rs.getInt("id"));
                conf.setRuc(rs.getString("ruc"));
                conf.setNombre(rs.getString("nombre"));
                conf.setTelefono(rs.getString("telefono"));
                conf.setDireccion(rs.getString("direccion"));
                conf.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return conf;
    }
    
    public boolean ModificarDatos(Config conf){
       String sql = "UPDATE config SET ruc=?, nombre=?, telefono=?, direccion=?, mensaje=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, conf.getRuc());
           ps.setString(2, conf.getNombre());
           ps.setString(3, conf.getTelefono());
           ps.setString(4, conf.getDireccion());
           ps.setString(5, conf.getMensaje());
           ps.setInt(6, conf.getId());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
}
