package logico;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Componente> inventario;
    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> facturas;
    private ArrayList<Combo> combos;

    public Tienda() {
        inventario = new ArrayList<>();
        clientes = new ArrayList<>();
        facturas = new ArrayList<>();
        combos = new ArrayList<>();
    }
    
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
}