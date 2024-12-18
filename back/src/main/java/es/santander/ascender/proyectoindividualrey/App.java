package es.santander.ascender.proyectoindividualrey;

import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ProductoController controller = new ProductoController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Ver productos");
            System.out.println("2. Crear producto");
            System.out.println("3. Comprar producto");
            System.out.println("4. Comprar varios productos");
            System.out.println("5. Aumentar stock de producto");
            System.out.println("6. Actualizar producto");
            System.out.println("7. Eliminar producto");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                    Map<Long, Producto> productos = controller.obtenerProductos();
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos disponibles.");
                    } else {
                        productos.values().forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("ID del producto: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    float precio = scanner.nextFloat();
                    System.out.print("Cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    Producto nuevoProducto = new Producto(id, nombre, descripcion, precio, cantidad);
                    String respuesta = controller.crearProducto(nuevoProducto);
                    System.out.println(respuesta);  // Muestra si el producto se creó correctamente
                    break;

                case 3:
                    System.out.print("ID del producto a comprar: ");
                    long idCompra = scanner.nextLong();
                    System.out.print("Cantidad a comprar: ");
                    int cantidadCompra = scanner.nextInt();
                    System.out.println(controller.comprarProducto(idCompra, cantidadCompra));
                    break;

                case 4:
                    System.out.print("ID del producto a comprar: ");
                    long idCompraVarios = scanner.nextLong();
                    System.out.print("Cantidad de productos a comprar: ");
                    int cantidadVarios = scanner.nextInt();
                    System.out.println(controller.comprarProducto(idCompraVarios, cantidadVarios));
                    break;

                case 5:
                    System.out.print("ID del producto para aumentar stock: ");
                    long idAumentarStock = scanner.nextLong();
                    System.out.print("Cantidad a aumentar: ");
                    int cantidadAumentar = scanner.nextInt();
                    System.out.println(controller.aumentarStockProducto(idAumentarStock, cantidadAumentar));
                    break;

                case 6:
                    System.out.print("ID del producto a actualizar: ");
                    long idActualizar = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Nuevo nombre del producto: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nueva descripción del producto: ");
                    String nuevaDescripcion = scanner.nextLine();
                    System.out.print("Nuevo precio del producto: ");
                    float nuevoPrecio = scanner.nextFloat();
                    System.out.print("Nueva cantidad del producto: ");
                    int nuevaCantidad = scanner.nextInt();
                    Producto productoActualizado = new Producto(idActualizar, nuevoNombre, nuevaDescripcion, nuevoPrecio, nuevaCantidad);
                    System.out.println(controller.actualizarProducto(idActualizar, productoActualizado));
                    break;

                case 7:
                    System.out.print("ID del producto a eliminar: ");
                    long idEliminar = scanner.nextLong();
                    System.out.println(controller.eliminarProducto(idEliminar));
                    break;

                case 8:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}