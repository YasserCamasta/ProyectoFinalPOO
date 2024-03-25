package logico;

import java.util.List;

public class Factura {
	private float numeroFactura;
	private String nombreCliente;
	private List<Componente> componentes;

	public Factura(float numeroFactura, String nombreCliente, List<Componente> componentes) {
		this.numeroFactura = numeroFactura;
		this.nombreCliente = nombreCliente;
		this.componentes = componentes;
	}

	public float getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(float numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public double calcularTotal() {
		double total = 0.0;
		for (Componente componente : componentes) {
			total += componente.getPrecio();
		}
		return total;
	}
}