package logico;

import java.util.ArrayList;

public class Combo {
    public static final double DESCUENTO_COMBO = 0.1; // Descuento del 10% para los combos
    private static int contadorCombos = 0; // Contador para generar ids únicos para cada combo
    private int idCombo;
    private ArrayList<Componente> componentes;

    public Combo() {
        this.idCombo = ++contadorCombos;
        this.componentes = new ArrayList<>();
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
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

    public double calcularPrecioTotal() {
        double precioTotal = 0;
        for (Componente componente : componentes) {
            precioTotal += componente.getPrecio(); // Sumamos el precio de cada componente
        }
        return precioTotal;
    }

    public double calcularDescuento() {
        return calcularPrecioTotal() * DESCUENTO_COMBO; // Aplicamos el descuento del 10% para combos
    }

    public double calcularPrecioConDescuento() {
        return calcularPrecioTotal() - calcularDescuento();
    }
}