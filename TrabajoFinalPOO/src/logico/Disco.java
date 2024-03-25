package logico;

public class Disco extends Componente {
	private String modelo;
	private double capacidadGB;
	private String tipoConexion;

	public Disco(String numeroSerie, double precio, int cantidadDisponible, String marca, String modelo,
			double capacidadGB, String tipoConexion) {
		super(numeroSerie, precio, cantidadDisponible, marca);
		this.modelo = modelo;
		this.capacidadGB = capacidadGB;
		this.tipoConexion = tipoConexion;
	}

	public String toString() {
		return "Disco{" + "marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", capacidadGB=" + capacidadGB
				+ ", tipoConexion='" + tipoConexion + '\'' + "} " + super.toString();
	}

	public String tipoDeDisco() {

		return this.tipoConexion.equalsIgnoreCase("SATA3") ? "SSD" : "HDD";
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getCapacidadGB() {
		return capacidadGB;
	}

	public void setCapacidadGB(double capacidadGB) {
		this.capacidadGB = capacidadGB;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
}
