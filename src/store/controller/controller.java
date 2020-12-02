/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import store.model.bodega;
import store.model.producto;
import store.model.venta;
import store.model.ventaD;

/**
 *
 * @author maindesktop
 */
public class controller {

    public controller() {
    }

    public ArrayList<producto> bodegaDefault() {
        ArrayList<producto> temporaryProductList = new ArrayList<producto>();
        temporaryProductList.add(new producto(001, "Mouse Logitech", 39990, 10));
        temporaryProductList.add(new producto(002, "Teclado Logitech", 79990, 20));
        temporaryProductList.add(new producto(003, "Mousepad Razer", 19990, 30));
        temporaryProductList.add(new producto(004, "MSI GTX 970", 119990, 10));
        return temporaryProductList;
    }

    public void cargarBodegaInicial() {
        bodega Bodega = new bodega();
        if (Bodega.getProductosList().isEmpty()) {
            Bodega.setProductosList(this.bodegaDefault());
        }
    }

    public void reestablecerFullStock() {
        bodega Bodega = new bodega();
        Bodega.setProductosList(this.bodegaDefault());
    }

    public void cargarJTableProductos(JTable jtableBodegaStock) {
        bodega Bodega = new bodega();

        DefaultTableModel tableModel = (DefaultTableModel) jtableBodegaStock.getModel();
        tableModel.getDataVector().removeAllElements();
        for (producto Producto : Bodega.getProductosList()) {

            int id = Producto.getIdProducto();
            String nombre = Producto.getNombreProducto();
            int precio = Producto.getPrecioProducto();
            int stock = Producto.getStockProducto();

            Object[] data = {id, nombre, precio, stock};

            tableModel.addRow(data);
            //jtableBodegaStock.setModel(tableModel);

        }
    }

    public void cargarJTableVentasD(JTable jTableVentasD) {
        ventaD VentaD = new ventaD();

        DefaultTableModel tableModel = (DefaultTableModel) jTableVentasD.getModel();
        tableModel.getDataVector().removeAllElements();
        for (venta Venta : VentaD.getVentasList()) {

            int id = Venta.getIdVenta();
            String nombre = Venta.getProducto().getNombreProducto();
            int cantidad = Venta.getCantidad();
            int total = Venta.getTotal();

            Object[] data = {id, nombre, cantidad, total};

            tableModel.addRow(data);
            //jtableBodegaStock.setModel(tableModel);

        }
    }

    public void cargarJComboBoxProductos(JComboBox cbxProductos) {
        bodega Bodega = new bodega();
        for (producto Producto : Bodega.getProductosList()) {
            cbxProductos.addItem(Producto.getNombreProducto());
            //cbxCantidad.addItem(String.valueOf(Producto.getStockProducto()));
        }
    }

    public void cbxProductosScript(JComboBox cbxCantidad, JComboBox cbxProductos, JLabel jLabelTotal) {
        cbxCantidad.removeAllItems();
        bodega Bodega = new bodega();
        for (producto Producto : Bodega.getProductosList()) {
            if (Producto.getNombreProducto() == cbxProductos.getSelectedItem()) {
                jLabelTotal.setText(String.valueOf(Producto.getPrecioProducto()));
                for (int i = 1; i < Producto.getStockProducto() + 1; i++) {
                    cbxCantidad.addItem(String.valueOf(i));
                }
                if (Producto.getStockProducto() == 0) {
                    jLabelTotal.setText("No hay Stock");
                } else {
                    jLabelTotal.setText(String.valueOf(Producto.getPrecioProducto()));
                }

            }
        }
    }

    public void cbxCantidadScript(JComboBox cbxCantidad, JComboBox cbxProductos, JLabel jLabelTotal) {
        bodega Bodega = new bodega();
        for (producto Producto : Bodega.getProductosList()) {
            if (Producto.getNombreProducto() == cbxProductos.getSelectedItem()) {
                if (cbxCantidad.getSelectedItem() == null) {

                } else {
                    jLabelTotal.setText(String.valueOf(Producto.getPrecioProducto() * (Integer.parseInt(String.valueOf(cbxCantidad.getSelectedItem())))));
                }
            }

        }
    }

    public void btnSubmitScript(JComboBox cbxCantidad, JComboBox cbxProductos, JLabel jLabelTotal) {

        bodega Bodega = new bodega();
        venta Venta = new venta();
        ventaD VentaD = new ventaD();
        
        for (producto Producto : Bodega.getProductosList()) {
            if (Producto.getNombreProducto() == cbxProductos.getSelectedItem()) {
                Producto.setStockProducto(Producto.getStockProducto() - Integer.parseInt(String.valueOf(cbxCantidad.getSelectedItem())));

                int maxId = 0;
                for (venta Ventas : VentaD.getVentasList()) {

                    if (Ventas.getIdVenta() > maxId) {
                        maxId = Ventas.getIdVenta();
                    }
                }

                Venta.setIdVenta(maxId + 1);
                Venta.setProducto(Producto);
                Venta.setCantidad(Integer.parseInt(String.valueOf(cbxCantidad.getSelectedItem())));
                Venta.setTotal(Integer.parseInt(jLabelTotal.getText()));
                VentaD.getVentasList().add(Venta);

                //System.out.println(VentaD.getVentasList());
            }
        }

    }

}
