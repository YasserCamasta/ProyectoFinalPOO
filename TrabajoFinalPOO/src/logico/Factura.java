package logico;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private static int contadorFacturas = 0;
    private int numeroFactura;
    private Cliente cliente;
    private ArrayList<Componente> componentes;

    public Factura(Cliente cliente) {
        this.numeroFactura = ++contadorFacturas;
        this.cliente = cliente;
        this.componentes = new ArrayList<>();
    }

    public Factura(Cliente cliente, List<Componente> componentes) {
        this(cliente);
        this.componentes.addAll(componentes);
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public void agregarComponente(Componente componente) {
        componentes.add(componente);
    }

    public double calcularTotal() {
        double total = 0;
        for (Componente componente : componentes) {
            total += componente.getPrecio();
        }
        return total;
    }

    public double calcularDescuento() {
        return calcularTotal() * 0.1; // Aplicamos el descuento del 10%
    }

    public double calcularTotalConDescuento() {
        return calcularTotal() - calcularDescuento();
    }
}