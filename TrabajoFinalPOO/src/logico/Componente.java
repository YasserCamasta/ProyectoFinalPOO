package logico;

public abstract class Componente {
	private String numeroSerie;
	private double precio;
	private int cantidadDisponible;

	public Componente(String numeroSerie, double precio, int cantidadDisponible) {
		this.numeroSerie = numeroSerie;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
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

	public abstract String obtenerDetalles();
}