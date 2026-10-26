/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.centro_comercial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Pablo Franco Solarte
 */
public class Centro_Comercial {

    public static void main(String[] args) {
        ArrayList<Productos> productos = new ArrayList<>();
        cargarProductos(productos);
 
        punto1(productos);
        punto2(productos);
        punto3(productos);
        
    }
    public static void cargarProductos(ArrayList<Productos> productos) {
        productos.add(new Productos(101, "Portátil", "Tecnología", 3200, 8));
        productos.add(new Productos(102, "Mouse", "Tecnología", 80, 25));
        productos.add(new Productos(103, "Teclado", "Tecnología", 120, 12));
        productos.add(new Productos(104, "Cuaderno", "Papelería", 15, 50));
        productos.add(new Productos(105, "Marcadores", "Papelería", 28, 30));
        productos.add(new Productos(106, "Impresora", "Tecnología", 950, 4));
        productos.add(new Productos(107, "Escritorio", "Muebles", 680, 6));
        productos.add(new Productos(108, "Silla", "Muebles", 450, 10));
        productos.add(new Productos(109, "Monitor", "Tecnología", 780, 9));
        productos.add(new Productos(110, "Disco SSD 1TB", "Tecnología", 350, 15));
        productos.add(new Productos(111, "Memoria USB 64GB", "Tecnología", 45, 40));
        productos.add(new Productos(112, "Router WiFi", "Tecnología", 220, 11));
        productos.add(new Productos(113, "Cable HDMI", "Tecnología", 35, 60));
        productos.add(new Productos(114, "Webcam", "Tecnología", 160, 13));
        productos.add(new Productos(115, "Audífonos", "Tecnología", 140, 20));
        productos.add(new Productos(116, "Micrófono", "Tecnología", 190, 7));
        productos.add(new Productos(117, "Calculadora Científica", "Papelería", 65, 18));
        productos.add(new Productos(118, "Resaltadores", "Papelería", 18, 35));
        productos.add(new Productos(119, "Carpeta", "Papelería", 12, 80));
        productos.add(new Productos(120, "Lápiz", "Papelería", 3, 200));
        productos.add(new Productos(121, "Bolígrafo", "Papelería", 5, 150));
        productos.add(new Productos(122, "Borrador", "Papelería", 2, 120));
        productos.add(new Productos(123, "Regla", "Papelería", 8, 45));
        productos.add(new Productos(124, "Archivador", "Papelería", 25, 20));
        productos.add(new Productos(125, "Mesa de Reuniones", "Muebles", 1500, 3));
        productos.add(new Productos(126, "Biblioteca", "Muebles", 1200, 5));
        productos.add(new Productos(127, "Archivador Metálico", "Muebles", 890, 4));
        productos.add(new Productos(128, "Sofá de Oficina", "Muebles", 2100, 2));
        productos.add(new Productos(129, "Lámpara de Escritorio", "Muebles", 95, 14));
        productos.add(new Productos(130, "Ventilador", "Electrodomésticos", 180, 8));
        productos.add(new Productos(131, "Cafetera", "Electrodomésticos", 320, 6));
        productos.add(new Productos(132, "Horno Microondas", "Electrodomésticos", 550, 4));
        productos.add(new Productos(133, "Nevera Ejecutiva", "Electrodomésticos", 980, 2));
        productos.add(new Productos(134, "Tablet", "Tecnología", 1300, 7));
        productos.add(new Productos(135, "Smartphone", "Tecnología", 2200, 5));
    }
public static void punto1(ArrayList<Productos> productos) {
        System.out.println(" Analisis del inventario ");
 
        int cantidadTotal = productos.size();
        double sumaPrecios = 0; 
        int stockBajo = 0;
        
        Productos masCostoso = productos.get(0);
        Productos menorPrecio = productos.get(0);
        
        for (int i = 0; i < productos.size(); i++) {
            Productos p = productos.get(i);
            sumaPrecios = sumaPrecios + p.getPrecio();
            if (p.getPrecio() > masCostoso.getPrecio()) {
                masCostoso = p;
            }
            if (p.getPrecio() < menorPrecio.getPrecio()) {
                menorPrecio = p;
            }
            if (p.getStock() < 10) {
                stockBajo++;
            }
        }
        double promedio = sumaPrecios / cantidadTotal;
 
        System.out.println(" Cantidad total de productos: " + cantidadTotal);
        System.out.println(" Valor promedio de los precios: $ " + promedio);
        System.out.println(" Producto más costoso: " + masCostoso);
        System.out.println(" Producto con menor precio: " + menorPrecio);
        System.out.println(" Productos con stock menor a 10: " + stockBajo);
        System.out.println();
    }
    public static void punto2(ArrayList<Productos> productos) {
        System.out.println(" Nuevas Listas");
        ArrayList<Productos> productosTecnologia = new ArrayList<>();
        ArrayList<Productos> productosEconomicos = new ArrayList<>();
        
        for (int i = 0; i < productos.size(); i++) {
            Productos p = productos.get(i);
            if (p.getCategoria().equalsIgnoreCase("Tecnologia")) {
                productosTecnologia.add(p);
            }
            if (p.getPrecio() < 200) {
                productosEconomicos.add(p);
            }
        }
        System.out.println(" Lista productosTecnologia ");
        mostrarLista(productosTecnologia);
        System.out.println(" Valor total del inventario (Tecnologia): $ " + valorInventario(productosTecnologia));
        System.out.println();
 
        System.out.println(" Lista productosEconomicos (precio menor a $200) ");
        mostrarLista(productosEconomicos);
        System.out.println(" Valor total del inventario (Económicos): $ " + valorInventario(productosEconomicos));
        System.out.println();
    }
    public static void mostrarLista(ArrayList<Productos> lista) {
        if (lista.isEmpty()) {
            System.out.println(" La lista está vacía.");
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    public static double valorInventario(ArrayList<Productos> lista) {
        double total = 0;
        for (int i = 0; i < lista.size(); i++) {
            Productos p = lista.get(i);
            total = total + (p.getPrecio() * p.getStock());
        }
        return total;
    }
    public static void punto3(ArrayList<Productos> productos) {
        Scanner user = new Scanner(System.in);
        int opcion;
 
        do {
            System.out.println(" Bienvanido al Menu del centro comercial ");
            System.out.println(" Menu ");
            System.out.println("1. Buscar producto por código");
            System.out.println("2. Actualizar precio");
            System.out.println("3. Actualizar stock");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Mostrar productos por categoría");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            opcion = user.nextInt();
 
            switch (opcion) {
                case 1:
                    buscarProducto(productos, user);
                    break;
                case 2:
                    actualizarPrecio(productos, user);
                    break;
                case 3:
                    actualizarStock(productos, user);
                    break;
                case 4:
                    eliminarProducto(productos, user);
                    break;
                case 5:
                    mostrarInventario(productos);
                    break;
                case 6:
                    mostrarPorCategoria(productos, user);
                    break;
                case 7:
                    System.out.println("Gracias por usar el sistema del centro comercial. ¡Nosvemos Pronto!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
            System.out.println();
 
        } while (opcion != 7);
    }
    public static int buscarPosicion(ArrayList<Productos> productos, int codigo) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
        
    }
    public static void buscarProducto(ArrayList<Productos> productos, Scanner user) {
        System.out.print(" Ingrese el código del producto: ");
        int codigo = user.nextInt();
 
        int pos = buscarPosicion(productos, codigo);
 
        if (pos == -1) {
            System.out.println(" No existe un producto con el código que ingresaste" + codigo);
        } else {
            System.out.println(" Producto encontrado: " + productos.get(pos));
        }
        
    }
    public static void actualizarPrecio(ArrayList<Productos> productos, Scanner user) {
        System.out.print(" Ingrese el código del producto: ");
        int codigo = user.nextInt();
 
        int pos = buscarPosicion(productos, codigo);
 
        if (pos == -1) {
            System.out.println(" No existe un producto con el código  " +  codigo);
        } else {
            System.out.print(" Ingrese el nuevo precio: ");
            double nuevoPrecio = user.nextDouble();
 
            if (nuevoPrecio <= 0) {
                System.out.println(" El precio debe ser mayor que 0.");
            } else {
                productos.get(pos).setPrecio(nuevoPrecio);
                System.out.println(" Precio actualizado: " + productos.get(pos));
            }
        }
        
    }
    public static void actualizarStock(ArrayList<Productos> productos, Scanner user) {
        System.out.print(" Ingrese el código del producto: ");
        int codigo = user.nextInt();
        int pos = buscarPosicion(productos, codigo);
 
        if (pos == -1) {
            System.out.println(" No existe un producto con el código  " +  codigo);
        } else {
            System.out.print(" Ingrese el nuevo stock: ");
            int nuevoStock = user.nextInt();
            if (nuevoStock < 0) {
                System.out.println("El stock no puede ser negativo.");
            } else {
                productos.get(pos).setStock(nuevoStock);
                System.out.println(" Stock actualizado: " + productos.get(pos));
            }
        }
        
    }
    public static void eliminarProducto(ArrayList<Productos> productos, Scanner user) {
        System.out.print(" Ingrese el código del producto a eliminar: ");
        int codigo = user.nextInt();
        int pos = buscarPosicion(productos, codigo);
 
        if (pos == -1) {
            System.out.println(" No existe un producto con el código " + codigo);
        } else {
            Productos eliminado = productos.remove(pos);
            System.out.println(" Producto eliminado: " + eliminado);
        }
        
    }
    public static void mostrarInventario(ArrayList<Productos> productos) {
        System.out.println(" El inventario completo ");
        mostrarLista(productos);
        System.out.println(" Total de productos: " + productos.size());
        System.out.println(" Valor total del inventario: $ " + valorInventario(productos));
        
    }
    public static void mostrarPorCategoria(ArrayList<Productos> productos, Scanner user) {
        System.out.println(" Categorías que hay en el centro comercial son: Tecnologia, Papeleria, Muebles, Electrodomesticos ");
        System.out.print(" Ingrese la categoría: ");
        String categoria = user.next();
 
        int contador = 0;
        for (int i = 0; i < productos.size(); i++) {
            Productos p = productos.get(i);
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(p);
                contador++;
            }
        }
 
        if (contador == 0) {
            System.out.println(" No hay productos en la categoría " + categoria + ".");
        }
    }
}
