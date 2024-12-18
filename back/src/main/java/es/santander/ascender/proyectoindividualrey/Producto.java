package es.santander.ascender.proyectoindividualrey;

public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private float precio;
    private int cantidad;

    public Producto(Long id, String nombre, String descripcion, float precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Aumentar el stock de un producto
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }
    @Override
    public String toString() {
    return "ID: " + id + ", Nombre: " + nombre + ", Descripción: " + descripcion + ", Precio: " + precio + ", Cantidad: " + cantidad;
    }   
}

