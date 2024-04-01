package logico;

import java.util.ArrayList;

public class Cliente {
    private static int contadorClientes = 0; // Contador para generar ids únicos para cada cliente
    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;

    public Cliente(String nombre, String direccion, String telefono) {
        this.idCliente = ++contadorClientes;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método para obtener la lista de componentes que ha comprado este cliente en sus facturas
    public ArrayList<Componente> obtenerComponentesComprados() {
        ArrayList<Componente> componentesComprados = new ArrayList<>();
        for (Factura factura : Tienda.getInstance().getFacturas()) {
            if (factura.getCliente().equals(this)) {
                componentesComprados.addAll(factura.getComponentes());
            }
        }
        return componentesComprados;
    }
}