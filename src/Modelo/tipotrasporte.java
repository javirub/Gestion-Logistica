/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author GUSTAVO
 */
public class tipotrasporte {
    private int id;
    private int id_pro;
    private int cantidad;
    private double precio;
    private int id_factura;
    
    public tipotrasporte(){
        
    }

    public tipotrasporte(int id, int id_pro, int cantidad, double precio, int id_venta) {
        this.id = id;
        this.id_pro = id_pro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_factura = id_factura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }
}
