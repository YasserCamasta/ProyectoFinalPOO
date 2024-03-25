package logico;

public class Ram extends Componente {

	private double memoriaGB;
	private String tipoMemoria;
	private double frecuencia;

	public Ram(String numeroSerie, double precio, int cantidadDisponible, String marca, double memoriaGB,
			String tipoMemoria, double frecuencia) {
		super(numeroSerie, precio, cantidadDisponible, marca);
		this.memoriaGB = memoriaGB;
		this.tipoMemoria = tipoMemoria;
		this.frecuencia = frecuencia;
	}

	public String toString() {
		return "Ram{" + "marca='" + marca + '\'' + ", memoriaGB=" + memoriaGB + ", tipoMemoria='" + tipoMemoria + '\''
				+ ", frecuencia=" + frecuencia + "} " + super.toString();
	}

	public boolean esCompatibleConFrecuencia(double frecuencia) {
		return this.frecuencia <= frecuencia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getMemoriaGB() {
		return memoriaGB;
	}

	public void setMemoriaGB(double memoriaGB) {
		this.memoriaGB = memoriaGB;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
}
