package logico;

public class Micro extends Componente {

	private String modelo;
	private String tipoConexion;
	private double velocidadProcesamiento;

	public Micro(String numeroSerie, double precio, int cantidadDisponible, String marca, String modelo,
			String tipoConexion, double velocidadProcesamiento) {

		super(numeroSerie, marca);
		this.modelo = modelo;
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public double getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}

	public void setVelocidadProcesamiento(double velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}

}
