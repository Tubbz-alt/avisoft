/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Insumo;
import java.util.ArrayList;

/**
 *
 * @author zirex
 */
public class ItemCompra {
    private ArrayList insumos;
    private int id;
    private String nombre;
    private int cantidad;
    private float precioUnt;
    private float total;

    public ItemCompra() {
        this.insumos= Insumo.getInsumos();
    }

    public ItemCompra(int id, String nombre, int cantidad, float precioUnt, float total) {
        this.insumos = Insumo.getInsumos();
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnt = precioUnt;
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioUnt() {
        return precioUnt;
    }

    public float getTotal() {
        return total;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioUnt(float precioUnt) {
        this.precioUnt = precioUnt;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
