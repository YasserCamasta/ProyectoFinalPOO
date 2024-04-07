package logico;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private static Tienda instancia = null; // Instancia �nica de la clase Tienda

    private ArrayList<Componente> inventario;
    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> facturas;
    private ArrayList<Combo> combos;

    // Constructor privado para evitar la creaci�n de instancias externas
    private Tienda() {
        inventario = new ArrayList<>();
        clientes = new ArrayList<>();
        facturas = new ArrayList<>();
        combos = new ArrayList<>();
    }

    // M�todo est�tico para obtener la instancia �nica de la clase Tienda
    public static Tienda getInstance() {
        if (instancia == null) {
            instancia = new Tienda();
        }
        return instancia;
    }
    
    // M�todos para agregar componentes, clientes, facturas y combos
    public void agregarComponente(Componente componente) {
        inventario.add(componente);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public void agregarCombo(Combo combo) {
        combos.add(combo);
    }

    // M�todo para generar una factura a partir de una lista de componentes
    public Factura generarFactura(Cliente cliente, List<Componente> componentes) {
        Factura factura = new Factura(cliente, componentes);
        facturas.add(factura);
        return factura;
    }

    // M�todo para contar la cantidad de componentes disponibles en el inventario
    public int contarComponentesDisponibles() {
        return inventario.size();
    }

    // M�todo para buscar componentes por marca
    public List<Componente> buscarComponentesPorMarca(String marca) {
        List<Componente> componentesPorMarca = new ArrayList<>();
        for (Componente componente : inventario) {
            if (componente.getMarca().equalsIgnoreCase(marca)) {
                componentesPorMarca.add(componente);
            }
        }
        return componentesPorMarca;
    }

    // M�todo para ordenar componentes por precio
    public List<Componente> ordenarComponentesPorPrecio() {
        List<Componente> inventarioOrdenado = new ArrayList<>(inventario);
        inventarioOrdenado.sort((c1, c2) -> Double.compare(c1.getPrecio(), c2.getPrecio()));
        return inventarioOrdenado;
    }

    // M�todo para verificar la compatibilidad entre los componentes de un combo
    public boolean verificarCompatibilidad(Motherboard motherboard, Ram ram, Disco disco) {
        // Aqu� puedes implementar la l�gica de compatibilidad como lo desees
        // Por ahora, simplemente retornaremos true para evitar errores
        return true;
    }
    public Cliente buscarClientePorNombre(String nombreCliente) {
        for (Cliente cliente : Tienda.getInstance().getClientes()) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente;
            }
        }
        return null; // Retorna null si no se encuentra ning�n cliente con el nombre dado
    }

    // Getters y setters
    public ArrayList<Componente> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Componente> inventario) {
        this.inventario = inventario;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<Combo> getCombos() {
        return combos;
    }

    public void setCombos(ArrayList<Combo> combos) {
        this.combos = combos;
    }
}