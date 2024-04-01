package logico;

public class Disco extends Componente {
    private String modelo;
    private double capacidadGB;
    private String tipoConexion;

    public Disco(String numeroSerie, String marca, String modelo, double capacidadGB, String tipoConexion) {
        super(numeroSerie, marca); // Llamamos al constructor de la clase padre
        this.modelo = modelo;
        this.capacidadGB = capacidadGB;
        this.tipoConexion = tipoConexion;
        this.precio = 2000.0;
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

    public String tipoDeDisco() {
        return "Tipo de Disco: " + tipoConexion;
    }

    
    public String obtenerDetalles() {
        return "Disco Duro: " + getMarca() + ", Modelo: " + modelo + ", Capacidad: " + capacidadGB + " GB, Tipo de Conexión: " + tipoConexion;
    }
}