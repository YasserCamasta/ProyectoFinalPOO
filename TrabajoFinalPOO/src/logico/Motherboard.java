package logico;

import java.util.ArrayList;

public class Motherboard extends Componente {
    private String modelo;
    private String socket;
    private String tipoMemoriaRAM;
    private ArrayList<String> conexionesDiscos;

    public Motherboard(String numeroSerie, String marca, String modelo, String socket, String tipoMemoriaRAM, ArrayList<String> conexionesDiscos) {
        super(numeroSerie, marca); 
        this.modelo = modelo;
        this.socket = socket;
        this.tipoMemoriaRAM = tipoMemoriaRAM;
        this.conexionesDiscos = conexionesDiscos;
        this.precio = 3000.0;
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

    public ArrayList<String> getConexionesDiscos() {
        return conexionesDiscos;
    }

    public void setConexionesDiscos(ArrayList<String> conexionesDiscos) {
        this.conexionesDiscos = conexionesDiscos;
    }

    // verificar si la motherboard es compatible con una RAM dada
    public boolean esCompatibleConRAM(Ram ram) {
        return this.tipoMemoriaRAM.equals(ram.getTipo());
    }

    // verificar si la motherboard tiene conexión para un disco dado
    public boolean tieneConexionParaDisco(Disco disco) {
        return this.conexionesDiscos.contains(disco.getTipoConexion());
    }

    
    public String obtenerDetalles() {
        return "Tarjeta Madre: " + getMarca() + " " + modelo + ", Socket: " + socket +
                ", Tipo de Memoria RAM: " + tipoMemoriaRAM + ", Conexiones para Discos: " + conexionesDiscos.toString();
    }

	public Object getConector() {
		// TODO Auto-generated method stub
		return null;
	}
}