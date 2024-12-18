package es.santander.ascender.proyectoindividualrey;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoControllerTest {

    private ProductoController productoController;
    private Producto productoA;
    private Producto productoB;

    @BeforeEach
    void setUp() {
        productoController = new ProductoController();
        productoA = new Producto(1L, "Coca-Cola", "Bebida refrescante", 1.5f, 10);
        productoB = new Producto(2L, "Pepsi", "Refresco de cola", 1.3f, 5);
        productoController.crearProducto(productoA);
        productoController.crearProducto(productoB);
    }

    @Test
    void testCrearProducto() {
        Producto productoNuevo = new Producto(3L, "Fanta", "Refresco de naranja", 1.2f, 20);
        String respuesta = productoController.crearProducto(productoNuevo);
        assertEquals("Producto creado con éxito.", respuesta);
        Producto productoObtenido = productoController.obtenerProducto(3L);
        assertNotNull(productoObtenido);
        assertEquals("Fanta", productoObtenido.getNombre());
        assertEquals(1.2f, productoObtenido.getPrecio());
    }

    @Test
    void testAumentarStock() {
        productoA.aumentarStock(5);
        assertEquals(15, productoA.getCantidad());
        productoB.aumentarStock(10);
        assertEquals(15, productoB.getCantidad());
    }
    @Test
    void testComprarProducto() {
        // Suponemos que el producto con ID 1 tiene 10 unidades disponibles (según el constructor).
        ProductoController productoController = new ProductoController();
        
        // Caso donde hay suficiente stock
        String respuestaCompra = productoController.comprarProducto(1L, 5); // Intentamos comprar 5 unidades del Producto A
        assertEquals("Compra realizada con éxito. Producto: Producto A, Cantidad: 5", respuestaCompra);
        
        // Verificamos que el stock se haya reducido correctamente
        Producto producto = productoController.obtenerProducto(1L);
        assertEquals(5, producto.getCantidad()); // El stock debería ser 5, ya que compramos 5 unidades
        
        // Caso donde no hay suficiente stock
        String respuestaCompraInsuficiente = productoController.comprarProducto(1L, 6); // Intentamos comprar más unidades de las disponibles
        assertEquals("No hay suficiente stock para realizar la compra. Stock disponible: 5", respuestaCompraInsuficiente);
    }

    @Test
    void testActualizarProducto() {
        Producto productoActualizado = new Producto(1L, "Coca-Cola", "Bebida refrescante actualizada", 1.6f, 10);
        String respuestaActualizar = productoController.actualizarProducto(1L, productoActualizado);
        assertEquals("Producto actualizado con éxito.", respuestaActualizar);
        Producto productoRecibido = productoController.obtenerProducto(1L);
        assertEquals("Bebida refrescante actualizada", productoRecibido.getDescripcion());
    }

    @Test
    void testEliminarProducto() {
        String respuestaEliminar = productoController.eliminarProducto(2L);
        assertEquals("Producto eliminado con éxito.", respuestaEliminar);
        Producto productoEliminado = productoController.obtenerProducto(2L);
        assertNull(productoEliminado);
    }
}
