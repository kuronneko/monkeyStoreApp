/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.model;

import java.util.ArrayList;

/**
 *
 * @author maindesktop
 */
public class venta {
    private int idVenta;
    private producto Producto;
    private int cantidad;
    private int total;

    public venta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public producto getProducto() {
        return Producto;
    }

    public void setProducto(producto Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "venta{" + "idVenta=" + idVenta + ", Producto=" + Producto + ", cantidad=" + cantidad + ", total=" + total + '}';
    }

   


    
}

