package logico;

class Micro extends Componente {
    private String marca;
    private String modelo;
    private String tipoSocket;
    private double velocidadProcesamiento;
    
    public Micro(String numeroSerie, double precio, int cantidadDisponible, String marca, String modelo,
                 String tipoSocket, double velocidadProcesamiento) {
        super(numeroSerie, precio, cantidadDisponible);
        this.marca = marca;
        this.modelo = modelo;
        this.tipoSocket = tipoSocket;
        this.velocidadProcesamiento = velocidadProcesamiento;
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
        return "Microprocesador: " + marca + " " + modelo + ", Socket: " + tipoSocket +
                ", Velocidad: " + velocidadProcesamiento + " GHz";
    }
}