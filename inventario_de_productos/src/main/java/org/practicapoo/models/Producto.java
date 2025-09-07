package org.practicapoo.models;
import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;

    protected static ArrayList<Producto> productos = new ArrayList<>();
    protected static ArrayList<String> codigos = new ArrayList<>();

    public Producto(String codigo, String nombre, int cantidad) {
        setCodigo(codigo);
        setNombre(nombre);
        setCantidad(cantidad);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        try{
            for(String c: codigos){
                if(codigo.equals(c)){
                    throw new InvalidAttributeValueException();
                }
            }
        }catch (InvalidAttributeValueException e){
            System.out.println("Ingrese un id que no haya sido utilizado antes");
            return;
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        try{
            if(nombre.length() < 4){
                throw new InvalidAttributeValueException();
            }
        }catch (InvalidAttributeValueException e) {
            System.out.println("Ponga un nombre mas descriptivo (Mayor a 4 letras)");
            return;
        }
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        try{
            if (cantidad < 1){
                throw new InvalidAttributeValueException();
            }
        }catch (InvalidAttributeValueException e){
            System.out.println("La cantidad debe ser mayor a 0");
            return;
        }

        this.cantidad = cantidad;


    }

    @Override
    public String toString() {
        return "Codigo: " + getCodigo() + ", Nombre: " + getNombre() + ", Cantidad: " + getCantidad() + "\n";
    }

    public static void aniadir_producto(String codigo, String nombre, int id) {
        Producto producto;
        try {
            producto = new Producto(codigo, nombre, id);
            if ((producto.getCodigo() == null) || (producto.getNombre() == null) || producto.getCantidad() == 0){
                throw new InvalidAttributesException();
            }
        } catch (InvalidAttributesException e) {
            System.out.println("Has ingresado uno/varios atributo invalido");
            return;
        }

        productos.add(producto);
        codigos.add(producto.getCodigo());

    }

    public static Producto buscar_producto(String codigo){
        for(Producto p: productos){
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }

    public static void imprimir_stock_bajo(){
        System.out.println("Productos bajos en stock:");
        for(Producto p: productos){
            if(p.getCantidad() < 5){
                System.out.println(p.toString());
            }
        }
    }

    public static void modificar_existencias(String codigo){
        Producto producto = Producto.buscar_producto(codigo);
        if (producto != null){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la nueva cantidad existencias: ");
            int nueva_cantidad = sc.nextInt();
            producto.setCantidad(nueva_cantidad);
        }
    }

    public static void eliminar_producto(String codigo){
        productos.remove(Producto.buscar_producto(codigo));
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }
}
