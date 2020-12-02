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
public class bodega {

    private static ArrayList<producto> productosList = new ArrayList<producto>();

    public bodega() {
    
    }
    
    public ArrayList<producto> getProductosList() {
        return productosList;
    }

    public void setProductosList(ArrayList<producto> productosList) {
        this.productosList = productosList;
    }
    
    
}
