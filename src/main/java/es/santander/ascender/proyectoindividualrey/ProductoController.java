package es.santander.ascender.proyectoindividualrey;

import java.util.HashMap;
import java.util.Map;

public class ProductoController {

    private Map<Long, Producto> productos = new HashMap<>();

    public ProductoController() {
        // Inicializando productos con datos ficticios.
        productos.put(1L, new Producto(1L, "Producto A", "Descripción A", 100.0f, 10));
        productos.put(2L, new Producto(2L, "Producto B", "Descripción B", 150.0f, 0));
    }

    public Producto obtenerProducto(long id) {
        return productos.get(id);
    }

    public Map<Long, Producto> obtenerProductos() {
        return productos;
    }

    public String crearProducto(Producto producto) {
        if (productos.containsKey(producto.getId())) {
            return "Producto con ese ID ya existe.";
        }
        productos.put(producto.getId(), producto);
        return "Producto creado con éxito.";
    }

    public String actualizarProducto(long id, Producto productoActualizado) {
        Producto productoExistente = productos.get(id);
        if (productoExistente == null) {
            return "Producto no encontrado.";
        }
        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setDescripcion(productoActualizado.getDescripcion());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setCantidad(productoActualizado.getCantidad());
        return "Producto actualizado con éxito.";
    }

    public String eliminarProducto(long id) {
        Producto producto = productos.remove(id);
        if (producto == null) {
            return "Producto no encontrado.";
        }
        return "Producto eliminado con éxito.";
    }

    public String comprarProducto(long id, int cantidad) {
        Producto producto = productos.get(id);
        if (producto == null) {
            return "Producto no encontrado.";
        }
        if (producto.getCantidad() < cantidad) {
            return "No hay suficiente stock para realizar la compra.";
        }
        producto.setCantidad(producto.getCantidad() - cantidad);
        return "Compra realizada con éxito. Producto: " + producto.getNombre() + ", Cantidad: " + cantidad;
    }

    public String aumentarStockProducto(long id, int cantidad) {
        Producto producto = productos.get(id);
        if (producto == null) {
            return "Producto no encontrado.";
        }
        if (cantidad <= 0) {
            return "La cantidad a aumentar debe ser mayor que 0.";
        }
        producto.aumentarStock(cantidad);
        return "Stock aumentado con éxito. Producto: " + producto.getNombre() + ", Nueva cantidad: " + producto.getCantidad();
    }
}
