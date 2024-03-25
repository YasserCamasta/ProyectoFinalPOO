package logico;

import java.util.List;
import java.util.ArrayList;

public class Motherboard extends Componente {
	private String modelo;
	private String socket;
	private String tipoMemoriaRAM;
	private List<String> conexionesDiscos;

	public Motherboard(String numeroSerie, double precio, int cantidadDisponible, String marca, String modelo,
			String socket, String tipoMemoriaRAM) {
		super(numeroSerie, precio, cantidadDisponible, marca);
		this.modelo = modelo;
		this.socket = socket;
		this.tipoMemoriaRAM = tipoMemoriaRAM;
		this.conexionesDiscos = new ArrayList<>();
	}

	public String toString() {
		return "Motherboard{" + "marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", socket='" + socket + '\''
				+ ", tipoMemoriaRAM='" + tipoMemoriaRAM + '\'' + ", conexionesDiscos=" + conexionesDiscos + "} "
				+ super.toString();
	}

	public boolean esCompatibleConRAM(Ram ram) {
		return this.tipoMemoriaRAM.equalsIgnoreCase(ram.getTipoMemoria());
	}

	public boolean tieneConexionParaDisco(Disco disco) {
		return this.conexionesDiscos.contains(disco.getTipoConexion());
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

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getTipoMemoriaRAM() {
		return tipoMemoriaRAM;
	}

	public void setTipoMemoriaRAM(String tipoMemoriaRAM) {
		this.tipoMemoriaRAM = tipoMemoriaRAM;
	}

	public List<String> getConexionesDiscos() {
		return conexionesDiscos;
	}

	public void setConexionesDiscos(List<String> conexionesDiscos) {
		this.conexionesDiscos = conexionesDiscos;
	}
}
