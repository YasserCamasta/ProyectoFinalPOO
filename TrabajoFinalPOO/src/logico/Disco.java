package logico;

class Disco extends Componente {
    private int capacidad;
    private String tipoConexion;

    public Disco(String numeroSerie, double precio, int cantidadDisponible, String marca, int capacidad, String tipoConexion) {
        super(numeroSerie, precio, cantidadDisponible, marca);
        this.capacidad = capacidad;
        this.tipoConexion = tipoConexion;
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
        return "Disco Duro: " + getMarca() + ", Capacidad: " + capacidad + " GB, Conexión: " + tipoConexion;
    }
}