package org.example.models;

public class Venta {

    private float precio;
    private int cantidad;

    public Venta(float precio, int cantidad) {
        setPrecio(precio);
        setCantidad(cantidad);
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if(precio > -1){
            this.precio = precio;
        }else{
            System.out.println("Precio invalido");
        }

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if(cantidad > 0){
            this.cantidad = cantidad;
        }else{
            System.out.println("Cantidad invalida");
        }
    }

    public float calcular_total(){
        return this.cantidad * this.precio;

    }
}
