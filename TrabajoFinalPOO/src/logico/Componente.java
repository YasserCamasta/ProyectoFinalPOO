package logico;

import java.util.ArrayList;

public abstract class Componente {
    protected String numeroSerie;
    protected double precio;
    protected int cantidadDisponible;
    protected String marca;

    public Componente(String numeroSerie, String marca) {
        this.numeroSerie = numeroSerie;
        this.precio = 0;
        this.marca = marca;
        this.cantidadDisponible = 0; // Inicializamos la cantidad disponible a 0
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public String getMarca() {
        return marca;
    }

    public void actualizarInventario(int cantidad) {
        cantidadDisponible += cantidad;
    }

    public boolean estaDisponible() {
        return cantidadDisponible > 0;
    }

    public abstract String obtenerDetalles();

    public static int compararPorPrecio(Componente c1, Componente c2) {
        return Double.compare(c1.getPrecio(), c2.getPrecio());
    }

    public static boolean sonCompatibles(Componente c1, Componente c2) {
        return c1.getClass().equals(c2.getClass());
    }

    public static ArrayList<Componente> buscarPorMarca(ArrayList<Componente> lista, String marca) {
        ArrayList<Componente> componentesPorMarca = new ArrayList<>();
        for (Componente componente : lista) {
            if (componente.getMarca().equalsIgnoreCase(marca)) {
                componentesPorMarca.add(componente);
            }
        }
        return componentesPorMarca;
    }

    
    public String toString() {
        return getClass().getSimpleName() + " - " + numeroSerie + " (" + marca + ")"; // Devolver el nombre del componente y su número de serie
    }
}