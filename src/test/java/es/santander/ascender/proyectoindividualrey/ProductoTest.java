package es.santander.ascender.proyectoindividualrey;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTest {

    private Producto producto;

    @BeforeEach
    void setUp() {
        // Inicialización del producto antes de cada prueba
        producto = new Producto(1L, "Coca-Cola", "Bebida refrescante", 1.5f, 10);
    }

    @Test
    void testGettersAndSetters() {
        // Comprobar los getters y setters
        assertEquals(1L, producto.getId());
        assertEquals("Coca-Cola", producto.getNombre());
        assertEquals("Bebida refrescante", producto.getDescripcion());
        assertEquals(1.5f, producto.getPrecio());
        assertEquals(10, producto.getCantidad());

        // Cambiar los valores usando los setters
        producto.setNombre("Pepsi");
        producto.setDescripcion("Refresco de cola");
        producto.setPrecio(1.3f);
        producto.setCantidad(5);

        // Verificar que los valores fueron actualizados correctamente
        assertEquals("Pepsi", producto.getNombre());
        assertEquals("Refresco de cola", producto.getDescripcion());
        assertEquals(1.3f, producto.getPrecio());
        assertEquals(5, producto.getCantidad());
    }

    @Test
    void testAumentarStock() {
        // Verificar que el stock inicial es 10
        assertEquals(10, producto.getCantidad());

        // Aumentar el stock de forma correcta
        producto.aumentarStock(5);
        assertEquals(15, producto.getCantidad()); // El stock debe aumentar a 15

        // Intentar aumentar el stock con una cantidad negativa (no debería cambiar el stock)
        producto.aumentarStock(-3);
        assertEquals(15, producto.getCantidad()); // El stock sigue siendo 15

        // Aumentar el stock con una cantidad positiva
        producto.aumentarStock(10);
        assertEquals(25, producto.getCantidad()); // El stock debe aumentar a 25
    }

    @Test
    void testAumentarStockConCero() {
        // Aumentar el stock con 0, no debe cambiar el stock
        producto.aumentarStock(0);
        assertEquals(10, producto.getCantidad()); // El stock sigue siendo 10
    }
}

