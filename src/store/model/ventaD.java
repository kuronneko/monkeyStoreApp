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
public class ventaD {
    private static ArrayList<venta> ventasList = new ArrayList<venta>();

    public ventaD() {
    }

    public ArrayList<venta> getVentasList() {
        return ventasList;
    }

    public void setVentasList(ArrayList<venta> ventasList) {
        this.ventasList = ventasList;
    }


    
}
