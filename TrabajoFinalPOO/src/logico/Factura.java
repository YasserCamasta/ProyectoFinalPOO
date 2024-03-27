package logico;

import java.util.ArrayList;

public class Factura {
    private int numeroFactura;
    private Cliente cliente;
    private ArrayList<Componente> componentes;
    
    public Factura(int numeroFactura, Cliente cliente) {
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        componentes = new ArrayList<>();
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
}