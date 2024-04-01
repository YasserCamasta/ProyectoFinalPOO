package logico;

public class Micro extends Componente {
    private String modelo;
    private String tipoSocket;
    private double velocidadProcesamiento;

    public Micro(String numeroSerie, String marca, String modelo, String tipoSocket, double velocidadProcesamiento) {
        super(numeroSerie, marca); 
        this.modelo = modelo;
        this.tipoSocket = tipoSocket;
        this.velocidadProcesamiento = velocidadProcesamiento;
        this.precio = 1500.0;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoSocket() {
        return tipoSocket;
    }

    public void setTipoSocket(String tipoSocket) {
        this.tipoSocket = tipoSocket;
    }

    public double getVelocidadProcesamiento() {
        return velocidadProcesamiento;
    }

    public void setVelocidadProcesamiento(double velocidadProcesamiento) {
        this.velocidadProcesamiento = velocidadProcesamiento;
    }

    
    public String obtenerDetalles() {
        return "Microprocesador: " + getMarca() + " " + modelo + ", Socket: " + tipoSocket +
                ", Velocidad: " + velocidadProcesamiento + " GHz";
    }
}