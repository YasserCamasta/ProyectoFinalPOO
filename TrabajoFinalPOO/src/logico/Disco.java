package logico;

class Disco extends Componente {
    private String marca;
    private int capacidad;
    private String tipoConexion;

    public Disco(String numeroSerie, double precio, int cantidadDisponible, String marca, int capacidad, String tipoConexion) {
        super(numeroSerie, precio, cantidadDisponible);
        this.marca = marca;
        this.capacidad = capacidad;
        this.tipoConexion = tipoConexion;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoConexion() {
        return tipoConexion;
    }

    public void setTipoConexion(String tipoConexion) {
        this.tipoConexion = tipoConexion;
    }

    public String obtenerDetalles() {
        return "Disco Duro: " + marca + ", Capacidad: " + capacidad + " GB, Conexión: " + tipoConexion;
    }
}