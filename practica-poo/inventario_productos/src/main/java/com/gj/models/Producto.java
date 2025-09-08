package com.gj.models;

import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;

public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;

    protected static ArrayList<Producto> productos = new ArrayList<>();
    protected static ArrayList<String> codigos = new ArrayList<>();

    public Producto(String codigo, String nombre, int cantidad) throws InvalidAttributeValueException {
        setCodigo(codigo);
        setNombre(nombre);
        setCantidad(cantidad);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws InvalidAttributeValueException {
        for (String c : codigos) {
            if (codigo.equals(c)) {
                throw new InvalidAttributeValueException("ingresaste un codigo ya utilizado");
            }
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws InvalidAttributeValueException {
        if (nombre.length() < 4) {
            throw new InvalidAttributeValueException("el nombre debe tener al menos 4 caracteres");
        }
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) throws InvalidAttributeValueException {
        if (cantidad < 1) {
            throw new InvalidAttributeValueException("La cantidad debe ser mayor a 0");
        }
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Codigo: " + getCodigo() + ", Nombre: " + getNombre() + ", Cantidad: " + getCantidad() + "\n";
    }

    public static void aniadir_producto(String codigo, String nombre, int cantidad)
            throws InvalidAttributeValueException, InvalidAttributesException {
        Producto producto = new Producto(codigo, nombre, cantidad);

        if ((producto.getCodigo() == null) || (producto.getNombre() == null) || producto.getCantidad() == 0) {
            throw new InvalidAttributesException("escribiste uno/varios atributos de forma invalida");
        }

        productos.add(producto);
        codigos.add(producto.getCodigo());
    }

    public static Producto buscar_producto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public static ArrayList<Producto> stock_bajo() {
        ArrayList<Producto> bajos = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCantidad() < 5) {
                bajos.add(p);
            }
        }
        return bajos;
    }

    public static void modificar_existencias(String codigo, int nuevaCantidad) throws InvalidAttributeValueException {
        Producto producto = Producto.buscar_producto(codigo);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
        }else{
            throw new NullPointerException();
        }
    }

    public static void eliminar_producto(String codigo) {
        Producto p = Producto.buscar_producto(codigo);
        if(p != null){
            productos.remove(p);
        }else{
            throw new NullPointerException();
        }

    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }
}
