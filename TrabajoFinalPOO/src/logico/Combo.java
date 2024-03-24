package logico;

import java.util.ArrayList;

import java.util.List;

public class Combo {
	private String id;
	private double precioTotal;
	private List<Componente> componentes;

	public Combo(String id) {
		super();
		this.id = id;
		this.precioTotal = 0.0;
		this.componentes = new ArrayList<>();
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public String getId() {
		return id;
	}

}
