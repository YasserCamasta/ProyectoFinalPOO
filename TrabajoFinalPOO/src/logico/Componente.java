package logico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Componente {
	protected String numeroSerie;
	protected double precio;
	protected int cantidadDisponible;
	protected String marca;
	protected static List<Componente> componentes = new ArrayList<>();

	public Componente(String numeroSerie, double precio, int cantidadDisponible, String marca) {
		this.numeroSerie = numeroSerie;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
		this.marca = marca;
		componentes.add(this);
	}

	public static void mostrarComponentes() {
		for (Componente componente : componentes) {
			System.out.println(componente);
		}
	}

	public String toString() {
		return "Componente{" + "numeroSerie='" + numeroSerie + '\'' + ", precio=" + precio + ", cantidadDisponible="
				+ cantidadDisponible + ", marca='" + marca + '\'' + '}';
	}

	public void actualizarInventario(int cantidad) {
		this.cantidadDisponible += cantidad;
	}

	public boolean estaDisponible() {
		return this.cantidadDisponible > 0;
	}

	public static List<Componente> buscarPorMarca(String marca) {
		return componentes.stream().filter(c -> c.marca.equalsIgnoreCase(marca)).collect(Collectors.toList());
	}

	public static int compararPorPrecio(Componente c1, Componente c2) {
		return Double.compare(c1.precio, c2.precio);
	}

	public static boolean sonCompatibles(Componente c1, Componente c2) {
		return c1.marca.equals(c2.marca);
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
