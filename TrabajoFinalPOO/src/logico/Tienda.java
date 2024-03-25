package logico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tienda {
	private List<Factura> facturas;
	private List<Componente> componentes;
	private List<Combo> combos;
	private List<Cliente> clientes;

	public Tienda() {
		super();

		this.facturas = new ArrayList<>();
		this.componentes = new ArrayList<>();
		this.combos = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public List<Combo> getCombos() {
		return combos;
	}

	public void setCombos(List<Combo> combos) {
		this.combos = combos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	// Este metodo es para agregar un componente al inventario de la tienda
	public void agregarComponente(Componente componente) {
		componentes.add(componente);
	}

	// Generar una factura para una lista de componentes
	public Factura generarFactura(List<Componente> componentes) {
		Factura factura = new Factura(0, null, componentes);
		facturas.add(factura);
		return factura;
	}

	// Contar la cantidad total de componentes disponibles en el inventario
	public int contarComponentesDisponibles() {
		return componentes.size();
	}

	// Buscar componentes por marca
	public List<Componente> buscarComponentesPorMarca(String marca) {
		return componentes.stream().filter(c -> c.getMarca().equalsIgnoreCase(marca)).collect(Collectors.toList());
	}

	// Ordenar componentes por precio
	public List<Componente> ordenarComponentesPorPrecio() {
		List<Componente> copiaComponentes = new ArrayList<>(componentes);
		Collections.sort(copiaComponentes, (c1, c2) -> Double.compare(c1.getPrecio(), c2.getPrecio()));
		return copiaComponentes;
	}

	// Verificar la compatibilidad de un conjunto de componentes (motherboard, ram,
	// disco)
	public boolean verificarCompatibilidad(Motherboard motherboard, Ram ram, Disco disco) {
		// Verificaciones de compatibilidad y resultado
		return motherboard.esCompatibleConRAM(ram) && motherboard.tieneConexionParaDisco(disco);
	}

}