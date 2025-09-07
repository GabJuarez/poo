package org.practicapoo;
import org.practicapoo.models.Producto;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        do {
            for (int i = 0; i < 20; i++) {
                System.out.println();
            }

            System.out.println("Menu de opciones");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto por codigo");
            System.out.println("3. Modificar existencias de un producto");
            System.out.println("4. Eliminar producto por su codigo");
            System.out.println("5. Ver productos bajos en stock");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");


            int op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op){
                    case 1: {
                        System.out.print("Ingrese el codigo del producto: ");
                        String codigo = sc.nextLine();
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese las existencias del producto: ");
                        int existencias = sc.nextInt();
                        Producto.aniadir_producto(codigo, nombre, existencias);
                        break;
                    }

                    case 2: {
                        System.out.print("Ingrese el codigo del producto a buscar: ");
                        String codigo = sc.nextLine();
                        System.out.print(Producto.buscar_producto(codigo).toString());
                        break;
                    }

                    case 3: {
                        System.out.print("Ingrese el codigo del producto al que desea modificar existencias: ");
                        String codigo = sc.nextLine();
                        Producto.modificar_existencias(codigo);
                        break;
                    }

                    case 4: {
                        System.out.print("Ingrese el codigo del producto a eliminar: ");
                        String codigo = sc.nextLine();
                        Producto.eliminar_producto(codigo);
                        break;
                    }

                    case 5: {
                        try{
                        Producto.imprimir_stock_bajo();
                        }catch (NullPointerException e){
                            System.out.println("Producto no encontrado");
                        }
                        break;
                    }

                    case 6: {
                        salir = true;
                    }

                    case 7:{
                        System.out.println(Producto.getProductos());
                    }

                    default: {
                        System.out.print("Ingrese una opcion valida: ");
                    }


                }
                if (!salir) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }catch (InputMismatchException e){
                System.out.print("Debes insertar un número: ");
                sc.next();
            }
        }while(!salir);
    }
}
