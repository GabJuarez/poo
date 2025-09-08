package com.gj;
import com.gj.models.Producto;

import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        do {
            System.out.println("Menu de opciones");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto por codigo");
            System.out.println("3. Modificar existencias de un producto");
            System.out.println("4. Eliminar producto por su codigo");
            System.out.println("5. Ver productos bajos en stock");
            System.out.println("6. Ver todos los productos");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opcion: ");

            try {
                int op = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (op) {
                    case 1: {
                        try {
                            System.out.print("ingrese el codigo del producto: ");
                            String codigo = sc.nextLine();

                            System.out.print("ingrese el nombre del producto: ");
                            String nombre = sc.nextLine();

                            System.out.print("ingrese las existencias del producto: ");
                            int existencias = sc.nextInt();

                            Producto.aniadir_producto(codigo, nombre, existencias);
                            System.out.println("producto agregado correctamente");
                        } catch (InvalidAttributeValueException | InvalidAttributesException e) {
                            System.out.println("error al agregar producto: " + e.getMessage());
                        }
                        break;
                    }

                    case 2: {
                        System.out.print("Ingrese el codigo del producto a buscar: ");
                        String codigo = sc.nextLine();
                        Producto p = Producto.buscar_producto(codigo);
                        if (p != null) {
                            System.out.println(p);
                        } else {
                            System.out.println("Producto no encontrado");
                        }
                        break;
                    }

                    case 3: {
                        try {
                            System.out.print("Ingrese el codigo del producto a modificar: ");
                            String codigo = sc.nextLine();

                            System.out.print("Ingrese la nueva cantidad: ");
                            int nuevaCantidad = sc.nextInt();

                            Producto.modificar_existencias(codigo, nuevaCantidad);
                            System.out.println("existencias modificadas");
                        } catch (InvalidAttributeValueException | NullPointerException e ) {
                            System.out.println("error: " + e.getMessage());
                        }
                        break;
                    }

                    case 4: {
                        System.out.print("Ingrese el codigo del producto a eliminar: ");
                        String codigo = sc.nextLine();
                        try{
                            Producto.eliminar_producto(codigo);
                            System.out.println("Producto eliminado");
                        }catch (NullPointerException e){
                            System.out.println("El producto que queres eliminar no existe");
                        }

                        break;
                    }

                    case 5: {
                        ArrayList<Producto> bajos = Producto.stock_bajo();
                        if(bajos.toArray().length > 0){
                            System.out.println("Productos bajos en stock:");
                            for (Producto p : Producto.stock_bajo()) {
                                System.out.println(p.toString());
                            }
                            break;
                        }else{
                            System.out.println("No se encontraron productos bajos o no hay productos registrados");
                        }

                    }

                    case 6: {
                        System.out.println("Lista de productos:");
                        for (Producto p : Producto.getProductos()) {
                            System.out.println(p.toString());
                        }
                        break;
                    }

                    case 7: {
                        salir = true;
                        break;
                    }

                    default: {
                        System.out.println("Ingrese una opcion valida.");
                    }
                }

                if (!salir) {
                    try {
                        Thread.sleep(2000);
                        System.out.print("\033[H\033[2J"); // limpiar pantalla
                        System.out.flush();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número válido.");
                sc.next();
            }

        } while (!salir);
    }
}
